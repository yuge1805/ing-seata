package com.yuge.ing.seata.store.business.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import com.yuge.ing.seata.store.business.StoreBusiness;
import com.yuge.ing.seata.store.common.param.CommodityAmountParam;
import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.common.param.CommodityOutboundParam;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.yuge.ing.seata.store.po.StoreLogEntity;
import com.yuge.ing.seata.store.service.StoreLogService;
import com.yuge.ing.seata.store.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yuge
 * @since 2022-06-25
 */
@Slf4j
@Service
public class StoreBusinessImpl implements StoreBusiness {

    private StoreService storeService;

    private StoreLogService storeLogService;

    public StoreBusinessImpl(StoreService storeService, StoreLogService storeLogService) {
        this.storeService = storeService;
        this.storeLogService = storeLogService;
    }

    /**
     * 初始化库存数量
     * （目的是为了验证前的初始化，是否有必要这样做，还是简单update就可以啦？）
     *
     * @param commodityInboundParam
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void init(CommodityInboundParam commodityInboundParam) {
        if (CollectionUtil.isEmpty(commodityInboundParam.getDetailList())) {
            return;
        }
        List<Long> commodityIdList = commodityInboundParam.getDetailList()
                .stream()
                .map(CommodityAmountParam::getCommodityId)
                .collect(Collectors.toList());
        List<StoreEntity> entityList = storeService.queryByCommodityId(commodityIdList);
        List<Long> existCommodityIdList = entityList.stream().map(StoreEntity::getCommodityId).collect(Collectors.toList());
        List<Long> notExistCommodityIdList = CollectionUtil.subtractToList(existCommodityIdList, commodityIdList);
        if (CollectionUtil.isNotEmpty(notExistCommodityIdList)) {
            throw new IllegalArgumentException("未找以下商品库存：" + notExistCommodityIdList);
        }
        Map<Long, BigDecimal> commodityIdAndAmountMap = commodityInboundParam.getDetailList().stream()
                .collect(Collectors.toMap(CommodityAmountParam::getCommodityId, CommodityAmountParam::getAmount,
                        (bigDecimal, bigDecimal2) -> bigDecimal));
        List<StoreEntity> updateList = entityList.stream()
                .filter(storeEntity -> commodityIdAndAmountMap.containsKey(storeEntity.getCommodityId()))
                .map(storeEntity -> {
                    StoreEntity updateEntity = new StoreEntity();
                    updateEntity.setId(storeEntity.getId());
                    updateEntity.setAmount(commodityIdAndAmountMap.get(storeEntity.getCommodityId()));
                    return updateEntity;
                }).collect(Collectors.toList());
        storeService.updateBatchById(updateList);
        // 删除所有日志
        storeLogService.deleteByCommodityId(commodityIdList);

    }

    /**
     * 入库
     *
     * @param commodityInboundParam
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void inbound(CommodityInboundParam commodityInboundParam) {
    }

    /**
     * 出库
     *
     * @param commodityOutboundParam
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void outbound(CommodityOutboundParam commodityOutboundParam) {
        if (CollectionUtil.isEmpty(commodityOutboundParam.getDetailList())) {
            return;
        }
        List<CommodityAmountParam> detailList = commodityOutboundParam.getDetailList();
        List<Long> commodityIdList = detailList
                .stream()
                .map(CommodityAmountParam::getCommodityId)
                .collect(Collectors.toList());
        List<StoreEntity> entityList = storeService.queryByCommodityId(commodityIdList);
        List<Long> existCommodityIdList = entityList.stream().map(StoreEntity::getCommodityId).collect(Collectors.toList());
        List<Long> notExistCommodityIdList = CollectionUtil.subtractToList(existCommodityIdList, commodityIdList);
        if (CollectionUtil.isNotEmpty(notExistCommodityIdList)) {
            throw new IllegalArgumentException("未找以下商品库存：" + notExistCommodityIdList);
        }
        Map<Long, BigDecimal> commodityIdAndAmountMap = commodityOutboundParam.getDetailList().stream()
                .collect(Collectors.toMap(CommodityAmountParam::getCommodityId, CommodityAmountParam::getAmount,
                        (bigDecimal, bigDecimal2) -> bigDecimal));
        // 更新库存
        List<StoreEntity> updateList = entityList.stream()
                .filter(storeEntity -> commodityIdAndAmountMap.containsKey(storeEntity.getCommodityId()))
                .map(storeEntity -> {
                    StoreEntity updateEntity = new StoreEntity();
                    updateEntity.setId(storeEntity.getId());
                    BigDecimal useAmount = commodityIdAndAmountMap.get(storeEntity.getCommodityId());
                    BigDecimal resultAmount = NumberUtil.sub(storeEntity.getAmount(), useAmount);
                    updateEntity.setAmount(resultAmount);
                    return updateEntity;
                }).collect(Collectors.toList());
        storeService.updateBatchById(updateList);
        // 增加库存日志
        this.saveLog(detailList);
        log.info("outbound success, orderId: {}", commodityOutboundParam.getOrderId());
    }

    private void saveLog(List<CommodityAmountParam> detailList) {
        List<StoreLogEntity> logList = detailList.stream()
                .filter(Objects::nonNull)
                .map(commodityAmountParam -> {
                    StoreLogEntity storeLogEntity = new StoreLogEntity();
                    storeLogEntity.setCommodityId(commodityAmountParam.getCommodityId());
                    storeLogEntity.setAmount(commodityAmountParam.getAmount().negate());
                    ;
                    storeLogEntity.setCrtTime(LocalDateTime.now());
                    return storeLogEntity;
                }).collect(Collectors.toList());
        storeLogService.saveBatch(logList);
    }

}

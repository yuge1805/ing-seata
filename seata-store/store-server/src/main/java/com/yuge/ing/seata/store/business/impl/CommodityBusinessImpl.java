package com.yuge.ing.seata.store.business.impl;

import com.yuge.ing.seata.store.business.CommodityBusiness;
import com.yuge.ing.seata.store.common.param.CommodityParam;
import com.yuge.ing.seata.store.converter.CommodityConverter;
import com.yuge.ing.seata.store.po.CommodityEntity;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.yuge.ing.seata.store.service.CommodityService;
import com.yuge.ing.seata.store.service.StoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author yuge
 * @since 2022-06-25
 */
@Service
public class CommodityBusinessImpl implements CommodityBusiness {

    private CommodityService commodityService;

    private StoreService storeService;

    public CommodityBusinessImpl(CommodityService commodityService, StoreService storeService) {
        this.commodityService = commodityService;
        this.storeService = storeService;
    }

    /**
     * 新增
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(CommodityParam param) {
        // 新增商品
        CommodityEntity commodityEntity = CommodityConverter.INSTANCE.paramToEntity(param);
        commodityService.save(commodityEntity);

        // 初始化库存
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setCommodityId(commodityEntity.getId());
        storeEntity.setAmount(BigDecimal.ZERO);
        storeService.save(storeEntity);
    }

}

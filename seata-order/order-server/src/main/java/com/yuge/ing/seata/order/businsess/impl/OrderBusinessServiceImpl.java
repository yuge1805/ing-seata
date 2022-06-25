package com.yuge.ing.seata.order.businsess.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.order.businsess.OrderBusinessService;
import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.order.converter.OrderConverter;
import com.yuge.ing.seata.order.converter.OrderItemConverter;
import com.yuge.ing.seata.order.po.OrderEntity;
import com.yuge.ing.seata.order.po.OrderItemEntity;
import com.yuge.ing.seata.order.service.OrderItemService;
import com.yuge.ing.seata.order.service.OrderService;
import com.yuge.ing.seata.store.api.StoreClient;
import com.yuge.ing.seata.store.common.param.CommodityAmountParam;
import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.common.param.CommodityOutboundParam;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderBusinessServiceImpl implements OrderBusinessService {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderItemService orderItemService;

    @Resource
    private StoreClient storeClient;

    /**
     * 新增
     *
     * @param orderParam
     */
    @GlobalTransactional(rollbackFor = Exception.class)
//    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(OrderParam orderParam) {
        // order
        OrderEntity entity = OrderConverter.INSTANCE.paramToEntity(orderParam);
        entity.setCrtTime(LocalDateTime.now());
        orderService.save(entity);
        Long orderId = entity.getId();

        // order item
        if (CollectionUtil.isEmpty(orderParam.getItemList())) {
            return;
        }
        List<OrderItemEntity> itemList = orderParam.getItemList().stream()
                .map(orderItemParam -> {
                    OrderItemEntity orderItemEntity = OrderItemConverter.INSTANCE.paramToEntity(orderItemParam);
                    orderItemEntity.setOrderId(orderId);
                    return orderItemEntity;
                })
                .collect(Collectors.toList());
        orderItemService.saveBatch(itemList);

        // 库存
        CommodityOutboundParam commodityOutboundParam = new CommodityOutboundParam();
        List<CommodityAmountParam> detailList = orderParam.getItemList().stream()
                .map(orderItemParam -> {
                    return new CommodityAmountParam(orderItemParam.getCommodityId(), orderItemParam.getAmount());
                }).collect(Collectors.toList());
        commodityOutboundParam.setDetailList(detailList);
        CommonResponse<Boolean> response = storeClient.outbound(commodityOutboundParam);
        if (!response.isSuccess()) {
            throw new IllegalStateException(String.format("storeClient.outbound error! code: %s, msg: %s", response.getCode(), response.getMsg()));
        }

        log.info("add order success! orderId: {}", orderId);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    public void addForTest() {
        String now = DateUtil.now();
        OrderParam orderParam = new OrderParam();
        orderParam.setContent(now);
        Long orderId = orderService.add(orderParam);
        log.info("add order! orderId: {}", orderId);

        CommodityInboundParam storeParam = new CommodityInboundParam();
//        storeParam.setName(now);
        CommonResponse<Long> response = storeClient.add(storeParam);
        if (!response.isSuccess()) {
            throw new IllegalStateException(String.format("storeClient.add error! code: %s, msg: %s", response.getCode(), response.getMsg()));
        }
        log.info("add store! storeId:{}", response.getData());
    }



}

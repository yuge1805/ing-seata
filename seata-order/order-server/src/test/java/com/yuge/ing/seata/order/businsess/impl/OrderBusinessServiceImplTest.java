package com.yuge.ing.seata.order.businsess.impl;

import com.yuge.ing.seata.order.businsess.OrderBusinessService;
import com.yuge.ing.seata.order.common.param.OrderItemParam;
import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.order.po.OrderEntity;
import com.yuge.ing.seata.order.po.OrderItemEntity;
import com.yuge.ing.seata.order.service.OrderItemService;
import com.yuge.ing.seata.order.service.OrderService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderBusinessServiceImplTest {

    @Resource
    private OrderBusinessService orderBusinessService;

    @Resource
    private OrderService orderService;

    @Resource
    private OrderItemService orderItemService;

    @Test
    void add() {
        OrderParam orderParam = new OrderParam();
        orderParam.setContent("xxxxx");
        orderParam.setItemList(Lists.newArrayList(
                new OrderItemParam(1L, 2),
                new OrderItemParam(3L, 1)
        ));
        orderBusinessService.add(orderParam);
    }

    @Test
    void deleteAll() {
        orderService.remove(orderService.lambdaQuery()
                .isNotNull(OrderEntity::getId).getWrapper());
        orderItemService.remove(orderItemService.lambdaQuery()
                .isNotNull(OrderItemEntity::getId).getWrapper());
    }
}
package com.yuge.ing.seata.order.businsess.impl;

import com.yuge.ing.seata.order.businsess.OrderBusinessService;
import com.yuge.ing.seata.order.common.param.OrderItemParam;
import com.yuge.ing.seata.order.common.param.OrderParam;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderBusinessServiceImplTest {

    @Resource
    private OrderBusinessService orderBusinessService;

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
}
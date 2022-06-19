package com.yuge.ing.seata.order.businsess.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.db.sql.Order;
import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.order.businsess.OrderBusinessService;
import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.order.service.OrderService;
import com.yuge.ing.seata.store.api.StoreClient;
import com.yuge.ing.seata.store.common.param.StoreParam;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderBusinessServiceImpl implements OrderBusinessService {

    @Resource
    private OrderService orderService;

    @Resource
    private StoreClient storeClient;

    @Override
//    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    public void add() {
        String now = DateUtil.now();
        OrderParam orderParam = new OrderParam();
        orderParam.setContent(now);
        Long orderId = orderService.add(orderParam);
        log.info("add order! orderId: {}", orderId);

        StoreParam storeParam = new StoreParam();
        storeParam.setName(now);
        CommonResponse<Long> response = storeClient.add(storeParam);
        if (!response.isSuccess()) {
            throw new IllegalStateException(String.format("storeClient.add error! code: %s, msg: %s", response.getCode(), response.getMsg()));
        }
        log.info("add store! storeId:{}", response.getData());
    }

}

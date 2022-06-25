package com.yuge.ing.seata.order.businsess;

import com.yuge.ing.seata.order.common.param.OrderParam;

public interface OrderBusinessService {

    /**
     * 新增
     *
     * @param orderParam
     */
    void add(OrderParam orderParam);

    void addForTest();

}

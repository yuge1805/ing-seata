package com.yuge.ing.seata.portal.business.impl;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.order.api.OrderClient;
import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.portal.business.PortalOrderBusiness;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PortalOrderBusinessImpl
 *
 * @author yuge
 * @since 2022-06-26
 */
@Slf4j
@Service
public class PortalOrderBusinessImpl implements PortalOrderBusiness {

    @Resource
    private OrderClient orderClient;

    /**
     * 仅验证从无数据库服务，也可以出发分布式事务；
     * 需要将order服务中
     * com.yuge.ing.seata.order.businsess.impl.OrderBusinessServiceImpl#add()
     * 该方法的注解从@GlobalTransactional改为@Transactional
     *
     * @param orderParam
     */
    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public void add(OrderParam orderParam) {
        CommonResponse<Boolean> response = orderClient.add(orderParam);
        if (response.isSuccess()) {
            log.info("add order success!");
        } else {
            log.info("add order error! code: {}, msg: {}", response.getCode(), response.getMsg());
        }
    }

}

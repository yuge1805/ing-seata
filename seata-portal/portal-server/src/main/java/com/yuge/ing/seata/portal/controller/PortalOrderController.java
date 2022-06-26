package com.yuge.ing.seata.portal.controller;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.portal.business.PortalOrderBusiness;
import com.yuge.ing.seata.portal.business.impl.PortalOrderBusinessImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PortalOrderController
 *
 * @author yuge
 * @since 2022-06-26
 */
@RestController
@RequestMapping("/order")
public class PortalOrderController {

    @Resource
    private PortalOrderBusiness portalOrderBusiness;

    @PostMapping
    public CommonResponse<Boolean> add(@RequestBody OrderParam orderParam) {
        portalOrderBusiness.add(orderParam);
        return CommonResponse.success(true);
    }

}

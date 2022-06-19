package com.yuge.ing.seata.order.controller;

import cn.hutool.db.sql.Order;
import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.order.businsess.OrderBusinessService;
import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.order.po.OrderEntity;
import com.yuge.ing.seata.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuge
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderBusinessService orderBusinessService;

    @GetMapping
    public List<OrderEntity> list() {
        return orderService.list();
    }

    @PostMapping
    public CommonResponse<Long> add(@RequestBody OrderParam orderParam) {
        Long id = orderService.add(orderParam);
        return CommonResponse.success(id);
    }

    @PostMapping("/business")
    public CommonResponse<Boolean> addBusiness() {
        orderBusinessService.add();
        return CommonResponse.success(true);
    }

}

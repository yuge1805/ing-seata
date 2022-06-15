package com.yuge.ing.seata.order.controller;

import com.yuge.ing.seata.order.po.OrderEntity;
import com.yuge.ing.seata.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<OrderEntity> list() {
        return orderService.list();
    }

}

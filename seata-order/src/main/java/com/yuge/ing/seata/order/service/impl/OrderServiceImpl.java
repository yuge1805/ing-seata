package com.yuge.ing.seata.order.service.impl;

import com.yuge.ing.seata.order.po.OrderEntity;
import com.yuge.ing.seata.order.mapper.OrderMapper;
import com.yuge.ing.seata.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuge
 * @since 2022-06-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

}

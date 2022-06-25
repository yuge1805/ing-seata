package com.yuge.ing.seata.order.service.impl;

import com.yuge.ing.seata.order.po.OrderItemEntity;
import com.yuge.ing.seata.order.mapper.OrderItemMapper;
import com.yuge.ing.seata.order.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuge
 * @since 2022-06-25
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {

}

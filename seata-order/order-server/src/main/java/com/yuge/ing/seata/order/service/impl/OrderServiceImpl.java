package com.yuge.ing.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.order.converter.OrderConverter;
import com.yuge.ing.seata.order.mapper.OrderMapper;
import com.yuge.ing.seata.order.po.OrderEntity;
import com.yuge.ing.seata.order.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long add(OrderParam OrderParam) {
        OrderEntity entity = OrderConverter.INSTANCE.paramToEntity(OrderParam);
        this.save(entity);
        return entity.getId();
    }
    
}

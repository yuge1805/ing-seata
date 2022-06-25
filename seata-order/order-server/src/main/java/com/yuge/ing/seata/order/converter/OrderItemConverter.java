package com.yuge.ing.seata.order.converter;

import com.yuge.ing.seata.order.common.param.OrderItemParam;
import com.yuge.ing.seata.order.po.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemConverter {

    OrderItemConverter INSTANCE = Mappers.getMapper(OrderItemConverter.class);

    OrderItemEntity paramToEntity(OrderItemParam param);

}

package com.yuge.ing.seata.order.converter;

import com.yuge.ing.seata.order.common.param.OrderParam;
import com.yuge.ing.seata.order.po.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderConverter {

    OrderConverter INSTANCE = Mappers.getMapper(OrderConverter.class);

    OrderEntity paramToEntity(OrderParam param);

}

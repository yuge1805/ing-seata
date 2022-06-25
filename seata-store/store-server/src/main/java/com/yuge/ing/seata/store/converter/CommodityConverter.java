package com.yuge.ing.seata.store.converter;

import com.yuge.ing.seata.store.common.param.CommodityParam;
import com.yuge.ing.seata.store.po.CommodityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommodityConverter {

    CommodityConverter INSTANCE = Mappers.getMapper(CommodityConverter.class);

    CommodityEntity paramToEntity(CommodityParam param);

}

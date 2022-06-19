package com.yuge.ing.seata.store.converter;

import com.yuge.ing.seata.store.common.param.StoreParam;
import com.yuge.ing.seata.store.po.StoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreConverter {

    StoreConverter INSTANCE = Mappers.getMapper(StoreConverter.class);

    StoreEntity paramToEntity(StoreParam param);

}

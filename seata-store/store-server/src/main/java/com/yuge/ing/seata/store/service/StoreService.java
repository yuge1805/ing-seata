package com.yuge.ing.seata.store.service;

import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 库存 服务类
 * </p>
 *
 * @author yuge
 * @since 2022-06-15
 */
public interface StoreService extends IService<StoreEntity> {

    Long add(CommodityInboundParam storeParam);

    List<StoreEntity> queryByCommodityId(List<Long> commodityIdList);

    Optional<StoreEntity> queryById(Long id);

}

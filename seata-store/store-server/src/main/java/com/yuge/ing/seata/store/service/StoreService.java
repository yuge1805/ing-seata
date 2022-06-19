package com.yuge.ing.seata.store.service;

import com.yuge.ing.seata.store.common.param.StoreParam;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库存 服务类
 * </p>
 *
 * @author yuge
 * @since 2022-06-15
 */
public interface StoreService extends IService<StoreEntity> {

    Long add(StoreParam storeParam);

}

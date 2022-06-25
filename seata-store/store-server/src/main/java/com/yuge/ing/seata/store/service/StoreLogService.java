package com.yuge.ing.seata.store.service;

import com.yuge.ing.seata.store.po.StoreLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 库存 服务类
 * </p>
 *
 * @author yuge
 * @since 2022-06-25
 */
public interface StoreLogService extends IService<StoreLogEntity> {

    void deleteByCommodityId(List<Long> commodityIdList);

}

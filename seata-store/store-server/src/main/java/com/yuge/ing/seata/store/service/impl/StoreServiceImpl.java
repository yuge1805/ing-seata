package com.yuge.ing.seata.store.service.impl;

import com.yuge.ing.seata.store.common.param.StoreParam;
import com.yuge.ing.seata.store.converter.StoreConverter;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.yuge.ing.seata.store.mapper.StoreMapper;
import com.yuge.ing.seata.store.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 库存 服务实现类
 * </p>
 *
 * @author yuge
 * @since 2022-06-15
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, StoreEntity> implements StoreService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long add(StoreParam storeParam) {
        StoreEntity entity = StoreConverter.INSTANCE.paramToEntity(storeParam);
        this.save(entity);
        return entity.getId();
    }

}

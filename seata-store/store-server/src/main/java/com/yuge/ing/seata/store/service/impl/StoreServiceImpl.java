package com.yuge.ing.seata.store.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.google.common.collect.Lists;
import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.converter.StoreConverter;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.yuge.ing.seata.store.mapper.StoreMapper;
import com.yuge.ing.seata.store.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Long add(CommodityInboundParam storeParam) {
        StoreEntity entity = StoreConverter.INSTANCE.paramToEntity(storeParam);
        this.save(entity);
        return entity.getId();
    }

    @Override
    public List<StoreEntity> queryByCommodityId(List<Long> commodityIdList) {
        if (CollectionUtil.isEmpty(commodityIdList)) {
            return Lists.newArrayList();
        }
        return this.list(lambdaQuery()
                .in(StoreEntity::getCommodityId, commodityIdList)
                .getWrapper());
    }

}

package com.yuge.ing.seata.store.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.yuge.ing.seata.store.po.StoreLogEntity;
import com.yuge.ing.seata.store.mapper.StoreLogMapper;
import com.yuge.ing.seata.store.service.StoreLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 库存 服务实现类
 * </p>
 *
 * @author yuge
 * @since 2022-06-25
 */
@Service
public class StoreLogServiceImpl extends ServiceImpl<StoreLogMapper, StoreLogEntity> implements StoreLogService {

    @Override
    public void deleteByCommodityId(List<Long> commodityIdList) {
        if (CollectionUtil.isEmpty(commodityIdList)) {
            return;
        }
        this.remove(lambdaQuery().in(StoreLogEntity::getCommodityId, commodityIdList).getWrapper());
    }

}

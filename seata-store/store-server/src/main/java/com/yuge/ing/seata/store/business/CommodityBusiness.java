package com.yuge.ing.seata.store.business;

import com.yuge.ing.seata.store.common.param.CommodityParam;

/**
 * 商品
 *
 * @author yuge
 * @since 2022-06-25
 */
public interface CommodityBusiness {

    /**
     * 新增
     */
    void add(CommodityParam param);

}

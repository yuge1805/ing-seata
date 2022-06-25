package com.yuge.ing.seata.store.business;

import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.common.param.CommodityOutboundParam;

/**
 * @author yuge
 * @since 2022-06-25
 */
public interface StoreBusiness {

    /**
     * 初始化库存数量
     *
     * @param commodityInboundParam
     */
    void init(CommodityInboundParam commodityInboundParam);

    /**
     * 入库
     *
     * @param commodityInboundParam
     */
    void inbound(CommodityInboundParam commodityInboundParam);

    /**
     * 出库
     *
     * @param commodityOutboundParam
     */
    void outbound(CommodityOutboundParam commodityOutboundParam);

}

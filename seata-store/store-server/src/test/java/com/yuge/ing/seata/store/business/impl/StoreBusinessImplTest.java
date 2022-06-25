package com.yuge.ing.seata.store.business.impl;

import com.google.common.collect.Lists;
import com.yuge.ing.seata.store.business.StoreBusiness;
import com.yuge.ing.seata.store.common.param.CommodityAmountParam;
import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.common.param.CommodityOutboundParam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreBusinessImplTest {

    @Resource
    private StoreBusiness storeBusiness;

    @Test
    void init() {
        CommodityInboundParam commodityInboundParam = new CommodityInboundParam();
        List<CommodityAmountParam> commodityAmountParams = Lists.newArrayList(
                new CommodityAmountParam(1L, 10000),
                new CommodityAmountParam(2L, 10000),
                new CommodityAmountParam(3L, 10000),
                new CommodityAmountParam(4L, 10000),
                new CommodityAmountParam(5L, 10000),
                new CommodityAmountParam(6L, 10000),
                new CommodityAmountParam(7L, 10000),
                new CommodityAmountParam(8L, 10000),
                new CommodityAmountParam(9L, 10000),
                new CommodityAmountParam(10L, 10000),
                new CommodityAmountParam(11L, 10000),
                new CommodityAmountParam(12L, 10000),
                new CommodityAmountParam(13L, 10000),
                new CommodityAmountParam(14L, 10000),
                new CommodityAmountParam(15L, 10000),
                new CommodityAmountParam(16L, 10000),
                new CommodityAmountParam(17L, 10000),
                new CommodityAmountParam(18L, 10000),
                new CommodityAmountParam(19L, 10000),
                new CommodityAmountParam(20L, 10000)
        );
        commodityInboundParam.setDetailList(commodityAmountParams);
        storeBusiness.init(commodityInboundParam);
    }


    @Test
    void outbound() {
        CommodityOutboundParam commodityOutboundParam = new CommodityOutboundParam();
        List<CommodityAmountParam> commodityAmountParams = Lists.newArrayList(
                new CommodityAmountParam(1L, 3),
                new CommodityAmountParam(2L, 8)
        );
        commodityOutboundParam.setDetailList(commodityAmountParams);
        storeBusiness.outbound(commodityOutboundParam);
    }

}
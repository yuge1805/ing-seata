package com.yuge.ing.seata.store.business.impl;

import com.google.common.collect.Lists;
import com.yuge.ing.seata.store.business.CommodityBusiness;
import com.yuge.ing.seata.store.common.param.CommodityParam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class CommodityBusinessImplTest {

    @Resource
    private CommodityBusiness commodityBusiness;

    @Test
    void add() {
        List<CommodityParam> lists = Lists.newArrayList(
                new CommodityParam("芒果"),
                new CommodityParam("铁干树枝"),
                new CommodityParam("小净化"),
                new CommodityParam("大药膏"),
                new CommodityParam("护腕"),
                new CommodityParam("智力挂件"),
                new CommodityParam("敏捷挂件"),
                new CommodityParam("穷鬼盾"),
                new CommodityParam("补刀斧"),
                new CommodityParam("速度之靴"),
                new CommodityParam("假腿"),
                new CommodityParam("小电锤"),
                new CommodityParam("大电锤"),
                new CommodityParam("坚韧球"),
                new CommodityParam("狂战斧"),
                new CommodityParam("BKB"),
                new CommodityParam("冰眼"),
                new CommodityParam("大炮"),
                new CommodityParam("金箍棒"),
                new CommodityParam("不朽盾"));
        lists.forEach(param -> commodityBusiness.add(param));
    }
}
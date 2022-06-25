package com.yuge.ing.seata.store.common.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 商品数量
 *
 * @author yuge
 * @since 2022-06-25
 */
@Getter
@Setter
@NoArgsConstructor
public class CommodityAmountParam {

    /**
     * 商品id
     */
    private Long commodityId;

    /**
     * 商品数量
     */
    private BigDecimal amount;

    public CommodityAmountParam(Long commodityId, Integer amount) {
        this.commodityId = commodityId;
        this.amount = new BigDecimal(amount.toString());
    }

    public CommodityAmountParam(Long commodityId, BigDecimal amount) {
        this.commodityId = commodityId;
        this.amount = amount;
    }
}

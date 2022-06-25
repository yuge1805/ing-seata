package com.yuge.ing.seata.order.common.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuge
 * @since 2022-06-25
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderItemParam {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id
     */
    private Long commodityId;

    /**
     * 数量
     */
    private BigDecimal amount;

    public OrderItemParam(Long commodityId, Integer amount) {
        this.commodityId = commodityId;
        this.amount = new BigDecimal(amount.toString());
    }

}

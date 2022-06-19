package com.yuge.ing.seata.store.common.param;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>
 * 库存
 * </p>
 *
 * @author yuge
 * @since 2022-06-15
 */
@Getter
@Setter
public class StoreParam {

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 数量
     */
    private BigDecimal amount;


}

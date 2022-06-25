package com.yuge.ing.seata.store.common.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author yuge
 * @since 2022-06-25
 */
@Getter
@Setter
@NoArgsConstructor
public class CommodityParam {

    private Long id;

    /**
     * 商品名称
     */
    private String name;

    public CommodityParam(String name) {
        this.name = name;
    }

}

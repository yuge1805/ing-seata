package com.yuge.ing.seata.order.common.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuge
 * @since 2022-06-13
 */
@Getter
@Setter
public class OrderParam {

    private Long id;

    private String content;

    private Integer type;


}

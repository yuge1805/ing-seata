package com.yuge.ing.seata.store.common.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 出库单参数
 *
 * @author yuge
 * @since 2022-06-15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommodityOutboundParam {

    /**
     * 明细列表
     */
    private List<CommodityAmountParam> detailList;


}

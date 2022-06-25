package com.yuge.ing.seata.store.api;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.common.param.CommodityOutboundParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "store", contextId = "storeClient", path = "/store")
public interface StoreClient {

    @PostMapping
    @Deprecated
    CommonResponse<Long> add(@RequestBody CommodityInboundParam storeParam);

    /**
     * 出库
     *
     * @param outboundParam
     * @return
     */
    @PostMapping("/outbound")
    CommonResponse<Boolean> outbound(@RequestBody CommodityOutboundParam outboundParam);

}

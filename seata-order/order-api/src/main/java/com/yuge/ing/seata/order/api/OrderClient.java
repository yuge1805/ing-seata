package com.yuge.ing.seata.order.api;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.order.common.param.OrderParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order", contextId = "orderClient", path = "/order")
public interface OrderClient {

    @PostMapping
    CommonResponse<Boolean> add(@RequestBody OrderParam orderParam);

}

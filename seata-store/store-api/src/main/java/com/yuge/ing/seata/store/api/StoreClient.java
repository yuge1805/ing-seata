package com.yuge.ing.seata.store.api;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.store.common.param.StoreParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "store", contextId = "storeClient", path = "/store")
public interface StoreClient {

    @PostMapping
    CommonResponse<Long> add(@RequestBody StoreParam storeParam);

}

package com.yuge.ing.seata.store.controller;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.store.business.StoreBusiness;
import com.yuge.ing.seata.store.common.param.CommodityInboundParam;
import com.yuge.ing.seata.store.common.param.CommodityOutboundParam;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.yuge.ing.seata.store.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 库存
 *
 * @author yuge
 * @since 2022-06-15
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @Resource
    private StoreBusiness storeBusiness;

    @GetMapping
    public List<StoreEntity> list() {
        return storeService.list();
    }

    @GetMapping("/{id}")
    public CommonResponse<StoreEntity> detail(@PathVariable("id") Long id) {
        Optional<StoreEntity> optional = storeService.queryById(id);
        return CommonResponse.success(optional.get());
    }

    @Deprecated
    @PostMapping
    public CommonResponse<Long> add(@RequestBody CommodityInboundParam storeParam) {
        Long id = storeService.add(storeParam);
        if (id%2 == 0) {
            return CommonResponse.error("-1", "It's error!");
        }
        return CommonResponse.success(id);
    }

    /**
     * 出库
     *
     * @param outboundParam
     * @return
     */
    @PostMapping("/outbound")
    public CommonResponse<Boolean> outbound(@RequestBody CommodityOutboundParam outboundParam) {
        storeBusiness.outbound(outboundParam);
        return CommonResponse.success(true);
    }

    /**
     * 初始化
     *
     * @param inboundParam
     * @return
     */
    @PostMapping("/init")
    public CommonResponse<Boolean> init(@RequestBody CommodityInboundParam inboundParam) {
        storeBusiness.inbound(inboundParam);
        return CommonResponse.success(true);
    }


}

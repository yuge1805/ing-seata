package com.yuge.ing.seata.store.controller;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.seata.store.common.param.StoreParam;
import com.yuge.ing.seata.store.po.StoreEntity;
import com.yuge.ing.seata.store.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping
    public List<StoreEntity> list() {
        return storeService.list();
    }

    @PostMapping
    public CommonResponse<Long> add(@RequestBody StoreParam storeParam) {
        Long id = storeService.add(storeParam);
        if (id%2 == 0) {
            return CommonResponse.error("-1", "It's error!");
        }
        return CommonResponse.success(id);
    }

}

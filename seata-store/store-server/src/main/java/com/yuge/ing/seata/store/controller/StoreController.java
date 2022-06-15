package com.yuge.ing.seata.store.controller;

import com.yuge.ing.seata.store.po.StoreEntity;
import com.yuge.ing.seata.store.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

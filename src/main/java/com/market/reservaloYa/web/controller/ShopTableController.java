package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.domain.service.ShopTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopTable")
public class ShopTableController {
    @Autowired
    private ShopTableService shopTableService;

    @GetMapping("/all")
    public List<ShopTable> getAllShopTables() {
        return shopTableService.getAll();
    }

    @GetMapping("/id/{id}")
    public ShopTable getShopTable(@PathVariable("id") Long id) {
        return shopTableService.getShopTableById(id).orElse(null);
    }

    @PostMapping("/create")
    public ShopTable creteShopTable(@RequestBody ShopTable shopTable) {
        return shopTableService.saveShopTable(shopTable).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteShopTable(@PathVariable("id") Long id) {
        return shopTableService.delete(id);
    }
}

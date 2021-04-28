package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.domain.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/all")
    public List<Shop> getAllShops() {
        return shopService.getAll();
    }

    @GetMapping("/id/{id}")
    public Shop getShop(@PathVariable Long id) {
        return shopService.getShopById(id).orElse(null);
    }

    @PostMapping("/create")
    public Shop creteShop(@RequestBody Shop shop) {
        return shopService.saveShop(shop).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteShop(@PathVariable Long id) {
        return shopService.delete(id);
    }
}

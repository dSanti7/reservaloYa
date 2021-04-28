package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.domain.service.OwnerShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ownerShop")
public class OwnerShopController {
    @Autowired
    private OwnerShopService ownerShopService;

    @GetMapping("/all")
    public List<OwnerShop> getAllOwnerShops() {
        return ownerShopService.getAll();
    }

    @GetMapping("/id/{id}")
    public OwnerShop getOwnerShop(@PathVariable Long id) {
        return ownerShopService.getOwnerShopById(id).orElse(null);
    }

    @PostMapping("/create")
    public OwnerShop creteOwnerShop(@RequestBody OwnerShop ownerShop) {
        return ownerShopService.saveOwnerShop(ownerShop).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteOwnerShop(@PathVariable Long id) {
        return ownerShopService.delete(id);
    }
}

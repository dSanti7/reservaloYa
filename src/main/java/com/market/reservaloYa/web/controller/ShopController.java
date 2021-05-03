package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.domain.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/all")
    public ResponseEntity<List<Shop>> getAllShops() {
        return new ResponseEntity<>(shopService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shop shop = shopService.getShopById(id).orElse(null);
        if (shop != null) {
            return new ResponseEntity<>(shop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Shop> creteShop(@RequestBody Shop shop) {
        if (shop == null || (shop.getIdShop() != null && shopService.getShopById(shop.getIdShop()).isPresent())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shop responseShop = shopService.saveShop(shop).orElse(null);
        if (responseShop != null) {
            return new ResponseEntity<>(responseShop, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteShop(@PathVariable("id") Long id) {
        return shopService.delete(id);
    }
}

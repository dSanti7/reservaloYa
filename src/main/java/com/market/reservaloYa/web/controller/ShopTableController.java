package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.domain.service.ShopTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopTable")
public class ShopTableController {
    @Autowired
    private ShopTableService shopTableService;

    @GetMapping("/all")
    public ResponseEntity<List<ShopTable>> getAllShopTables() {
        return new ResponseEntity<>(shopTableService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ShopTable> getShopTable(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ShopTable shopTable = shopTableService.getShopTableById(id).orElse(null);
        if (shopTable != null) {
            return new ResponseEntity<>(shopTable, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<ShopTable> creteShopTable(@RequestBody ShopTable shopTable) {
        if (shopTable == null || (shopTable.getIdShopTable() != null && shopTableService.getShopTableById(shopTable.getIdShopTable()).isPresent())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ShopTable responseShopTable = shopTableService.saveShopTable(shopTable).orElse(null);
        if (responseShopTable != null) {
            return new ResponseEntity<>(responseShopTable, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteShopTable(@PathVariable("id") Long id) {
        return shopTableService.delete(id);
    }
}

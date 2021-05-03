package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.domain.service.OwnerShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ownerShop")
public class OwnerShopController {
    @Autowired
    private OwnerShopService ownerShopService;
    @GetMapping("/all")
    public ResponseEntity<List<OwnerShop>> getAllOwnerShops() {
        return new ResponseEntity<>(ownerShopService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<OwnerShop> getOwnerShop(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        OwnerShop ownerShop = ownerShopService.getOwnerShopById(id).orElse(null);
        if (ownerShop != null) {
            return new ResponseEntity<>(ownerShop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<OwnerShop> creteOwnerShop(@RequestBody OwnerShop ownerShop) {
        if (ownerShop == null || (ownerShop.getIdOwnerShop() != null && ownerShopService.getOwnerShopById(ownerShop.getIdOwnerShop()).isPresent())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        OwnerShop responseOwnerShop = ownerShopService.saveOwnerShop(ownerShop).orElse(null);
        if (responseOwnerShop != null) {
            return new ResponseEntity<>(responseOwnerShop, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteOwnerShop(@PathVariable("id") Long id) {
        return ownerShopService.delete(id);
    }
}

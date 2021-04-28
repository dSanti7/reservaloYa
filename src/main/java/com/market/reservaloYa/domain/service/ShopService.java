package com.market.reservaloYa.domain.service;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.domain.repository.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    IShopRepository shopRepository;

    public List<Shop> getAll() {
        return shopRepository.getAll();
    }

    public Optional<Shop> getShopById(Long id) {
        return shopRepository.getById(id);
    }

    public Optional<Shop> saveShop(Shop Shop) {
        return shopRepository.save(Shop);
    }

    public boolean delete(Long id) {
        return shopRepository.getById(id).map(ShopDB -> {
            shopRepository.delete(ShopDB);
            return true;
        }).orElse(false);
    }
}

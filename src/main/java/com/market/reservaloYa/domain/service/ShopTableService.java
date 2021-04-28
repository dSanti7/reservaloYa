package com.market.reservaloYa.domain.service;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.domain.repository.IShopTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopTableService {
    @Autowired
    IShopTableRepository shopTableRepository;

    public List<ShopTable> getAll() {
        return shopTableRepository.getAll();
    }

    public Optional<ShopTable> getShopTableById(Long id) {
        return shopTableRepository.getById(id);
    }

    public Optional<ShopTable> saveShopTable(ShopTable shopTable) {
        return shopTableRepository.save(shopTable);
    }

    public boolean delete(Long id) {
        return shopTableRepository.getById(id).map(shopTableDB -> {
            shopTableRepository.delete(shopTableDB);
            return true;
        }).orElse(false);
    }
}

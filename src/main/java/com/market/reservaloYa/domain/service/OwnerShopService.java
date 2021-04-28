package com.market.reservaloYa.domain.service;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.domain.repository.IOwnerShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerShopService {
    @Autowired
    IOwnerShopRepository ownerShopRepository;

    public List<OwnerShop> getAll() {
        return ownerShopRepository.getAll();
    }

    public Optional<OwnerShop> getOwnerShopById(Long id) {
        return ownerShopRepository.getById(id);
    }

    public Optional<OwnerShop> saveOwnerShop(OwnerShop ownerShop) {
        return ownerShopRepository.save(ownerShop);
    }

    public boolean delete(Long id) {
        return ownerShopRepository.getById(id).map(ownerShopDB -> {
            ownerShopRepository.delete(ownerShopDB);
            return true;
        }).orElse(false);
    }
}

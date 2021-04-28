package com.market.reservaloYa.domain.repository;

import com.market.reservaloYa.domain.OwnerShop;

import java.util.List;
import java.util.Optional;

public interface IOwnerShopRepository {
    List<OwnerShop> getAll();

    Optional<OwnerShop> getById(Long id);

    void delete(OwnerShop ownerShop);

    Optional<OwnerShop> save(OwnerShop ownerShop);

}

package com.market.reservaloYa.domain.repository;

import com.market.reservaloYa.domain.Shop;

import java.util.List;
import java.util.Optional;

public interface IShopRepository {
    List<Shop> getAll();

    Optional<Shop> getById(Long id);

    void delete(Shop IShopRepository);

    Optional<Shop> save(Shop IShopRepository);

}

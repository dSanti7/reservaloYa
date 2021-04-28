package com.market.reservaloYa.domain.repository;

import com.market.reservaloYa.domain.ShopTable;

import java.util.List;
import java.util.Optional;

public interface IShopTableRepository {
    List<ShopTable> getAll();

    Optional<ShopTable> getById(Long id);

    void delete(ShopTable shopTable);

    Optional<ShopTable> save(ShopTable shopTable);

}

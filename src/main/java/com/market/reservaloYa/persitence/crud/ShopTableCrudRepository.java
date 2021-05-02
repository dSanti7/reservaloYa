package com.market.reservaloYa.persitence.crud;

import com.market.reservaloYa.persitence.entity.ShopTableDB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopTableCrudRepository extends CrudRepository<ShopTableDB, Long> {

    List<ShopTableDB> findByIdShop(Long idShop);
}

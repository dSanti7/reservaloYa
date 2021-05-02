package com.market.reservaloYa.persitence.crud;

import com.market.reservaloYa.persitence.entity.ShopDB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopCrudRepository extends CrudRepository<ShopDB, Long> {

    List<ShopDB> findByIdOwner(Long idOwnerShop);
}

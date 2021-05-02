package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.domain.repository.IShopTableRepository;
import com.market.reservaloYa.persitence.crud.BookingShopTableCrudRepository;
import com.market.reservaloYa.persitence.crud.ShopCrudRepository;
import com.market.reservaloYa.persitence.crud.ShopTableCrudRepository;
import com.market.reservaloYa.persitence.entity.ShopDB;
import com.market.reservaloYa.persitence.entity.ShopTableDB;
import com.market.reservaloYa.persitence.mapper.ShopTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShopTableRepository implements IShopTableRepository {

    @Autowired
    private ShopTableCrudRepository shopTableCrudRepository;
    @Autowired
    private ShopTableMapper shopTableMapper;

    @Override
    public List<ShopTable> getAll() {
        return shopTableMapper.toShopTablesDomain((List<ShopTableDB>) shopTableCrudRepository.findAll());
    }

    @Override
    public Optional<ShopTable> getById(Long id) {
        return Optional.of(shopTableMapper.toShopTableDomain(shopTableCrudRepository.findById(id).orElse(null)));
    }

    @Override
    public void delete(ShopTable shopTable) {
        shopTableCrudRepository.delete(shopTableMapper.toShopTableDB(shopTable));
    }

    @Autowired
    private ShopCrudRepository shopCrudRepository;

    @Autowired
    private BookingShopTableCrudRepository bookingShopTableCrudRepository;

    @Override
    public Optional<ShopTable> save(ShopTable shopTable) {
        ShopTable responseShopTable = null;
        ShopDB shopDB = shopCrudRepository.findById(shopTable.getIdShop()).orElse(null);
        if (shopDB != null) {
            ShopTableDB shopTableDB = shopTableMapper.toShopTableDB(shopTable);
            shopTableDB.setShopDB(shopDB);
            shopTableDB.setBookingShopTableDBS(bookingShopTableCrudRepository.findByIdTable(shopTable.getIdShopTable()));
            responseShopTable = shopTableMapper.toShopTableDomain(shopTableCrudRepository.save(shopTableDB));
        }
        return Optional.ofNullable(responseShopTable);
    }
}

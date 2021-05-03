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
    @Autowired
    private ShopCrudRepository shopCrudRepository;

    @Autowired
    private BookingShopTableCrudRepository bookingShopTableCrudRepository;

    @Override
    public List<ShopTable> getAll() {
        return shopTableMapper.toShopTables((List<ShopTableDB>) shopTableCrudRepository.findAll());
    }

    @Override
    public Optional<ShopTable> getById(Long id) {
        Optional<ShopTableDB> shopTableDB = shopTableCrudRepository.findById(id);
        return shopTableDB.map(db -> shopTableMapper.toShopTable(db));
    }

    @Override
    public void delete(ShopTable shopTable) {
        shopTableCrudRepository.delete(shopTableMapper.toShopTableDB(shopTable));
    }

    @Override
    public Optional<ShopTable> save(ShopTable shopTable) {
        ShopTable responseShopTable = null;
        Optional<ShopDB> shopDB = shopCrudRepository.findById(shopTable.getIdShop());
        if (shopDB.isPresent()) {
            ShopTableDB shopTableDB = shopTableMapper.toShopTableDB(shopTable);
            responseShopTable = shopTableMapper.toShopTable(shopTableCrudRepository.save(shopTableDB));
        }
        return Optional.ofNullable(responseShopTable);
    }
}

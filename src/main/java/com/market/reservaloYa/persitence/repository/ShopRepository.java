package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.domain.repository.IShopRepository;
import com.market.reservaloYa.persitence.crud.OwnerShopCrudRepository;
import com.market.reservaloYa.persitence.crud.ShopCrudRepository;
import com.market.reservaloYa.persitence.crud.ShopTableCrudRepository;
import com.market.reservaloYa.persitence.entity.ShopDB;
import com.market.reservaloYa.persitence.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShopRepository implements IShopRepository {

    @Autowired
    private ShopCrudRepository shopCrudRepository;
    @Autowired
    private OwnerShopCrudRepository ownerShopCrudRepository;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopTableCrudRepository shopTableCrudRepository;

    @Override
    public List<Shop> getAll() {
        return shopMapper.toShops((List<ShopDB>) shopCrudRepository.findAll());
    }

    @Override
    public Optional<Shop> getById(Long id) {
        Optional<ShopDB> shopDB = shopCrudRepository.findById(id);
        return shopDB.map(db -> shopMapper.toShop(db));
    }

    @Override
    public void delete(Shop shop) {
        shopCrudRepository.delete(shopMapper.toShopDB(shop));
    }


    @Override
    public Optional<Shop> save(Shop shop) {
        Shop saveShop = null;
        if (ownerShopCrudRepository.findById(shop.getIdOwnerShop()).isPresent()) {
            saveShop = shopMapper.toShop(shopCrudRepository.save(shopMapper.toShopDB(shop)));
        }
        return Optional.ofNullable(saveShop);
    }
}

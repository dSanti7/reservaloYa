package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.domain.repository.IOwnerShopRepository;
import com.market.reservaloYa.persitence.crud.OwnerShopCrudRepository;
import com.market.reservaloYa.persitence.crud.ShopCrudRepository;
import com.market.reservaloYa.persitence.entity.OwnerShopDB;
import com.market.reservaloYa.persitence.mapper.OwnerShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OwnerShopRepository implements IOwnerShopRepository {

    @Autowired
    private OwnerShopCrudRepository ownerShopCrudRepository;
    @Autowired
    private OwnerShopMapper ownerShopMapper;
    @Autowired
    private ShopCrudRepository shopCrudRepository;

    @Override
    public List<OwnerShop> getAll() {
        return ownerShopMapper.toOwnersShop((List<OwnerShopDB>) ownerShopCrudRepository.findAll());
    }

    @Override
    public Optional<OwnerShop> getById(Long id) {
        Optional<OwnerShopDB> ownerShopDB = ownerShopCrudRepository.findById(id);
        return ownerShopDB.map(db -> ownerShopMapper.toOwnerShop(db));
    }

    @Override
    public void delete(OwnerShop ownerShop) {
        ownerShopCrudRepository.delete(ownerShopMapper.toOwnerShopDB(ownerShop));
    }

    @Override
    public Optional<OwnerShop> save(OwnerShop ownerShop) {
        return Optional.of(ownerShopMapper.toOwnerShop(ownerShopCrudRepository.save(ownerShopMapper.toOwnerShopDB(ownerShop))));
    }
}

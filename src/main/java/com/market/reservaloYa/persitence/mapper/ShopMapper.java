package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.persitence.entity.ShopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ShopMapper {

    @Autowired
    private OwnerShopMapper ownerShopMapper;
    @Autowired
    private ShopTableMapper shopTableMapper;

    public Shop toShopDomain(ShopDB shopDB) {
        if (shopDB == null) return null;
        return Shop.builder()
                .phoneNumber(shopDB.getPhoneNumber())
                .name(shopDB.getName())
                .geographicalPosition(shopDB.getGeographicalPosition())
                .email(shopDB.getEmail())
                .idShop(shopDB.getId())
                .ownerShop(ownerShopMapper.toOwnerShop(shopDB.getOwnerShopDB())).build();

    }

    public List<Shop> toShopsDomain(List<ShopDB> shopsDB) {
        if (shopsDB == null) return null;
        return shopsDB.stream().map(this::toShopDomain).collect(Collectors.toList());
    }

    public ShopDB toShopDB(Shop shop) {
        if (shop == null) return null;
        return ShopDB.builder()
                .email(shop.getEmail())
                .geographicalPosition(shop.getGeographicalPosition())
                .id(shop.getIdShop())
                .idOwner(shop.getOwnerShop().getIdOwnerShop())
                .name(shop.getName())
                .ownerShopDB(ownerShopMapper.toOwnerShopDB(shop.getOwnerShop()))
                .phoneNumber(shop.getPhoneNumber())
                .shopTablesDB(shopTableMapper.toShopTablesDBS(shop.getShopTable())).build();
    }

    public List<ShopDB> toShopsDB(List<Shop> shops) {
        if (shops == null) return null;
        return shops.stream().map(this::toShopDB).collect(Collectors.toList());
    }
}

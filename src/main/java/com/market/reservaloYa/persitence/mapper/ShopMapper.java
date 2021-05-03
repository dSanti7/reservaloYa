package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.persitence.entity.ShopDB;
import com.sun.istack.NotNull;
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

    public Shop toShop(@NotNull ShopDB shopDB) {

        return Shop.builder()
                .phoneNumber(shopDB.getPhoneNumber())
                .name(shopDB.getName())
                .geographicalPosition(shopDB.getGeographicalPosition())
                .email(shopDB.getEmail())
                .idShop(shopDB.getId())
                .ownerShop(ownerShopMapper.toOwnerShop(shopDB.getOwnerShopDB())).build();

    }

    public List<Shop> toShops(@NotNull List<ShopDB> shopsDB) {

        return shopsDB.stream().map(this::toShop).collect(Collectors.toList());
    }

    public ShopDB toShopDB(@NotNull Shop shop) {

        return ShopDB.builder()
                .email(shop.getEmail())
                .geographicalPosition(shop.getGeographicalPosition())
                .id(shop.getIdShop())
                .idOwner(shop.getOwnerShop().getIdOwnerShop())
                .name(shop.getName())
                .ownerShopDB(ownerShopMapper.toOwnerShopDB(shop.getOwnerShop()))
                .phoneNumber(shop.getPhoneNumber())
                .shopTablesDB(shopTableMapper.toShopTablesDB(shop.getShopTable())).build();
    }

    public List<ShopDB> toShopsDB(@NotNull List<Shop> shops) {

        return shops.stream().map(this::toShopDB).collect(Collectors.toList());
    }
}

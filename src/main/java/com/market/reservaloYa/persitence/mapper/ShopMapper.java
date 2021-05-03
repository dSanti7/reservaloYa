package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.ShopDB;
import com.market.reservaloYa.persitence.entity.ShopTableDB;
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
                .shopTable(getShopTableByShopDB(shopDB))
                .ownerShop(ownerShopMapper.toOwnerShop(shopDB.getOwnerShopDB())).build();

    }

    private List<ShopTable> getShopTableByShopDB(ShopDB shopDB) {
        if (shopDB.getShopTablesDB().isEmpty()) {
            return null;
        }
        return shopTableMapper.toShopTables(shopDB.getShopTablesDB());
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
                .shopTablesDB(getShopTablesDBByShop(shop)).build();
    }

    private List<ShopTableDB> getShopTablesDBByShop(Shop shop) {
        if (shop.getShopTable().isEmpty()) {
            return null;
        }
        return shopTableMapper.toShopTablesDB(shop.getShopTable());
    }

    public List<ShopDB> toShopsDB(@NotNull List<Shop> shops) {
        return shops.stream().map(this::toShopDB).collect(Collectors.toList());
    }
}

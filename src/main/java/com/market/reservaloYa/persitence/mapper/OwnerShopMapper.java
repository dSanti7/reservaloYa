package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.persitence.entity.OwnerShopDB;
import com.market.reservaloYa.persitence.entity.ShopDB;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwnerShopMapper {

    @Autowired
    private ShopMapper shopMapper;

    public OwnerShop toOwnerShop(@NotNull OwnerShopDB ownerShopDB) {

        return OwnerShop.builder()
                .email(ownerShopDB.getEmail()).idOwnerShop(ownerShopDB.getId()).lastName(ownerShopDB.getLastName())
                .name(ownerShopDB.getName())
                .password(ownerShopDB.getPassword())
                .phoneNumber(ownerShopDB.getPhoneNumber())
                .shops(getShopsByOwnerShopDB(ownerShopDB))
                .build();
    }

    private List<Shop> getShopsByOwnerShopDB(OwnerShopDB ownerShopDB) {
        if(ownerShopDB.getShopsDB().isEmpty()){
            return null;
        }
        return shopMapper.toShops(ownerShopDB.getShopsDB());
    }

    public List<OwnerShop> toOwnersShop(@NotNull List<OwnerShopDB> ownersShopDB) {

        return ownersShopDB.stream().map(this::toOwnerShop).collect(Collectors.toList());
    }

    public OwnerShopDB toOwnerShopDB(@NotNull OwnerShop ownerShop) {

        return OwnerShopDB.builder().email(ownerShop.getEmail()).id(ownerShop.getIdOwnerShop())
                .lastName(ownerShop.getLastName()).name(ownerShop.getName())
                .password(ownerShop.getPassword())
                .phoneNumber(ownerShop.getPhoneNumber())
                .shopsDB(getShopsDBByOwnerShop(ownerShop))
                .build();
    }

    private List<ShopDB> getShopsDBByOwnerShop(OwnerShop ownerShop) {
        if(ownerShop.getShops().isEmpty()){
            return null;
        }
        return shopMapper.toShopsDB(ownerShop.getShops());
    }

    public List<OwnerShopDB> toOwnersShopDB(@NotNull List<OwnerShop> ownerShops) {

        return ownerShops.stream().map(this::toOwnerShopDB).collect(Collectors.toList());
    }

}

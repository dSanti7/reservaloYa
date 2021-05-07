package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.persitence.entity.OwnerShopDB;
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
                .email(ownerShopDB.getEmail())
                .lastName(ownerShopDB.getLastName())
                .name(ownerShopDB.getName())
                .password(ownerShopDB.getPassword())
                .phoneNumber(ownerShopDB.getPhoneNumber())
               // .shops(getShopsByOwnerShopDB(ownerShopDB))
                .build();
    }

    public List<OwnerShop> toOwnersShop(@NotNull List<OwnerShopDB> ownersShopDB) {

        return ownersShopDB.stream().map(this::toOwnerShop).collect(Collectors.toList());
    }

    public OwnerShopDB toOwnerShopDB(@NotNull OwnerShop ownerShop) {

        return OwnerShopDB.builder().email(ownerShop.getEmail())
                .lastName(ownerShop.getLastName())
                .name(ownerShop.getName())
                .password(ownerShop.getPassword())
                .phoneNumber(ownerShop.getPhoneNumber())
             //   .shopsDB(getShopsDBByOwnerShop(ownerShop))
                .build();
    }

    public List<OwnerShopDB> toOwnersShopDB(@NotNull List<OwnerShop> ownerShops) {
        return ownerShops.stream().map(this::toOwnerShopDB).collect(Collectors.toList());
    }

}

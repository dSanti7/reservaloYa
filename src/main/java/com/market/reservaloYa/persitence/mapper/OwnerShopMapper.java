package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.persitence.entity.OwnerShopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwnerShopMapper {

    @Autowired
    private ShopMapper shopMapper;

    public OwnerShop toOwnerShop(OwnerShopDB ownerShopDB) {
        if (ownerShopDB == null) return null;
        return ownerShopDB != null ? OwnerShop.builder()
                .email(ownerShopDB.getEmail()).idOwnerShop(ownerShopDB.getId()).lastName(ownerShopDB.getLastName())
                .name(ownerShopDB.getName())
                .password(ownerShopDB.getPassword())
                .phoneNumber(ownerShopDB.getPhoneNumber())
                .shops(shopMapper.toShopsDomain(ownerShopDB.getShopsDB()))
                .build() : null;
    }

    public List<OwnerShop> toOwnersShop(List<OwnerShopDB> ownersShopDB) {
        if (ownersShopDB == null) return null;
        return ownersShopDB.stream().map(this::toOwnerShop).collect(Collectors.toList());
    }

    public OwnerShopDB toOwnerShopDB(OwnerShop ownerShop) {
        if (ownerShop == null) return null;
        return OwnerShopDB.builder().email(ownerShop.getEmail()).id(ownerShop.getIdOwnerShop())
                .lastName(ownerShop.getLastName()).name(ownerShop.getName())
                .password(ownerShop.getPassword())
                .phoneNumber(ownerShop.getPhoneNumber())
                .shopsDB(shopMapper.toShopsDB(ownerShop.getShops()))
                .build();
    }

    public List<OwnerShopDB> toOwnersShopDB(List<OwnerShop> ownerShops) {
        if (ownerShops == null) return null;
        return ownerShops.stream().map(this::toOwnerShopDB).collect(Collectors.toList());
    }

}

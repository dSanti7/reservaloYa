package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.persitence.entity.OwnerShopDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerShopMapper {
    @Mappings({
            @Mapping(source = "id", target = "idOwnerShop"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "password", target = "password")
    })
    OwnerShop toOwnerShopDomain(OwnerShopDB ownerShopDB);
    List<OwnerShop> toOwnersShopDomain(List<OwnerShopDB> ownerShops);

    @InheritInverseConfiguration
    OwnerShopDB toOwnerShopDB(OwnerShop ownerShop);

    List<OwnerShopDB> toOwnersShopDB(List<OwnerShop> ownerShops);
}

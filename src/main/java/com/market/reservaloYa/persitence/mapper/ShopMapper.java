package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.persitence.entity.ShopDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OwnerShopMapper.class})
public interface ShopMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "geographicalPosition", target = "geographicalPosition"),
            @Mapping(source = "id", target = "idShop"),
            @Mapping(source = "idOwner", target = "idOwnerShop"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),

    })
    Shop toShopDomain(ShopDB shopDB);

    List<Shop> toShopsDomain(List<ShopDB> shopDB);

    @InheritInverseConfiguration
    ShopDB toShopDB(Shop shop);
}

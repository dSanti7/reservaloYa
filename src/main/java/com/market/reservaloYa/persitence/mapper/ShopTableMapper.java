package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.ShopTableDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ShopMapper.class})
public interface ShopTableMapper {

    @Mappings({
            @Mapping(source = "id", target = "idShopTable"),
            @Mapping(source = "idShop", target = "idShop"),
            @Mapping(source = "positionShop", target = "positionShop"),
            @Mapping(source = "maxPeople", target = "maxPeople"),
            @Mapping(source = "minPeople", target = "minPeople"),
    })
    ShopTable toShopTableDomain(ShopTableDB shopTableDB);

    List<ShopTable> toShopTablesDomain(List<ShopTableDB> shopTableDB);

    @InheritInverseConfiguration
    ShopTableDB toShopTableDB(ShopTable shopTable);

    List<ShopTableDB> toSHopTablesDB(List<ShopTable> shopTable);
}

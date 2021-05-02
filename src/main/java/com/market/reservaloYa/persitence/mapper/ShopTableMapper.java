package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.ShopTableDB;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ShopTableMapper {

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private ShopMapper shopMapper;

    public ShopTable toShopTableDomain(ShopTableDB shopTableDB) {
        if (shopTableDB == null) return null;
        return ShopTable.builder().idShopTable(shopTableDB.getId())
                .idShop(shopTableDB.getIdShop())
                .maxPeople(shopTableDB.getMaxPeople())
                .minPeople(shopTableDB.getMinPeople())
                .positionShop(shopTableDB.getPositionShop())
                .build();
    }

    public List<ShopTable> toShopTablesDomain(List<ShopTableDB> shopTableDB) {
        if (shopTableDB == null) return null;
        return shopTableDB.stream().map(this::toShopTableDomain).collect(Collectors.toList());
    }

    public ShopTableDB toShopTableDB(ShopTable shopTable) {
        if (shopTable == null) return null;
        return ShopTableDB.builder()
                .bookingShopTableDBS(shopTable.getBookings().stream()
                        .map(booking -> bookingMapper.getBookingShopTableDBByBooking(booking))
                        .collect(Collectors.toList()))
                .id(shopTable.getIdShopTable())
                .idShop(shopTable.getIdShop())
                .maxPeople(shopTable.getMaxPeople())
                .minPeople(shopTable.getMinPeople())
                .positionShop(shopTable.getPositionShop())
                .shopDB(shopMapper.toShopDB(shopTable.getShop()))
                .build();
    }

    public List<ShopTableDB> toShopTablesDBS(List<ShopTable> shopTables) {
        if (shopTables == null) return null;
        return shopTables.stream().map(this::toShopTableDB).collect(Collectors.toList());
    }
}

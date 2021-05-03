package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.ShopTableDB;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopTableMapper {

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private ShopMapper shopMapper;

    public ShopTable toShopTable(@NotNull ShopTableDB shopTableDB) {

        return ShopTable.builder().idShopTable(shopTableDB.getId())
                .idShop(shopTableDB.getIdShop())
                .maxPeople(shopTableDB.getMaxPeople())
                .minPeople(shopTableDB.getMinPeople())
                .positionShop(shopTableDB.getPositionShop())
                .build();
    }

    public List<ShopTable> toShopTables(@NotNull List<ShopTableDB> shopTableDB) {

        return shopTableDB.stream().map(this::toShopTable).collect(Collectors.toList());
    }

    public ShopTableDB toShopTableDB(@NotNull ShopTable shopTable) {

        return ShopTableDB.builder()
                .bookingShopTablesDB(getBookingShopTablesDBByShopTable(shopTable))
                .id(shopTable.getIdShopTable())
                .idShop(shopTable.getIdShop())
                .maxPeople(shopTable.getMaxPeople())
                .minPeople(shopTable.getMinPeople())
                .positionShop(shopTable.getPositionShop())
                .shopDB(shopMapper.toShopDB(shopTable.getShop()))
                .build();
    }

    private List<BookingShopTableDB> getBookingShopTablesDBByShopTable(ShopTable shopTable) {
        if (shopTable.getBookings().isEmpty()) return null;
        return shopTable.getBookings().stream()
                .map(booking -> bookingMapper.getBookingShopTableDBByBooking(booking))
                .collect(Collectors.toList());
    }

    public List<ShopTableDB> toShopTablesDB(@NotNull List<ShopTable> shopTables) {
        if (shopTables == null) return null;
        return shopTables.stream().map(this::toShopTableDB).collect(Collectors.toList());
    }
}

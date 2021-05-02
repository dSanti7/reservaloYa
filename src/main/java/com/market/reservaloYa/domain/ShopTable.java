package com.market.reservaloYa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ShopTable {

    private Long idShopTable;
    private Long idShop;
    private Short positionShop;
    private Short maxPeople;
    private Short minPeople;

    private List<Booking> bookings;
    private Shop shop;
}

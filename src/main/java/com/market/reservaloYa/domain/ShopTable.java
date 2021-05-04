package com.market.reservaloYa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShopTable {

    private Long idShopTable;
    private Long idShop;
    private Short positionShop;
    private Short maxPeople;
    private Short minPeople;

    private List<Booking> bookings;

}

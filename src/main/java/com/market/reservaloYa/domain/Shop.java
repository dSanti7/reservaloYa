package com.market.reservaloYa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Shop {

    private String name;
    private String geographicalPosition;
    private String phoneNumber;
    private String email;
    private Long idOwnerShop;


    private List<ShopTable> shopTable;
}

package com.market.reservaloYa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Shop {

    private Long idShop;
    private String name;
    private String geographicalPosition;
    private String phoneNumber;
    private String email;
    private Long idOwnerShop;

}

package com.market.reservaloYa.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Shop {

    private Long idShop;
    private String name;
    private String geographicalPosition;
    private String phoneNumber;
    private String email;
    private Long idOwnerShop;


    private List<ShopTable> shopTable;
}

package com.market.reservaloYa.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OwnerShop {

    private Long   idOwnerShop;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    private List<Shop> shops;
}

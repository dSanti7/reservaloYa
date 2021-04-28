package com.market.reservaloYa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Client{

    private Long idClient;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

}


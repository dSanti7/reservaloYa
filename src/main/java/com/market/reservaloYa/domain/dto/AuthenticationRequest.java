package com.market.reservaloYa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String user;
    private String pass;

}

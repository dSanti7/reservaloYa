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
public class Client{

    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    private List<Booking> bookings;

}


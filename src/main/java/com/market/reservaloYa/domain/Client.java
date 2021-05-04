package com.market.reservaloYa.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Client{

    private Long idClient;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    private List<Booking> bookings;

}


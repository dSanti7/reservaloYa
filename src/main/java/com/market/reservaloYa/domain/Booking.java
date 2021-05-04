package com.market.reservaloYa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.market.reservaloYa.constants.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Booking {

    private Long idBooking;
    private Short people;
    private Status status;
    private LocalDateTime dayBooking;
    private Long idClient;
    private Long idShopTable;

}

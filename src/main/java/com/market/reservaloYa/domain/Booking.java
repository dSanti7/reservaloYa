package com.market.reservaloYa.domain;

import com.market.reservaloYa.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Booking {

    private Long idBooking;
    private Short people;
    private Status status;
    private LocalDateTime dayBooking;

    private Client client;
    private ShopTable shopTable;


}

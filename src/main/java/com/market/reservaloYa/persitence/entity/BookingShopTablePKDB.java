package com.market.reservaloYa.persitence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookingShopTablePKDB implements Serializable {
    @Column(name = "id_table")
    private Long idTable;
    @Column(name = "id_booking")
    private Long idBooking;

}

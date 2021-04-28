package com.market.reservaloYa.persitence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
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

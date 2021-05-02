package com.market.reservaloYa.persitence.entity;

import com.market.reservaloYa.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking_shop_table")
public class BookingShopTableDB {

    @EmbeddedId
    private BookingShopTablePKDB id;
    private Status status;
    @Column(name = "day_booking")
    private LocalDateTime dayBooking;

    @ManyToOne
    @JoinColumn(name = "id_table", updatable = false, insertable = false)
    private ShopTableDB shopTableDB;

    @ManyToOne
    @JoinColumn(name = "id_booking", insertable = false, updatable = false)
    private BookingDB bookingDB;

}
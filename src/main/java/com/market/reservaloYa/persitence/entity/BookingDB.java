package com.market.reservaloYa.persitence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class BookingDB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_booking_shop_table")
    private Long idBookingShopTable;
    @Column(name = "id_client")
    private Long idClient;
    private Short people;

    @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private ClientDB clientDB;

    @OneToMany
    @JoinColumn(name = "id_booking_shop_table",insertable = false,updatable = false)
    private List<BookingShopTableDB> bookingShopTableDBS;

}

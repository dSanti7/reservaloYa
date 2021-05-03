package com.market.reservaloYa.persitence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class BookingDB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_table")
    private Long idTable;
    @Column(name = "id_client")
    private Long idClient;
    private Short people;

    @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private ClientDB clientDB;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumns({
            @JoinColumn(name="id_table", referencedColumnName="id_table", insertable = false,updatable = false),
            @JoinColumn(name="id", referencedColumnName="id_booking", insertable = false,updatable = false)
    })
    private BookingShopTableDB bookingShopTableDB;

}

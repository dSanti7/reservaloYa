package com.market.reservaloYa.persitence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop_tables")
public class ShopTableDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_shop")
    private Long idShop;
    @Column(name = "position_shop")
    private short positionShop;

    @Column(name = "max_people")
    private short maxPeople;
    @Column(name = "min_people")
    private short minPeople;

    @ManyToOne
    @JoinColumn(name = "id_shop", updatable = false, insertable = false)
    private ShopDB shopDB;

    @OneToMany
    @JoinColumn(name = "shopTable")
    private List<BookingShopTableDB> bookingShopTableDBS;

}

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shops")
public class ShopDB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "geographical_position")
    private String geographicalPosition;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @Column(name = "id_owner")
    private Long idOwner;

    @ManyToOne
    @JoinColumn(name = "id_owner", updatable = false, insertable = false)
    private OwnerShopDB ownerShopDB;

    @OneToMany(mappedBy = "shopDB")
    private List<ShopTableDB> shopTableDBS;

}

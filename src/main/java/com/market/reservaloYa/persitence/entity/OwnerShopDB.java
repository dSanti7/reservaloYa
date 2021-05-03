package com.market.reservaloYa.persitence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owner_shops")
public class OwnerShopDB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String password;

    @OneToMany(mappedBy = "ownerShopDB")
    private List<ShopDB> shopsDB;

}

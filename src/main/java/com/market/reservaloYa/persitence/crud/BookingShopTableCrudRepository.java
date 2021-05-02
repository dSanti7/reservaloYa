package com.market.reservaloYa.persitence.crud;

import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingShopTableCrudRepository extends CrudRepository<BookingShopTableDB, Long> {

    @Query(value = "SELECT * FROM booking_shop_table WHERE id_table = ? ", nativeQuery = true)
    List<BookingShopTableDB> findByIdTable(Long idShopTable);
}

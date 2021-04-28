package com.market.reservaloYa.persitence.crud;

import com.market.reservaloYa.persitence.entity.BookingDB;
import org.springframework.data.repository.CrudRepository;

public interface BookingCrudRepository extends CrudRepository<BookingDB, Long> {

}

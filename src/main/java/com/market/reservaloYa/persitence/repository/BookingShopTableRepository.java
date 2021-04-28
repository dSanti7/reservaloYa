package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.persitence.crud.BookingShopTableCrudRepository;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingShopTableRepository {


    private BookingShopTableCrudRepository bookingShopTableCrudRepository;


    public List<BookingShopTableDB> findAll() {
        return (List<BookingShopTableDB>) bookingShopTableCrudRepository.findAll();
    }

    public Optional<BookingShopTableDB> findById(Long id) {
        return bookingShopTableCrudRepository.findById(id);
    }

    public void delete(BookingShopTableDB bookingShopTableDBRepository) {
        bookingShopTableCrudRepository.delete(bookingShopTableDBRepository);
    }

    public BookingShopTableDB save(BookingShopTableDB bookingShopTableDBRepository) {
        return bookingShopTableCrudRepository.save(bookingShopTableDBRepository);
    }
}

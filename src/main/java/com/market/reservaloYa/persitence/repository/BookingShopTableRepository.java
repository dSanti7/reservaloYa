package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.persitence.crud.BookingShopTableCrudRepository;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingShopTableRepository  {

    @Autowired
    private BookingShopTableCrudRepository bookingShopTableCrudRepository;


    public List<BookingShopTableDB> findAll() {
        return (List<BookingShopTableDB>) bookingShopTableCrudRepository.findAll();
    }

    public Optional<BookingShopTableDB> findById(@NotNull Long id) {
        return bookingShopTableCrudRepository.findById(id);
    }

    public void delete(@NotNull BookingShopTableDB bookingShopTableDBRepository) {
        bookingShopTableCrudRepository.delete(bookingShopTableDBRepository);
    }

    public Optional<BookingShopTableDB> save(@NotNull BookingShopTableDB bookingShopTableDBRepository) {
        return Optional.of(bookingShopTableCrudRepository.save(bookingShopTableDBRepository));
    }
}

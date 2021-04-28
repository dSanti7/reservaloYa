package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.repository.IBookingRepository;
import com.market.reservaloYa.persitence.crud.BookingCrudRepository;
import com.market.reservaloYa.persitence.crud.BookingShopTableCrudRepository;
import com.market.reservaloYa.persitence.crud.ClientCrudRepository;
import com.market.reservaloYa.persitence.crud.ShopTableCrudRepository;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.ClientDB;
import com.market.reservaloYa.persitence.entity.ShopTableDB;
import com.market.reservaloYa.persitence.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookingRepository implements IBookingRepository {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    @Autowired
    private ShopTableCrudRepository shopTableCrudRepository;
    @Autowired
    private BookingShopTableCrudRepository bookingShopTableCrudRepository;
    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public List<Booking> getAll() {

        List<BookingDB> bookingDBList = (List<BookingDB>) bookingCrudRepository.findAll();
        List<ClientDB> clientDBS = bookingDBList.stream().map(BookingDB::getClientDB).collect(Collectors.toList());
        List<List<BookingShopTableDB>> bookingsShopTable = bookingDBList.stream().map(BookingDB::getBookingShopTableDBS).collect(Collectors.toList());
        List<List<ShopTableDB>> shopTables = bookingsShopTable.stream()
                .map(listBookingShopTable -> listBookingShopTable.stream()
                        .map(BookingShopTableDB::getShopTableDB).collect(Collectors.toList())
                ).collect(Collectors.toList());

//        return bookingMapper.toBookingsDomain(bookingDBList, clientDBS, shopTables, bookingsShopTable);
        return null;
    }

    @Override
    public Optional<Booking> getById(Long id) {
        return Optional.of(bookingMapper.toBookingDomain(bookingCrudRepository.findById(id).orElse(null)));
    }

    @Override
    public void delete(Booking booking) {

    }

    @Override
    public Optional<Booking> save(Booking booking) {
        return null;
    }
}

package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.repository.IBookingRepository;
import com.market.reservaloYa.persitence.crud.BookingCrudRepository;
import com.market.reservaloYa.persitence.crud.BookingShopTableCrudRepository;
import com.market.reservaloYa.persitence.crud.ClientCrudRepository;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.BookingShopTablePKDB;
import com.market.reservaloYa.persitence.mapper.BookingMapper;
import com.market.reservaloYa.persitence.mapper.ShopTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepository implements IBookingRepository {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;

    @Autowired
    private BookingShopTableCrudRepository bookingShopTableCrudRepository;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private ShopTableMapper shopTableMapper;

    @Override
    public List<Booking> getAll() {
        return bookingMapper.toBookingsDomain((List<BookingDB>) bookingCrudRepository.findAll());

    }

    @Override
    public Optional<Booking> getById(Long id) {
        BookingDB bookingDB = bookingCrudRepository.findById(id).orElse(null);
        Booking booking = bookingMapper.toBookingDomain(bookingDB);
        if (bookingDB != null) {
            booking.setShopTable(shopTableMapper.toShopTableDomain(
                    bookingDB.getBookingShopTableDB().getShopTableDB()));
        }
        return Optional.of(booking);
    }

    @Override
    public void delete(Booking booking) {

    }

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Override
    public Optional<Booking> save(Booking booking) {

        BookingDB bookingDB = bookingMapper.toBookingDB(booking);
        Booking responseBooking = bookingMapper.toBookingDomain(bookingCrudRepository.save(bookingDB));
        if (responseBooking != null) {

            BookingShopTableDB bookingShopTableDB = BookingShopTableDB.builder()
                    .id(BookingShopTablePKDB.builder()
                            .idTable(booking.getShopTable().getIdShopTable())
                            .idBooking(booking.getIdBooking()).build())
                    .shopTableDB(shopTableMapper.toShopTableDB(booking.getShopTable()))
                    .bookingDB(bookingDB)
                    .dayBooking(booking.getDayBooking())
                    .status(booking.getStatus())
                    .build();
            bookingShopTableCrudRepository.save(bookingShopTableDB);
        }
        return Optional.ofNullable(responseBooking);
    }
}

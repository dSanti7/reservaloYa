package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.repository.IBookingRepository;
import com.market.reservaloYa.persitence.crud.BookingCrudRepository;
import com.market.reservaloYa.persitence.crud.ClientCrudRepository;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.BookingShopTablePKDB;
import com.market.reservaloYa.persitence.mapper.BookingMapper;
import com.market.reservaloYa.persitence.mapper.ShopTableMapper;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepository implements IBookingRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;
    @Autowired
    private BookingCrudRepository bookingCrudRepository;
    @Autowired
    private BookingShopTableRepository bookingShopTableRepository;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private ShopTableMapper shopTableMapper;

    @Override
    public List<Booking> getAll() {

        return bookingMapper.toBookings((List<BookingDB>) bookingCrudRepository.findAll(), bookingShopTableRepository.findAll());
    }

    @Override
    public Optional<Booking> getById(Long id) {
        Optional<BookingDB> bookingDB = bookingCrudRepository.findById(id);
        return bookingDB.map(db -> bookingMapper.toBooking(db));
    }

    @Override
    public void delete(@NotNull Booking booking) {
        bookingCrudRepository.delete(bookingMapper.toBookingDB(booking));
    }

    @Override
    public Optional<Booking> save(@NotNull Booking booking) {

        BookingDB bookingDB = bookingCrudRepository.save(bookingMapper.toBookingDB(booking));
        BookingShopTableDB bookingShopTableDB = saveBookingShopTable(booking, bookingDB);

        bookingDB.setBookingShopTableDB(bookingShopTableDB);

        Booking responseBooking = bookingMapper.toBooking(bookingDB);
        return Optional.ofNullable(responseBooking);
    }

    private BookingShopTableDB saveBookingShopTable(Booking booking, BookingDB bookingDB) {
        BookingShopTableDB bookingShopTableDB = BookingShopTableDB.builder()
                .id(BookingShopTablePKDB.builder()
                        .idTable(booking.getIdShopTable())
                        .idBooking(bookingDB.getId()).build())
                .dayBooking(booking.getDayBooking())
                .status(booking.getStatus())
                .build();
        return bookingShopTableRepository.save(bookingShopTableDB).orElse(null);
        //todo: cuidado cuando no se haya guardado bookingShopTable
    }
}

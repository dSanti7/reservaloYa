package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.BookingShopTablePKDB;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ShopTableMapper shopTableMapper;

    public Booking toBooking(@NotNull BookingDB bookingDB) {

        return Booking.builder()
                .idBooking(bookingDB.getId())
                .status(bookingDB.getBookingShopTableDB().getStatus())
                .client(clientMapper.toClient(bookingDB.getClientDB()))
                .people(bookingDB.getPeople())
                .dayBooking(bookingDB.getBookingShopTableDB().getDayBooking())
                .shopTable(shopTableMapper.toShopTable(bookingDB.getBookingShopTableDB().getShopTableDB()))
                .build();
    }

    public List<Booking> toBookings(@NotNull List<BookingDB> bookingsDB) {

        return bookingsDB.stream().map(this::toBooking).collect(Collectors.toList());
    }

    public BookingDB toBookingDB(@NotNull Booking booking) {

        return BookingDB.builder()
                .people(booking.getPeople())
                .idTable(booking.getShopTable().getIdShopTable())
                .idClient(booking.getClient().getIdClient())
                .id(booking.getIdBooking())
                .clientDB(clientMapper.toClientDB(booking.getClient()))
                .bookingShopTableDB(getBookingShopTableDBByBooking(booking))
                .build();
    }

    public BookingShopTableDB getBookingShopTableDBByBooking(@NotNull Booking booking) {
        return BookingShopTableDB.builder()
                .id(getBookingShopTablePKDBByBooking(booking))
                .status(booking.getStatus())
                .dayBooking(booking.getDayBooking())
                .bookingDB(toBookingDB(booking))
                .shopTableDB(shopTableMapper.toShopTableDB(booking.getShopTable())).build();
    }

    private BookingShopTablePKDB getBookingShopTablePKDBByBooking(@NotNull Booking booking) {
        return BookingShopTablePKDB.builder()
                .idBooking(booking.getIdBooking())
                .idTable(booking.getShopTable().getIdShopTable()).build();
    }

    public List<BookingDB> toBookingsDB(@NotNull List<Booking> bookings) {

        return bookings.stream().map(this::toBookingDB).collect(Collectors.toList());
    }
}

package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.BookingShopTablePKDB;
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


    public Booking toBookingDomain(BookingDB bookingDBEntity) {
        if (bookingDBEntity == null) return null;
        return Booking.builder().idBooking(bookingDBEntity.getId())
                .status(bookingDBEntity.getBookingShopTableDB().getStatus())
                .client(clientMapper.toClientDomain(bookingDBEntity.getClientDB()))
                .people(bookingDBEntity.getPeople())
                .dayBooking(bookingDBEntity.getBookingShopTableDB().getDayBooking())
                .shopTable(shopTableMapper.toShopTableDomain(bookingDBEntity.getBookingShopTableDB().getShopTableDB()))
                .build();
    }

    public List<Booking> toBookingsDomain(List<BookingDB> bookingsDB) {
        if (bookingsDB == null) return null;
        return bookingsDB.stream().map(this::toBookingDomain).collect(Collectors.toList());
    }

    public BookingDB toBookingDB(Booking booking) {
        if (booking == null) return null;
        return BookingDB.builder().people(booking.getPeople()).idTable(booking.getShopTable().getIdShopTable())
                .idClient(booking.getClient().getIdClient())
                .id(booking.getIdBooking())
                .clientDB(clientMapper.toClientDB(booking.getClient()))
                .bookingShopTableDB(getBookingShopTableDBByBooking(booking))
                .build();
    }

    public BookingShopTableDB getBookingShopTableDBByBooking(Booking booking) {
        if (booking == null) return null;
        return BookingShopTableDB.builder()
                .id(getBookingShopTablePKDBByBooking(booking))
                .status(booking.getStatus())
                .dayBooking(booking.getDayBooking())
                .bookingDB(toBookingDB(booking))
                .shopTableDB(shopTableMapper.toShopTableDB(booking.getShopTable())).build();
    }

    private BookingShopTablePKDB getBookingShopTablePKDBByBooking(Booking booking) {
        if (booking == null) return null;
        return BookingShopTablePKDB.builder()
                .idBooking(booking.getIdBooking())
                .idTable(booking.getShopTable().getIdShopTable()).build();
    }

    public List<BookingDB> toBookingsDB(List<Booking> bookings) {
        if (bookings == null) return null;
        return bookings.stream().map(this::toBookingDB).collect(Collectors.toList());
    }
}

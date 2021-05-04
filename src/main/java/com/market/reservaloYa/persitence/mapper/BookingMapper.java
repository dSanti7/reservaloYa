package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.constants.Status;
import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.BookingShopTablePKDB;
import com.market.reservaloYa.persitence.repository.BookingShopTableRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
                .status(getStatusByBookingDB(bookingDB))
                .idClient(bookingDB.getIdClient())
                .people(bookingDB.getPeople())
                .dayBooking(getDayBookingByBookingDB(bookingDB))
                .idShopTable(getIdTableByBookingDB(bookingDB))
                .build();
    }

    private Long getIdTableByBookingDB(BookingDB bookingDB) {
        if (bookingDB.getBookingShopTableDB() == null) {
            return null;
        }
        return bookingDB.getBookingShopTableDB().getId().getIdTable();
    }

    private LocalDateTime getDayBookingByBookingDB(BookingDB bookingDB) {

        if (bookingDB.getBookingShopTableDB() == null) {
            return null;
        }
        return bookingDB.getBookingShopTableDB().getDayBooking();
    }

    private Status getStatusByBookingDB(BookingDB bookingDB) {
        if (bookingDB.getBookingShopTableDB() == null) {
            return null;
        }
        return bookingDB.getBookingShopTableDB().getStatus();
    }

    public List<Booking> toBookings(@NotNull List<BookingDB> bookingsDB, List<BookingShopTableDB> bookingShopTablesDB) {

        return bookingsDB.stream().map(bookingDB -> {
            for (BookingShopTableDB booking :
                    bookingShopTablesDB) {
                if (booking.getId().getIdBooking().equals(bookingDB.getId())) {
                    bookingDB.setBookingShopTableDB(booking);
                }
            }
            /*List<BookingShopTableDB> bookingShopTable = bookingShopTablesDB.stream()
                    .filter(bookingShopTableDB ->
                            bookingShopTableDB.getId().getIdBooking().equals(bookingDB.getId()))
                    .collect(Collectors.toList());
                    */

            return toBooking(bookingDB);
        }).collect(Collectors.toList());
    }

    public BookingDB toBookingDB(@NotNull Booking booking) {

        return BookingDB.builder()
                .people(booking.getPeople())
                .idClient(booking.getIdClient())
                .id(booking.getIdBooking())
//                .clientDB(clientMapper.toClientDB(booking.getClient()))
//                .bookingShopTableDB(getBookingShopTableDBByBooking(booking))
                .build();
    }

    public BookingShopTableDB getBookingShopTableDBByBooking(@NotNull Booking booking) {
        return BookingShopTableDB.builder()
                .id(getBookingShopTablePKDBByBooking(booking))
                .status(booking.getStatus())
                .dayBooking(booking.getDayBooking())
//                .bookingDB(toBookingDB(booking))
//                .shopTableDB(shopTableMapper.toShopTableDB(booking.getShopTable()))
                .build();
    }

    private BookingShopTablePKDB getBookingShopTablePKDBByBooking(@NotNull Booking booking) {
        return BookingShopTablePKDB.builder()
                .idBooking(booking.getIdBooking())
                .idTable(booking.getIdShopTable())
                .build();
    }

    public List<BookingDB> toBookingsDB(@NotNull List<Booking> bookings) {

        return bookings.stream().map(this::toBookingDB).collect(Collectors.toList());
    }
}

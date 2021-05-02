package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.Application;
import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import com.market.reservaloYa.persitence.entity.ClientDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
class BookingMapperTest {

    @Autowired
    private BookingMapper bookingMapper;

    @Test
    void toBookingDomain() {


    }

    @Test
    void toBookingsDomain() {
        Assertions.assertTrue(true);
    }

    @Test
    void toBookingDB() {
    }

    @Test
    void toBookingsDB() {
    }
}
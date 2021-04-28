package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }

    @GetMapping("/id/{id}")
    public Booking getBooking(@PathVariable("id") Long id) {
        return bookingService.getBookingById(id).orElse(null);
    }

    @PostMapping("/create")
    public Booking creteBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteBooking(@PathVariable("id") Long id) {
        return bookingService.delete(id);
    }
}

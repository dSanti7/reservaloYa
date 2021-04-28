package com.market.reservaloYa.domain.service;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    IBookingRepository bookingRepository;

    public List<Booking> getAll() {
        return bookingRepository.getAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.getById(id);
    }

    public Optional<Booking> saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public boolean delete(Long id) {
        return bookingRepository.getById(id).map(bookingDB -> {
            bookingRepository.delete(bookingDB);
            return true;
        }).orElse(false);
    }
}

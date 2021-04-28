package com.market.reservaloYa.domain.repository;

import com.market.reservaloYa.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository {
    List<Booking> getAll();

    Optional<Booking> getById(Long id);

    void delete(Booking booking);

    Optional<Booking> save(Booking booking);

}

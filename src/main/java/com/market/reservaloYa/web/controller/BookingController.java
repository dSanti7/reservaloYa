package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.service.BookingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation("Client create a booking")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Booking has been created"),
            @ApiResponse(code = 500, message = "Error, when creating booking")

    })
    public ResponseEntity<Booking> creteBooking(@RequestBody Booking booking) {
        if (booking == null || (booking.getIdBooking() != null && bookingService.getBookingById(booking.getIdBooking()).isPresent())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Booking responseBooking = bookingService.saveBooking(booking).orElse(null);
        if (responseBooking != null) {
            return new ResponseEntity<>(responseBooking, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/id/{id}")
    @ApiResponses({
            @ApiResponse(code = 200,message = "Booking has been found"),
            @ApiResponse(code = 404, message = "Booking has not been found"),
            @ApiResponse(code = 400, message = "Error in the parameters")
    })
    public ResponseEntity<Booking> getBooking(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Booking booking = bookingService.getBookingById(id).orElse(null);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteBooking(@PathVariable("id") Long id) {
        return bookingService.delete(id);
    }
}

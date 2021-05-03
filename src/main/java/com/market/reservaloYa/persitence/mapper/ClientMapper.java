package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.ClientDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sun.istack.NotNull;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    @Autowired
    private BookingMapper bookingMapper;

    public Client toClient(@NotNull ClientDB clientDB) {

        return Client.builder()
                .idClient(clientDB.getId())
                .email(clientDB.getEmail())
                .lastName(clientDB.getLastName())
                .name(clientDB.getName())
                .password(clientDB.getPassword())
                .phoneNumber(clientDB.getPhoneNumber())
                .bookings(getBookingsByClientDB(clientDB))
                .build();
    }

    private List<Booking> getBookingsByClientDB(ClientDB clientDB) {
        if (clientDB.getBookingsDB().isEmpty()) {
            return null;
        }
        return bookingMapper.toBookings(clientDB.getBookingsDB());
    }


    public List<Client> toClients(@NotNull List<ClientDB> clientsDB) {

        return clientsDB.stream().map(this::toClient).collect(Collectors.toList());
    }


    public ClientDB toClientDB(@NotNull Client client) {

        return ClientDB.builder()
                .bookingsDB(getBookingsDBByClient(client))
                .email(client.getEmail())
                .id(client.getIdClient())
                .lastName(client.getLastName())
                .name(client.getName())
                .password(client.getPassword())
                .phoneNumber(client.getPhoneNumber()).build();
    }

    private List<BookingDB> getBookingsDBByClient(Client client) {
        if (client.getBookings().isEmpty()) {
            return null;
        }
        return bookingMapper.toBookingsDB(client.getBookings());
    }

    public List<ClientDB> toClientsDB(@NotNull List<Client> clients) {

        return clients.stream().map(this::toClientDB).collect(Collectors.toList());
    }
}


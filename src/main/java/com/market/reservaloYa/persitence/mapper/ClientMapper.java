package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.persitence.entity.ClientDB;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    @Autowired
    private BookingMapper bookingMapper;

    public Client toClient(@NotNull ClientDB clientDB) {

        return Client.builder()
                .email(clientDB.getEmail())
                .lastName(clientDB.getLastName())
                .name(clientDB.getName())
                .password(clientDB.getPassword())
                .phoneNumber(clientDB.getPhoneNumber())
             //   .bookings(getBookingsByClientDB(clientDB))
                .build();
    }

    public List<Client> toClients(@NotNull List<ClientDB> clientsDB) {

        return clientsDB.stream().map(this::toClient).collect(Collectors.toList());
    }


    public ClientDB toClientDB(@NotNull Client client) {

        return ClientDB.builder()
//                .bookingsDB(getBookingsDBByClient(client))
                .email(client.getEmail())
                .lastName(client.getLastName())
                .name(client.getName())
                .password(client.getPassword())
                .phoneNumber(client.getPhoneNumber()).build();
    }

    public List<ClientDB> toClientsDB(@NotNull List<Client> clients) {

        return clients.stream().map(this::toClientDB).collect(Collectors.toList());
    }
}


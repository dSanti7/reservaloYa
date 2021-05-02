package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.persitence.entity.ClientDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    @Autowired
    private BookingMapper bookingMapper;

    public Client toClientDomain(ClientDB clientDB) {
        if (clientDB == null) return null;
        return Client.builder()
                .idClient(clientDB.getId())
                .email(clientDB.getEmail())
                .lastName(clientDB.getLastName())
                .name(clientDB.getName())
                .password(clientDB.getPassword())
                .phoneNumber(clientDB.getPhoneNumber())
                .bookings(bookingMapper.toBookingsDomain(clientDB.getBookingDBS()))
                .build();
    }


    public List<Client> toClientsDomain(List<ClientDB> clientsDB) {
        if (clientsDB == null) return null;
        return clientsDB.stream().map(this::toClientDomain).collect(Collectors.toList());
    }


    public ClientDB toClientDB(Client client) {
        if (client == null) return null;
        return ClientDB.builder()
                .bookingDBS(bookingMapper.toBookingsDB(client.getBookings()))
                .email(client.getEmail())
                .id(client.getIdClient())
                .lastName(client.getLastName())
                .name(client.getName())
                .password(client.getPassword())
                .phoneNumber(client.getPhoneNumber()).build();
    }

    public List<ClientDB> toClientsDB(List<Client> clients) {
        if (clients == null) return null;
        return clients.stream().map(this::toClientDB).collect(Collectors.toList());
    }
}


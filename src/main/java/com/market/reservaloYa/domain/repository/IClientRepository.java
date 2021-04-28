package com.market.reservaloYa.domain.repository;

import com.market.reservaloYa.domain.Client;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {
    List<Client> getAll();

    Optional<Client> getById(Long id);

    void delete(Client client);

    Optional<Client> save(Client client);

}

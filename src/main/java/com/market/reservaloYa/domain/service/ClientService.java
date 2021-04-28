package com.market.reservaloYa.domain.service;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.domain.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    IClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.getById(id);
    }

    public Optional<Client> saveClient(Client client) {
        return clientRepository.save(client);
    }

    public boolean delete(Long id) {
        return clientRepository.getById(id).map(clientDB -> {
            clientRepository.delete(clientDB);
            return true;
        }).orElse(false);
    }
}

package com.market.reservaloYa.persitence.repository;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.domain.repository.IClientRepository;
import com.market.reservaloYa.persitence.crud.ClientCrudRepository;
import com.market.reservaloYa.persitence.entity.ClientDB;
import com.market.reservaloYa.persitence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> getAll() {
        return clientMapper.toClients((List<ClientDB>) clientCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getById(Long id) {
        Optional<ClientDB> clientDB = clientCrudRepository.findById(id);
        return clientDB.map(db -> clientMapper.toClient(db));
    }

    @Override
    public void delete(Client client) {
        clientCrudRepository.delete(clientMapper.toClientDB(client));
    }

    @Override
    public Optional<Client> save(Client client) {
        return Optional.of(clientMapper.toClient(clientCrudRepository.save(clientMapper.toClientDB(client))));
    }
}

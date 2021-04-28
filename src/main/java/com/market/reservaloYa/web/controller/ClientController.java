package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @GetMapping("/id/{id}")
    public Client getClient(@PathVariable("id") Long id) {
        return clientService.getClientById(id).orElse(null);
    }

    @PostMapping("/create")
    public Client creteClient(@RequestBody Client client) {
        return clientService.saveClient(client).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteClient(@PathVariable("id") Long id) {
        return clientService.delete(id);
    }
}

package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.domain.service.ClientService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Client client = clientService.getClientById(id).orElse(null);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Client has been found"),
            @ApiResponse(code = 400, message = "Error in the parameters"),
            @ApiResponse(code = 404, message = "Client has not been found")
    })
    public ResponseEntity<Client> creteClient(@RequestBody Client client) {
        if (client == null || (client.getIdClient() != null && clientService.getClientById(client.getIdClient()).isPresent())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Client responseClient = clientService.saveClient(client).orElse(null);
        if (responseClient != null) {
            return new ResponseEntity<>(responseClient, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteClient(@PathVariable("id") Long id) {
        return clientService.delete(id);
    }
}

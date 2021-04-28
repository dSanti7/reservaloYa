package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.persitence.entity.ClientDB;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-28T09:46:01+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.3.jar, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toClientDomain(ClientDB clientDB) {
        if ( clientDB == null ) {
            return null;
        }

        Long idClient = null;
        String name = null;
        String lastName = null;
        String phoneNumber = null;
        String email = null;
        String password = null;

        idClient = clientDB.getId();
        name = clientDB.getName();
        lastName = clientDB.getLastName();
        phoneNumber = clientDB.getPhoneNumber();
        email = clientDB.getEmail();
        password = clientDB.getPassword();

        Client client = new Client( idClient, name, lastName, phoneNumber, email, password );

        return client;
    }

    @Override
    public List<Client> toClientsDomain(List<ClientDB> clientDB) {
        if ( clientDB == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientDB.size() );
        for ( ClientDB clientDB1 : clientDB ) {
            list.add( toClientDomain( clientDB1 ) );
        }

        return list;
    }

    @Override
    public ClientDB toClientDB(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDB clientDB = new ClientDB();

        clientDB.setId( client.getIdClient() );
        clientDB.setName( client.getName() );
        clientDB.setLastName( client.getLastName() );
        clientDB.setPhoneNumber( client.getPhoneNumber() );
        clientDB.setEmail( client.getEmail() );
        clientDB.setPassword( client.getPassword() );

        return clientDB;
    }
}

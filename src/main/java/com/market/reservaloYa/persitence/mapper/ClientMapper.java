package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.persitence.entity.ClientDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "id", target = "idClient"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password")
    })
    Client toClientDomain(ClientDB clientDB);
    List<Client> toClientsDomain(List<ClientDB> clientDB);

    @InheritInverseConfiguration
    ClientDB toClientDB(Client client);
}

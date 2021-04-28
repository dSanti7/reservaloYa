package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.OwnerShop;
import com.market.reservaloYa.persitence.entity.OwnerShopDB;
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
public class OwnerShopMapperImpl implements OwnerShopMapper {

    @Override
    public OwnerShop toOwnerShopDomain(OwnerShopDB ownerShopDB) {
        if ( ownerShopDB == null ) {
            return null;
        }

        Long idOwnerShop = null;
        String phoneNumber = null;
        String email = null;
        String name = null;
        String lastName = null;
        String password = null;

        idOwnerShop = ownerShopDB.getId();
        phoneNumber = ownerShopDB.getPhoneNumber();
        email = ownerShopDB.getEmail();
        name = ownerShopDB.getName();
        lastName = ownerShopDB.getLastName();
        password = ownerShopDB.getPassword();

        OwnerShop ownerShop = new OwnerShop( idOwnerShop, name, lastName, phoneNumber, email, password );

        return ownerShop;
    }

    @Override
    public List<OwnerShop> toOwnersShopDomain(List<OwnerShopDB> ownerShops) {
        if ( ownerShops == null ) {
            return null;
        }

        List<OwnerShop> list = new ArrayList<OwnerShop>( ownerShops.size() );
        for ( OwnerShopDB ownerShopDB : ownerShops ) {
            list.add( toOwnerShopDomain( ownerShopDB ) );
        }

        return list;
    }

    @Override
    public OwnerShopDB toOwnerShopDB(OwnerShop ownerShop) {
        if ( ownerShop == null ) {
            return null;
        }

        OwnerShopDB ownerShopDB = new OwnerShopDB();

        ownerShopDB.setId( ownerShop.getIdOwnerShop() );
        ownerShopDB.setPhoneNumber( ownerShop.getPhoneNumber() );
        ownerShopDB.setEmail( ownerShop.getEmail() );
        ownerShopDB.setName( ownerShop.getName() );
        ownerShopDB.setLastName( ownerShop.getLastName() );
        ownerShopDB.setPassword( ownerShop.getPassword() );

        return ownerShopDB;
    }

    @Override
    public List<OwnerShopDB> toOwnersShopDB(List<OwnerShop> ownerShops) {
        if ( ownerShops == null ) {
            return null;
        }

        List<OwnerShopDB> list = new ArrayList<OwnerShopDB>( ownerShops.size() );
        for ( OwnerShop ownerShop : ownerShops ) {
            list.add( toOwnerShopDB( ownerShop ) );
        }

        return list;
    }
}

package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Shop;
import com.market.reservaloYa.persitence.entity.ShopDB;
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
public class ShopMapperImpl implements ShopMapper {

    @Override
    public Shop toShopDomain(ShopDB shopDB) {
        if ( shopDB == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String geographicalPosition = null;
        Long idShop = null;
        Long idOwnerShop = null;
        String phoneNumber = null;

        name = shopDB.getName();
        email = shopDB.getEmail();
        geographicalPosition = shopDB.getGeographicalPosition();
        idShop = shopDB.getId();
        idOwnerShop = shopDB.getIdOwner();
        phoneNumber = shopDB.getPhoneNumber();

        Shop shop = new Shop( idShop, name, geographicalPosition, phoneNumber, email, idOwnerShop );

        return shop;
    }

    @Override
    public List<Shop> toShopsDomain(List<ShopDB> shopDB) {
        if ( shopDB == null ) {
            return null;
        }

        List<Shop> list = new ArrayList<Shop>( shopDB.size() );
        for ( ShopDB shopDB1 : shopDB ) {
            list.add( toShopDomain( shopDB1 ) );
        }

        return list;
    }

    @Override
    public ShopDB toShopDB(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDB shopDB = new ShopDB();

        shopDB.setName( shop.getName() );
        shopDB.setEmail( shop.getEmail() );
        shopDB.setGeographicalPosition( shop.getGeographicalPosition() );
        shopDB.setId( shop.getIdShop() );
        shopDB.setIdOwner( shop.getIdOwnerShop() );
        shopDB.setPhoneNumber( shop.getPhoneNumber() );

        return shopDB;
    }
}

package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.ShopTableDB;
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
public class ShopTableMapperImpl implements ShopTableMapper {

    @Override
    public ShopTable toShopTableDomain(ShopTableDB shopTableDB) {
        if ( shopTableDB == null ) {
            return null;
        }

        Long idShopTable = null;
        Long idShop = null;
        Short positionShop = null;
        Short maxPeople = null;
        Short minPeople = null;

        idShopTable = shopTableDB.getId();
        idShop = shopTableDB.getIdShop();
        positionShop = shopTableDB.getPositionShop();
        maxPeople = shopTableDB.getMaxPeople();
        minPeople = shopTableDB.getMinPeople();

        ShopTable shopTable = new ShopTable( idShopTable, idShop, positionShop, maxPeople, minPeople );

        return shopTable;
    }

    @Override
    public List<ShopTable> toShopTablesDomain(List<ShopTableDB> shopTableDB) {
        if ( shopTableDB == null ) {
            return null;
        }

        List<ShopTable> list = new ArrayList<ShopTable>( shopTableDB.size() );
        for ( ShopTableDB shopTableDB1 : shopTableDB ) {
            list.add( toShopTableDomain( shopTableDB1 ) );
        }

        return list;
    }

    @Override
    public ShopTableDB toShopTableDB(ShopTable shopTable) {
        if ( shopTable == null ) {
            return null;
        }

        ShopTableDB shopTableDB = new ShopTableDB();

        shopTableDB.setId( shopTable.getIdShopTable() );
        shopTableDB.setIdShop( shopTable.getIdShop() );
        if ( shopTable.getPositionShop() != null ) {
            shopTableDB.setPositionShop( shopTable.getPositionShop() );
        }
        if ( shopTable.getMaxPeople() != null ) {
            shopTableDB.setMaxPeople( shopTable.getMaxPeople() );
        }
        if ( shopTable.getMinPeople() != null ) {
            shopTableDB.setMinPeople( shopTable.getMinPeople() );
        }

        return shopTableDB;
    }

    @Override
    public List<ShopTableDB> toSHopTablesDB(List<ShopTable> shopTable) {
        if ( shopTable == null ) {
            return null;
        }

        List<ShopTableDB> list = new ArrayList<ShopTableDB>( shopTable.size() );
        for ( ShopTable shopTable1 : shopTable ) {
            list.add( toShopTableDB( shopTable1 ) );
        }

        return list;
    }
}

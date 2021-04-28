package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.constants.Status;
import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.persitence.entity.BookingDB;
import com.market.reservaloYa.persitence.entity.BookingShopTableDB;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-28T09:46:01+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.3.jar, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Booking toBookingDomain(BookingDB bookingDBEntity) {
        if ( bookingDBEntity == null ) {
            return null;
        }

        Long idBooking = null;
        Client client = null;
        List<ShopTable> shopTables = null;
        Short people = null;

        idBooking = bookingDBEntity.getId();
        client = clientMapper.toClientDomain( bookingDBEntity.getClientDB() );
        shopTables = bookingShopTableDBListToShopTableList( bookingDBEntity.getBookingShopTableDBS() );
        people = bookingDBEntity.getPeople();

        LocalDateTime dayBooking = null;
        Status status = null;

        Booking booking = new Booking( idBooking, people, status, dayBooking, client, shopTables );

        return booking;
    }

    @Override
    public List<Booking> toBookingsDomain(List<BookingDB> bookingDBEntity) {
        if ( bookingDBEntity == null ) {
            return null;
        }

        List<Booking> list = new ArrayList<Booking>( bookingDBEntity.size() );
        for ( BookingDB bookingDB : bookingDBEntity ) {
            list.add( toBookingDomain( bookingDB ) );
        }

        return list;
    }

    @Override
    public BookingDB toBookingDB(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDB bookingDB = new BookingDB();

        bookingDB.setIdClient( bookingClientIdClient( booking ) );
        bookingDB.setId( booking.getIdBooking() );
        bookingDB.setClientDB( clientMapper.toClientDB( booking.getClient() ) );
        bookingDB.setBookingShopTableDBS( shopTableListToBookingShopTableDBList( booking.getShopTables() ) );
        bookingDB.setPeople( booking.getPeople() );

        return bookingDB;
    }

    @Override
    public List<BookingDB> toBookingsDB(List<Booking> booking) {
        if ( booking == null ) {
            return null;
        }

        List<BookingDB> list = new ArrayList<BookingDB>( booking.size() );
        for ( Booking booking1 : booking ) {
            list.add( toBookingDB( booking1 ) );
        }

        return list;
    }

    protected ShopTable bookingShopTableDBToShopTable(BookingShopTableDB bookingShopTableDB) {
        if ( bookingShopTableDB == null ) {
            return null;
        }

        Long idShopTable = null;
        Long idShop = null;
        Short positionShop = null;
        Short maxPeople = null;
        Short minPeople = null;

        ShopTable shopTable = new ShopTable( idShopTable, idShop, positionShop, maxPeople, minPeople );

        return shopTable;
    }

    protected List<ShopTable> bookingShopTableDBListToShopTableList(List<BookingShopTableDB> list) {
        if ( list == null ) {
            return null;
        }

        List<ShopTable> list1 = new ArrayList<ShopTable>( list.size() );
        for ( BookingShopTableDB bookingShopTableDB : list ) {
            list1.add( bookingShopTableDBToShopTable( bookingShopTableDB ) );
        }

        return list1;
    }

    private Long bookingClientIdClient(Booking booking) {
        if ( booking == null ) {
            return null;
        }
        Client client = booking.getClient();
        if ( client == null ) {
            return null;
        }
        Long idClient = client.getIdClient();
        if ( idClient == null ) {
            return null;
        }
        return idClient;
    }

    protected BookingShopTableDB shopTableToBookingShopTableDB(ShopTable shopTable) {
        if ( shopTable == null ) {
            return null;
        }

        BookingShopTableDB bookingShopTableDB = new BookingShopTableDB();

        return bookingShopTableDB;
    }

    protected List<BookingShopTableDB> shopTableListToBookingShopTableDBList(List<ShopTable> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingShopTableDB> list1 = new ArrayList<BookingShopTableDB>( list.size() );
        for ( ShopTable shopTable : list ) {
            list1.add( shopTableToBookingShopTableDB( shopTable ) );
        }

        return list1;
    }
}

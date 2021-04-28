package com.market.reservaloYa.persitence.mapper;

import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.persitence.entity.BookingDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, ShopTableMapper.class})
public interface BookingMapper {
    //todo: tengo que hacer bien el mapeo intentando que se muestre la info del cliente al usar la api
    @Mappings({
            @Mapping(source = "id", target = "idBooking"),
            @Mapping(source = "clientDB", target = "client"),
            @Mapping(source = "bookingShopTableDBS", target = "shopTables"),
            @Mapping(source = "people", target = "people"),
            @Mapping(target = "dayBooking", ignore = true),
            @Mapping(target = "status", ignore = true)
    })
    Booking toBookingDomain(BookingDB bookingDBEntity);

    List<Booking> toBookingsDomain(List<BookingDB> bookingDBEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "client.idClient", target = "idClient"),
            @Mapping(target = "idBookingShopTable", ignore = true)
    })
    BookingDB toBookingDB(Booking booking);

    List<BookingDB> toBookingsDB(List<Booking> booking);

}

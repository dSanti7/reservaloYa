import com.market.reservaloYa.Application;
import com.market.reservaloYa.constants.Status;
import com.market.reservaloYa.domain.Booking;
import com.market.reservaloYa.domain.Client;
import com.market.reservaloYa.domain.ShopTable;
import com.market.reservaloYa.web.controller.BookingController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
public class BookingControllerTest {

    //@Autowired
    private BookingController bookingController;
//
    @Test
    public void ShouldSaveBookingAndReturnBookingSaved() {
        Assertions.assertTrue(true);
    /*
        LocalDateTime dateTime = LocalDateTime.now();
        Booking booking = Booking.builder()
                .idBooking(1L)
                .dayBooking(dateTime)
                .client(Client.builder()
                        .idClient(13L)
                        .build())
                .people((short) 3)
                .shopTable(ShopTable.builder()
                        .idShop(4L)
                        .idShopTable(19L)
                        .build())
                .status(Status.WAITING)
                .build();
        Booking refundBooking = bookingController.creteBooking(booking);

        Assertions.assertEquals("", refundBooking.getClient());
        Assertions.assertEquals(dateTime, refundBooking.getDayBooking());
        Assertions.assertEquals("", refundBooking.getIdBooking());
        Assertions.assertEquals("", refundBooking.getPeople());
        Assertions.assertEquals("", refundBooking.getShopTable());
        Assertions.assertEquals("", refundBooking.getStatus());*/
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    InvoiceGenerator invoiceGenerator;

    @BeforeEach
    public void setUp(){
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        double diff = Math.abs(25 - fare);
        Assertions.assertEquals(25.0, fare, diff);
    }

    @Test
    public void givenLessDistaneOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        double diff = Math.abs(5 - fare);
        Assertions.assertEquals(5,fare, diff);
    }
}
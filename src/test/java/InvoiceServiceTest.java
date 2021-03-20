import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    @BeforeEach
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time, "normal");
        double diff = Math.abs(25 - fare);
        Assertions.assertEquals(25.0, fare, diff);
    }

    @Test
    public void givenLessDistaneOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time, "normal");
        double diff = Math.abs(5 - fare);
        Assertions.assertEquals(5, fare, diff);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.calculateFare(rides, 5, "normal");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void getUserRideSummaryTest() {
        ArrayList<InvoiceSummary> expectedSummery = new ArrayList<>();
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides1, 5, "normal");
        expectedSummery.add(summary);
        Ride[] rides2 = {new Ride(2.0, 5),
                new Ride(0.3, 1)
        };
        summary = invoiceGenerator.calculateFare(rides2, 5, "premium");
        expectedSummery.add(summary);
        Assertions.assertEquals(expectedSummery, RideRepository.getUserRideList(5));
    }
}
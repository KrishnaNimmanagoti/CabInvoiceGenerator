public class InvoiceGenerator {
    private static final int MINIMUM_COST_PER_KM_FOR_NORMAL_RIDES= 10;
    private static final int COST_PER_TIME_FOR_NORMAL_RIDES = 1;
    private static final double MINIMUM_FARE_FOR_NORMAL_RIDES = 5.0;
    private static final int MINIMUM_COST_PER_KM_FOR_PREMIUM_RIDES= 15;
    private static final int COST_PER_TIME_FOR_PREMIUM_RIDES = 2;
    private static final double MINIMUM_FARE_FOR_PREMIUM_RIDES = 20;

    public double calculateFare(double distance, int time, String rideType) {
        if (rideType.equals("normal")) {
            double totalFare = (distance * MINIMUM_COST_PER_KM_FOR_NORMAL_RIDES + time * COST_PER_TIME_FOR_NORMAL_RIDES);
            return Math.max(totalFare, MINIMUM_FARE_FOR_NORMAL_RIDES);
        }
        if (rideType.equals("premium")) {
            double totalFare = (distance * MINIMUM_COST_PER_KM_FOR_PREMIUM_RIDES + time * COST_PER_TIME_FOR_PREMIUM_RIDES);
            return Math.max(totalFare, MINIMUM_FARE_FOR_PREMIUM_RIDES);
        }
        return 0.0;
    }

    public InvoiceSummary calculateFare(Ride[] rides, int userID, String rideType){
        double totalFare = 0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, rideType);
        }
        InvoiceSummary summary = new InvoiceSummary(rides.length, totalFare) ;
        RideRepository.addRide(userID, summary);
        return summary;
    }
}

//hai
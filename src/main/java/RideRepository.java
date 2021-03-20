import java.util.ArrayList;
import java.util.HashMap;

public class RideRepository {
    private static HashMap<Integer, ArrayList<InvoiceSummary>> userData = new HashMap<>();
    public static ArrayList<InvoiceSummary> getUserRideList(int userID){
        return userData.get(userID);
    }
    public static void addRide(int userId, InvoiceSummary summary){
        ArrayList<InvoiceSummary> userInvoice = userData.get(userId);
        if(userInvoice == null){
            userInvoice = new ArrayList<>();
        }
        userInvoice.add(summary);
        userData.put(userId,userInvoice);
    }
}

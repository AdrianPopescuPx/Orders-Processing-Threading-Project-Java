import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Database {
    public static File orderFileOut;
    public static File productFileOut;
    private static final FileWriter orderWriter;

    static {
        try {
            orderWriter = new FileWriter(Constants.outputOrder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    private static final FileWriter productWriter;

    static {
        try {
            productWriter = new FileWriter(Constants.outputOrderProducts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static final HashMap<String, Integer> orders = new HashMap<>();
    public static final HashMap<String, Integer> ordersData = new HashMap<>();

    public static HashMap<Product, Boolean> products = new HashMap<>();

    public static final Set<String> activeOrders = new HashSet<>();


    public static synchronized void addOrder(Order order) {
        orders.put(order.getId(), order.getNumberOfProducts());
    }

    public static void showOrders() {
        for (HashMap.Entry<String, Integer> entry : orders.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    public static void writeOrderToFile(String orderId) throws IOException {
        orderWriter.write(orderId + "," + ordersData.get(orderId) + ",shipped\n");
        orderWriter.flush();
    }

    public static void writeProductToFile(String productId, String orderId) throws IOException {
        productWriter.write(productId + "," + orderId + ",shipped\n");
        productWriter.flush();
    }
}

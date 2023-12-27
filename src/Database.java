import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Database {
    public static final HashMap<String, Integer> orders = new HashMap<>();

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

    public static synchronized void addWorkedProduct(String productId, String orderId) {
        System.out.println(productId + " " + orderId + "shipped it!");
    }

    public static void addProduct(Product product) {
        products.put(product, false);
    }
}

import java.util.HashMap;

public class Database {
    public static  HashMap<String, Integer> orders = new HashMap<>();

    public static HashMap<String, String> orderProduct = new HashMap<>();

    public static synchronized void addOrder(Order order) {
        orders.put(order.getId(), order.getNumberOfProducts());
    }

    public static void showOrders() {
        for (HashMap.Entry<String, Integer> entry : orders.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static synchronized boolean hasOrder(Order order) {
        return false;
    }
}

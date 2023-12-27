import javax.xml.crypto.Data;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class OrderWorker implements Runnable{

    private ExecutorService productsExecutorService;
    private String inputLocation;
    private Integer threadsNumber;
    private int start;
    private int end;
    public OrderWorker(Integer threadsNumber, String inputLocation, int start, int end, ExecutorService productsExecutorService) {
        this.productsExecutorService = productsExecutorService;
        this.inputLocation = inputLocation;
        this.threadsNumber = threadsNumber;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {

        // reads the orders from the file and saves each order in the Database class
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(inputLocation));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Order order = new Order();
        StringBuilder stringBuilder = new StringBuilder();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) != ',') {
                    stringBuilder.append(line.charAt(i));
                }   else {
                    order.setId(stringBuilder.toString());
                    order.setNumberOfProducts(Integer.valueOf(line.substring(i + 1)));
                    Database.addOrder(order);
                    Database.ordersData.put(order.getId(), order.getNumberOfProducts());
                    if (order.getNumberOfProducts() != 0) {
                        Database.activeOrders.add(order.getId());
                    }
                    stringBuilder.setLength(0);
                    break;
                }
            }
            for (int i = 0; i < order.getNumberOfProducts(); ++i) {
                productsExecutorService.submit(new ProductWorker(order, i + 1));
            }
        }
    }

    public static synchronized void shippedProductNotification(String orderId) throws IOException {
        Database.orders.replace(orderId, Database.orders.get(orderId) - 1);
        if (Database.orders.get(orderId).equals(0)) {
            Database.writeOrderToFile(orderId);
            Database.activeOrders.remove(orderId);
        }
    }
}

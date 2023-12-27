import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ProductWorker implements Runnable{
    private Order order;
    private Integer productNumber;


    public ProductWorker(){
    }

    public ProductWorker(Order order, Integer productNumber) {
        this.order = order;
        this.productNumber = productNumber;
    }


    @Override
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src\\test\\order_products.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        Integer number = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String orderId = "";
            String productId = "";
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) != ',') {
                    stringBuilder.append(line.charAt(i));
                }   else {
                    orderId = String.valueOf(stringBuilder);
                    productId = line.substring(i + 1);
                    if (orderId.equals(this.order.getId())) {
                        number++;
                    }
                    if (number.equals(this.productNumber)) {
                        if (Database.activeOrders.contains(orderId)) {
                            try {
                                OrderWorker.shippedProductNotification(orderId);
                                Database.writeProductToFile(productId, orderId);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    stringBuilder.setLength(0);
                    break;
                }
            }
        }
    }
}

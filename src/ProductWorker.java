import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class ProductWorker implements Runnable{
    private Order order;


    public ProductWorker(){
    }

    public ProductWorker(Order order) {
        this.order = order;
    }

//    synchronized boolean checkIfWorked(Product product) {
//        if(Database.products.)
//    }

    @Override
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src\\test\\order_products.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Order order = new Order();
        StringBuilder stringBuilder = new StringBuilder();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String orderId = "";
            String productId = "";
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) != ',') {
                    stringBuilder.append(line.charAt(i));
                }   else {
                    orderId = String.valueOf(stringBuilder);
                    productId = String.valueOf(line.substring(i+1));

                    Product product = new Product(orderId, productId);
                    if (Objects.equals(orderId, order.getId())) {
                        if (!Database.workedProducts.contains(product)) {
                            Database.addWorkedProduct(product);
                        }
                    }
                    Database.addProduct(product);
                    stringBuilder.setLength(0);
                    break;
                }
            }
        }
    }
}

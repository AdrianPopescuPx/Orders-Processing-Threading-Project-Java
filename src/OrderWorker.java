import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class OrderWorker implements Runnable{

    private String inputLocation;
    private Integer threadsNumber;
    private int start;
    private int end;
    public OrderWorker(Integer threadsNumber, String inputLocation, int start, int end) {
        this.inputLocation = inputLocation;
        this.threadsNumber = threadsNumber;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(inputLocation));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputLocation));
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
                    stringBuilder.setLength(0);
                    break;
                }
            }
        }
    }
}

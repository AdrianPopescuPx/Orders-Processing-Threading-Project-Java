import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Error: Te rog sa furnizezi exact doua argumente!");
            System.exit(1);
        }

        String inputLocation = args[0];
        int threadsNumber = Integer.parseInt(args[1]);

        BufferedReader br = new BufferedReader(new FileReader(inputLocation));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        ExecutorService ordersExecutorService = Executors.newFixedThreadPool(threadsNumber);
        ExecutorService productsExecutorService = Executors.newFixedThreadPool(threadsNumber);

    }
}
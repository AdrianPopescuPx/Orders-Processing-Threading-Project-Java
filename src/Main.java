import test.TestingThread;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length != 2) {
            System.out.println("Error: Te rog sa furnizezi exact doua argumente!");
            System.exit(1);
        }


        String inputLocation = args[0] + File.separator + Constants.inputOrder;
        int threadsNumber = Integer.parseInt(args[1]);
        long numLines = Files.lines(Path.of(inputLocation)).count();
        int ordersPerWorker = (int) (numLines / threadsNumber);

        ExecutorService ordersExecutorService = Executors.newFixedThreadPool(threadsNumber);
        ExecutorService productsExecutorService = Executors.newFixedThreadPool(threadsNumber);

        for (int i = 0; i < threadsNumber; i++) {
            int start = i * ordersPerWorker;
            int end = (i + 1) * ordersPerWorker;
            ordersExecutorService.submit(new OrderWorker(threadsNumber, inputLocation, start, (int) Math.min(end, numLines)));
        }
        ordersExecutorService.shutdown();
        ordersExecutorService.awaitTermination(100, TimeUnit.SECONDS);
        Database.showOrders();
    }
}
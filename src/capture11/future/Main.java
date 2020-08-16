package capture11.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        double price = new Shop().getPrice("p");
        System.out.println("foo");
        System.out.println(price);

        System.out.println();

        Future<Double> future = new Shop().getPriceAsync("p");
        System.out.println("foo");
        System.out.println(future.get());
    }
}

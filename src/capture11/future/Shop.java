package capture11.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    public static void delay() {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println(System.currentTimeMillis());
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            try {
                future.complete(price);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();

        return future;
    }

    public Future<Double> getPriceAsyncFactory(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return product.charAt(0);
    }
}

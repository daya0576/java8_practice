package capture11.pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class Main {
    static List<Shop> shopList = Arrays.asList(
            new Shop("shop1"),
            new Shop("shop2"),
            new Shop("shop3")
    );

    private static void findPrices() {
        List<String> productList = shopList.stream()
                .map(shop -> shop.getPrice("apple"))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
        System.out.println(productList);
    }

    private static void findPricesAsync() {
        List<CompletableFuture<String>> productFutures = shopList.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice("apple")))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote))))
                .collect(toList());

        List<String> productList = productFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
        System.out.println(productList);
    }


    public static void measure(Runnable r1) {
        long start = System.currentTimeMillis();
        r1.run();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        // 3 x (100ms+100ms) ≈ 600ms
        measure(Main::findPrices);

        // 100ms+100ms ≈ 200ms
        // 使用多线程的方式将多个查询任务并行执行
        measure(Main::findPricesAsync);
    }
}

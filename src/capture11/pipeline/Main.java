package capture11.pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Shop> shopList = Arrays.asList(
            new Shop("shop1"),
            new Shop("shop2"),
            new Shop("shop3")
    );

    private static void syncQuery() {
        List<String> productList = shopList.stream()
                .map(shop -> shop.getPrice("apple"))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
        System.out.println(productList);
    }

    public static void measure(Runnable r1) {
        long start = System.currentTimeMillis();
        r1.run();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        // 3 x (1s+1s) = 6s
        measure(Main::syncQuery);


    }
}

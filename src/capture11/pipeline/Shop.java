package capture11.pipeline;

import java.util.Random;


public class Shop {
    private final String name;
    Random random = new Random();

    public Shop(String name) {
        this.name = name;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];

        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        return product.charAt(0);
    }
}

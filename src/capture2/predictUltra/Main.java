package capture2.predictUltra;

import capture2.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static <T> List<T> filter(List<T> list, Predict<T> p) {
        List<T> result = new ArrayList<>();

        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("red", 11),
                new Apple("green", 10)
        );
        // lambda
        List<Apple> lambdaGreenApples = filter(apples, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(lambdaGreenApples);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = filter(numbers, i -> i % 2 == 0);
        System.out.println(evenNumbers);
    }
}

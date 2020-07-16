package capture2.predict;

import capture2.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> applePredict) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredict.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("red", 10),
                new Apple("green", 10)
        );

        // 策略模式
//        List<Apple> heavyApples = filterApples(apples, (Predict<Apple>) new HeavyApplePredict());
//        System.out.println(heavyApples);
//
//        List<Apple> greenApples = filterApples(apples, new ColorApplePredict());
//        System.out.println(greenApples);

        // lambda
        List<Apple> lambdaGreenApples = filterApples(apples, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(lambdaGreenApples);
        List<Apple> lambdaHeavyApples = filterApples(apples, Apple::isHeavyApple);
        System.out.println(lambdaHeavyApples);

        Predicate<Apple> greenApplePredict = (Apple apple) -> "green".equals(apple.getColor());
        Predicate<Apple> predict = greenApplePredict.and(Apple::isHeavyApple);
    }
}

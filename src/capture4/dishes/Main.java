package capture4.dishes;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        // flatMap
        List<String> words = Arrays.asList("hello", "world");
        List<String> wordsParsed = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .collect(toList());
        System.out.println(wordsParsed);

        // 给定列表[1, 2, 3]和􏳴表[3, 4]，返回笛卡尔积：
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(toList());


//        Optional<Dish> found = menu.stream().filter().findAny();
//        if (found.isPresent()) {
//
//        }
    }
}

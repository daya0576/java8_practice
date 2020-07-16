package capture3.functional_interface.contains;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

class Apple {

}

public class Main {
    public static void main(String[] args) {
        String[] x = new String[]{"1", "2"};
        BiPredicate<List<String>, String> contains = List::contains;
        contains.test(Arrays.asList(x), "1");


    }
}

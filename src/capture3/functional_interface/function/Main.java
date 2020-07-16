package capture3.functional_interface.function;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // g(f(x))
        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> g1 = x -> x * 2;
        Function<Integer, Integer> h1 = f1.andThen(g1).andThen(f1);
        int result1 = h1.apply(1);
        System.out.println(result1);

        // f(g(x))
        Function<Integer, Integer> f2 = x -> x + 1;
        Function<Integer, Integer> g2 = x -> x * 2;
        Function<Integer, Integer> h2 = f2.compose(g2);
        int result2 = h2.apply(1);
        System.out.println(result2);

        //
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);


    }
}

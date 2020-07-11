package capture3.functional_interface;

public class Main {
    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello World");
        r1.run();
    }
}

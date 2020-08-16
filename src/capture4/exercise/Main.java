package capture4.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 找出2011年所有交易
        List<Transaction> transactions1 = transactions.stream().filter(x -> x.getYear() == 2011).collect(Collectors.toList());
        System.out.println(transactions1);

        // 所有交易额 总数
        Optional<Integer> sum = transactions.stream().map(Transaction::getValue).reduce(Integer::sum);
        sum.ifPresent(System.out::println);

        // 找到最大金额的交易
        Optional<Transaction> maxTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t1 : t2);
    }
}

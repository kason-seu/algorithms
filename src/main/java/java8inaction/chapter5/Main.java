package java8inaction.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(  new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950) );

        // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> transActions2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        List<Transaction> transActions2011V2 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((Transaction t1, Transaction t2) -> t1.getValue() - t2.getValue())
                .collect(Collectors.toList());
        System.out.println(transActions2011);
        System.out.println(transActions2011V2);

        // (2) 交易员都在哪些不同的城市工作过？
        List<String> diffCitys = transactions.stream().map(v -> v.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(diffCitys);

        // (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> q3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(v -> "Cambridge".equals(v.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(q3);

        // (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        String q4 = transactions.stream()
                .map(v -> v.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.joining("-"));
        System.out.println(q4);

        // (5) 有没有交易员是在米兰工作的？
        boolean b = transactions.stream().anyMatch(v -> "Milan".equals(v.getTrader().getCity()));
        System.out.println("有没有交易员是在米兰工作的 " + b);

        // (6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream()

                .filter(v -> "Cambridge".equals(v.getTrader().getCity()))
                .forEach(v -> {
                    System.out.println(v.getValue());
                });
        // (7) 所有交易中，最高的交易额是多少？
        Integer q7 = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max)
                .get();
        System.out.println(q7);

        // (8) 找到交易额最小的交易。
        transactions.stream().min(Comparator.comparing(Transaction::getValue))
                .ifPresent(System.out::println);

    }
}

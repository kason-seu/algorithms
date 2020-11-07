package java8inaction.chapter5;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollector {


    public static void main(String[] args) {
        Optional<Integer> reMax = Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.maxBy((Integer::compareTo)));
        reMax.ifPresent((Integer e) -> {
            System.out.println(e);
        });
        Long reCount = Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.counting());
        System.out.println(reCount);

        System.out.println("===================");



        System.out.println("==============================");


        Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.minBy(Integer::compareTo))
                .ifPresent(System.out::println);
        System.out.println("===============================");


        // T A R
        IntSummaryStatistics summarizingInt = Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.summarizingInt(a -> a));
        System.out.println(summarizingInt);
        System.out.println("===================================================");


        String rejoining = Lists.newArrayList("a", "b", "c", "d").stream().collect(Collectors.joining("-"));
        System.out.println(rejoining);
        System.out.println("======================================================");


        // reducing
        Integer sumResult = Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.reducing(0, (a, b) -> a + b));
        System.out.println(String.format("sum result = %d", sumResult));
        System.out.println("======================================================");

        BinaryOperator<String> binaryOperator = new BinaryOperator<String>() {
            String combine = "-";
            int num = 0;
            @Override
            public String apply(String s, String s2) {
                if (num == 0) {
                    num++;
                    return s + s2;

                } else {
                    return s + combine + s2;
                }
            }
        };
        String customReduce = Lists.newArrayList("a", "b", "c", "d").stream().collect(Collectors.reducing("", binaryOperator));
        System.out.println(String.format("custom reduce string values = %s", customReduce));
        ArrayList<String> strings = Lists.newArrayList();
        customReduce = strings.stream().collect(Collectors.reducing("", binaryOperator));
        System.out.println(String.format("custom reduce string values = %s", customReduce));

        Optional<String> stringCombine = Lists.newArrayList("a", "b", "c", "d").stream().collect(Collectors.reducing((s1, s2) -> s1 + "-" + s2));
        stringCombine.ifPresent(val -> {
            System.out.println(String.format("string combine = %s", val));
        });
        strings.stream().collect(Collectors.reducing((s1, s2) -> s1 + "-" + s2))
                .ifPresent(val -> {
                    System.out.println(String.format("string combine = %s", val));
                });

        Integer result = Lists.newArrayList("a", "b", "c", "d")
                .stream()
                .collect(Collectors.reducing(0, (String s) -> s.charAt(0) - 'a', (a, b) -> a + b));

        System.out.println(result);


        // 分组
        List<Integer> list = Lists.newArrayList(1,1,2,2,3,3,3,3,3);
        // 聚合获取count
        Map<Integer, Long> countResultMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countResultMap);
        System.out.println("===================================================");

        Map<Integer, List<Integer>> listGroupByMap = list.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println(listGroupByMap);





    }
}

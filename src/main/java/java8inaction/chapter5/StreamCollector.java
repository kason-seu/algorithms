package java8inaction.chapter5;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
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


        Map<String, List<Integer>> customFunctionGroupby = Lists.newArrayList(1, 1, 2, 2, 3, 3, 3, 3, 3, 8, 8, 8, 8, 8, 12, 12, 11, 111)
                .stream()
                .collect(Collectors
                        .groupingBy(val -> {
                            if (val < 5) {
                                return "LOW";
                            } else if (val < 10) {
                                return "MEDIAN";
                            } else {
                                return "HIGH";
                            }
                        }, Collectors.toList()));

        System.out.println(customFunctionGroupby);


        Map<String, Map<Integer, Long>> twoLayerGroupBy = Lists.newArrayList(1, 1, 2, 2, 3, 3, 3, 3, 3, 8, 8, 8, 8, 8, 12, 12, 11, 111)
                .stream()
                .collect(Collectors.groupingBy(val -> {
                    if (val < 5) {
                        return "LOW";
                    } else if (val < 10) {
                        return "MEDIAN";
                    } else {
                        return "HIGH";
                    }
                }, Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.println(twoLayerGroupBy);


        Map<Integer, Integer> collectingAndThen = Lists.newArrayList(1, 1, 2, 2, 3, 3, 3, 3, 3, 8, 8, 8, 8, 8, 12, 12, 11, 111)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.summingInt((Integer a) -> a), a -> a)));
                //.collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.maxBy(Integer::compareTo), Optional::get)));

        System.out.println(collectingAndThen);

        Map<Integer, Set<String>> groupByMapping = Lists.newArrayList(1, 1, 2, 2, 3, 3, 3, 3, 3, 8, 8, 8, 8, 8, 12, 12, 11, 111)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.mapping((Integer val) -> {
                    if (val < 5) {
                        return "LOW";
                    } else if (val < 10) {
                        return "MEDIAN";
                    } else {
                        return "HIGH";
                    }
                }, Collectors.toSet())));

        System.out.println(groupByMapping);


        Map<Boolean, List<Integer>> partitoningByTest = Lists.newArrayList(1, 1, 2, 2, 3, 3, 3, 3, 3, 8, 8, 8, 8, 8, 12, 12, 11, 111)
                .stream()
                .collect(Collectors.partitioningBy((Integer v) -> v > 5, Collectors.toList()));
        System.out.println(partitoningByTest);



        // 自定义Collector的实现.
        ListCollector listCollector = new ListCollector();
        Map<Integer, List<Integer>> customCollector = Lists.newArrayList(1, 1, 2, 2, 3, 3, 3, 3, 3, 8, 8, 8, 8, 8, 12, 12, 11, 111)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), listCollector));
        System.out.println(customCollector);

    }
    static class ListCollector implements Collector<Integer, List<Integer>, List<Integer>> {


        @Override
        public Supplier<List<Integer>> supplier() {
            return () -> Lists.newArrayList();
        }

        @Override
        public BiConsumer<List<Integer>, Integer> accumulator() {
            return List::add;
        }

        @Override
        public BinaryOperator<List<Integer>> combiner() {
            return (List<Integer> l1, List<Integer> l2) ->{
                l1.addAll(l2);
                return l1;
            };
        }

        @Override
        public Function<List<Integer>, List<Integer>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Sets.newHashSet(Characteristics.IDENTITY_FINISH);
        }
    }
}

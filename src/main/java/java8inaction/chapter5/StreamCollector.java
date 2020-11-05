package java8inaction.chapter5;

import com.google.common.collect.Lists;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollector {


    public static void main(String[] args) {
        Optional<Integer> reMax = Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.maxBy((Integer::compareTo)));
        reMax.ifPresent((Integer e) -> {
            System.out.println(e);
        });
       /* Long reCount = Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.counting());
        System.out.println(reCount);

        System.out.println("===================");



        System.out.println("==============================");


        Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.minBy(Integer::compareTo))
                .ifPresent(System.out::println);
        System.out.println("===============================");


        // T A R
        IntSummaryStatistics summarizingInt = Lists.newArrayList(1, 2, 3, 4).stream().collect(Collectors.summarizingInt(a -> a));
        System.out.println(summarizingInt);
        System.out.println("===================================================");*/


        String rejoining = Lists.newArrayList("a", "b", "c", "d").stream().collect(Collectors.joining("-"));
        System.out.println(rejoining);
        System.out.println("======================================================");
    }
}

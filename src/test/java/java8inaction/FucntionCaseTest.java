package java8inaction;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FucntionCaseTest {

    @Test
    public void testPredicate() {
        List<Integer> list = Lists.newArrayList(1,10,100,1000,10000);

        List<Integer> collect = list.stream().filter((Integer v) -> v > 1000).collect(Collectors.toList());

        collect = list.stream().filter(v -> v > 1000).collect(Collectors.toList());

        // 不需要装箱拆箱，
        IntPredicate intPredicate = (int i) -> i % 10 == 0;
        LongPredicate longPredicate = (long l) -> l > 1000;
        DoublePredicate doublePredicate = (double d) -> d % 2 == 1;
    }

    @Test
    public void testConsumer() {

        Consumer<List<String>> c = (List<String> list) -> {
            list.stream().forEach(System.out::println);
        };
        // 可以不用Integer
        IntConsumer intConsumer = (int a) -> {System.out.println(a);};

        LongConsumer longConsumer = (long l) -> {
            System.out.println(l);
        };

        DoubleConsumer doubleConsumer = (double d) -> {
            System.out.println(d);
        };

    }

    @Test
    public void testFunction() {
        Function<Integer, String> function = (Integer i) -> String.valueOf("string" + i);

        IntFunction<String> intFunction = (int i) -> String.valueOf(i * i);
        LongFunction<String> longFunction = (long l) -> String.valueOf(l * l);
        DoubleFunction<String> doubleFunction = (double d) -> String.valueOf(d * d);

        ToIntFunction<List<Integer>> toIntFunction = List::size;

        ToDoubleFunction<List<Double>> toDoubleFunction = (List<Double> doubleLists) -> {
            return doubleLists.stream().reduce(Double::sum).orElseGet(() -> 0D);
        };

        ToLongFunction<List<Long>> toLongFunction = (List<Long> longLists) -> {
            return longLists.stream().reduce(Long::sum).orElseGet(() -> 0L);
        };
        IntToLongFunction intToLongFunction = (int a )-> {
            return (long)a;
        };

        //IntToDoubleFunction

        //LongToDoubleFunction
        //LongToIntFunction

        //DoubleToIntFunction
        //DoubleToLongFunction
    }

}
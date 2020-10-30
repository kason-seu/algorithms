package java8inaction.chapter5;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBuilder {

    public static void main(String[] args) {
        // Stream.of 函数生成流
        String collect = Stream.of(1, 2, 3, 4, 5)
                .map(String::valueOf)
                .collect(Collectors.joining("-"));
        System.out.println(collect);

        // 2 数组生成流
        Arrays.stream(new String[]{"a","b"})
                .forEach(System.out::print);
        System.out.println();

        // 3 列表生成流
        Lists.newArrayList(100,200,300)
                .stream()
                .forEach(System.out::print);
        System.out.println();

        // generator 生成流

        Stream.generate(new Supplier<Object>(){


            int i = 0;
            int j = 1;
            @Override
            public Object get() {
                int tmp = j;
                j = i + j;
                i = tmp;
                return j;
            }
        }).limit(10).forEach(System.out::print);
        System.out.println();

        // iterate 生成无线流
        Stream.iterate(0, n -> n+1).limit(10).forEach(System.out::println);
        System.out.println("--------");
        IntStream.iterate(0, val -> val < 10, n -> n + 1)
                .limit(100)
                .forEach(System.out::println);
        System.out.println("--------");
    }
}

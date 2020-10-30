package java8inaction.chapter5;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DataStream {

    /**
     * 数据流Stream主要有三种： IntStream, LongStream, DoubleStream
     * @param args
     */

    public static void main(String[] args) {
        IntStream intStream = Lists.newArrayList(1,2,3,4).stream().mapToInt(i -> i);

        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();

        System.out.println("max: " + intSummaryStatistics.getMax() + "---min: " + intSummaryStatistics.getMin() + "---average: " + intSummaryStatistics.getAverage()
        + "---count: " + intSummaryStatistics.getCount() + "---sum: " + intSummaryStatistics.getSum());

        LongStream longStream = Arrays.stream(new long[] {1L, 2L,3L});
        LongSummaryStatistics longSummaryStatistics = longStream.summaryStatistics();

        DoubleStream doubleStream = Arrays.stream(new double[]{0D,1D,2D});

        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();

        IntStream range = IntStream.range(0, 100);
        range.limit(10)
                .forEach(System.out::println);
        
        IntStream closedRange = IntStream.rangeClosed(1,5);
        closedRange.forEach(System.out::println);

    }
}

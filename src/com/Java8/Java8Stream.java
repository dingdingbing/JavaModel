package com.Java8;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * +--------------------+       +------+   +------+   +---+   +-------+
 * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 * +--------------------+       +------+   +------+   +---+   +-------+
 *
 * @author dingfubing
 * @since 2020/9/9 11:10
 */
public class Java8Stream {

    public static void main(String[] args) {
        List<String> ads = Arrays.asList("3", "2", "1", "", "ads", "asd", "1");
        List<String> collect = ads.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        List<String> collect2 = ads.stream().filter(s -> !s.isEmpty()).sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
        List<String> collect3 = ads.stream().filter(s -> !s.isEmpty()).sorted().collect(Collectors.toList());
        Set<String> collect1 = ads.stream().filter(s -> !s.isEmpty()).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(collect3);
        Random random = new Random();
        random.ints().limit(10).forEach(a -> {
            System.out.print(a + " ");
        });
        random.doubles().limit(10).forEach(System.out::print);
        System.out.println();

        List<Integer> integers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect4 = integers.stream().map(i -> i + 1).collect(Collectors.toList());
        System.out.println(collect4);

        List<String> sssdds = Arrays.asList("123", "321", "", "", "sssdds");
        long count = sssdds.stream().filter(String::isEmpty).count();
        System.out.println(count);

        // random.doubles().limit(10).sorted().forEach(System.out::print);

        String collect5 = String.join(",,,", sssdds);
        System.out.println(collect5);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());

        numbers.forEach(a->{

        });

        try(FileInputStream fis = new FileInputStream(new File(""))) {
            System.out.println(fis.read());
        } catch (Exception e) {

        }
    }
}

package com.items.api.util;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tool {
    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate){
        // ChronoUnit 計算時間差
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        numOfDaysBetween += 1;
        List<LocalDate> date = new ArrayList<>();
        for (int i = 0; i < numOfDaysBetween; i++) {
            date.add(startDate.plusDays(i));
        }
        //IntStream.iterate(0,s->s+2).limit(5).toArray();
        //IntStream.iterate(0,s->s+2).limit(5).mapToObj(i -> String.format("我就坐在這裡%s",startDate.plusDays(i))).forEach(System.out::println);

        // 使用 IntStream 取代 for loop
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }
}

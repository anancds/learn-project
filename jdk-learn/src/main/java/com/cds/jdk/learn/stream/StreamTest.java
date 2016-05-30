/**
 * Copyright (c) 2015, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :learn-project
 * Package Name :com.cds.jdk.learn.stream
 * Date Created :2016/5/30
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/5/30      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.jdk.learn.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();

        items.add("one");
        items.add("two");
        items.add("three");

        Stream<String> stream = items.stream();
        System.out
            .println(stream.filter(item -> item.startsWith("o")).collect(Collectors.toList()));

        System.out
            .println(items.stream().map(item -> item.toUpperCase()).collect(Collectors.toList()));

        String shortest = items.stream().min(Comparator.comparing(item -> item.length())).get();
        System.out.println(shortest);

        long count = items.stream().filter(item -> item.startsWith("t")).count();
        System.out.println(count);

        String reduced2 = items.stream().reduce((acc, item) -> acc + "," + item).get();
        System.out.println(reduced2);

        String reduced = items.stream().filter(item -> item.startsWith("o"))
            .reduce("", (acc, item) -> acc + "," + item);
        System.out.println(reduced);

    }
}

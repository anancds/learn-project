package com.cds.jdk.learn.javaLang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; ++i) {
            executor.submit(new TaskRun());
        }
//        Thread thread = new Thread(new TaskRun());
    }
}

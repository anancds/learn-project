package com.cds.jdk.learn.javaLang;

public class TaskRun implements Runnable{

    @Override public void run() {
        System.out.println("1");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

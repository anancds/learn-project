package com.cds.jdk.learn.chap2;

public class VolatileTest {
    volatile static String a = new String("abc");
    public static void main(String[] args) {

        a = "dbc";
        System.out.println(a);
    }
}

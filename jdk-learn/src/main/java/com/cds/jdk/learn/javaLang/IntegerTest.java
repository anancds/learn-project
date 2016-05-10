package com.cds.jdk.learn.javaLang;

import java.util.Properties;

public class IntegerTest {

    private static void testEqual() {
        Integer i1 = 3;
        Integer i2 = 3;
        System.out.println(i1 == i2);

        Integer i3 = 120;
        Integer i4 = 120;
        System.out.println(i3 == i4);
    }

    private static void testInitInteger() {
        Integer i = new Integer(10);
        i = 5;
        //这里i输出是5，其实是创建了一个新的对象，而且这个新的对象是从Integer的cache中取出的。
        System.out.println(i);
    }

    private static void testGetIntegrer() {
        Properties properties = System.getProperties();
        properties.put("cds", "12345");
        Integer i = Integer.getInteger("cds", 111);
        System.out.println(i);
    }

    private static void testDecode() {
        Integer bigNum = Integer.decode("-2147483648");
        Integer decimal = Integer.decode("+10");
        Integer oct = Integer.decode("-010");
        Integer hex1 = Integer.decode("-0x10");
        Integer hex2 = Integer.decode("#10");

        System.out.println(bigNum);
        System.out.println(decimal);
        System.out.println(oct);
        System.out.println(hex1);
        System.out.println(hex2);
    }

    private static void testReverse() {
        System.out.println(Integer.reverse(4));
        System.out.println(Integer.reverseBytes(1));
    }

    private static void testToString() {
        System.out.println(Integer.toString(10, 8));
    }

    private static void testParseInt() {
        System.out.println(Integer.parseInt("0", 10));
        System.out.println(Integer.parseInt("-0", 10));
        System.out.println(Integer.parseInt("-FF", 16));
        System.out.println(Integer.parseInt("10101010", 2));
        System.out.println(Integer.parseInt("-2147483648", 10));
        System.out.println(Integer.parseInt("2147483647", 10));
    }

    public static void main(String[] args) {
        //        testEqual();
        //        testToString();
        //        testInitInteger();
        //        testGetIntegrer();
        //        testDecode();
        //        testParseInt();
        testReverse();
    }
}

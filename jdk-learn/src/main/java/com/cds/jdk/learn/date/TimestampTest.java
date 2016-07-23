package com.cds.jdk.learn.date;

import java.sql.Timestamp;

public class TimestampTest {
    public static void main(String[] args) {
        System.out.println(Timestamp.valueOf("2016-05-30 03:57:23.000").getTime());
        System.out.println(Timestamp.valueOf("2016-05-30 03:57:23").getTime());

        System.out.println((-1L) >>> 63);
    }
}

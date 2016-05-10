package com.cds.rxjavalearn.rxhelloword;

import rx.Observable;

public class helloRxJava {
    public static void hello(String... names) {
        Observable.from(names).subscribe(s -> {
            System.out.println("Hello " + s + "!");
        });
    }

    public static void main(String[] args) {

        hello("abc", "cds");

    }
}

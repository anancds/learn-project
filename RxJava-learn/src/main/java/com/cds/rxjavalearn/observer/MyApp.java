package com.cds.rxjavalearn.observer;

import java.util.Observable;

public class MyApp {

    public static void main(String[] args) {
        System.out.println("Enter Text >");

        EventSource eventSource = new EventSource();
        eventSource.addObserver(
            (Observable obj, Object arg) -> System.out.println("\n Received response: " + arg));

        new Thread(eventSource).start();
    }
}

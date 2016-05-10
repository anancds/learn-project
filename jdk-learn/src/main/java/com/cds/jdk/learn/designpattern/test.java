package com.cds.jdk.learn.designpattern;

public class test {
    public static void print(String ... s){
        for(String a: s)
            System.out.println(a);
    }

    public static void main(String[] args) {


        print("a", "b");
    }

}

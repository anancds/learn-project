package com.cds.jdk.learn.cloneTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 通过串行化实现深复制
 */
class Teacher implements Serializable {
    String name;
    int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


public class DeepStudent2 implements Serializable {
    String name;//常量对象
    int age;
    Teacher t;//学生1和学生2的引用值都是一样的。

    public DeepStudent2(String name, int age, Teacher t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {//将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);//从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher t = new Teacher("tangliang", 30);
        DeepStudent2 s1 = new DeepStudent2("zhangsan", 18, t);
        DeepStudent2 s2 = (DeepStudent2) s1.deepClone();
        s2.t.name = "tony";
        s2.t.age = 40;
        //学生1的老师不改变
        System.out.println("name=" + s1.t.name + "," + "age=" + s1.t.age);
    }
}

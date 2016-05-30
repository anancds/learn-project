package com.cds.jdk.learn.inner;

public class OuterClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("OuterClass...");
    }

    public class InnerClass {

        public InnerClass() {
            name = "chenssy";
            age = 23;
        }

        public OuterClass getOuterClass() {
            return OuterClass.this;
        }

        public void display() {
            System.out.println("name：" + getName() + "   ;age：" + getAge());
        }

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.display();
        innerClass.getOuterClass().display();
    }
}

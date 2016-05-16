package com.cds.jdk.learn.cloneTest;

/**
 * http://www.importnew.com/18999.html
 * <p/>
 * 浅复制（浅克隆） ：被复制对象的所有变量都含有与原来的对象相同的值，
 * 而所有的对其他对象的引用仍然指向原来的对象。换言之，浅复制仅仅复制所考虑的对象，
 * 而不复制它所引用的对象。
 * 深复制（深克隆） ：被复制对象的所有变量都含有与原来的对象相同的值，
 * 除去那些引用其他对象的变量。那些引用其他对象的变量将指向被复制过的新对象，
 * 而不再是原有的那些被引用的对象。换言之，深复制把要复制的对象所引用的对象都复制了一遍。
 * <p/>
 */
public class ShallowStudent implements Cloneable {
    private String name;

    private int age;

    ShallowStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Object clone() {
        ShallowStudent o = null;
        try {
            // Object中的clone()识别出你要复制的是哪一个对象。
            o = (ShallowStudent) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    public static void main(String[] args) {
        ShallowStudent s1 = new ShallowStudent("zhangsan", 18);
        ShallowStudent s2 = (ShallowStudent) s1.clone();
        //        s2.name = "lisi";
        //        s2.age = 20;
        //修改学生2后，不影响学生1的值。
        System.out.println("name=" + s1.name + "," + "age=" + s1.age);
        System.out.println("name=" + s2.name + "," + "age=" + s2.age);
    }
}

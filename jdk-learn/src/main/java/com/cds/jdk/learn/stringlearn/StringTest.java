package com.cds.jdk.learn.stringlearn;

public class StringTest {
    public static void main(String[] args) {
        int h;
        System.out.println(("ab".hashCode()));
        Object o = "";
        Long l = Long.valueOf(o.toString());
        //先在栈中创建一个对String类的对象引用变量a，然后通过符号引用去字符串常量池里找有没有"hello",
        // 如果没有，则将"hello"存放进字符串常量池 ，并令a指向"hello"，如果已经有"hello"则直接将a指向"hello"
        // -->  产生1个对象及1个引用
        String a = "hello";

        char[] ch = new char[8] ;
        System.out.println(a.codePointAt(2));
        System.out.println(a.codePointBefore(2));
        System.out.println(a.codePoints());
        System.out.println(a.offsetByCodePoints(0,3));
        a.getChars(0,3,ch,2);
        System.out.println(ch);
        System.out.println(a.getBytes());
//        System.out.println(a.codePointCount(0,19));

        //先在栈中创建一个对String类的对象引用变量b，然后通过符号引用去字符串常量池里找有没有"hello",
        // 因为之前在常量池中已经有"hello"，所以直接将b指向"hello"
        //   -->  因为不需要在常量池产生"hello"，所以只是在栈中产生1个引用
        String b = "hello";

        //先在栈中创建一个对String类的对象引用变量newA，然后new()操作会在heap堆中产生一个新的对象"hello"，
        // 并将newA指向堆中的"hello",同时检查String pool常量池中是否有对象"hello"，如果没有也产生一个对象"hello",
        // 如果有则不产生，因为这里之前已经在常量池中产生过了，所以   -->  只需要产生1个对象及1个引用
        String newA = new String("hello").intern();

        //因为new每次都会保证在heap堆内存中产生新的对象，并将栈中的引用指向对应的堆中的地址，
        // 所以此语句同上一条的处理
        String newB = new String("hello").intern();

        System.out.println("a == b ? :" + (a == b) );
        System.out.println("newA==newB ? :" +(newA==newB));
        System.out.println("a==newA ? :" + (a==newA));

        System.out.println("a.intern()==b.intern() ? : " + (a.intern()==b.intern()));
        System.out.println("newA.intern()==newB.intern() ? :" + (newA.intern()==newB.intern()));
        System.out.println("a.intern()==newA.intern() ? :" + (a.intern()==newA.intern()));
        System.out.println("a=a.intern() ? :" + (a==a.intern()));
        System.out.println("newA==newA.intern() ? : " + (newA==newA.intern()));

        System.out.println("equals() method :" + a.equals(newA));

        String c = "hel";
        String d = "lo";
        final String finalc = "hel";
        final String finalgetc = getc();

        System.out.println("****** Testing Object splice ******");
        //JVM对于字符串常量的"+"号连接，在程序编译期，
        // JVM就将常量字符串的"+"连接优化为连接后的值，因此"hel" + "lo"优化后完全等同于"hello"
        System.out.println("a==\"hel\"+\"lo\" ? :" + (a=="hel"+"lo"));
        System.out.println("a==c+d ? : " + (a==c+d));

        //JVM对于字符串引用，由于在字符串的"+"连接中，有字符串引用存在，而引用的值在程序编译期是无法确定的，
        // 所以c+\"lo\"实际是c在栈中保存的地址+字符串"lo"于常量池中指向的地址 所指向的在堆中新分配的一块内存空间
        System.out.println("a==c+\"lo\" ? : " + (a==c+"lo"));

        //对于final修饰的变量，它在编译时被解析为常量值的一个本地拷贝存储到自己的常量 池中或嵌入到它的字节码流中，
        // 在编译期就已经确定了内存空间地址，所以此类似于2个字符串常量的+
        System.out.println("a==finalc+\"lo\" ? :" + (a==finalc+"lo"));
        System.out.println("a==finalgetc+\"lo\" ? :" + (a==finalgetc+"lo"));
    }

    private static void testEquals() {

    }

    private static String getc() {
        return "hel";
    }

}

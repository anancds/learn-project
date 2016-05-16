package com.cds.jdk.learn.cloneTest;

import java.util.ArrayList;
import java.util.HashMap;

public class StringTest {
    public static void main(String[] args) {
        //字符串(不理解无colne()方法)
        String s = "sss";
        String t = s;   //深拷贝
        String y = new String(s); //深拷贝
        System.out.println("s:" + s + " t:" + t + " y:" + y);
        t = "ttt";
        y = "yyy";
        System.out.println("s:" + s + " t:" + t + " y:" + y);

        //数组
        String[] ss = {"111", "222", "333"};
        String[] tt = ss; //浅拷贝
        String[] ww = (String[]) ss.clone();//深拷贝
        System.out.println("ss:" + ss[1] + " tt:" + tt[1] + " ww:" + ww[1]);
        tt[1] = "2t2";
        ww[1] = "2w2";
        System.out.println("ss:" + ss[1] + " tt:" + tt[1] + " ww:" + ww[1]);


        //list列表
        ArrayList a = new ArrayList();
        for (int i = 0; i < 10; i++) {
            a.add(String.valueOf(i + 1));
        }
        ArrayList b = a;//浅拷贝
        ArrayList c = new ArrayList(a);//深拷贝
        ArrayList d = (ArrayList) a.clone();//深拷贝
        System.out
            .println("a:" + a.get(1) + " b:" + b.get(1) + " c:" + c.get(1) + " d:" + d.get(1));
        b.set(1, "bbb");
        c.set(1, "ccc");
        System.out
            .println("a:" + a.get(1) + " b:" + b.get(1) + " c:" + c.get(1) + " d:" + d.get(1));

        //HashMap
        HashMap h = new HashMap();
        h.put("1", "hhh");
        HashMap m = h;//浅拷贝
        HashMap p = new HashMap(h);//深拷贝
        HashMap n = (HashMap) h.clone();//深拷贝
        System.out.println(
            "h:" + h.get("1") + " m:" + m.get("1") + " p:" + p.get("1") + " n:" + n.get("1"));
        m.put("1", "mmm");
        p.put("1", "ppp");
        n.put("1", "nnn");
        System.out.println(
            "h:" + h.get("1") + " m:" + m.get("1") + " p:" + p.get("1") + " n:" + n.get("1"));
    }
}

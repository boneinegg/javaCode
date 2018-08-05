package com.liupp.java;

import com.sun.xml.internal.ws.api.model.MEP;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface  Test {
    int size();
    public static String  get(Test2 test) {
        return test.getName();
    }
    default boolean isEmpty() {
        return size() == 0;
    }
}

public class Test1 implements Test {
    static int s = 0;
    public int size() {
        return s;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2("lpp", 22);
        Test1 test1 = new Test1();
        System.out.println(test1.size());
        System.out.println(test1.isEmpty());
        System.out.println(Test.get(test2));
    }

}

class Test2 {
    static int test = 1;
    String name;
    int age;
    public Test2(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

//    public static void main(String[] args) {
//        Test2 test = new Test2("liping", 22);
//        Class cl = test.getClass();
//        System.out.println(test.getName());
//        try {
//            Field f = cl.getDeclaredField("name");
//            Method m1 = Math.class.getMethod("sqrt", double.class);
//            Method m2 = Test1.class.getMethod("getName");
//            System.out.println(f);
//            System.out.println(m2);
//            String v = (String) m2.invoke(test);
//            double v1 = (Double) m1.invoke(null, 10.0);
//            System.out.println(v);
//            System.out.println(v1);
//            f.set(test, "lpp");
//            Object v2 = f.get(test);
//            System.out.println(v2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
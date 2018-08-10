package javaCode;

interface  Test {
    int size();
    static String  get(Test2 test) {
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
        Object o = new Object();
        Thread t = new Thread();
        System.out.println(Object.class.getDeclaredMethods());
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
//        Test2 com.liupp.test = new Test2("liping", 22);
//        Class cl = com.liupp.test.getClass();
//        System.out.println(com.liupp.test.getName());
//        try {
//            Field f = cl.getDeclaredField("name");
//            Method m1 = Math.class.getMethod("sqrt", double.class);
//            Method m2 = Test1.class.getMethod("getName");
//            System.out.println(f);
//            System.out.println(m2);
//            String v = (String) m2.invoke(com.liupp.test);
//            double v1 = (Double) m1.invoke(null, 10.0);
//            System.out.println(v);
//            System.out.println(v1);
//            f.set(com.liupp.test, "lpp");
//            Object v2 = f.get(com.liupp.test);
//            System.out.println(v2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

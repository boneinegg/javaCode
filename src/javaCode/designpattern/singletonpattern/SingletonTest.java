package javaCode.designpattern.singletonpattern;

public class SingletonTest {
    //恶汉模式
    static class Wife1 {
        private static final Wife1 wife1 = new Wife1();

        private Wife1() {

        }
        public static Wife1 getInstance() {
            return wife1;
        }
    }

    //懒汉模式
    static class Wife2 {
        private static Wife2 wife2;

        private Wife2() {

        }
        public static Wife2 getInstance() {
            if (wife2 == null)
                return new Wife2();
            return wife2;
        }
    }

    //线程安全的懒汉模式
    static class Wife3 {
        private static Wife3 wife3;

        private Wife3() {

        }
        public synchronized static Wife3 getInstance() {
            if (wife3 == null)
                return new Wife3();
            return wife3;
        }
    }

    //双重锁
    static class Wife4 {
        private volatile static Wife4 wife4;

        private Wife4() {

        }
        public static Wife4 getInstance() {
            if (wife4 == null)
                synchronized (Wife4.class) {
                    if (wife4 == null)
                        return new Wife4();
                }
            return wife4;
        }
    }

    //静态内部类
    static class Wife5 {
        private static class HelloWife {
            private static final Wife5 wife5 = new Wife5();
        }

        private Wife5() {

        }

        public static Wife5 getInstance() {
            return HelloWife.wife5;
        }
    }

    //枚举
    enum Wife6 {
        INSTANCE;

        public void otherMethod() { }
    }

    public static void main(String[] args) {
        Wife1.getInstance();
        Wife2.getInstance();
        Wife3.getInstance();
        Wife4.getInstance();
        Wife5.getInstance();
        Wife6 wife6 = Wife6.INSTANCE;
    }
}

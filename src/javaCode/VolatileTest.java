package javaCode;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    public static volatile int race = 0;    //不具备原子性
    public static AtomicInteger race2 = new AtomicInteger(0);  //原子性

    public static void increase() {
        race++;
        race2.incrementAndGet();
    }

    private static final int count = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++)
                        increase();
                }
            });
            threads[i].start();
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("hello");

        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(race);
        System.out.println(race2);
    }
}

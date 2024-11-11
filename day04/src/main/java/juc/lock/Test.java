package juc.lock;

import java.util.concurrent.locks.LockSupport;

public class Test {
    //有三个线程，线程A只会输出A，线程B只会输出B，线程C只会输出C设计使他们按顺序打印ABC

    private static Thread t1, t2, t3;

    public static void main(String[] args) throws InterruptedException {
        t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                LockSupport.park();
                //线程进入运行，进入阻塞代码执行到这不动，直到unpark执行
                System.out.print("A");
                LockSupport.unpark(t2);
                //释放t2阻塞
            }
        });
        t2 = new Thread(() -> {
            for (int j = 0; j < 2; j++) {
                LockSupport.park();
                System.out.print("B");
                LockSupport.unpark(t3);
                //释放t3阻塞
            }
        });
        t3 = new Thread(() -> {
            for (int j = 0; j < 2; j++) {
                LockSupport.park();
                System.out.print("C");
                System.out.println("");
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
    }
}
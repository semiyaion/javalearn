package thread.deadlock;

import sun.security.krb5.internal.TGSRep;

public class Example implements Runnable {
    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {
        while (true) {
            if ("线程A".equals(Thread.currentThread().getName())) {
                synchronized (o1) {
                    System.out.println("线程A抢到了o1锁，准备抢o2");
                    synchronized (o2) {
                        System.out.println("线程A抢到了o2锁，结束");
                    }
                }
            } else if ("线程B".equals(Thread.currentThread().getName())) {
                synchronized (o2) {
                    System.out.println("线程B抢到了o2锁，准备抢o1");
                    synchronized (o1) {
                        System.out.println("线程B抢到了o1锁，结束");
                    }
                }
                //此时形成死锁，进程永远不会结束
            }
        }

    }
}

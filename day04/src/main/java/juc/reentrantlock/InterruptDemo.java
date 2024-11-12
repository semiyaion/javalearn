package juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class InterruptDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //可打断，避免死锁
        Thread t1 = new Thread(() -> {
            try {
                //线程没有竞争时，t1直接获得锁，并打印
                //线程有竞争之后，t1线程抢不到锁，则可以使用interrput停止阻塞等待
                log.println("尝试获得锁");
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.println("没有获取到锁，打断");
                return;
            }
            try {
                log.println("获取到锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        //给主线程上锁
        t1.start();
        //线程1开始
        //停止线程
        t1.interrupt();

    }
}

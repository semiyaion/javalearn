package juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ReentrantLockDemo {
    //重入锁ReentrantLock
    private static ReentrantLock lcok = new ReentrantLock();

    public static void main(String[] args) {
        lcok.lock();//相当于syn，创建出来的lock就相当于创建了一把锁
        //ReentrantLock对象后面必须紧跟try-catch
        try {
            log.println("进入的主方法" + Thread.currentThread().getName());
            m1();
            //可重入的体现同一个线程多次获得同一把锁，此方法中的线程都为main
            //如果不能重入就会阻塞
        } finally {
            lcok.unlock();
        }

    }

    public static void m1() {
        lcok.lock();
        try {
            log.println("进入m1方法" + Thread.currentThread().getName());
            m2();
            //可重入的体现
        } finally {
            lcok.unlock();
        }
    }

    public static void m2() {
        lcok.lock();
        try {
            log.println("进入m2方法" + Thread.currentThread().getName());
        } finally {
            lcok.unlock();
        }
    }
}

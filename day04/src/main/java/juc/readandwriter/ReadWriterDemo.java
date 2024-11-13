package juc.readandwriter;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterDemo {

    /*允许多个线程同时访问，但只允许一个写线程访问
     * 读写锁允许同一时间被多个线程访问，但在写线程访问时所有其他读写线程都会被阻塞
     * （我虽然抽烟，喝酒，烫头但对你我是真心的，我其实是个好女孩）
     *
     * 1.支持公平锁和不公平锁，非公平锁的吞吐量优于公平
     * 2.支持重入，读锁获取后还能再次获取锁，
     * 3.锁降级：是一种写锁转换成读锁的进程：
     * 获取写锁：线程首先获取写锁，确保在修改数据时排它访问
     * 获取读锁：在写锁保持的同时，线程可以再次获取读锁
     * 释放写锁：线程保持读锁的同时释放写锁
     * 释放读锁：最后线程释放读锁*/


    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        //新建读写锁
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        //写锁
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        //读锁
        System.out.println("我现在获取到了写锁");
        writeLock.lock();
        try {
            readLock.lock();
            System.out.println("我现在获取到了写锁");
        } finally {
            writeLock.unlock();
            System.out.println("我现在释放了写锁");
        }
        try {
            System.out.println("我要释放读锁");
        } finally {
            readLock.unlock();
        }
        //写锁不能被多个线程获取，所以写锁其实就是一个独占式锁，同步语义时通过重写AQS中tryAcqueir方法获取的

    }
}

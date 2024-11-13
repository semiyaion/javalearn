package juc.readandwriter;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Test {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            data.read();
        }, "t1").start();
        new Thread(() -> {
            data.read();
        }, "t2").start();
        //读读不互斥，读写会互斥，写写互斥

    }


}

class Data {
    private Integer data1;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read() {
        log.println(Thread.currentThread().getName() + "获取读锁");
        r.lock();
        try {
            log.println("读取");
            return data1;
        } finally {
            log.println(Thread.currentThread().getName() + "释放读锁");
            r.unlock();
        }

    }

    public Object writer() {
        w.lock();
        System.out.println(Thread.currentThread().getName() + "获取写锁");
        try {
            log.println("数据加一");
            data1++;
            return data1;
        } finally {
            w.unlock();
            log.println(Thread.currentThread().getName() + "释放写锁");
        }

    }
}

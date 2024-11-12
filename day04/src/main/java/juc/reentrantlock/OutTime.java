package juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class OutTime {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //尝试获得锁，返回一个boolean值，获取到了就返回值为真
            try {
                if (!lock.tryLock(10, TimeUnit.SECONDS)) {
                    //此线程再次等待10秒。如果10s还是获取不到锁就返回false
                    log.println(lock.tryLock());
                    log.println(Thread.currentThread().getName() + "获取不到锁");
                    return;
                } else {
                    try {
                        log.println(Thread.currentThread().getName() + "获取到锁了");
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");
        lock.lock();
        t1.start();
    }

}

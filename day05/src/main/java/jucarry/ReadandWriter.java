package jucarry;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadandWriter {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock wl = lock.writeLock();
    ReentrantReadWriteLock.ReadLock rl = lock.readLock();
    int num = 0;

    public int read() {
        rl.lock();
        //读锁先锁定
        try {
            System.out.println("当前num资源为" + num);
        } finally {
            rl.unlock();
        }
        return num;
    }

    public int writer() throws InterruptedException {
        wl.lock();
        try {
            System.out.println("当前资源为" + num);
            num++;
        } finally {
            System.out.println("经过写后num为" + num);
            Thread.sleep(3000);
            wl.unlock();
        }
        return num;
    }

    public static void main(String[] args) throws InterruptedException {
        ReadandWriter rw = new ReadandWriter();
        Thread t1 = new Thread(() -> {
            try {
                rw.writer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //写入锁运行时候，其他所以读写锁阻塞
        Thread t2 = new Thread(() -> rw.read());
        Thread t3 = new Thread(() -> rw.read());
        //线程可以多次使用读锁
        t1.start();
        t2.start();
        t3.start();
    }
}

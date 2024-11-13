package jucarry;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    //假设有一个仓库库存数，多个线程可以读取库存数，但只有一个线程可以修改库存数。
    private static int nums = 100;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock rl = lock.readLock();
    ReentrantReadWriteLock.WriteLock wl = lock.writeLock();

    public int read() {
        rl.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "read当前容量为" + nums);
        } finally {
            rl.unlock();
        }
        return nums;
    }

    public int add(int i) {
        wl.lock();
        nums = nums + i;
        System.out.println(Thread.currentThread().getName() + "仓库库存更新了了" + i);
        try {
            System.out.println(Thread.currentThread().getName() + "add当前仓库容量为" + nums);
        } finally {
            wl.unlock();
        }
        return nums;
    }
//    public int del(int i){
//        wl.lock();
//        int afternum=nums-i;
//        if(afternum<0){
//            System.out.println(Thread.currentThread().getName()+"当前库存不足");
//        }else {
//            try {
//                System.out.println(Thread.currentThread().getName()+"仓库取出了" + i);
//            }
//
//            finally {
//                System.out.println(Thread.currentThread().getName()+"del当前库存容量为" + afternum);
//                wl.unlock();
//            }
//        }
//        return afternum;
//    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t = new Thread(() -> test.add(16), "增加");
        Thread.sleep(100);
        Thread t1 = new Thread(() -> test.read(), "a更新后读");
        Thread t2 = new Thread(() -> test.add(-47));
        Thread t3 = new Thread(() -> test.read());

        t.start();
        t1.start();
        t2.start();
        t3.start();
//        增加仓库库存更新了了16
//                增加add当前仓库容量为116
//        Thread-1read当前容量为116
//        Thread-0仓库库存更新了了-47
//        Thread-0add当前仓库容量为69
//                a更新后读read当前容量为69

    }
}

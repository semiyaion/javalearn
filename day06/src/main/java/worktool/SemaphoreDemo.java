package worktool;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    //限制线程数量Seamphore
    /*acquire方法会申请一个permit，而release方法会释放一个permit
     * 也可以多个申请和释放acquire（int ）release（int）
     * seamphore中的方法
     * availablePermits()  返回当前可用的许可数量，主要用于监控或调试。
     * getQueueLength()  返回当前正在等待获取许可的线程数。这是一个观察方法，用于调试或监控。
     * hasQueuedThreads() 返回 true 或 false，表示是否有线程正在等待许可。
     * reducePermits(int reduction)  减少信号量的许可数量。注意，这是一个直接操作许可数量的方法，慎用，因为它会影响信号量的许可状态。
     * drainPermits()获取并移除当前所有的许可。调用此方法后，信号量的许可数量将变为 0。*/

    static class MyThread implements Runnable {
        private int value;
        private Semaphore semaphore;

        public MyThread(int value, Semaphore semaphore) {
            this.value = value;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // 获取permit
                System.out.println("当前线程是" + value + "还有" + semaphore.getQueueLength() + "个线程资源可以使用" + semaphore.availablePermits() + "个线程在等待");

                // 线程在一秒内随机释放
                Random random = new Random();
                //使当前线程睡眠随即一段时间
                Thread.sleep(random.nextInt(1000));
                System.out.println("线程" + value + "释放了资源");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // 释放permit
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(i, semaphore)).start();
            //启动线程，线程中运行MyThread中的run方法

        }

    }
}

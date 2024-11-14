package worktool;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    //假设某个线程在执行任务之前，需要等待其他线程完成一些前置任务，前置任务必须全部完成才能执行本线程任务则用屏障CountDownLatch
    /*await等待
     * await（long timeout，TimeUnitunit）超时等待
     * countDown  count-1
     * getCount 获取还有多少count
     * */

    static class pretask implements Runnable {
        private String preptask;
        private CountDownLatch countDownLatch;

        public pretask(String preptask, CountDownLatch countDownLatch) {
            this.preptask = preptask;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("线程" + preptask + "完成了");
                countDownLatch.countDown();
                //线程数量-1
                //完成后减少线程
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        //假设有三个线程需要提前加载
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new pretask("前置线程1", countDownLatch)).start();
        new Thread(new pretask("前置线程2", countDownLatch)).start();
        new Thread(new pretask("前置线程3", countDownLatch)).start();


        //创建主线程

        new Thread(() -> {
            System.out.println("等待前置线程加载");
            System.out.println("还有" + countDownLatch.getCount() + "个线程未加载");
            try {
                countDownLatch.await();
                //等待计数器为0
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("数据加载完成");
        }).start();


    }
}

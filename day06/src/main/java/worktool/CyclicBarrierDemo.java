package worktool;

import javax.lang.model.element.NestingKind;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    //CountDownLatch设置前置任务，当计数器bount被设为0后就不能再使用，只能起到一次屏障效果
    //CyclicBarrier有CountDownLatch的所有方法，并可通过reset重新设置屏障
    //内部采用方法与CountDownLatch完全不同，采用的是Lock+Condition实现等待/通知模式

    static class pretask implements Runnable {
        private String task;
        private CyclicBarrier cyclicBarrier;

        public pretask(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Random random = new Random();
                System.out.println("前置任务" + i + "." + task + "完成了");
                try {
                    cyclicBarrier.await();
                    //cyclicbarrier中没有countdown，只用await就能完成前置任务是否完成1的监视
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("所有前置线程结束，开始下一线程");
        });
        new Thread(new pretask("进程1", cyclicBarrier)).start();
        new Thread(new pretask("线程2", cyclicBarrier)).start();
        new Thread(new pretask("线程3", cyclicBarrier)).start();
//        new Thread(()->{
//            System.out.println("所以前置线程完成，开始执行主线程");
//        }).start();

    }
}

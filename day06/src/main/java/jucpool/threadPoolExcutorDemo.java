package jucpool;

import java.util.concurrent.*;

public class threadPoolExcutorDemo {
    public static void main(String[] args) {
        /*使用详解
         * 就是一个线程集合和一个阻塞队列
         * 当用户向线程池提交一个任务时，线程池会先将任务放到workQueue中，workerSet中的线程会不断从阻塞线程中获取线程然后执行*/
        //池化思想：线程池，字符串池，数据库连接池
        //提高资源利用率
        ThreadPoolExecutor t1 = new ThreadPoolExecutor(3,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //参数顺序，核心线程数（即主要执行任务的线程数），最大线程数（如果核心线程不能即使处理创建的临时线程最大值）
        //临时线程的执行时间，执行时间的单位，未及时处理的线程存放在数组中的最大值，
        //线程工厂，拒绝策略，线程池不能完成任务抛出异常
        for (int i = 0; i < 5; i++) {
            t1.execute(() -> {
                System.out.println((Thread.currentThread().getName() + "在执行"));
            });
        }
        t1.shutdown();
        //关闭线程池
        ExecutorService es = Executors.newFixedThreadPool(10);
        //船舰一个固定有10个线程数的线程池
    }
}

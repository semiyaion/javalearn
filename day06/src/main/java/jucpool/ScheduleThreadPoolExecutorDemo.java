package jucpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolExecutorDemo {
    public static void main(String[] args) {
        /*为任务提供延迟或者周期执行
         * 继承自ThreadPoolExexutor
         * 有专门的任务类型来执行周期任务，ScheduledFutureTask
         * 使用专门的存储队列：DelayedWorkQueue来存储任务
         * 支持可选的run-after-shutdown参数*/

        //构造
        ScheduledThreadPoolExecutor she = new ScheduledThreadPoolExecutor(2);
        she.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好任务三秒延迟");
            }
        }, 3, TimeUnit.SECONDS);
        she.schedule(() -> System.out.println("执行延迟任务，延迟3秒"), 3, TimeUnit.SECONDS);

        // 2. scheduleAtFixedRate 方法，每5秒执行一次任务，不论上次任务执行是否完成
        she.scheduleAtFixedRate(() -> {
            System.out.println("固定频率执行任务，每隔5秒执行一次");
            //执行的任务
        }, 1, 5, TimeUnit.SECONDS);
        //忽略任务的所需要的时间，经过一定时间后一定会再次执行


        // 3. scheduleWithFixedDelay 方法，每次任务完成后延迟2秒再执行下一次
        she.scheduleWithFixedDelay(() -> {
            System.out.println("固定延迟执行任务，每次执行完后延迟2秒再执行");
        }, 0, 2, TimeUnit.SECONDS);
        //首次任务延迟0秒，之后每两秒执行一次
        //在上次任务执行完毕后，才会按照指定时间再次执行

        try {
            TimeUnit.SECONDS.sleep(20);
            // 运行20秒后关闭线程池
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        she.shutdown();
    }
        /*ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) 延迟执行一次指定的任务。
                command：要执行的任务。delay：任务开始的延迟时间。unit：延迟时间的单位。

                <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) 延迟执行指定的 Callable 任务并返回结果。
                callable：任务内容。delay：任务延迟时间。unit：时间单位。

                ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
                    以固定的频率执行任务，任务之间的时间间隔是固定的，忽略任务执行时间。
                    command：要执行的任务。
                    initialDelay：首次执行的延迟时间。
                    period：任务间隔时间。
                    unit：时间单位。

                ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
                    以固定的延迟执行任务，即每次执行完成后等待指定时间，再执行下一次。
                    command：要执行的任务。
                    initialDelay：首次执行的延迟时间。
                    delay：每次执行完成后的延迟时间。
                    unit：时间单位。*/
}

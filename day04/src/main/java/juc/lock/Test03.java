package juc.lock;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class Test03 {
    static Thread t1;
    //实现一个线程，使它在每天的指定时间（如当前时间15:10）执行某项任务。可以使用 LockSupport.parkUntil 方法来控制线程的等待。

    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY, 15);
        c1.set(Calendar.MINUTE, 24);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
        long waitUntil = c1.getTimeInMillis();
        //Lock类只负责阻塞当前线程，释放锁资源是Condition中await（）方法
        // 如果当前时间已过下午3点，则设置为明天下午点
        if (System.currentTimeMillis() > c1.getTimeInMillis()) {
            c1.add(Calendar.DAY_OF_YEAR, 1);

            System.out.println("等待时间为 " + c1.getTime());
        } else {

            // 阻塞当前线程，直到指定时间

            try {
                LockSupport.parkUntil(waitUntil);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            // 执行任务
            System.out.println("执行任务时间 " + c1.getTime());
            //执行任务时间 Mon Nov 11 15:20:00 GMT+08:00 2024

            // 任务执行完成，重新循环等待下一次任务
            t1.start();
        }
    }
}









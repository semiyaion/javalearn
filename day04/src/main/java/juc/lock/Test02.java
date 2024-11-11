package juc.lock;

import java.util.concurrent.locks.LockSupport;

public class Test02 {
    private static Thread t1, t2;
    static int target = 100;
    static int i = 1;
    static int flag = 0;
    //0未生产，1已生产要消费

    public static void main(String[] args) {
        //实现一个简单的生产者-消费者模型（使用 LockSupport）
        Object o = new Object();
        t1 = new Thread(() -> {
            LockSupport.parkUntil(o, 10000000);
            while (i <= target) {
                if (flag == 0) {
                    System.out.println("我现在要生产第" + i + "个物品");
                    flag = 1;
                    LockSupport.unpark(t2);

                }
            }
        });
        t2 = new Thread(() -> {
            LockSupport.parkUntil(o, 10000000);
            while (i <= target) {
                if (flag == 1) {
                    System.out.println("我现在要消费第" + i + "个物品");
                    flag = 0;
                    LockSupport.unpark(t1);
                    i++;
                }
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LockSupport.unpark(t1);
    }
}


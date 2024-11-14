package blocking;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    /*是一个非常特殊的阻塞队列，不存储任何元素，每一个插入操作必须等待另一个现成的移除操作
     * 因此，SynchronousQueue的内部实际上是空的，他必须一个线程先另外一个线程逐个输出元素
     * 即插入和移除操作同时进行*/

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Object> queue = new SynchronousQueue<>();
        Thread t1 = new Thread(() -> {
            try {
                String event = "event";
                System.out.println("放入" + event);
                queue.put(event);
                System.out.println("sucessput");
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                String evevt = (String) queue.take();
                System.out.println("拿出" + evevt);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        });

        t1.start();
        Thread.sleep(5000);
        //放入5秒后才执行拿出
        t2.start();
        t1.join();

        t2.join();

    }
}

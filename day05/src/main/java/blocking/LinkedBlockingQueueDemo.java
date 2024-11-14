package blocking;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
    /*基于链表的线程安全阻塞队列
     * 1.可在队列头部和尾部进行高效的增删操作
     * 2.队列为空则取会阻塞知到有新元素可用，队列已满也会阻塞，直到队列有新空间可用
     * 3.初始化时候要可以指定最大容量
     * */

    private static LinkedBlockingQueue queue = new LinkedBlockingQueue(100);

    static class pro implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put(i);
                    System.out.println("生产了" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    static class cos implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.take();
                    System.out.println("消费了" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public static void main(String[] args) {
        new Thread(new pro()).start();
        new Thread(new cos()).start();
    }
}

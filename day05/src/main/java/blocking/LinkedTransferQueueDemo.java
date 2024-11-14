package blocking;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueDemo {
    public static void main(String[] args) throws Exception {
        //基于链表的无界传输队列，实现TranferQueue接口，
        //允许一个元素直接从生产者传输给消费者我，如果消费者在等待，如果没有等待的消费者，元素入队
        /*transfer(E e):将元素转移给等待的消费者，如果不存在消费者则元素入队并阻塞直到元素被消费
         * tryTransfer（E e）尝试立即转移元素，如果有消费者正在等待，则传输成功，否则返回false*/
        LinkedTransferQueue<Object> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            while (true) {
                System.out.println("消费者正在等待获取元素..");
                try {
                    int e = (int) queue.take();
                    System.out.println("消费者收到元素");
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }).start();
        System.out.println("生产者传输元素");
        for (int i = 0; i < 10; i++) {
            queue.transfer(i);
            System.out.println("生产者已经传输了数字" + i);
        }

    }

}

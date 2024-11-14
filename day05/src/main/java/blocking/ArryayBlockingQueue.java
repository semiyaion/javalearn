package blocking;

import java.util.concurrent.ArrayBlockingQueue;

public class ArryayBlockingQueue {
    private static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10, true);

    public static void main(String[] args) {
        new Thread(new Product()).start();
        new Thread(new Consumer()).start();
    }

    static class Product implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.put(i);
                    System.out.println("生产" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("消费" + i);
            }
        }
    }
}

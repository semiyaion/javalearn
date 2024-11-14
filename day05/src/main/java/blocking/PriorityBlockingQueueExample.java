package blocking;

import java.util.concurrent.PriorityBlockingQueue;
    /*  排序特性：PriorityBlockingQueue 会根据元素的自然顺序或指定的 Comparator 排序，不保证同优先级元素的顺序。
        阻塞特性：PriorityBlockingQueue 是一个线程安全的阻塞队列，提供 take() 方法来阻塞当前线程，直到队列中有元素。
        无界性：它是无界的，但如果内存限制，会导致 OutOfMemoryError。
        线程安全：它是线程安全的，可以在多线程环境中使用。

        add(E e) 和 offer(E e)：添加元素到队列。
        take()：从队列中取出并删除最高优先级的元素。如果队列为空，它会阻塞直到有元素可以取出。
        peek()：获取最高优先级的元素，但不删除它；如果队列为空，则返回 null。
        remove(Object o)：从队列中删除指定元素。*/

class Task implements Comparable<Task> {
    private int priority;
    private String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    // 任务优先级比较：优先级越小，任务优先级越高
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    public void execute() {
        System.out.println("执行任务: " + name + "，优先级: " + priority);
    }
}

class TaskProducer implements Runnable {
    private PriorityBlockingQueue<Task> queue;

    public TaskProducer(PriorityBlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // 向队列中添加任务
        queue.add(new Task(3, "低优先级任务"));
        queue.add(new Task(1, "高优先级任务"));
        queue.add(new Task(2, "中优先级任务"));
    }
}

class TaskConsumer implements Runnable {
    private PriorityBlockingQueue<Task> queue;

    public TaskConsumer(PriorityBlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 从队列中取出并执行任务
                Task task = queue.take();
                task.execute();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        // 创建任务生产者和消费者线程
        Thread producerThread = new Thread(new TaskProducer(queue));
        Thread consumerThread = new Thread(new TaskConsumer(queue));

        // 启动线程
        producerThread.start();
        consumerThread.start();
    }
}

package linkedqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Demo02 {
    public static void main(String[] args) {
        //offer方法
        //在队列末尾插入一个元素
        ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Object poll = queue.poll();
        System.out.println(poll);
        //每次从对头推出一个元素
        System.out.println(queue);
    }
}

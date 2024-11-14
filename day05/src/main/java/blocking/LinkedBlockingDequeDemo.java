package blocking;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class LinkedBlockingDequeDemo {
    /*addFrist(E e),addLast(E e)：在队列的开头或结尾添加元素
     * takeFrist（），takeLast（）在队列开头或者末尾移除返回元素
     * putFirst（E e），putlast（E e）在队列开头插入/结尾插入，如果队列已满，则等待
     * pollFrist（Long timeout，TimeUnit unit），在队列的开头结尾移除和返回元素，如果队列为空，则等待指定的超时时间*/
    public static void main(String[] args) throws Exception {
        LinkedBlockingDeque<Object> deque = new LinkedBlockingDeque<>(10);
        deque.putLast("369");
        deque.putLast("258");
        deque.putFirst("147");
        System.out.println(deque);
        Object o = deque.takeFirst();
        System.out.println(o);
        System.out.println(deque);


    }
}

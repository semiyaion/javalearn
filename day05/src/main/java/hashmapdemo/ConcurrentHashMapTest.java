package hashmapdemo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        /*ConcurrentHashmap的本质上还是一个hashmap
         * 但由于hashmap在多线程1的情况下会发生线程不安全的问题例如：扩容造成死循环，put会导致元素丢失，put和get并发可能导致getnull
         * conhashmap一旦链表长度小于低于6会将红黑树退化成单项链表，提升效率
         * comhashmap在hashmap的基础上提供了并发安全的方法，
         * 方法为对node节点枷锁来保证数据更新的安全性，
         * 当数组长度不够时候，会触发扩容，扩容时引入了多线程并发扩容的实现，就是多个线程将原始数组进行切片，之后每个线程去负责一个切片的数据转移从而整体提高了扩容效率
         * 1.7之前任何保证并发线程安全：
         * 采用分段锁的方法，分段锁采用的是可重入锁ReentrantLock，属于同一段内的数据更新时只需要共享一个锁
         * 1.8之后是CAS+同步锁Synchronized
         * 1.看写入的槽是否为空，如果为空则直接使用CAS
         * 如果槽位不为空，则使用同步锁，同时使用volatile来保证数据的可见性*/
        // HashMap 示例：非线程安全
        HashMap<Integer, String> hashMap = new HashMap<>();
        //向hashmap中存储1500个数字
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put(i, "Value" + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 500; i < 1500; i++) {
                hashMap.put(i, "Value" + i);
            }
        });

        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.put(i, "Value" + i);
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 500; i < 1500; i++) {
                concurrentHashMap.put(i, "Value" + i);
            }
        });

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        //让main线程等待其他线程执行结束
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        // 输出结果
        System.out.println("HashMap Size: " + hashMap.size());
//        System.out.println(hashMap+" ");
        // 可能输出不准确的大小
        System.out.println("ConcurrentHashMap Size: " + concurrentHashMap.size());
//        System.out.println(concurrentHashMap+" ");
        // 准确
    }
}

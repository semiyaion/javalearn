package juc.aqs;

public class AQSshow {
    public static void main(String[] args) {
        /*AQS是AbstractQueuedSynchronizer的简称，即抽象队列同步器，从字面上可以这样理解:
            抽象：抽象类，只实现一些主要逻辑，有些方法由子类实现；
            队列：使用先进先出（FIFO）的队列存储数据；
            同步：实现了同步的功能。
            如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并将资源设置为锁定状态
            AQS对资源的共享方法：
            Exclusive（独占）：只有一个线程执行：
            公平锁：线程在队列中排队执行，先到先拿锁
            非公平
            Share（共享）：多个线程可同时进行。*/
    }
}

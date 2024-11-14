package jucpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class Fork_JoinDemo {

    public static void main(String[] args) {
        //并发编程的任务分为三种：简单并行，聚合任务，批量并行任务，分治模型
        /*分治模型将一个复杂问题分解成多个相似的子问题，然后再将这些子问题进一步分解成更小的问题，直到每个子问题变得足够简单从而直接求解
         * 流程：总任务——》子任务——》更小的子任务——》子任务的结果——》总任务
         * fork/join就是用来支持分治模型的使用
         * fork表示任务分解，jion表任务合并
         *
         * forkjoinpool中存在多个任务队列，队列中存放的是当前任务，其中只有奇数队列会对应一个工作线程，偶数队列则对所有线程共享
         * invoke，submit，execute会将任务提交到偶数的共享队列，而用fork会放入奇数的队列，工作线程默认会从自己队列的头部来获取任务，
         * 如果自己队列没有任务而共享队列中有任务，或者从其他队列的尾部发生工作窃取，提升运行效率
         * */


    }
}

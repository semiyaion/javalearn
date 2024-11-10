package juc.a_cas_unsafe_atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Test {
    /*CAS是什么
     * CAS是一种常用的无锁并发编程技术，用于实现原子操作，它主要用于解决多线程环境下的并发问题
     * 特别是当多个线程修改或是访问共享数据是，CAS通过指令比较和交换操作，保证数据操作的原子性
     * 不需要使用锁机制
     * CAS中存在三个关键参数
     * 1.内存位置：即要更新的变量的内存地址
     * 2.预期值：期望内存位置的当前值（旧值
     * 3.新值：希望写入的新值
     *
     * CAS操作的过程
     * 1.首先比较内存位置的当前值和预期值是否相同
     * 如果相同则新值写入该位置，表示更新成功，如果不同，操作失败表示有其他线程修改了该值
     * CAS会采取其他策略，比如抛出异常等操作）*/
}

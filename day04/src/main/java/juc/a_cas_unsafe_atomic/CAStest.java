package juc.a_cas_unsafe_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CAStest {
    //cas翻译过来就是对比交互，是CPU的原子指令，作用是让Cpu先比较两个值是否相等，然后原子地更新某个位置的值
    /*CAS底层是一个乐观锁，它认为在进程中不会有其他进程进来抢锁
     * 并发操作不会发生冲突，因此在操作之前不加锁，在操作完成时再检查否存在冲突
     * 如果有冲突再进行相应的处理
     * 悲观锁：是以一种悲观的态度来防止数据冲突，它是以一种预防的姿态在修改数据之前就把数据锁住，再对数据
     * 进行读写，，直到锁释放之后下一个进程才能继续对数据进行枷锁*/

    static AtomicInteger num = new AtomicInteger(0);

    /*AtomicInterger常用API
     * 1.get获取当前的值
     * 2.gaeAndset（int newvalue）：获取当前的值，并设置新的值
     * 3.getandincrement获取当前的值，并自增
     * 4.getanddecrement获取当前的值并自减
     * 5.geydanadd（int），获取当前的值，并加上预期值
     * 6lazyset（int value）最终会设置成value，但使用lazyset设置后，可能导致其他线程在一小段时间内还是读取到旧值*/

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num.get() < 100) {
                        System.out.println("线程1" + Thread.currentThread().getName() + ":" + num.incrementAndGet());
                    }
                }
            }).start();
        }
    }

}
//CAS本质:设置资源对象的状态值为0，当有两个线程并行时，发现状态值为0，则开始争抢线程，抢到的线程资源状态会先与其匹配
//若匹配成功则修改自己的状态值，未抢到的线程会自动自旋，如果发现状态值更改则立即争抢，所以CAS必须是原子性的
//CAS其实没有用上锁，反而会主动匹配线程的状态值





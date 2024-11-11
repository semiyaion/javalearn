package juc.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        /*LockSupport用来创建锁和其他同步类的基本线程阻塞原语。
        简而言之，当调用LockSupport.park时，表示当前线程将会等待，直至获得许可，
        当调用LockSupport.unpark时，必须把等待获得许可的线程作为参数进行传递，好让此线程继续运行
        优点：
        可以直接进行使用,不需要配合其他关键词或方法
        wait（）notify（）要配合synchronized来使用
        即使先执行"唤醒"方法,再执行阻塞方法,线程依旧可以顺利执行

        LockSupport引入了许可证的思想,当执行unpark()方法的时候会赋给指定对象一个许可证,
        执行park()方法的时候判断当前对象是否拥有许可证,没有则进行阻塞,
        直到其拥有一个许可证才放行,如果拥有则直接放行.放行后将该对象拥有的许可证置空.
*/
        MyThread myThread = new MyThread(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        LockSupport.park("Demo");
        //设置阻塞
        System.out.println("after park");

        /*1.park:阻塞当前线程，如果调用unpark方法或线程中断则该线程将变得可运行
         * park（object blocker）入参增加一个object对象，用来记录导致线程阻塞的对象，方便问题排查
         * parkNanos（long nanos)阻塞当前线程纳秒的时间或直到被unpark调用或线程被中断
         * parkNanos（object blocker，long nanos）入参一个object对象，用来记录导致线程阻塞的对象，方便排查
         * parkuntil（long deadline）：阻塞当前线程直到被unpark调用，或直接被中断
         * parkuntil（Object blocker，long deadline）记录*/
    }


}

class MyThread extends Thread {
    private Object object;

    public MyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Blocker inffo" + "   " + LockSupport.getBlocker((Thread) object));
        LockSupport.unpark((Thread) object);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Blocker info" + LockSupport.getBlocker((Thread) object));
        System.out.println("after unpark");
    }
}

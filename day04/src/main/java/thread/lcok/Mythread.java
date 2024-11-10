package thread.lcok;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mythread extends Thread {
    static int ticket = 0;
    static Lock lock = new ReentrantLock();

    //属于一个接口不能实例化，只能用实现类的对象
    //static保证锁的钥匙只有一个
    @Override
    public void run() {
        while (true) {
//            synchronized (Mythread.class){
            //用lock上锁
            lock.lock();
            if (ticket == 100) {
                break;
            } else {
                try {
                    Thread.sleep(5);
                    ticket++;
                    System.out.println(Thread.currentThread().getName() + "在卖" + ticket + "张票");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
//            }
        }
    }
}

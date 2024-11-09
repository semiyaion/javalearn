package thread.synchronizedtest.duixiang;

public class Demo implements Runnable {
    static Demo lock = new Demo();

    //对象锁
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("这是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock);
        t1.start();
        t2.start();
    }
}

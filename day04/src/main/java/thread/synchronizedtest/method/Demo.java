package thread.synchronizedtest.method;

public class Demo implements Runnable {
    static Demo s1 = new Demo();
    static Demo s2 = new Demo();

    @Override
    public synchronized void run() {
        //将锁放到方法上但是方法不是静态的，所以锁的钥匙不一致
        System.out.println(Thread.currentThread().getName() + "开始了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "结束了");

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        t1.start();
        t2.start();
    }
}

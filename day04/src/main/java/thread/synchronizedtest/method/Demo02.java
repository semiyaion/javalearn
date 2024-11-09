package thread.synchronizedtest.method;

public class Demo02 implements Runnable {
    static Demo02 d1 = new Demo02();
    static Demo02 d2 = new Demo02();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println(Thread.currentThread().getName() + "开始了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "结束了");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
    }
}

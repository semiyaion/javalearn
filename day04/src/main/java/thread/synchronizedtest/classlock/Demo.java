package thread.synchronizedtest.classlock;

public class Demo implements Runnable {
    static Demo d1 = new Demo();
    static Demo d2 = new Demo();

    @Override
    public void run() {
        synchronized (Demo.class) {
            System.out.println("这是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程" + Thread.currentThread().getName() + "结束了");
        }


    }

    public static void main(String[] args) {
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
    }
}

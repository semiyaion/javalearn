package thread.synchronizedtest.method;

public class Demo02 implements Runnable {
    static Demo02 d1 = new Demo02();
    static Demo02 d2 = new Demo02();

    @Override
    public void run() {
        method();
    }

    //在实例方法上添加synchronized关键字后，整个方法体可以被看做同步代码块
    //  共享对象的随想锁一定是this的
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

package thread.threadtest;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "hello");
            //线程睡眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //继承Thread类，并重写run方法

            /*public void run() :此线程要执行的任务在此处定义代码。
                 public String getName() :获取当前线程名称。
                 public void setName(线程名字):给线程设置名字
                public static Thread currentThread() :返回对当前正在执行的线程对象的引用。此方法在哪个线程中用获取的就是哪个线程对象
                static void sleep(long millis) :线程睡眠,设置的是毫秒值,如果超时,线程会自动醒来,继续执行
                void start()  使该线程开始执行；Java 虚拟机调用该线程的 run 方法    */
        }
    }

}

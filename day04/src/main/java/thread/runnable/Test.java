package thread.runnable;

public class Test {
    public static void main(String[] args) {
        //表示多线程要执行的任务
        MyRunnable mr = new MyRunnable();

        //新建线程
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.setName("线程一");
        t2.setName("线程二");
        //开启线程
        t1.start();
        t2.start();
    }
}

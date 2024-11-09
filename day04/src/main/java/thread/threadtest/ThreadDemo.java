package thread.threadtest;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();

        Thread thread = Thread.currentThread();
        //开启线程
        String name = thread.getName();
        System.out.println(name);
        //main,在java虚拟机中，会自动开启多条线程
        //其中就有main线程作用就是调用main方法，并执行其中的代码


    }

}

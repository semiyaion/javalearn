package thread.synchronizedtest;

public class Example {
    public static void main(String[] args) {
        //多线程对同一数据进行访问操作，就会发生线程不安全的情况
        //当线程抢到线程后，还未执行，就可能会被其他线程抢走，就会出现数据冲突问题
        /*原因：1.CPU缓存导致，一条线程抢到cpu后还未将数据写入主存线程2就已经开始主存，即线程一将变量修改后线程2未能及时拿出
         * 2.分时复用，比如线程1先执行了一条指令，之后立即切换至线程2，线程2直接完成了指令，再切换到了线程一，因为是对同一数据进行修改，所以数据被执行了两次
         * 3.重排列引起编译器为保证效率会将执行循序在不改变语义的情况下，重写将代码排列*/
        //同步代码块
        MyThread y1 = new MyThread();
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(y1, "源玺凯粉丝1");
        Thread t2 = new Thread(myThread, "黄牛1");
        t1.start();
        t2.start();
    }
}

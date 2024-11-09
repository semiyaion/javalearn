package thread.callable;

import thread.runnable.MyRunnable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建MyCallable的对象
        MyCallable mc = new MyCallable();
        //创建FutureTask对象（作用管理多线程运行的结果，对mc进行1一次封装）
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread t = new Thread(ft);
        t.start();
        //获取多线程运行的结果
        Integer i = ft.get();
        System.out.println(i);


    }
    /*Callable可以获取到多线程运行的结果*/
}

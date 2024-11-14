package jucpool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class PoolTest {
    private static final int i = 4;
    private static final ExecutorService ex = Executors.newFixedThreadPool(i);
    //创建一个4线程的线程池

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Double> task = new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return Math.random() * 100;
                //创建线程任务
            }
        };
        ArrayList<Future<Double>> list = new ArrayList<>();
        for (int i1 = 0; i1 < 10; i1++) {
            //循环 10 次，每次将任务 task 提交到线程池中，并以 Future<Double> 对象添加到列表中。
            list.add(ex.submit(task));
        }
        for (Future<Double> result : list) {
            //遍历 list 中的 Future 对象，通过 result.get() 获取每个任务的执行结果。
            System.out.println(result.get());
        }
        ex.shutdown();
    }
}

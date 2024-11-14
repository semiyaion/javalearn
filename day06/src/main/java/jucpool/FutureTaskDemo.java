package jucpool;

import java.util.concurrent.*;

public class FutureTaskDemo {
    //处于三种状态：
    /*1.未启动状态：run方法还饿米有执行之前，当创建一个FutureTask时，这个FutureTask将一直处于未启动这状态
    * 2.已启动状态
    * 3.已完成状态：正常执行后结束，或者被取消，cancel或执行方法是被抛出异常
    *
    * 方法
    *  get()
        获取任务的执行结果，如果任务尚未完成则阻塞直到任务完成。如果任务执行过程中抛出了异常，get() 会抛出 ExecutionException，并包装实际异常。
       get(long timeout, TimeUnit unit)
        在给定的超时时间内获取任务的执行结果，如果任务在超时时间内未完成，则抛出 TimeoutException。用于需要设定等待时间的场景。
*      boolean isDone()
*       判断任务是否已完成，完成包括任务正常结束、抛出异常结束或被取消。返回 true 表示任务已结束，可以通过 get() 获取结果。
       boolean isCancelled()
       *判断任务是否已被取消。返回 true 表示任务已取消，无法再获取结果。
       boolean cancel(boolean mayInterruptIfRunning)尝试取消任务的执行。如果任务已完成或已取消，则此方法无效。
       参数 mayInterruptIfRunning 表示是否允许中断正在执行的任务：
        true 表示立即中断任务。
        false 表示仅在任务未启动时取消。
       run()执行任务。如果 FutureTask 是由线程池管理，通常不直接调用 run() 方法。一般由线程池自动调用，也可以在主线程中调用 run() 执行任务（同步执行）*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TaskTest test = new TaskTest();
//        Future submit = Executors.newSingleThreadExecutor().submit(test);
//        System.out.println(submit.get());
//        //hello world

        FutureTask futureTask = new FutureTask<>(test);
        futureTask.run();
        System.out.println(futureTask.get());
        futureTask.cancel(false);
    }

    private static class TaskTest implements Callable {


        @Override
        public Object call() throws Exception {
            return "hello world";
        }
    }
}

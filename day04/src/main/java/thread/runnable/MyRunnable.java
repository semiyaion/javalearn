package thread.runnable;

import java.util.concurrent.Callable;

public class MyRunnable implements Runnable, Callable<Integer> {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //获取当前线程的对象
            System.out.println(Thread.currentThread().getName() + "hello");
        }
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

package thread.yieldtest;

public class Mine03 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "@" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.yield();
            //出让当前cpu的执行权,当不是绝对另外一个线程就能一定抢到
        }
    }
}

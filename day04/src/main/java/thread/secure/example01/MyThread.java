package thread.secure.example01;

public class MyThread implements Runnable {
    Integer ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "抢到了" + ticket + "张票");
            ticket--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

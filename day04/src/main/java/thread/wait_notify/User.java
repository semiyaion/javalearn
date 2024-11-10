package thread.wait_notify;

public class User implements Runnable {
    @Override
    public void run() {

        while (true) {
            synchronized (Briage.lock) {
                if (Briage.count == 0) {
                    break;
                }
                if (Briage.falg == 0) {
                    try {
                        Briage.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("现在要消费第" + Briage.i + "个数据");
                    Briage.i++;
                    Briage.falg = 0;
                    Briage.lock.notify();


                }
            }
        }
    }
}

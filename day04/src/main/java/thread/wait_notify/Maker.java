package thread.wait_notify;

public class Maker implements Runnable {
    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (Briage.lock) {
                if (Briage.count == 0) {
                    break;
                }
                if (Briage.falg == 1) {
                    try {
                        Briage.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("现在要生产第" + Briage.i + "个数据");
                    i++;
                    Briage.falg = 1;
                    Briage.count--;
                    Briage.lock.notify();


                }
            }
        }
    }
}

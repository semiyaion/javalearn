package thread.synchronizedtest;

public class MyThread implements Runnable {
    static Integer ticket = 0;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(Thread.currentThread().getName() + "抢到了" + ticket + "张票");
                } else {
                    break;
                }

            }
        }
    }
}


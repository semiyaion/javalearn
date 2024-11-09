package thread.stop;

public class tag {
    public static void main(String[] args) {
        Myrun myrun = new Myrun();
        Thread t1 = new Thread(myrun);
        t1.setName("123");
        t1.start();
        //五秒之后停止线程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myrun.run1 = false;

    }
}

class Myrun implements Runnable {
    boolean run1 = true;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (run1) {
                System.out.println(Thread.currentThread().getName() + "   " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                return;
            }
        }

    }
}


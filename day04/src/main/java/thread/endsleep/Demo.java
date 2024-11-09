package thread.endsleep;

public class Demo {
    public static void main(String[] args) {
        Thread s = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始");
                try {
                    Thread.sleep(365 * 24 * 60 * 60 * 1000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "干活了");
            }

        });
        s.start();

        //要求5秒线程起来干活
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        s.interrupt();

    }
}

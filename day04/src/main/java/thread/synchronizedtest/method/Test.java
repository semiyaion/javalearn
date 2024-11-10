package thread.synchronizedtest.method;

public class Test {
    public static void main(String[] args) {
        Myclass mc = new Myclass();
        Thread th1 = new Thread(new g1(mc));
        Thread th2 = new Thread(new g1(mc));
        th1.start();
        th2.start();
        th1.setName("th1");
        th2.setName("th2");


    }
}

class g1 implements Runnable {
    private Myclass t1;

    public g1(Myclass t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        if (t1.equals(Thread.currentThread().getName())) {
            t1.m1();
        } else {
            t1.m2();
        }
    }

}

class Myclass {

    public synchronized void m1() {
        System.out.println("m1开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("m1结束");
    }

    public synchronized void m2() {
        System.out.println("m2开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("m2结束");
    }


}

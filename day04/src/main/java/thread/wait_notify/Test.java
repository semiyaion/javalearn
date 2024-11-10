package thread.wait_notify;

public class Test {
    public static void main(String[] args) {
        Maker m1 = new Maker();
        User u1 = new User();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(u1);
        t1.start();
        t2.start();
    }
}

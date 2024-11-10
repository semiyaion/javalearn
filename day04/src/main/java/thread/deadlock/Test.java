package thread.deadlock;

public class Test {
    public static void main(String[] args) {
        Example e1 = new Example();
        Example e2 = new Example();
        Thread t1 = new Thread(e1, "线程A");
        Thread t2 = new Thread(e2, "线程B");
        t1.start();
        t2.start();
    }
}

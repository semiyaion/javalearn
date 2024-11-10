package thread.lcok;

public class Test {
    //lock是一个接口不能进行实例化
    public static void main(String[] args) {
        Mythread m1 = new Mythread();
        Mythread m2 = new Mythread();
        Mythread m3 = new Mythread();
        Thread t1 = new Thread(m1, "窗口1");
        Thread t2 = new Thread(m2, "窗口2");
        Thread t3 = new Thread(m3, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

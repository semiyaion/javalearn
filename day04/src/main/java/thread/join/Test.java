package thread.join;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //join插队线程
        Mythod04 mine = new Mythod04();
        Thread t1 = new Thread(mine, "霸总一号");
        t1.start();
        t1.join();
        //将t1插入到当先线程之前，等他结束后其他的才执行,join方法一定要执行在start线程后

        //执行在main线程中
        for (int j = 0; j < 10; j++) {
            System.out.println(Thread.currentThread().getName() + j);
        }
    }
}

package thread.setdaemon;

public class Test {
    public static void main(String[] args) {
        Mine01 mine01 = new Mine01();
        Mine02 mine02 = new Mine02();
        Thread t1 = new Thread(mine01, "男朋友");
        Thread t2 = new Thread(mine02, "备胎一号");
        //当男朋友线程结束后，备胎就没有存在的必要了，就会陆续结束，所以备胎线程不一定会完全执行完
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}

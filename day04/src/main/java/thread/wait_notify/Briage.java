package thread.wait_notify;

public class Briage {
    public static int falg = 0;
    //表示生产者是否生产
    //0表示没生产，1表示已生产

    //总个数
    public static int count = 10;
    public static int i = 1;

    //锁对象
    public static Object lock = new Object();
}

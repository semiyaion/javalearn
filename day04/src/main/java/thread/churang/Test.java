package thread.churang;

public class Test {
    public static void main(String[] args) {
        //yield出让线程
        Mine03 mine03 = new Mine03();
        Thread thread = new Thread(mine03, "二百公斤的美国大力士");
        Thread thread1 = new Thread(mine03, "马保国");

        thread.start();
        thread1.start();

    }
}

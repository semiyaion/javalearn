package worktool;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    //用于俩个线程交换数据
    public static void main(String[] args) {
        Exchanger<Object> objectExchanger = new Exchanger<>();
        /*exchange(V x, long timeout, TimeUnit unit)
            功能和第一个方法类似，但添加了超时参数。
            如果在指定的超时时间内没有另一个线程准备好交换，则会抛出 TimeoutException。*/
        new Thread(() -> {
            System.out.println("这是线程1原有的数据");
            try {
                System.out.println("这是线程1交换的数据：     " + objectExchanger.exchange("这是线程1的数据"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        //当一个线程使用了exchange方法，会先进入阻塞状态，直直到另外一个线程也开始使用了exchange
        new Thread(() -> {
            System.out.println("这是线程2原有的数据");
            try {
                System.out.println("这是线程2交换的数据：      " + objectExchanger.exchange("这是线程2的数据"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

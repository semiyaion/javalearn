package copyonwritrtarrylist;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
//实质就是copyonwriterarrylis是一种读写分离的数组
/*在每次修改操作时，都会创建一个新的底层数组副本，新副本会替换旧的列表
 * 而对旧列表的所有读取操作仍然能进行，其实就是使用了读写锁的机制
 * 就是说往一个容器中华添加元素的时候，不直接往容器中加，而是复制出一个新的容器
 * 然后在新容器中添加元素，添加完之后，再将原容器的引用指向新容器*/

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 150; i++) {
                list.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list);
        System.out.println(list.size());

    }
}

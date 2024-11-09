package a_reflect.test03.c_map.treemapdemo;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        /* a.对元素进行排序
            b.元素唯一
            c.无索引
            d.线程不安全
            数据结构:红黑树*/
        TreeMap<Object, Object> tm = new TreeMap<>();
        tm.put(4,"第四");
        tm.put(0,"第一");
        tm.put(1,"第二");
        tm.put(3,"第四");
        tm.put(2,"第三");
        //自动根据key值排序
        System.out.println(tm);
        tm.put(4,"第五");
        System.out.println(tm);
        Set<Map.Entry<Object, Object>> entries = tm.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry);
        }
    }
}

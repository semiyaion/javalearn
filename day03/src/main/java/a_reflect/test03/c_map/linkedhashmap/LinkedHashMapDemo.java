package a_reflect.test03.c_map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        /*在HashMap中为了提高查找效率，所以HashMap在插入对key进行了一次key的哈希算法，
           这就导致插入的元素是无序的
           为了保证键值正确有序的插入就引入了LinkedHashmap
           LinkedHashMap引入了双向链表*/
        /*Linkedhashmap继承了hashmap所以HashMap的方法都可以事使用
        *  数组+链表（+红黑树）+双向链表（在hashmap的基础上+双向链表）*/
        LinkedHashMap<Object, Object> lhm = new LinkedHashMap<>();
        lhm.put(1,"许良辰");
        lhm.put(2,"张三");
        lhm.put(3,"李莫愁");
        lhm.put(null,null);
        for (Map.Entry<Object, Object> entry : lhm.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+" "+value);
        }
    }
}

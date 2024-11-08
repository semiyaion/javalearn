package b_collection;

public class HashMap {
    public static void main(String[] args) {
        /*HashMap
        * 1.继承的是双联集合map接口，key值唯一，但value可重复
        * 无序，无索引，线程不安全，可以存储null值，数据结构是哈希表*/
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        //增
        map.put("清华",1);
        map.put("北大",2);
        map.put("南大",3);
        map.put("浙大",3);
        map.put("哈理工",4);
        map.put("麻省理工",1);
        System.out.println(map);
        //删
        map.remove("麻省理工");
        System.out.println(map);
        //改
        map.put("南大",4);
        System.out.println(map);
        //查
        Integer i = map.get("清华");
        System.out.println(i);
        /*hashmap的存储原理：
        * 将hashmap中的key的hashcode进行处理，将其先存储到初始化长度为16的数组中，每次的数组扩容都会将数组转成原来的2倍，默认的扩容参数是0.75
        * 在1.8之前是数组加链表
        * 在1.8之后是数组加链表加红黑树，当所存的值大于8时，就会将链表转换成红黑树
        * key值值重复value不可重复的原因，在hashmap的使用中，key和value会根据key的hash值存放到指定的数组中，当出现hash冲突时候，会比较两者间的value值
        * 若一致，则直接覆盖，说不一致则用链表的方法将其追加在上一个value值后*/

    }
}

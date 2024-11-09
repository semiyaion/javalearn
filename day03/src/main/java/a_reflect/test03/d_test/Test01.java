package a_reflect.test03.d_test;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        /*班级有第三名同学，学号和姓名分别为：
        1=张三，2=李四，3=王五，2班有三名同学，
        学号和姓名分别为：1=黄晓明，2=杨颖，3=刘德华,
        请将同学的信息以键值对的形式存储到2个Map集合中
        在将2个Map集合存储到List集合中。*/
        TreeMap<Object, Object> treemap01 = new TreeMap<>();
        treemap01.put(1,"张三");
        treemap01.put(2,"李四");
        treemap01.put(3,"王五");

        TreeMap<Object, Object> map2 = new TreeMap<>();
        map2.put(1,"黄晓明");
        map2.put(2,"杨颖");
        map2.put(3,"刘德华");
        ArrayList<Object> list = new ArrayList<>();
        Set<Map.Entry<Object, Object>> entries = map2.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            list.add(entry);
        }
        Set<Map.Entry<Object, Object>> entries1 = treemap01.entrySet();
        for (Map.Entry<Object, Object> entry01 : entries1) {
            list.add(entry01);
        }
        for (Object list1 : list) {
            System.out.println(list1);
        }
    }
}

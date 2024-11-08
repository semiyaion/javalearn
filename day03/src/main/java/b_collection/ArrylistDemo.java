package b_collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrylistDemo {
        //ArryLiit：底层由数组实现，有索引，线程不安全，存放数据按照存放顺序排列，允许重复
        // 在创建的过程中，new时不不初始化数组，只有在新添加时候，才会创建一个初始化容量为10的数组
        // 当超出数组容量时，数组自动扩容1.5倍
        // 扩容过程：将老数组需要扩容时，数组会先使用Arrys.copyof将原有的老数组复制到新数组中，在新数组中添加新的元素并返回
    //
    //add(element)
    //if (size == elementData.length) // 判断是否需要扩容
    //     grow(minCapacity) // 扩容          oldCapacity默认容量为10,10的二进制数为1010，右移一位就是0101转换成十进制就是5，所以每次都扩容1.5倍
    //       newCapacity = oldCapacity + (oldCapacity >> 1) // 计算新的数组容量
    //        Arrays.copyOf(elementData, newCapacity) // 创建新的数组
    //    elementData[size++] = element; // 添加新元素
    //     return true; // 添加成功*/}

        public static void main(String[] args) {
            //使用空参构造器构造默认容量的ArryList
            ArrayList<Object> list = new ArrayList<>();
            list.add(156);
            list.add("152");
            list.add(true);
            list.add(56.215);
            System.out.println(list);
            //[156, 152, true, 56.215],数组有序
            //使用有参构造器构造
            ArrayList<Object> list1 = new ArrayList<>(16);
            //表示创建一个容量为16的数组

            //调用Collection方法，批量添加元素,默认都是在队尾插入
            Collections.addAll(list,16,"1562",78,false,46.3);
            System.out.println(list);
            //在指定地方插入
            list.add(3,18);
            System.out.println(list);
            ArrayList<Object> list2 = new ArrayList<>();
            list2.add(123);
            list2.add(true);
            list.addAll(3,list2);
            System.out.println(list);
            //Collection中的方法
            Collections.shuffle(list);
            //打乱数组
            System.out.println("list"+list);
            //数组排序，按照Ascii排列
            ArrayList<String> list3 = new ArrayList<>();
            Collections.addAll(list3,"沉默波比","沉默张三","UZi","变态小李");
            Collections.sort(list3);
            System.out.println(list3);

            //查找
            int i = list.indexOf(true);
            //找到了返回集合的索引值
            int i1 = list.indexOf(18);
            //没找到返回-1
            System.out.println(i+" "+i1);
            //删除指定位置的元素
            list.remove(2);
            //将数组容量调整为当前列表当前大小
            list.trimToSize();
            //set更改
            list.set(0,56);




        }
}

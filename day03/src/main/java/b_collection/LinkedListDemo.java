package b_collection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //LinkedList继承Collection,底层实现是一个双向链表元素可重复，有索引，线程不安全
        //与ArryList不同，LinkedList的删除操作复杂度为O（1）而ArryList的最坏复杂度为o（n）
        //ArrtList复制数组，从中间删除数组都要移动大量数据很浪费时间
        LinkedList<String> list = new LinkedList<>();
        list.add("沉默张三");
        list.add("开朗小李");
        list.add("集美小花");
        /*add操作调用的是LinkLast方法
            即在链表尾部添加元素；
            在添加时，会获取链表中的最后一个节点 l
            然后会建立一个新的节点，设置新节点的pre指向l，l的next指向新节点，并将新节点的next指向null
            最后将新节点设置为最后一个节点
            在过程中如果链表为空则设置新节点为头节点

            LinkedList的双向机制实现是依靠Queue
            */
        //头插
        list.addFirst("你好");
        //指定插入
        list.add(1,"变态小杨");
        System.out.println(list);
        //删除
        list.remove(4);
        System.out.println(list);
        //集美小花被删除
        String s = list.get(0);
        //根据索引获取value

        //删除第一个元素，并返回第一个元素
        String poll = list.poll();
        System.out.println(poll);
        System.out.println(list);
        //pop弹栈，弹出一个元素
        String pop = list.pop();
        System.out.println(pop+" "+list);
        System.out.println(list);
        list.push("杀马特团长");
        System.out.println(list);
        //peek弹出栈顶元素但不删除
        String peek = list.peek();
        System.out.println(peek+"  "+list);

    }
}

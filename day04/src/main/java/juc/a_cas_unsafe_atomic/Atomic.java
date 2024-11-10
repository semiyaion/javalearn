package juc.a_cas_unsafe_atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Atomic {
    public static void main(String[] args) {

        /*AtomicInterger常用API
         * 1.get获取当前的值
         * 2.gaeAndset（int newvalue）：获取当前的值，并设置新的值
         * 3.getandincrement获取当前的值，并自增
         * 4.getanddecrement获取当前的值并自减
         * 5.getdanadd（int），获取当前的值，并加上预期值
         * 6lazyset（int value）最终会设置成value，但使用lazyset设置后，可能导致其他线程在一小段时间内还是读取到旧值
         * 其他Atomic与其用法类似*/
        AtomicIntegerArray arry = new AtomicIntegerArray(new int[]{0, 0});
        System.out.println(arry);
        System.out.println(arry.getAndAdd(1, 2));
        System.out.println(arry.getAndAdd(1, 5));
        //在arry索引为1的位置数值加x，并返回原有数值
        System.out.println(arry);
        /*AtomicReference: 原子更新引用类型。
        AtomicStampedReference: 原子更新引用类型, 内部使用Pair来存储元素值及其版本号。
        AtomicMarkableReferce: 原子更新带有标记位的引用类型。*/
    }
}

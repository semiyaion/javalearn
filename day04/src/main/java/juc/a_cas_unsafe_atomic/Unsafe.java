package juc.a_cas_unsafe_atomic;

import java.lang.reflect.Field;

public class Unsafe {
    public static void main(String[] args) throws NoSuchFieldException {
        //类型被final修饰，不可被继承，构造方法是private不可被实例化
        //使用反射获得unsafe中的成员变量
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        //暴力破解Unsafe中私有成员变量

    }
}

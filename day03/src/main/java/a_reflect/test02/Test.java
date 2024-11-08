package a_reflect.test02;

import java.lang.annotation.ElementType;

public class Test {
    public static void main(String[] args) {
        //class类
        Class c1 = Object.class;
        //类
        Class c2 = Comparable.class;
        //接口类
        Class<String[]> c3 = String[].class;
        //数组类
        Class<int[][]> c4 = int[][].class;
        //二维数组
        Class<Override> c5 = Override.class;
        //注解
        Class<ElementType> c6 = ElementType.class;
        //枚举
        Class<Integer> c7 = Integer.class;
        //包装类
        Class<Class> c8 = Class.class;
        //class类
    }
}

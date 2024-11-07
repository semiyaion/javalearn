package h_generic.limit.upper_limit;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Limit.Test<Integer> integerTest = new Limit.Test<>();
        //声明此次使用的类型为Integer类型
        Limit.Test<Long> longTest = new Limit.Test<>();
        integerTest.setVarcha(16);
        longTest.setVarcha(158L);

        ArrayList<Limit.Test<? extends Number>> list = new ArrayList<>();
        //定义数组，数组类只能是数字类型
        list.add(new Limit.Test<Integer>(16));
        System.out.println(list);


    }
}

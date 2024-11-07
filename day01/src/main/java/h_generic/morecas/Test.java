package h_generic.morecas;

import java.util.ArrayList;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Dem<String, String> stringDem = new Dem<>();
        stringDem.setKey("考研");
        stringDem.setValue("狗都不去");
        System.out.println(stringDem.getKey());
        System.out.println(stringDem.getValue());
        ArrayList<Dem<String,Integer>> list = new ArrayList<>();
        //在Arrylist中添加多元泛型
        list.add(new Dem<>("苹果24promaxplus",500000));
        list.add(new Dem<>("华为非凡大师x70",565656565));
        for (Dem<String, Integer> stringIntegerDem : list) {
            System.out.println(stringIntegerDem);
        }



    }
}

package a_annotation.mine;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    @Override
    //重新编译
    public String toString(){
        return super.toString();
    }
    @Deprecated()
    //已过时，不推荐使用
    public static void test(){
        System.out.println("Deprecated");
    }
    @SuppressWarnings("all")
    public void test02(){
        List list=new ArrayList();
        //取消<>括号的报错
    }

    public static void main(String[] args) {
        test();
    }
}

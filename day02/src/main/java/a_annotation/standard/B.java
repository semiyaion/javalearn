package a_annotation.standard;

import java.util.ArrayList;
import java.util.List;

public class B extends A{
    @Override
    //表明重写
    public void test(){
        System.out.println("123");
    }
    @Deprecated
    //表示方法过时
    public void add(){

    }
    @SuppressWarnings("rawtypes")
    //忽略警告（编辑警告类型）
    public List processList(){
        ArrayList list = new ArrayList();
        return list;
    }
}

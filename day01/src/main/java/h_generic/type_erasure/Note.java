package h_generic.type_erasure;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Note {
    /*类型擦除的原则：
    * 1.消除类型参数声明，即删除<>及其包围部分
    * 2.根据上下界推断并替换所有的类型为原生态类型，如果类型参数是无限制通配符或没有上下界则替换为Object
    * 如果有上下界限定则取父类
    * 必要时在插入强制类型转换代码
    */
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(123);
        System.out.println(list.getClass()==list1.getClass());
        //使用getClass方法获取他们类的信息，结果为true说明String和Interger都被擦除了，只剩下原始类
        list1.getClass().getMethod("add", Object.class).invoke(list1,"asd");
        //利用反射调用add方法，然后接受了一个Object类型的参数并将“asd”添加到list1中
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        list1.getClass().getMethod("remove", Object.class).invoke(list1,123);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        //利用反射删除list1中Interger类中的123
    }
}

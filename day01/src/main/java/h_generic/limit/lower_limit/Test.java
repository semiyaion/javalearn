package h_generic.limit.lower_limit;

public class Test {
    public static void main(String[] args) {
        Demo<String> stringDemo = new Demo<>();
        Demo<Object> objectDemo = new Demo<>();
        stringDemo.setVarchar("你好");
        objectDemo.setVarchar(new Object());
        fun(stringDemo);
        fun(objectDemo);

    }
    public static void fun(Demo<? super String> temp){
        //确定，只接收String类和Object类
        System.out.println(temp);
    }
    /*泛型的上下限，extend决定泛型的上限，表示类型可能是指定类型及其子类0，super决定泛型下限，表示类型是指定类型及其父类*/
}

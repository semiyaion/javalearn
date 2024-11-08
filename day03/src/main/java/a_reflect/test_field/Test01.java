package a_reflect.test_field;

import java.lang.reflect.Field;

public class Test01 {
    /*获取成员变量
    * 1.Field[] getFields()             返回所以共有成员变量对象的数组
    * 2.Field[] getDelaredFields        返回所以成员变量的数组
    * 3.Field   getField（String nam）   返回单个公共成员变量对象
    * 4.Field   getDeclaredField(String name)    返回单个成员变量对象*/

    //1.获取字节码文件的变量
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("a_reflect.test_field.User");
        //获取公共的
        Field[] df = clazz.getFields();
        for (Field field : df) {
            System.out.println(field);
            //public java.lang.String a_reflect.test_field.User.id_name
        }
        Field[] df2 = clazz.getDeclaredFields();
        for (Field field : df2) {
            System.out.println(field);
            /*private java.lang.String a_reflect.test_field.User.name
              private java.lang.Integer a_reflect.test_field.User.age
              protected java.lang.String a_reflect.test_field.User.pwd
              public java.lang.String a_reflect.test_field.User.id_name*/
        }
        //只能获取单个共有成员变量

        Field idName = clazz.getField("id_name");
        System.out.println(idName);
        //public java.lang.String a_reflect.test_field.User.id_name

        //获取私有的单个成员变量
        Field age = clazz.getDeclaredField("age");
        System.out.println(age);
        //private java.lang.Integer a_reflect.test_field.User.age

        //获取成员变量名
        String name = idName.getName();
        System.out.println(name);
        //获取数据类型
        Class<?> type = idName.getType();
        System.out.println(type);


        //成员变量记录的值
        User zhansan = new User("张三，", 23, "1564", "zhansan");
        Object zsid = idName.get(zhansan);
        System.out.println(zsid);
        //zhansan

        Field name1 = clazz.getDeclaredField("name");
        //暴力获取
        name1.setAccessible(true);
        Object val = name1.get(zhansan);
        System.out.println(val);

        //修改对象里面的值
        name1.set(zhansan,"李四");
        System.out.println(zhansan);



    }
}

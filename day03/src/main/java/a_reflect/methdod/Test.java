package a_reflect.methdod;

import a_reflect.test_field.User;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {
    public static void main(String[] args) throws Exception {
        /*getMethod()获取公共成员方法
        * getDelaredMethod：返回所以成员方法对象的数组，不包括继承
        * getMothod（String）  返回单个的公共成员方法对象啊
        * geDelaredMethod      返回单个成员方法对象
        *
        * 方法（）Constructor，成员变量（Field），成员方法（Method）的用法大致相同*/
        Class<?> clazz = Class.forName("a_reflect.methdod.User");
        /*获取所有的public方法对象会包含父类中所有的公共方法*/
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        /*获取所有方法但不会获取父类方法*/
        Method[] meth02 = clazz.getDeclaredMethods();
        for (Method method : meth02) {
            System.out.println(method);
        }
        //获取指定单一方法
        Method send = clazz.getDeclaredMethod("send", String.class);
        Method send1 = clazz.getDeclaredMethod("send", String.class, Integer.class);
        Method login = clazz.getDeclaredMethod("login");

        //修饰符
        int i = send.getModifiers();
        //2
        int i2 = send1.getModifiers();
        //2
        int i3 = login.getModifiers();
        //1
        System.out.println(i+" "+i2+" "+i3);

        //名字
        String name = send.getName();
        System.out.println(name);

        //形参
        Parameter[] p1 = send1.getParameters();
        for (Parameter parameter : p1) {
            System.out.println(parameter);
            //java.lang.String arg0
            //java.lang.Integer arg1
        }

        //方法抛出的异常
        Class<?>[] exceptionTypes = send1.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
            //class java.io.IOException
            //class java.lang.NullPointerException
        }

        //方法运行invoke
        User user = new User();
        //user：表示方法的调用者
        //参数传递
        send1.setAccessible(true);
        send1.invoke(user,"张三",16);


    }
}

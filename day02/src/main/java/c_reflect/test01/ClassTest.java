package c_reflect.test01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassTest {
    public  static void main(String[] args) throws ClassNotFoundException {


    Logger logger = Logger.getLogger("ClassTest.java");
        logger.setLevel(Level.INFO);
        //获取class类的实例
        //通过反射获取类的class对象
         Class c1 = Class.forName("c_reflect.test01.User");
        //封装类名
        Class<User> userClass = User.class;
        //根据类的class属性获取
        User user = new User();
        Class<? extends User> aClass = user.getClass();
        //根据类的实例，调用getclass来获取
        System.out.println(c1.hashCode());
        System.out.println(aClass.hashCode());
        System.out.println(userClass.hashCode());
        //一个类在内存中只有一个class对象,所以hashcode的值都一样
        //一个类被加载后，整个类的结构都会分装到class中




        //反射的理解，一般来说一个新的对象要么使用new 要不使用clone，而反射可以做到根据方法，获得新对对象
        //即反射可以通过继承要描述的类的子类对象方法，创建一个新的要描述的类
        /*class的方法
        * 1.ClassforName（String name）           根据类名返回一个class对象
        * 2.newInstance（）                       返回Class对象一个实例
        * 3.getName                               返回此Class对象所表示的实体
        * 4.getsuperclass                            返回此class对象的父类class对象
        * 5.getClassLoader                           返回该类的类加载器
        * 6.getConstructors                          返回一个包含某些Constructor对象的数组
        * 7.getinterfaces                           获取当前class的接口
        * 8.gemothed                                  返回一个对象*/




}
}


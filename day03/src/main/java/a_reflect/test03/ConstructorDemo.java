package a_reflect.test03;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/*class的方法
 * 1.ClassforName（String name）           根据类名返回一个class对象
 * 2.newInstance（）                       返回Class对象一个实例
 * 3.getName                               返回此Class对象所表示的实体
 * 4.getsuperclass                            返回此class对象的父类class对象
 * 5.getClassLoader                           返回该类的类加载器
 * 6.getConstructors                          返回一个包含某些Constructor对象的数组
 * 7.getinterfaces                           获取当前class的接口
 * 8.gemothed                                  返回一个对象*/
public class ConstructorDemo implements Serializable {
    public static void main(String[] args) throws Exception {
        Class<User> user = User.class;
        User user1 = user.newInstance();
        user1.setName("xlc");
        user1.setAge(17);
        System.out.println(user1);
        System.out.println("==================");
        /*Constructor类的用法
        * 1.getConstructor                        返回指定参数类型，具有public访问权限的构造函数对象
        * 2.getConstructors                       返回所有具有public访问权限的构造函数的对象数组
        * 3.getDeclaredConstructor                   返回指定参数类型，所有声明的构造函数对象
        * 4.getDeclareConstructors                  返回所以声明的构造函数对象
        * 5.newINstance                             调用构造器创建此class对象所表示的类的一个新实例*/


        /*获取带String参数的public构造函数*/

        //获取User的字节码文件
        Class<?> clazz = Class.forName("a_reflect.test03.User");
        /*获取所有带String参数的public构造函数*/
        Constructor<?>[] StringDemo = clazz.getConstructors();
        //2构造方法
        //获取public
        Constructor<?>[] cons = clazz.getConstructors();
        for (Constructor<?> con : cons) {
            System.out.println(con);
            //public a_reflect.test03.User()
            //public a_reflect.test03.User(java.lang.String,java.lang.Integer
        }
        //获取所有
        Constructor<?>[] con2 = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : con2) {
            System.out.println(constructor);
            //public a_reflect.test03.User(java.lang.String,java.lang.Integer)
            //protected a_reflect.test03.User(java.lang.String)
            //public a_reflect.test03.User()
        }
        //获取单个
        Constructor<?> con3 = clazz.getDeclaredConstructor(String.class);
        System.out.println("con3="+con3);
        //con3=protected a_reflect.test03.User(java.lang.String)

        //获取私有
        Constructor<?> con4 = clazz.getDeclaredConstructor(Integer.class, String.class);
        //私有设置为可编辑
        con4.setAccessible(true);
        //用con4创建
        User user01 =(User) con4.newInstance(16, "张三");
        System.out.println("con4"+con4);
        //con4private a_reflect.test03.User(java.lang.Integer,java.lang.String)
        System.out.println(user01);

        //获取构造方法要保证参数传递的一致




    }
}

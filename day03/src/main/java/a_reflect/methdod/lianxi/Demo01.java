package a_reflect.methdod.lianxi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
@SuppressWarnings("all")
public class Demo01 {

    public static void main(String[] args) throws Exception, IOException {
        //保存信息，对于任一对象，都可以把对象所以的字段名和值，保存到文件中
        Student s = new Student("张三", 23, "男", 175.6, "睡觉");
        Teacher t = new Teacher("李四", 8765.43);
        saveObject(s);
//        saveObject(t);
    }
    public static void saveObject(Object o) throws Exception, IOException {
        Class<?> alzz = o.getClass();
        Field[] fild = alzz.getDeclaredFields();
        //写入文档，io流
        ExecutorService ex = Executors.newFixedThreadPool(3);

        BufferedWriter bw = new BufferedWriter(new FileWriter("day03/a.txt"));


        //获取所有成员变量
        for (Field field : fild) {
            field.setAccessible(true);
            //获取成员变量名字
            String name = field.getName();
            //获取成员变量的值
            Object value = field.get(o);
            bw.write(name+"  "+value);
            bw.newLine();

        }
        System.out.println("写入完成");

        bw.close();

    }
}

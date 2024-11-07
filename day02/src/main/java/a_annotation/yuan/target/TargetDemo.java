package a_annotation.yuan.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class TargetDemo {
    /*target描述注解的使用范围：即修饰的注解可以使用在什么地方*/
    @Target(ElementType.METHOD)
    //Target注解中只有一个value值，但value值的类型是一个枚举数组，数组中存在FIELD，METHOD等类型，表示修饰什么位置
    //定义注解，指定它只能用于方法
    //该注解只用于方法上
    public @interface Method01{
        String des();
    }

}

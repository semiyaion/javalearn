package a_annotation.yuan.inheritrf;

import java.lang.annotation.*;

@Inherited
//被他修饰的注解具有继承性，某个子类继承则一样还会出现这个注解
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface TestInher {
    String [] value();
    int number();

}

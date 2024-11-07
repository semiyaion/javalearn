package a_annotation.yuan.inheritrf;

import org.junit.Test;

import java.lang.annotation.Annotation;

@TestInher(value = {"value"},number = 10)
public class Person {
}
class Stundent extends Person{
    @Test
    public void test(){
        Class clazz= Stundent.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }
}

package a_annotation.mine;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test02 {
    @Test
    @Myannot(name="张强",age=17,id=1076409766,school = "睢宁")
    public void test(){

    }
    @Myannnot2("lqd")
    public  void test02(){

    }


}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Myannot{
    String name() default "";
    int age() default 0;
    int id() default -1;//如果值为-1，表示不存在
    String[] school() default {"睢宁中学"};

}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Myannnot2{
    String value();
}

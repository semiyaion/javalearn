package a_annotation.yuan.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Test {
    @Retention(RetentionPolicy.SOURCE)
    public @interface SourcePolicy{
        /*在源代码期间有效*/

    }
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassPolicy{
    /*在编译成class期间还有效*/
    }
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RuntimePolicy{
    }
    //在任何时间都有效
    //Reteniton注解的作用是注解保留的时间，即被描述的注解在他所修饰的类中可以被保留到何时
}

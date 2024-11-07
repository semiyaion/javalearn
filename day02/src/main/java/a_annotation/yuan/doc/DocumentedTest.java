package a_annotation.yuan.doc;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
//在使用javadoc工具为类生成帮助文档时是否要保存注解信息
@Target({ElementType.TYPE,ElementType.METHOD})
//在类和方法中使用接口
public @interface DocumentedTest {
        public String value()default "123456";

}



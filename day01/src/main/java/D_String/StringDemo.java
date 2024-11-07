package D_String;

public class StringDemo {
    public static void main(String[] args) {
        /*public final class String
         implements java.io.Serializable, Comparable<String>, CharSequence {*/
        /*String类被final修饰,不能被继承*/

        String s1=new String("aaa");
        String s2 = new String("aaa");
        String s3 = s1.intern();
        /*intern首先将自自己引用的对象放到字符串常量池中，然后返回对象引用赋值给s3，所以地址名相同，所含字符串也相同*/

        /*与Interger类似，自动放入字符串池*/
        String s4="abc";
        String s5="abc";
        System.out.println(s4==s5);


        /*String类型连接与字符池子中的关系*/
        String s6="helloworld";
        String s7="hello";
        String s8="world";
        String s9=s7+s8;
        System.out.println(s9==s6);
        /*false*/
        /*String result = new StringBuilder().append(str1).append(str2).toString();会再次new对象*/
        StringBuffer sb = new StringBuffer();
        sb.append(s7);
        sb.append(s8);
        String s10=sb.toString();
        System.out.println(s10);
    }
}

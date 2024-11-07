package h_generic;

public class Demo {
    private static int add(int a,int b){
        //此处为未使用泛型的操作，
        System.out.println(a+"+"+b+"="+(a+b));
        return a+b;
    }
    private static float add(float a,float b){
        System.out.println(a+"+"+b+"="+(a+b));
        return a+b;
    }
    private static double add(double a,double b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }
    private static <T extends Number> double add(T a,T b){
        /*泛型T继承Number，NUmber是Java中的一个抽象类，包括了INteger，Double，Float ，Long等各种包装类
        可实现方法有 数值类型Value（），常用于泛型约束，可以限制泛型类型为数值类型*/
        System.out.println(a + "+" + b + "=" + (a.doubleValue()+b.doubleValue()));
        //将a和b接收到的数据类型全部转成double，用double类型进行运算操作，泛型在使用中不需要使用强转（类型安全）
        return a.doubleValue()+b.doubleValue();
    }

    public static void main(String[] args) {
        add(10,16.2);
    }

}

package c_reflect.test02.dogclass;

public class Tsst02 {
    public static void main(String[] args) {
        Class<Dog> dogClass = Dog.class;
        //类名
        System.out.println(dogClass.getName());
        //接口
        for (Class<?> i1 : dogClass.getInterfaces()) {
            System.out.println(i1);
        }
        //父类
        Class<? super Dog> sup1 = dogClass.getSuperclass();
        System.out.println(sup1);
    }
}

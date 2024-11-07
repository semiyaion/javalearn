package h_generic.method;

public class Test {
    public static <T> boolean Test01(T obj1,T obj2){
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
        Integer int01=10;
        Integer int02=20;
        System.out.println(Test01(int01,int02));
        String s1="123";
        String s2="123";
        System.out.println(Test01(s1,s2));
    }
}

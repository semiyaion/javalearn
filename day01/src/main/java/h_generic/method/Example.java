package h_generic.method;

public class Example {
    public static <T> void printArry(T[] arry){
        for(T element :arry){
            System.out.print(element+"");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Integer[] intArry={1,2,3,4,};

    }
}

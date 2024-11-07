package b_exception.usually_use;

public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
            int a = 10;
            /*算术条件异常*/
            int b = 0;
            try {
                System.out.println(a / b);
            }catch (ArithmeticException e){
                e.printStackTrace();
            }

    }
}

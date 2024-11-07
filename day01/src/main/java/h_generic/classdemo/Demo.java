package h_generic.classdemo;

public class Demo {
    public static void main(String[] args) {
        Test<String> test = new Test<>();
        /*将Test中的T赋为String*/
        test.setVarchar("666");
        String s = test.getVarchar();
        System.out.println(s);

    }
}

package b_exception.usually_use;

public class NullPonter {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.length());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}

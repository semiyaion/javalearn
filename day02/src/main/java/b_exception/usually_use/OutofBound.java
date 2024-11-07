package b_exception.usually_use;

public class OutofBound {
    public static void main(String[] args) {
        //数组索引越界异常
        int[] arr={1,2,3};
        try{
            System.out.println(arr[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}

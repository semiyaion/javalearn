package h_generic.arry;

public class ArryDemo {
    public static void main(String[] args) {
        Integer i[]=fun1(1,2,3,4,5,6);
        //返回泛型数组
        fun2(i);
        //将接受的数组存入fun2中，fun2 t接收到Interger并将param[]设为Interger类型的数组
    }



    public static <T>T[]fun1(T...arg) {
        //传递数量不确定的参数，并以数组的形式返回
        return arg;
    }
     public static <T> void fun2(T param[]){
         System.out.println("接受泛型数组");
         //param[] 表示这个方法接受一个数组类型的参数
         //<T>表示声明此类方法使用泛型
         //T接收泛型的类型
         for (T t : param) {
             System.out.println(t+" ");
         }
     }
    }
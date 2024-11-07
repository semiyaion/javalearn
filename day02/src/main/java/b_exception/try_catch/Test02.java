package b_exception.try_catch;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        int value = 0;
        Scanner sc = new Scanner(System.in);
        value = sc.nextInt();
        if(value==0){
            throw new ArithmeticException("参数不能为空");
        }
    }
    }

package b_exception.try_catch;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        tryResour();
    }
    private  static void tryResour(){
        try (Scanner scanner= new Scanner(new FileInputStream("b_exception/123.txt"),"UTF-8")){
            System.out.println(scanner);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

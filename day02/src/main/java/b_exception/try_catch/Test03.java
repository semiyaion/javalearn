package b_exception.try_catch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test03 {
    public static void main(String[] args) throws IOException {

    }
    private static void readFile(String filePath) throws IOException {
        File file = new File(filePath);
        String result;
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((result= reader.readLine())!=null){
                System.out.println(result);
            }
        }catch (Exception e){
            System.out.println("catch block");
        }finally {
            while ((result= reader.readLine())!=null){
                System.out.println(result);
        }
    }
}
}

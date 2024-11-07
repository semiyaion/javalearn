package b_exception.try_catch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test01 {
    private static void reeadFiels(String filepath) throws IOException {
        File file = new File(filepath);
        //新建文件类
        String result;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        //如果文件中还有内容，就继续读取
        while ((result=reader.readLine())!=null){
            System.out.println(result);
            //输出文件中的一行信息
        }
        reader.close();
    }
}

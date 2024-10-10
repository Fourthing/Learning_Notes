import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

/**
  * 这个类复制文本文件
  */
class FileCopy {

    /** 
     * 构造方法. 
     */
    protected FileCopy() {
    }

    /** 
     * 复制文件的方法.
     * @param file1 存储源文件名.
     * @param file2 存储目标文件名.
     */
    public void copy(final String file1, final String file2) {

         //创建 File 对象.
        File inFile  = new File(file1);  
        File outFile = new File(file2);

      
        try {
        	System.out.println("复制文件开始。。。");
            //为文本文件创建 reader 类和 writer 类.
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

            //只要有输入行就进行循环.
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();   
            }

            //关闭 reader 和 writer.
            reader.close();  
            writer.close();  

        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        System.out.println("复制文件结束。");
    }
}

/** 
 * 这是一个 main 类. 
 */
class CopyTextFile {
    public static void main(String[] args) throws IOException {    	
            FileCopy obj = new FileCopy();
            obj.copy("D:\\myDoc\\s1.txt", "D:\\myDoc\\s2.txt");           
    }
}

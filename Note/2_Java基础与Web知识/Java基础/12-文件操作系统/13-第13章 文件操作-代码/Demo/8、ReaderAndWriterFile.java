
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.omg.CORBA.Environment;

public class ReaderAndWriterFile {

	 public void replaceFile(String file1,String file2) {   
		   BufferedReader reader = null;
           BufferedWriter writer = null;
		 try {
			//创建 FileReader对象和FileWriter对象.
			 //中文内容编码问题
			//FileReader fr  = new FileReader(file1);  
			 FileInputStream fis=new FileInputStream(file1);
			InputStreamReader isr=new InputStreamReader(fis,"utf-8");
			
			FileWriter fw = new FileWriter(file2);
            //创建 输入、输入出流对象.
            reader = new BufferedReader(isr);
            writer = new BufferedWriter(fw);
            String line = null;
            StringBuffer sbf=new StringBuffer();  
            //循环读取并追加字符
            while ((line = reader.readLine()) != null) {
                sbf.append(line);  
            }
            System.out.println("替换前："+sbf);
            /*替换内容*/
            String newString=sbf.toString().replace("{name}", "欧欧");
            newString = newString.replace("{type}", "狗狗");
            newString = newString.replace("{master}", "李伟");
            System.out.println("替换后："+newString);
            writer.write(newString);  //写入文件       
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	//关闭 reader 和 writer.
			try {
				if(reader!=null)
					reader.close();
				if(writer!=null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ReaderAndWriterFile obj = new ReaderAndWriterFile();
        obj.replaceFile("c:\\pet.template", "C:\\myDoc\\pet.txt");   
        System.out.println(Charset.defaultCharset());
	}
}

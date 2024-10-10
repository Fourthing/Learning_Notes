import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class FileOutputStreamTest {
	
	public static void main(String[] args) {
		 try {
			 String str ="好好学习Java";
	         byte[] words  = str.getBytes();
	         FileOutputStream fos = new FileOutputStream("D:\\myDoc\\hello.txt",true);
	         fos.write(words, 0, words.length);
	         System.out.println("hello文件已更新!");
	         fos.close();
	      }catch (IOException obj) {
	    	  System.out.println("创建文件时出错!");
	      }
	}
}

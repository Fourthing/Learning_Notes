import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class FileOutputStreamTest {
	
	public static void main(String[] args) {
		 try {
			 String str ="�ú�ѧϰJava";
	         byte[] words  = str.getBytes();
	         FileOutputStream fos = new FileOutputStream("D:\\myDoc\\hello.txt",true);
	         fos.write(words, 0, words.length);
	         System.out.println("hello�ļ��Ѹ���!");
	         fos.close();
	      }catch (IOException obj) {
	    	  System.out.println("�����ļ�ʱ����!");
	      }
	}
}

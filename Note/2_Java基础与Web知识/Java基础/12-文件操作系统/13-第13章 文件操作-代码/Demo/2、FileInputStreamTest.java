
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class FileInputStreamTest {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:\\myDoc\\hello.txt");
		int data;
		
		System.out.println("可读取的字节数: "+ fis.available());
	
		/*
		System.out.print("文件内容为: ");
		while((data=fis.read())!=-1){
			System.out.print(data+" ");
		}
		*/			
		
		System.out.println("\n将字节文件内容转换为字符串后查看到的文件内容为: ");		
		 while((data=fis.read())!=-1){			
				System.out.print((char)data);
		}		
		
	
		fis.close();
	}
}

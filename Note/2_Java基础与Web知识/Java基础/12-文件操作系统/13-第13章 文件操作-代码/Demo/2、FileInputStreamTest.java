
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class FileInputStreamTest {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:\\myDoc\\hello.txt");
		int data;
		
		System.out.println("�ɶ�ȡ���ֽ���: "+ fis.available());
	
		/*
		System.out.print("�ļ�����Ϊ: ");
		while((data=fis.read())!=-1){
			System.out.print(data+" ");
		}
		*/			
		
		System.out.println("\n���ֽ��ļ�����ת��Ϊ�ַ�����鿴�����ļ�����Ϊ: ");		
		 while((data=fis.read())!=-1){			
				System.out.print((char)data);
		}		
		
	
		fis.close();
	}
}

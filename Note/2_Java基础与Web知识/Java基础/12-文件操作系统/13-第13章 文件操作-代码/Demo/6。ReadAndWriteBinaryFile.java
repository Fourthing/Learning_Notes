

import java.io.*;

//二进制文件的读写
public class ReadAndWriteBinaryFile {
	public static void main(String[] args){
		DataInputStream dis=null;
		DataOutputStream dos=null;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			//创建输入流对象
			fis=new FileInputStream("d:\\myDoc\\star.jpg");
			dis=new DataInputStream(fis);
			//创建输出流对象
			fos=new FileOutputStream("d:\\myDoc\\newPic\\new.jpg");
			dos=new DataOutputStream(fos);
			//读取文件并写入文件
			int temp;
			while((temp=dis.read())!=-1){
				dos.write(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
			try {
				if(dis!=null){
					dis.close();
				}
				if(dos!=null){
					dos.close();
				}
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

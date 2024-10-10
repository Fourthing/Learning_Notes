import  java.io.*;
public class BufferedReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
	        //创建一个FileReader对象
	        FileReader fr=new FileReader("D:\\myDoc\\hello.txt"); 
	        //创建一个BufferedReader 对象
	        BufferedReader br=new BufferedReader(fr); 
	        //读取一行数据 
	        String line=br.readLine();
	        while(line!=null){ 
	            System.out.println(line);
	            line=br.readLine(); 
	        }
	         //流的关闭 
	        br.close();
	        fr.close(); 
	       
	    }catch(IOException e){
	            System.out.println("文件不存在!");
	    }
	}

}

import  java.io.*;
public class BufferedWriterTest {

	public static void main(String[] args) {
		try {
		       //创建一个FileWriter 对象
		       FileWriter fw=new FileWriter("D:\\myDoc\\hello.txt"); 
		       //创建一个BufferedWriter 对象
		       BufferedWriter bw=new BufferedWriter(fw); 
		       bw.write("大家好！"); 
		       bw.write("我正在学习BufferedWriter。"); 
		       bw.newLine(); 
		       bw.write("请多多指教！"); 
		       bw.newLine();		       

		       bw.flush();
		       fw.close();
		       
		       //读取文件内容
		        FileReader fr=new FileReader("c:\\myDoc\\hello.txt"); 
		        BufferedReader br=new BufferedReader(fr); 
		        String line=br.readLine();
		        while(line!=null){ 
		            System.out.println(line);
		            line=br.readLine(); 
		        }
		        br.close(); 
		        fr.close(); 

		       }catch(IOException e){
		            System.out.println("文件不存在!");
		       }
	}
}

import  java.io.*;
public class BufferedWriterTest {

	public static void main(String[] args) {
		try {
		       //����һ��FileWriter ����
		       FileWriter fw=new FileWriter("D:\\myDoc\\hello.txt"); 
		       //����һ��BufferedWriter ����
		       BufferedWriter bw=new BufferedWriter(fw); 
		       bw.write("��Һã�"); 
		       bw.write("������ѧϰBufferedWriter��"); 
		       bw.newLine(); 
		       bw.write("����ָ�̣�"); 
		       bw.newLine();		       

		       bw.flush();
		       fw.close();
		       
		       //��ȡ�ļ�����
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
		            System.out.println("�ļ�������!");
		       }
	}
}

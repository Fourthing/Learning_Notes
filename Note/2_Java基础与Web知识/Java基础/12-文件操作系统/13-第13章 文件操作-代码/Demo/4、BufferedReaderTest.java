import  java.io.*;
public class BufferedReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
	        //����һ��FileReader����
	        FileReader fr=new FileReader("D:\\myDoc\\hello.txt"); 
	        //����һ��BufferedReader ����
	        BufferedReader br=new BufferedReader(fr); 
	        //��ȡһ������ 
	        String line=br.readLine();
	        while(line!=null){ 
	            System.out.println(line);
	            line=br.readLine(); 
	        }
	         //���Ĺر� 
	        br.close();
	        fr.close(); 
	       
	    }catch(IOException e){
	            System.out.println("�ļ�������!");
	    }
	}

}

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

/**
  * ����ิ���ı��ļ�
  */
class FileCopy {

    /** 
     * ���췽��. 
     */
    protected FileCopy() {
    }

    /** 
     * �����ļ��ķ���.
     * @param file1 �洢Դ�ļ���.
     * @param file2 �洢Ŀ���ļ���.
     */
    public void copy(final String file1, final String file2) {

         //���� File ����.
        File inFile  = new File(file1);  
        File outFile = new File(file2);

      
        try {
        	System.out.println("�����ļ���ʼ������");
            //Ϊ�ı��ļ����� reader ��� writer ��.
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

            //ֻҪ�������оͽ���ѭ��.
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();   
            }

            //�ر� reader �� writer.
            reader.close();  
            writer.close();  

        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        System.out.println("�����ļ�������");
    }
}

/** 
 * ����һ�� main ��. 
 */
class CopyTextFile {
    public static void main(String[] args) throws IOException {    	
            FileCopy obj = new FileCopy();
            obj.copy("D:\\myDoc\\s1.txt", "D:\\myDoc\\s2.txt");           
    }
}

package JBJADV003;

import java.io.*;

class FileEditor {
  public static void main(String args[]) throws IOException {
    /*���ʱ�主ԣ�����޸��ļ����ɿ���̨����    */	  
    File f = new File("c:\\myDoc\\test.txt");
    if (f.exists() && f.isFile()) {
      System.out.println("�ļ��Ѵ��ڡ���������");
    }
    else {
      System.out.println("�ļ������ڡ��½�һ���ļ�");
    }
    try {
      BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
      String line;
      DataOutputStream o = new DataOutputStream(new FileOutputStream("c:\\myDoc\\test.txt"));
      System.out.println("�������ı����ݣ��� end �������룺");
      System.out.println("=============================");
      while ( (line = i.readLine()) != null) {
        if (line.equals("end")) {
          break;
        }
        else {
          String z = (line);
          o.writeBytes(z + "\r\n");
        }
      }
      o.close();
      BufferedReader d = new BufferedReader(new FileReader("c:\\myDoc\\test.txt"));
      System.out.println("\n����ļ����ݣ� " );

      System.out.println("=============================");
      while ( (line = d.readLine()) != null) {
        System.out.println(line);
      }
      d.close();
    }
    catch (IOException e) {
      System.out.println("���ִ���");
    }
  }
}

package JBJADV003;

import java.io.*;

class FileEditor {
  public static void main(String args[]) throws IOException {
    /*如果时间富裕，可修改文件名由控制台输入    */	  
    File f = new File("c:\\myDoc\\test.txt");
    if (f.exists() && f.isFile()) {
      System.out.println("文件已存在。覆盖内容");
    }
    else {
      System.out.println("文件不存在。新建一个文件");
    }
    try {
      BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
      String line;
      DataOutputStream o = new DataOutputStream(new FileOutputStream("c:\\myDoc\\test.txt"));
      System.out.println("请输入文本内容，入 end 结束输入：");
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
      System.out.println("\n输出文件内容： " );

      System.out.println("=============================");
      while ( (line = d.readLine()) != null) {
        System.out.println(line);
      }
      d.close();
    }
    catch (IOException e) {
      System.out.println("出现错误");
    }
  }
}

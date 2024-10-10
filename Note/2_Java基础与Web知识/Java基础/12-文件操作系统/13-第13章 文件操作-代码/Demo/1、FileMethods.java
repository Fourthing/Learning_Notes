
import  java.io.*;
public class FileMethods {

	public static void main(String[] args) throws IOException {
		//查看文件属性
		File f1 = new File("D:\\myDoc", "hello.txt");
		 System.out.println("文件名：" + f1.getName());
		 System.out.println("路径：" + f1.getPath());
		 System.out.println("绝对路径：" + f1.getAbsolutePath());
		 System.out.println(f1.exists() ? "文件存在" : "文件不存在");
		 System.out.println(f1.isDirectory() ? "文件是目录" :"文件不是目录");
		 System.out.println(f1.isFile() ? "文件是普通文件" :"文件可能是命名管道");
		 if (f1.canRead()){
			 System.out.println("可以读取此文件");
		 }else {
		     System.out.println("不能读取此文件");
		 }
		 if (f1.canWrite()){
			 System.out.println("可以写入到此文件");
		 }else {
		     System.out.println("不能写入此文件");
		 }
                   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");                 
                   Date date =new Date(file.lastModified());
		 
System.out.println("此文件最后修改时间是" +sdf.format(date));
		 		 
		 //创建和删除文件
		 FileMethods fm=new FileMethods();
		 File f = new File("c:\\myDoc\\test.txt");
		 fm.create(f);
		 fm.delete(f1);
		 File dir = new File("c:\\myDoc");
		 fm.listDir(dir);
	}
	//创建文件
	public void create(File file) throws IOException{
		if(!file.exists()){
			file.createNewFile();
                          System.out.println("创建成功");
		}
	}
	//删除文件
	public void delete(File file){
		if(file.exists()){
			file.delete();
                        System.out.println("删除成功");
		}
	}
	//查看目录信息
	public void listDir(File dir){
		File[] lists=dir.listFiles();
		//打印当前目录dir的所有子目录和文件
		String info="目录信息为："+dir.getName()+"\\";
		for(int i=0;i<lists.length;i++){
			info+=lists[i].getName()+"\\";
		}		
		System.out.print(info);
	}
}




import  java.io.*;
public class FileMethods {

	public static void main(String[] args) throws IOException {
		//�鿴�ļ�����
		File f1 = new File("D:\\myDoc", "hello.txt");
		 System.out.println("�ļ�����" + f1.getName());
		 System.out.println("·����" + f1.getPath());
		 System.out.println("����·����" + f1.getAbsolutePath());
		 System.out.println(f1.exists() ? "�ļ�����" : "�ļ�������");
		 System.out.println(f1.isDirectory() ? "�ļ���Ŀ¼" :"�ļ�����Ŀ¼");
		 System.out.println(f1.isFile() ? "�ļ�����ͨ�ļ�" :"�ļ������������ܵ�");
		 if (f1.canRead()){
			 System.out.println("���Զ�ȡ���ļ�");
		 }else {
		     System.out.println("���ܶ�ȡ���ļ�");
		 }
		 if (f1.canWrite()){
			 System.out.println("����д�뵽���ļ�");
		 }else {
		     System.out.println("����д����ļ�");
		 }
                   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");                 
                   Date date =new Date(file.lastModified());
		 
System.out.println("���ļ�����޸�ʱ����" +sdf.format(date));
		 		 
		 //������ɾ���ļ�
		 FileMethods fm=new FileMethods();
		 File f = new File("c:\\myDoc\\test.txt");
		 fm.create(f);
		 fm.delete(f1);
		 File dir = new File("c:\\myDoc");
		 fm.listDir(dir);
	}
	//�����ļ�
	public void create(File file) throws IOException{
		if(!file.exists()){
			file.createNewFile();
                          System.out.println("�����ɹ�");
		}
	}
	//ɾ���ļ�
	public void delete(File file){
		if(file.exists()){
			file.delete();
                        System.out.println("ɾ���ɹ�");
		}
	}
	//�鿴Ŀ¼��Ϣ
	public void listDir(File dir){
		File[] lists=dir.listFiles();
		//��ӡ��ǰĿ¼dir��������Ŀ¼���ļ�
		String info="Ŀ¼��ϢΪ��"+dir.getName()+"\\";
		for(int i=0;i<lists.length;i++){
			info+=lists[i].getName()+"\\";
		}		
		System.out.print(info);
	}
}



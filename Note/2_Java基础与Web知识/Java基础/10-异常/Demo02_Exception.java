import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo02_Exception{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // ��ȡ��������
            System.out.println("������һ��������");
            int number = scanner.nextInt();
            
            // ģ��������������������쳣
            System.out.println("�����������");
            int divisor = scanner.nextInt();
            int result = divide(number, divisor);
            System.out.println("����ǣ�" + result);
            
            // ģ��������ʣ�������������Խ���쳣
            int[] array = {1, 2, 3};
            System.out.println("����������������");
            int index = scanner.nextInt();
            System.out.println("����Ԫ���ǣ�" + array[index]);
        } catch (InputMismatchException e) {
            // �����������Ͳ�ƥ���쳣
            System.out.println("�������Ͳ�ƥ���쳣��" + e.getMessage());
        } catch (ArithmeticException e) {
            // ���������쳣
            System.out.println("�����쳣��" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // ������������Խ���쳣
            System.out.println("��������Խ���쳣��" + e.getMessage());
        } catch (Exception e) {
            // �������������쳣
            System.out.println("�����쳣��" + e.getMessage());
        } finally {
            // �����Ƿ����쳣����ִ����δ���
            System.out.println("����������");
            scanner.close(); // �ر� Scanner ����
        }
    }

    // ���������������׳� ArithmeticException
    public static int divide(int a, int b) {
        return a / b;
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo02_Exception{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // 读取整数输入
            System.out.println("请输入一个整数：");
            int number = scanner.nextInt();
            
            // 模拟除法操作，捕获算术异常
            System.out.println("请输入除数：");
            int divisor = scanner.nextInt();
            int result = divide(number, divisor);
            System.out.println("结果是：" + result);
            
            // 模拟数组访问，捕获数组索引越界异常
            int[] array = {1, 2, 3};
            System.out.println("请输入数组索引：");
            int index = scanner.nextInt();
            System.out.println("数组元素是：" + array[index]);
        } catch (InputMismatchException e) {
            // 捕获输入类型不匹配异常
            System.out.println("输入类型不匹配异常：" + e.getMessage());
        } catch (ArithmeticException e) {
            // 捕获算术异常
            System.out.println("算术异常：" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // 捕获数组索引越界异常
            System.out.println("数组索引越界异常：" + e.getMessage());
        } catch (Exception e) {
            // 捕获其他所有异常
            System.out.println("其他异常：" + e.getMessage());
        } finally {
            // 无论是否发生异常，都执行这段代码
            System.out.println("操作结束。");
            scanner.close(); // 关闭 Scanner 对象
        }
    }

    // 除法操作，可能抛出 ArithmeticException
    public static int divide(int a, int b) {
        return a / b;
    }
}

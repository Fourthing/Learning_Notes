import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *电话簿管理类，与用户进行交互
 */
public class PhoneBookTest {
    /**
     * 启动方法
     */
    public static void main(String[] args) {
        //新建电话簿
        PhoneManager phoneBook = new PhoneManager();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            //打印操作选项
            System.out.println("-----------请选择操作-----------");
            System.out.println("            1.添加");
            System.out.println("            2.详细");
            System.out.println("            3.删除");
            System.out.println("            4.统计");
            System.out.println("            5.全部展示");
            System.out.println("            6.退出");
            System.out.println("------------------------------");
            int operation = scanner.nextInt();

            switch (operation) {
                // 1是添加
                case 1:{
                    Phone phone = new Phone();
                    System.out.print("请输入姓名:");
                    phone.setName(scanner.next());
                    System.out.print("请输入电话型号:");
                    phone.setPhoneType(scanner.next());
                    System.out.print("请输入电话号码:");
                    phone.setPhoneNumber(scanner.next());
                    if (CheckMobilePhoneNum(phone.getPhoneNumber())) {
                        // 添加成功与否的判断
                        if (phoneBook.addPhone(phone)) {
                            System.out.println("添加成功！");
                        }else {
                            System.out.println("添加失败，已存在相同电话号码！");
                        }
                    }else {
                        System.out.println("电话号码格式错误，添加失败！");
                    }

                    break;
                }
                // 2是查看详细
                case 2:{
                    phoneBook.printBooks();
                    System.out.println("请输入查看的序号");
                    int num = scanner.nextInt();
                    // 输入有效性检测
                    if (phoneBook.getPhoneNumber()<num){
                        System.out.println("无效的下标！");
                        break;
                    }
                    phoneBook.printSingleBook(num);
                    break;
                }
                // 3是查看删除电话信息
                case 3:{
                    phoneBook.printBooks();
                    System.out.println("请输入要删除的电话号码");
                    String num = scanner.next();
                    // 删除成功与否的判断
                    if (phoneBook.deletePhone(num)) {
                        System.out.println("删除成功！");
                    }else {
                        System.out.println("该手机号码不存在！");
                    }
                    break;
                }
                // 4是查看统计数量信息
                case 4:{
                    System.out.println("当前的数量是："+phoneBook.getPhoneNumber());
                    break;
                }
                // 5是打印所有电话信息
                case 5:{
                    phoneBook.printBooks();
                    break;
                }
                // 6是退出
                case 6:{
                    flag = false;
                    break;
                }
                default: break;
            }

        }

    }

    /**
     * 正则表达式匹配手机号格式是否正确
     * @param phoneNum 电话号码
     * @return java.lang.Boolean
     */
    public static boolean CheckMobilePhoneNum(String phoneNum) {
        String regex = "^(1[3-9]\\d{9}$)";
        if (phoneNum.length() == 11) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNum);
            if (m.matches()) {
                return true;
            }
        }
        return false;
    }
}

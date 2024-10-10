// package com.example;

// /**
//  * Hello world!
//  *
//  */
// public class App 
// {
//     public static void main( String[] args )
//     {
//         System.out.println( "Hello World!" );
//     }
// }
package com.example;

import java.util.Scanner;

public class App {
    private static String[] names = new String[4]; // 保存订餐人名称
    private static String[] dishMegs = new String[4]; // 保存菜品名及份数
    private static int[] times = new int[4]; // 保存送餐时间
    private static String[] addresses = new String[4]; // 保存送餐地址
    private static int[] states = new int[4]; // 保存订单状态: 0:已预订 1:已完成
    private static double[] sumPrices = new double[4]; // 保存订单的总金额
    private static String[] dishNames = {"糖醋排骨", "鱼香肉丝", "水煮菜心"};
    private static double[] prices = {38.0, 20.0, 30.0};
    private static int[] likes = {0, 0, 0};

    public static void main(String[] args) {
        // 初始化订单信息
        names[0] = "张晴";
        dishMegs[0] = "糖醋排骨 2份";
        times[0] = 12;
        addresses[0] = "长春路13号";
        states[0] = 1;
        sumPrices[0] = 76.0;

        names[1] = "张晴";
        dishMegs[1] = "鱼香肉丝 2份";
        times[1] = 18;
        addresses[1] = "长春路13号";
        states[1] = 0;
        sumPrices[1] = 45.0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用在线订餐系统");
            System.out.println("1. 查看餐袋");
            System.out.println("2. 我要订餐");
            System.out.println("3. 签收订单");
            System.out.println("4. 删除订单");
            System.out.println("5. 我要点赞");
            System.out.println("6. 退出系统");
            System.out.print("请选择：");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewOrders();
                    break;
                case 2:
                    addOrder(scanner);
                    break;
                case 3:
                    signOrder(scanner);
                    break;
                case 4:
                    deleteOrder(scanner);
                    break;
                case 5:
                    likeDish(scanner);
                    break;
                case 6:
                    System.out.println("感谢使用，再见！");
                    return;
                default:
                    System.out.println("无效选择，请重新输入");
            }
        }
    }

    private static void viewOrders() {
        System.out.println("查看餐袋");
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.println("订单编号：" + (i + 1));
                System.out.println("订餐人：" + names[i]);
                System.out.println("菜品信息：" + dishMegs[i]);
                System.out.println("送餐时间：" + times[i] + "点");
                System.out.println("送餐地址：" + addresses[i]);
                System.out.println("订单状态：" + (states[i] == 0 ? "已预订" : "已完成"));
                System.out.println("订单总金额：" + sumPrices[i] + "元");
                System.out.println("---------------");
            }
        }
    }

    private static void addOrder(Scanner scanner) {
        System.out.print("请输入订餐人姓名：");
        String customerName = scanner.next();
        System.out.println("菜品信息：");
        for (int i = 0; i < dishNames.length; i++) {
            System.out.println((i + 1) + ". " + dishNames[i] + " " + prices[i] + "元");
        }
        System.out.print("请选择您要点的菜品编号：");
        int dishIndex = scanner.nextInt() - 1;
        System.out.print("请选择您需要的份数：");
        int quantity = scanner.nextInt();
        System.out.print("请输入送餐时间（10-20点整点送餐）：");
        int deliveryTime = scanner.nextInt();
        System.out.print("请输入送餐地址：");
        String address = scanner.next();

        String dishInfo = dishNames[dishIndex] + " " + quantity + "份";
        double totalPrice = prices[dishIndex] * quantity;
        if (totalPrice < 50) {
            totalPrice += 5; // 送餐费
        }

        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                names[i] = customerName;
                dishMegs[i] = dishInfo;
                times[i] = deliveryTime;
                addresses[i] = address;
                states[i] = 0;
                sumPrices[i] = totalPrice;
                System.out.println("订餐成功！");
                break;
            }
        }
    }

    private static void signOrder(Scanner scanner) {
        System.out.print("请输入要签收的订单编号：");
        int orderIndex = scanner.nextInt() - 1;
        if (orderIndex >= 0 && orderIndex < names.length && names[orderIndex] != null) {
            if (states[orderIndex] == 0) {
                states[orderIndex] = 1;
                System.out.println("订单签收成功！");
            } else {
                System.out.println("订单已签收！");
            }
        } else {
            System.out.println("无效的订单编号！");
        }
    }

    private static void deleteOrder(Scanner scanner) {
        System.out.print("请输入要删除的订单编号：");
        int orderIndex = scanner.nextInt() - 1;
        if (orderIndex >= 0 && orderIndex < names.length && names[orderIndex] != null) {
            if (states[orderIndex] == 1) {
                for (int j = orderIndex; j < names.length - 1; j++) {
                    names[j] = names[j + 1];
                    dishMegs[j] = dishMegs[j + 1];
                    times[j] = times[j + 1];
                    addresses[j] = addresses[j + 1];
                    states[j] = states[j + 1];
                    sumPrices[j] = sumPrices[j + 1];
                }
                names[names.length - 1] = null;
                dishMegs[dishMegs.length - 1] = null;
                times[times.length - 1] = 0;
                addresses[addresses.length - 1] = null;
                states[states.length - 1] = 0;
                sumPrices[sumPrices.length - 1] = 0;
                System.out.println("订单删除成功！");
            } else {
                System.out.println("订单未签收，无法删除！");
            }
        } else {
            System.out.println("无效的订单编号！");
        }
    }

    private static void likeDish(Scanner scanner) {
        System.out.println("菜品点赞");
        for (int i = 0; i < dishNames.length; i++) {
            System.out.println((i + 1) + ". " + dishNames[i] + " " + prices[i] + "元 " + likes[i] + "赞");
        }
        System.out.print("请选择要点赞的菜品编号：");
        int dishIndex = scanner.nextInt() - 1;
        if (dishIndex >= 0 && dishIndex < dishNames.length) {
            likes[dishIndex]++;
            System.out.println("点赞成功！");
        } else {
            System.out.println("无效的菜品编号！");
        }
    }
}

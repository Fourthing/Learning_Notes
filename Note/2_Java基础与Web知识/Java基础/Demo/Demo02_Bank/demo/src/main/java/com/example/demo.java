package com.example;

import java.io.*;
import java.util.*;

public class demo {
    private static final String USER_DATA_FILE = "userdata.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, Double> balances = new HashMap<>();

    public static void main(String[] args) {
        loadUserData();
        
        while (true) {
            System.out.println("1. 注册");
            System.out.println("2. 登录");
            System.out.println("3. 退出");
            System.out.print("选择一个选项: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // 读取换行符
            
            switch (option) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    saveUserData();
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    private static void register() {
        System.out.print("输入用户名 (3-20字符): ");
        String username = scanner.nextLine();
        
        if (username.length() < 3 || username.length() > 20 || users.containsKey(username)) {
            System.out.println("用户名无效或已存在，请重试。");
            return;
        }

        System.out.print("输入密码: ");
        String password1 = scanner.nextLine();
        System.out.print("再次输入密码: ");
        String password2 = scanner.nextLine();

        if (!password1.equals(password2)) {
            System.out.println("密码不匹配，请重试。");
            return;
        }

        // 将用户名和密码添加到用户表，将初始余额设为0
        users.put(username, password1);
        balances.put(username, 0.0);
        System.out.println("注册成功！");
    }

    private static void login() {
        System.out.print("输入用户名: ");
        String username = scanner.nextLine();
        System.out.print("输入密码: ");
        String password = scanner.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("用户名不存在。");
            return;
        }

        int attempts = 0;
        while (attempts < 3) {
            if (users.get(username).equals(password)) {
                System.out.println("登录成功！");
                userMenu(username);
                return;
            } else {
                attempts++;
                System.out.println("密码错误。");
                if (attempts < 3) {
                    System.out.print("请再试一次: ");
                    password = scanner.nextLine();
                }
            }
        }
        System.out.println("账户锁定。");
    }

    private static void userMenu(String username) {
        while (true) {
            System.out.println("1. 取款");
            System.out.println("2. 存款");
            System.out.println("3. 登出");
            System.out.print("选择一个选项: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // 读取换行符
            
            switch (option) {
                case 1:
                    withdraw(username);
                    break;
                case 2:
                    deposit(username);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    private static void withdraw(String username) {
        // System.out.println("选择取款方式:");
        // System.out.println("1. 银行卡");
        // System.out.println("2. 信用卡");
        // int method = scanner.nextInt();
        // scanner.nextLine(); // 读取换行符

        // System.out.print("输入取款金额: ");
        // double amount = scanner.nextDouble();
        // scanner.nextLine(); // 读取换行符

        // if (amount > balances.get(username)) {
        //     System.out.println("余额不足。");
        // } else {
        //     balances.put(username, balances.get(username) - amount);
        //     System.out.println("取款成功！新余额: " + balances.get(username));
        // }
        System.out.println("选择取款方式:");
        System.out.println("1. 银行卡");
        System.out.println("2. 信用卡");
        int method = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        System.out.print("输入取款金额: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // 读取换行符

        double currentBalance = balances.get(username);

        if (method == 1) { // 银行卡取款
            if (amount > currentBalance) {
                System.out.println("余额不足。");
            } else {
                balances.put(username, currentBalance - amount);
                System.out.println("取款成功！新余额: " + balances.get(username));
            }
        } else if (method == 2) { // 信用卡取款
            if (amount > currentBalance + 2000) { // 超过透支限额
                System.out.println("超出透支限额。");
            } else {
                balances.put(username, currentBalance - amount);
                System.out.println("取款成功！新余额: " + balances.get(username));
            }
        } else {
            System.out.println("无效的取款方式。");
        }
    }

    private static void deposit(String username) {
        System.out.print("输入存款金额（必须是整数）: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // 读取换行符

        if (amount != (int) amount) {
            System.out.println("金额无效。");
        } else {
            balances.put(username, balances.get(username) + amount);
            System.out.println("存款成功！新余额: " + balances.get(username));
        }
    }

    private static void loadUserData() {
        File file = new File(USER_DATA_FILE);
        if (!file.exists()) {
            System.out.println("用户数据文件不存在，创建新文件。");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("无法创建新文件：" + e.getMessage());
            }
            return;
        }
    
        System.out.println("加载用户数据文件：" + USER_DATA_FILE);
    
        try (BufferedReader br = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("读取到的数据行：" + line);
                String[] data = line.split(",");
                if (data.length != 3) {
                    System.out.println("数据格式错误：" + line);
                    continue;
                }
                users.put(data[0], data[1]);
                balances.put(data[0], Double.parseDouble(data[2]));
            }
        } catch (IOException e) {
            System.out.println("用户数据加载失败：" + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("余额格式错误：" + e.getMessage());
        }
    }

    private static void saveUserData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_DATA_FILE))) {
            for (String username : users.keySet()) {
                bw.write(username + "," + users.get(username) + "," + balances.get(username));
                bw.newLine();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("用户数据保存失败。");
        }
    }
}

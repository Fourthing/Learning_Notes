package com.niko.controller;

import com.niko.dao.ApplyInfoDao;
import com.niko.pojo.ApplyInfo;
import com.niko.dao.ApplyInfoDaoImpl;


import java.util.List;
import java.util.Scanner;

public class GameMgr {
    private static ApplyInfoDao applyInfoDao = new ApplyInfoDaoImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    queryByGame();
                    break;
                case 3:
                    queryByClass();
                    break;
                case 4:
                    cancelRegistration();
                    break;
                case 5:
                    System.out.println("谢谢使用！");
                    System.exit(0);
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("==== 学校运动会报名系统 ====");
        System.out.println("1. 学生报名");
        System.out.println("2. 按比赛项目查询");
        System.out.println("3. 按班级查询");
        System.out.println("4. 取消报名");
        System.out.println("5. 退出系统");
        System.out.print("请选择操作：");
    }

    private static void addStudent() throws Exception {
        System.out.print("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入学生年龄：");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("请输入班级号：");
        String className = scanner.nextLine();
        System.out.print("请输入报名项目编号：");
        String game = scanner.nextLine();
        ApplyInfo applyInfo = new ApplyInfo(name, age, className, game);
        applyInfoDao.addApplyInfo(applyInfo);
    }

    private static void queryByGame() throws Exception {
        System.out.print("请输入查询的比赛项目：");
        String game = scanner.nextLine();
        List<ApplyInfo> list = applyInfoDao.getApplyInfoByGame(game);
        if (list.isEmpty()) {
            System.out.println("未找到相关报名信息！");
        } else {
            System.out.println("项目名\t姓名  \t班级  \t年龄");
            for (ApplyInfo applyInfo : list) {
                System.out.printf("%s\t%s\t%s\t%d\n", applyInfo.getGame(), applyInfo.getName(), applyInfo.getClassName(), applyInfo.getAge());
            }
        }
    }

    private static void queryByClass() throws Exception {
        System.out.print("请输入查询的班级：");
        String className = scanner.nextLine();
        List<ApplyInfo> list = applyInfoDao.getApplyInfoByClass(className);
        if (list.isEmpty()) {
            System.out.println("未找到相关报名信息！");
        } else {
            System.out.println("项目名\t   姓名\t  班级\t  年龄");
            for (ApplyInfo applyInfo : list) {
                System.out.printf("%s %s\t%s\t%d\n", applyInfo.getGame(), applyInfo.getName(), applyInfo.getClassName(), applyInfo.getAge());
            }
        }
    }

    private static void cancelRegistration() throws Exception {
        System.out.print("请输入要取消报名的学生姓名：");
        String name = scanner.nextLine();
        applyInfoDao.deleteApplyInfoByName(name);
    }
}

package com.example;

import java.util.ArrayList;
import java.util.Scanner;

// 定义电脑类
class Computer {
    protected String name;
    protected String brand;
    protected String cpu;
    protected String memory;
    protected String hardDisk;
    protected String monitor;

    public Computer(String name, String brand, String cpu, String memory, String hardDisk, String monitor) {
        this.name = name;
        this.brand = brand;
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Computer [name=" + name + ", brand=" + brand + ", cpu=" + cpu + ", memory=" + memory 
                + ", hardDisk=" + hardDisk + ", monitor=" + monitor + "]";
    }
}

// 定义台式机类，继承自电脑类
class Desktop extends Computer {
    private String hostType;

    public Desktop(String name, String brand, String cpu, String memory, String hardDisk, String monitor, String hostType) {
        super(name, brand, cpu, memory, hardDisk, monitor);
        this.hostType = hostType;
    }

    @Override
    public String toString() {
        return "Desktop [hostType=" + hostType + ", " + super.toString() + "]";
    }
}

// 定义笔记本类，继承自电脑类
class Notebook extends Computer {
    private String battery;

    public Notebook(String name, String brand, String cpu, String memory, String hardDisk, String monitor, String battery) {
        super(name, brand, cpu, memory, hardDisk, monitor);
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Notebook [battery=" + battery + ", " + super.toString() + "]";
    }
}

// 主应用程序类
public class App {
    private static ArrayList<Computer> computers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addInitialComputers(); // 添加初始化的电脑信息
        while (true) {
            System.out.println("1. 查看电脑信息");
            System.out.println("2. 增加电脑信息");
            System.out.println("3. 删除电脑信息");
            System.out.println("4. 退出");
            System.out.print("请选择一个选项: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除缓冲区

            switch (choice) {
                case 1:
                    viewComputers();
                    break;
                case 2:
                    addComputer();
                    break;
                case 3:
                    deleteComputer();
                    break;
                case 4:
                    System.out.println("退出程序。");
                    return;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    private static void addInitialComputers() {
        computers.add(new Notebook("笔记本1", "华硕", "Intel i5", "8GB", "512GB SSD", "15.6 inch", "6芯"));
        computers.add(new Desktop("台式机1", "戴尔", "AMD Ryzen 7", "16GB", "1TB HDD", "27 inch", "立式"));
        computers.add(new Notebook("笔记本2", "联想", "Intel i7", "16GB", "1TB SSD", "14 inch", "9芯"));
        computers.add(new Desktop("台式机2", "惠普", "Intel i9", "32GB", "2TB SSD", "32 inch", "卧式"));
        computers.add(new Desktop("删除测试用", "惠普", "Intel i9", "32GB", "2TB SSD", "32 inch", "卧式"));
    }

    private static void viewComputers() {
        if (computers.isEmpty()) {
            System.out.println("没有电脑信息。");
        } else {
            for (int i = 0; i < computers.size(); i++) {
                System.out.println("NO."+(i + 1) + "  " + computers.get(i));
                
            }
            String newLine = System.lineSeparator();

        }
    }

    private static void addComputer() {
        System.out.print("请输入电脑名称: ");
        String name = scanner.nextLine();
        System.out.print("请输入品牌: ");
        String brand = scanner.nextLine();
        System.out.print("请输入CPU: ");
        String cpu = scanner.nextLine();
        System.out.print("请输入内存: ");
        String memory = scanner.nextLine();
        System.out.print("请输入硬盘: ");
        String hardDisk = scanner.nextLine();
        System.out.print("请输入显示器: ");
        String monitor = scanner.nextLine();

        System.out.println("请选择电脑类型:");
        System.out.println("1. 笔记本");
        System.out.println("2. 台式机");
        int type = scanner.nextInt();
        scanner.nextLine(); // 清除缓冲区

        switch (type) {
            case 1:
                System.out.print("请输入电池（9芯或6芯）: ");
                String battery = scanner.nextLine();
                computers.add(new Notebook(name, brand, cpu, memory, hardDisk, monitor, battery));
                break;
            case 2:
                System.out.print("请输入机箱类型（卧式或立式）: ");
                String hostType = scanner.nextLine();
                computers.add(new Desktop(name, brand, cpu, memory, hardDisk, monitor, hostType));
                break;
            default:
                System.out.println("无效选项，添加电脑失败。");
        }
    }

    private static void deleteComputer() {
        System.out.print("请输入要删除的电脑序号: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // 清除缓冲区

        if (index > 0 && index <= computers.size()) {
            computers.remove(index - 1);
            System.out.println("删除成功。");
        } else {
            System.out.println("无效序号，删除失败。");
        }
    }
}

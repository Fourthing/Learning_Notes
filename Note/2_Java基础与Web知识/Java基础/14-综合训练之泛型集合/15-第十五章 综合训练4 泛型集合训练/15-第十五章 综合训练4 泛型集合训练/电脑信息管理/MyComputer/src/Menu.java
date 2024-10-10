import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * 菜单栏
 */
public class Menu {
    public static void show() throws IOException {
        ComputerManager computerManager = new ComputerManager();
        computerManager.initComputer();
        menu();
        boolean flag = true;
        while (flag) {
            Scanner input = new Scanner(System.in);
            String option = input.next();
            switch (option) {
                case "1" :
                    listComputers(computerManager);
                    break;
                case "2" :
                    viewDetail(input, computerManager);
                    break;
                case "3" :
                    deleteByName(input, computerManager);
                    break;
                case "4" :
                    updatePrice(input, computerManager);
                    break;
                case "5" :
                    printComputerInfo(input, computerManager);
                    break;
                case "6" :
                    addComputer(input, computerManager);
                    break;
                case "0" :
                    computerManager.exit();
                    flag = false;
                    break;
            }
        }
    }

    /**
     * 查看电脑列表
     * @param computerManager 电脑管理
     */
    public static void listComputers(ComputerManager computerManager) {
        System.out.println("-----查看电脑列表-----");
        Map<String, Computer> map  = computerManager.getComputerMap();
        for (Map.Entry<String, Computer> computerEntry : map.entrySet()) {
            System.out.println("电脑名称: " + computerEntry.getValue().getName());
        }
        menu();
    }

    /**
     * 按名称查看电脑详情
     * @param input 接收键盘输入
     * @param computerManager 电脑管理
     */
    public static void viewDetail(Scanner input, ComputerManager computerManager) {
        System.out.println("-----查看指定电脑信息-----");
        System.out.print("请输入需要查询的电脑名称: \t");
        computerManager.viewDetail(input.next());
        menu();
    }

    /**
     * 按名称删除电脑
     * @param input 接收键盘输入
     * @param computerManager 电脑管理
     */
    public static void deleteByName(Scanner input, ComputerManager computerManager) {
        System.out.println("-----删除指定电脑-----");
        System.out.print("请输入需要删除的电脑名称: \t");
        computerManager.deleteByName(input.next());
        System.out.println("-----电脑列表-----");
        Map<String, Computer> map  = computerManager.getComputerMap();
        for (Map.Entry<String, Computer> computerEntry : map.entrySet()) {
            System.out.println("电脑名称: " + computerEntry.getValue().getName());
        }
        menu();
    }

    /**
     * 修改电脑价格
     * @param input 接收键盘输入
     * @param computerManager 电脑管理
     */
    public static void updatePrice(Scanner input, ComputerManager computerManager) {
        System.out.println("-----修改制定电脑售价-----");
        System.out.print("请输入需要修改的电脑名称: \t");
        String computerName = input.next();
        System.out.print("请输入需要修改的电脑价格: \t");
        double price = input.nextDouble();
        computerManager.updatePrice(computerName, price);
        menu();
    }

    /**
     * 打印电脑信息
     * @param input 接收键盘输入
     * @param computerManager 电脑管理
     */
    public static void printComputerInfo(Scanner input, ComputerManager computerManager) throws IOException {
        System.out.println("-----打印电脑信息-----");
        System.out.print("请输入需要打印信息的电脑名称: \t");
        computerManager.printComputerInfo(input.next());
        menu();
    }

    /**
     * 添加电脑操作
     * @param input 接收键盘输入
     * @param computerManager 电脑管理
     */
    public static void addComputer(Scanner input, ComputerManager computerManager) {
        System.out.println("-----添加新电脑-----");
        System.out.print("请输入需要添加的电脑类型: 1: 台式机 2:笔记本 :\t");
        int computerType = input.nextInt();
        if (computerType == 1) {
            Desktop desktop = new Desktop();
            System.out.print("请输入电脑名称: \t");
            desktop.setName(input.next());
            System.out.print("请输入电脑品牌: \t");
            desktop.setBrand(input.next());
            System.out.print("请输入CPU信息: \t");
            desktop.setCpu(input.next());
            System.out.print("请输入内存信息: \t");
            desktop.setMemory(input.next());
            System.out.print("请输入硬盘信息: \t");
            desktop.setHardDisk(input.next());
            System.out.print("请输入显示器信息: \t");
            desktop.setMonitor(input.next());
            System.out.print("请输入售价: \t");
            desktop.setPrice(input.nextDouble());
            System.out.print("请输入机箱类型: \t");
            desktop.setHostType(input.next());
            computerManager.addComputer(desktop);
            menu();
        }
        if (computerType == 2) {
            Notebook notebook = new Notebook();
            System.out.print("请输入电脑名称: \t");
            notebook.setName(input.next());
            System.out.print("请输入电脑品牌: \t");
            notebook.setBrand(input.next());
            System.out.print("请输入CPU信息: \t");
            notebook.setCpu(input.next());
            System.out.print("请输入内存信息: \t");
            notebook.setMemory(input.next());
            System.out.print("请输入硬盘信息: \t");
            notebook.setHardDisk(input.next());
            System.out.print("请输入显示器信息: \t");
            notebook.setMonitor(input.next());
            System.out.print("请输入售价: \t");
            notebook.setPrice(input.nextDouble());
            System.out.print("请输入电池信息: \t");
            notebook.setBattery(input.next());
            computerManager.addComputer(notebook);
            menu();
        }
    }

    public static void menu() {
        System.out.println("----------主菜单---------");
        System.out.println("1: \t 查看电脑列表");
        System.out.println("2: \t 查看指定电脑信息");
        System.out.println("3: \t 删除指定电脑");
        System.out.println("4: \t 修改制定电脑售价");
        System.out.println("5: \t 打印指定电脑信息");
        System.out.println("6: \t 添加新电脑");
        System.out.println("0: \t 退出");
        System.out.println("----------主菜单---------");
        System.out.print("请输入命令编号: \t");
    }

}

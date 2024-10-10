import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 程序逻辑处理模块
 */
public class ComputerManager {

    private Map<String, Computer> computerMap = null;

    public Map<String, Computer> getComputerMap() {
        return computerMap;
    }

    /**
     * 初始化数据信息
     */
    public void initComputer() {
        computerMap = new HashMap<>();
        // 创建笔记本对象
        Notebook apple = new Notebook("MacbookPro", "Apple", "Turbo Boost", "8GB", "512GB", "16.0英寸", "7850mAh", 16699.00);
        Notebook huawei = new Notebook("MateBookXPro", "Huawei", "酷睿", "8GB", "512GB", "14.0英寸", "6850mAh", 8699.99);
        // 创建台式机对象
        Desktop dell = new Desktop("Dell", "戴尔", "9代8核", "16GB", "1TB", "27.8英寸", "集成机箱", 8899.99);
        Desktop lenovo = new Desktop("Lenovo", "联想", "9代8核", "8GB", "1TB", "23.8英寸", "立式机箱", 4999.99);

        // 将笔记本与台式机对象存入 Map 中
        computerMap.put(apple.getName(), apple);
        computerMap.put(huawei.getName(), huawei);
        computerMap.put(dell.getName(), dell);
        computerMap.put(lenovo.getName(), lenovo);
    }

    /**
     * 查看电脑信息
     * @param computerName 需要查看的电脑型号
     */
    public void viewDetail(String computerName) {
        // 根据电脑名称 获取需要查看的电脑对象
        Computer computer = computerMap.get(computerName);
        if (computer != null) {
            // 设置两种电脑的公共内容
            System.out.println("------------------------");
            System.out.println("电脑名称: \t" + computer.getName());
            System.out.println("电脑品牌: \t" + computer.getBrand());
            System.out.println("电脑CPU: \t" + computer.getCpu());
            System.out.println("电脑内存: \t" + computer.getMemory());
            System.out.println("电脑硬盘: \t" + computer.getHardDisk());
            System.out.println("电脑显示器: \t" + computer.getMonitor());
            System.out.println("电脑售价: \t" + computer.getPrice() + "元");

            // 如果该对象是 Notebook 的一个实例 (instance) 的话 增加电池信息
            if (computer instanceof Notebook) {
                Notebook notebook = (Notebook) computer;
                System.out.println("电池信息: \t" + notebook.getBattery());
            }

            // 如果该对象是 Desktop 的一个实例 (instance) 的话 增加机箱信息
            if (computer instanceof Desktop) {
                Desktop desktop = (Desktop) computer;
                System.out.println("机箱类型: \t" + desktop.getHostType());
            }
        } else {
            System.out.println("所要查询的电脑不存在");
        }
    }

    /**
     * 根据电脑名称修改电脑售价
     * @param computerName 电脑名称
     * @param price 电脑售价
     */
    public void updatePrice(String computerName, double price) {
        Computer computer = computerMap.get(computerName);
        if (computer != null) {
            computer.setPrice(price);
            System.out.println("修改价格成功");
        } else {
            System.out.println("所要修改的电脑不存在");
        }
    }

    /**
     * 按电脑名称删除电脑
     * @param computerName 电脑名称
     */
    public void deleteByName(String computerName) {
        Computer computer = computerMap.get(computerName);
        if (computer != null) {
            computerMap.remove(computerName);
            System.out.println("删除任务已完成...");
        } else {
            System.out.println("所要删除的电脑不存在");
        }
    }

    public void addComputer(Computer computer) {
        computerMap.put(computer.getName(), computer);
        System.out.println("添加成功.");
    }

    /**
     * 打印电脑信息
     * @param computerName 需要打印的电脑型号
     */
    public void printComputerInfo(String computerName) throws IOException {
        // 根据电脑名称 获取需要查看的电脑对象
        Computer computer = computerMap.get(computerName);

        if (computer != null) {
            if (computer instanceof Notebook) {
                Notebook notebook = (Notebook) computer;
                notebook.print(notebook);
            }

            if (computer instanceof Desktop) {
                Desktop desktop = (Desktop) computer;
                desktop.print(desktop);
            }
        } else {
            System.out.println("所要打印的电脑信息不存在");
        }
    }

    /**
     * 退出
     */
    public void exit() throws IOException {
        System.out.println("系统已退出...");
    }

}

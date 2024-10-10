import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 笔记本电脑类 继承了 Computer 基类 实现了 IPrintable 接口
 */
public class Notebook extends Computer implements IPrintable {

    // 电池信息
    private String battery;

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public Notebook() {}

    public Notebook(String name, String brand, String cpu, String memory, String hardDisk, String monitor, String battery, double price) {
        super(name, brand, cpu, memory, hardDisk, monitor, price);
        this.battery = battery;
    }

    @Override
    public void print(Computer computer) throws IOException {
        System.out.println("正在打印笔记本信息...");
        File file = new File("./NBInfo-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("-----笔记本信息-----\r\n");
        out.write("电脑名称: \t" + computer.getName() + "\r\n");
        out.write("电脑品牌: \t" + computer.getBrand() + "\r\n");
        out.write("电脑CPU: \t" + computer.getCpu() + "\r\n");
        out.write("电脑内存: \t" + computer.getMemory() + "\r\n");
        out.write("电脑硬盘: \t" + computer.getHardDisk() + "\r\n");
        out.write("电脑显示器: \t" + computer.getMonitor() + "\r\n");
        out.write("电脑售价: \t" + computer.getPrice() + "元\r\n");
        out.write("电池信息: \t" + this.getBattery());
        // 刷新并关闭文件流
        out.flush();
        out.close();
        System.out.println("打印笔记本信息已完成.");
    }

}

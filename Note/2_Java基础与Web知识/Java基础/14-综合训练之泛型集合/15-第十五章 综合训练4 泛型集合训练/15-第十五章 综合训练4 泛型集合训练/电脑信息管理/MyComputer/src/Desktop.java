import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 台式机电脑类 继承了 Computer 基类 实现了 IPrintable 接口
 */
public class Desktop extends Computer implements IPrintable {

    // 机箱类型
    private String hostType;

    public String getHostType() {
        return hostType;
    }

    public void setHostType(String hostType) {
        this.hostType = hostType;
    }

    public Desktop() {}

    public Desktop(String name, String brand, String cpu, String memory, String hardDisk, String monitor, String hostType, double price) {
        super(name, brand, cpu, memory, hardDisk, monitor, price);
        this.hostType = hostType;
    }

    @Override
    public void print(Computer computer) throws IOException {
        System.out.println("正在打印台式机信息...");
        File file = new File("./DIInfo-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("-----台式机信息-----\r\n");
        out.write("电脑名称: \t" + computer.getName() + "\r\n");
        out.write("电脑品牌: \t" + computer.getBrand() + "\r\n");
        out.write("电脑CPU: \t" + computer.getCpu() + "\r\n");
        out.write("电脑内存: \t" + computer.getMemory() + "\r\n");
        out.write("电脑硬盘: \t" + computer.getHardDisk() + "\r\n");
        out.write("电脑显示器: \t" + computer.getMonitor() + "\r\n");
        out.write("电脑售价: \t" + computer.getPrice() + "元\r\n");
        out.write("机箱类型: \t" + this.getHostType());
        // 刷新并关闭文件流
        out.flush();
        out.close();
        System.out.println("打印台式机信息已完成.");
    }

}

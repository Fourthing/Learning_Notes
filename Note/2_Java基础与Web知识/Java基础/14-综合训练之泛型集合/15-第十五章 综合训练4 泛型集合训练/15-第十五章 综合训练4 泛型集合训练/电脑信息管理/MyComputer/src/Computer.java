/**
 * Computer 基类
 */
public class Computer {

    // 电脑名称
    private String name;

    // 电脑品牌
    private String brand;

    // CPU 信息
    private String cpu;

    // 内存信息
    private String memory;

    // 硬盘信息
    private String hardDisk;

    // 显示器信息
    private String monitor;

    // 电脑售价
    private double price;

    /**
     * 无惨的构造方法
     */
    public Computer() {}

    /**
     * 全参的构造方法
     */
    public Computer(String name, String brand, String cpu, String memory, String hardDisk, String monitor, double price) {
        this.name = name;
        this.brand = brand;
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

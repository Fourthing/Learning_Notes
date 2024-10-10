package org.example;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

// 电视机接口
interface TV {
    void play();
}

// 具体产品 - 海信电视
class HisenseTV implements TV {
    @Override
    public void play() {
        System.out.println("Playing on Hisense TV.");
    }
}

// 具体产品 - 三星电视
class SamsungTV implements TV {
    @Override
    public void play() {
        System.out.println("Playing on Samsung TV.");
    }
}

// 遥控器接口
interface Remote {
    void control();
}

// 具体产品 - 海信遥控器
class HisenseRemote implements Remote {
    @Override
    public void control() {
        System.out.println("Controlling with Hisense Remote.");
    }
}

// 具体产品 - 三星遥控器
class SamsungRemote implements Remote {
    @Override
    public void control() {
        System.out.println("Controlling with Samsung Remote.");
    }
}

// 抽象工厂接口 - 定义创建电视和遥控器的接口
interface ElectronicsFactory {
    TV createTV();
    Remote createRemote();
}

// 具体工厂 - 海信电子产品工厂
class HisenseFactory implements ElectronicsFactory {
    @Override
    public TV createTV() {
        return new HisenseTV();
    }

    @Override
    public Remote createRemote() {
        return new HisenseRemote();
    }
}

// 具体工厂 - 三星电子产品工厂
class SamsungFactory implements ElectronicsFactory {
    @Override
    public TV createTV() {
        return new SamsungTV();
    }

    @Override
    public Remote createRemote() {
        return new SamsungRemote();
    }
}

// 测试类
public class Demo05_AbstractFactory {
    public static void main(String[] args) {
        // 创建海信电子产品工厂
        ElectronicsFactory hisenseFactory = new HisenseFactory();
        TV hisenseTV = hisenseFactory.createTV();
        Remote hisenseRemote = hisenseFactory.createRemote();
        hisenseTV.play();  // 输出: Playing on Hisense TV.
        hisenseRemote.control();  // 输出: Controlling with Hisense Remote.

        // 创建三星电子产品工厂
        ElectronicsFactory samsungFactory = new SamsungFactory();
        TV samsungTV = samsungFactory.createTV();
        Remote samsungRemote = samsungFactory.createRemote();
        samsungTV.play();  // 输出: Playing on Samsung TV.
        samsungRemote.control();  // 输出: Controlling with Samsung Remote.
    }
}

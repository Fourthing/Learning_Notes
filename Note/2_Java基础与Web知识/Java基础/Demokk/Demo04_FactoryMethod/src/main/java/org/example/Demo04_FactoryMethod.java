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

// 抽象工厂接口 - 定义创建电视的接口
abstract class TVFactory {
    // 工厂方法 - 动态创建电视对象
    public abstract TV createTV();

    // 使用反射机制创建具体产品
    protected TV createTVByClassName(String className) {
        try {
            // 通过反射创建对应类的实例
            Class<?> clazz = Class.forName(className);
            return (TV) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown TV class: " + className, e);
        }
    }
}

// 具体工厂 - 海信电视工厂
class HisenseTVFactory extends TVFactory {
    @Override
    public TV createTV() {
        return createTVByClassName("HisenseTV");
    }
}

// 具体工厂 - 三星电视工厂
class SamsungTVFactory extends TVFactory {
    @Override
    public TV createTV() {
        return createTVByClassName("SamsungTV");
    }
}

// 测试类
public class Demo04_FactoryMethod {
    public static void main(String[] args) {
        // 使用反射机制创建海信电视工厂
        TVFactory hisenseFactory = new HisenseTVFactory();
        TV hisenseTV = hisenseFactory.createTV();
        hisenseTV.play();  // 输出: Playing on Hisense TV.

        // 使用反射机制创建三星电视工厂
        TVFactory samsungFactory = new SamsungTVFactory();
        TV samsungTV = samsungFactory.createTV();
        samsungTV.play();  // 输出: Playing on Samsung TV.
    }
}

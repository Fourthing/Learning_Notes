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

// 工厂类 - 负责创建不同品牌的电视
class TVFactory {
    // 根据传入的电视机品牌创建对应的电视对象
    public static TV createTV(String type) {
        if (type.equalsIgnoreCase("Hisense")) {
            return new HisenseTV();
        } else if (type.equalsIgnoreCase("Samsung")) {
            return new SamsungTV();
        }
        throw new IllegalArgumentException("Unknown TV type: " + type);
    }
}

// 测试类
public class SimpleTVFactoryExample {
    public static void main(String[] args) {
        // 创建海信电视
        TV hisenseTV = TVFactory.createTV("Hisense");
        hisenseTV.play();  // 输出: Playing on Hisense TV.

        // 创建三星电视
        TV samsungTV = TVFactory.createTV("Samsung");
        samsungTV.play();  // 输出: Playing on Samsung TV.
    }
}

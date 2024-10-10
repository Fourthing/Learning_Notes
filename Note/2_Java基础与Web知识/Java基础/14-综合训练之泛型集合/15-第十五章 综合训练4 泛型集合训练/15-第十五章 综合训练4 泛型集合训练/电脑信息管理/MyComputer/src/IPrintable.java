import java.io.IOException;

/**
 * 打印接口
 */
public interface IPrintable {
    // 接口中的方法默认都是 public 所以可以省略
    void print(Computer computer) throws IOException;
}

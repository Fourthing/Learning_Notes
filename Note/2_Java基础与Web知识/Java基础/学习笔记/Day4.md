## Day4  

### 2024年9月9日15:38:20

#### 一、java文件名和类名一致性问题

首先明确，不是必须一致。若一个类是公共`（public）`的，则应该在一个同名的java文件中声明。反之default类型的类声明则可以成功通过编译，编译后的`.class`文件和所声明的类名一致。

```java
public class Demo01_HelloWorld{
    public static void main(String args[]){
    	System.out.println("H R!");
	}
}
```

若有多个class声明，则会生成对应的多个`.class`文件，但不建议这么写，实际开发为了保证规范性，一个java文件写一个class。main方法写在带public类的java文件中。

#### 二、java关键字

下面列出了 Java 关键字。这些保留字不能用于常量、变量、和任何标识符的名称。

| 类别                 | 关键字       | 说明                           |
| :------------------- | :----------- | :----------------------------- |
| 访问控制             | private      | 私有的                         |
|                      | protected    | 受保护的                       |
|                      | public       | 公共的                         |
|                      | default      | 默认                           |
| 类、方法和变量修饰符 | abstract     | 声明抽象                       |
|                      | class        | 类                             |
|                      | extends      | 扩充、继承                     |
|                      | final        | 最终值、不可改变的             |
|                      | implements   | 实现（接口）                   |
|                      | interface    | 接口                           |
|                      | native       | 本地、原生方法（非 Java 实现） |
|                      | new          | 创建                           |
|                      | static       | 静态                           |
|                      | strictfp     | 严格浮点、精准浮点             |
|                      | synchronized | 线程、同步                     |
|                      | transient    | 短暂                           |
|                      | volatile     | 易失                           |
| 程序控制语句         | break        | 跳出循环                       |
|                      | case         | 定义一个值以供 switch 选择     |
|                      | continue     | 继续                           |
|                      | do           | 运行                           |
|                      | else         | 否则                           |
|                      | for          | 循环                           |
|                      | if           | 如果                           |
|                      | instanceof   | 实例                           |
|                      | return       | 返回                           |
|                      | switch       | 根据值选择执行                 |
|                      | while        | 循环                           |
| 错误处理             | assert       | 断言表达式是否为真             |
|                      | catch        | 捕捉异常                       |
|                      | finally      | 有没有异常都执行               |
|                      | throw        | 抛出一个异常对象               |
|                      | throws       | 声明一个异常可能被抛出         |
|                      | try          | 捕获异常                       |
| 包相关               | import       | 引入                           |
|                      | package      | 包                             |
| 基本类型             | boolean      | 布尔型                         |
|                      | byte         | 字节型                         |
|                      | char         | 字符型                         |
|                      | double       | 双精度浮点                     |
|                      | float        | 单精度浮点                     |
|                      | int          | 整型                           |
|                      | long         | 长整型                         |
|                      | short        | 短整型                         |
| 变量引用             | super        | 父类、超类                     |
|                      | this         | 本类                           |
|                      | void         | 无返回值                       |
| 保留关键字           | goto         | 是关键字，但不能使用           |
|                      | const        | 是关键字，但不能使用           |

**注意：**Java 的 null 不是关键字，类似于 true 和 false，它是一个字面常量，不允许作为标识符使用。

#### 三、常量与变量

![image-20240910104132902](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409101041021.png)




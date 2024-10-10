## Day1

### 2024年6月30日14:07:36

### 一、Java的主要特性

![1719730535712](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409151537986.png)

- **Java 语言是简单的：**

  Java 丢弃了 C++ 中很少使用的、很难理解的、令人迷惑的那些特性，如操作符重载、多继承、自动的强制类型转换。特别地，**Java 语言不使用指针，而是引用**。并提供了自动分配和回收内存空间，使得程序员不必为内存管理而担忧。

- **Java 语言是面向对象的：**

  Java 语言提供类、接口和继承等面向对象的特性，为了简单起见，只支持**类之间的单继承**，但支持**接口之间的多继承**，并支持**类与接口之间的实现机制（关键字为 implements）**。Java 语言全面支持动态绑定，而 C++语言只对虚函数使用动态绑定。总之，Java语言是一个纯的面向对象程序设计语言。

- **Java语言是分布式的：**

  Java 语言支持 Internet 应用的开发，在基本的 Java 应用编程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类库，包括 URL、URLConnection、Socket、ServerSocket 等。Java 的 RMI（远程方法激活）机制也是开发分布式应用的重要手段。

- **Java 语言是健壮的：**

  Java 的强类型机制、异常处理、垃圾的自动收集等是 Java 程序健壮性的重要保证。对指针的丢弃是 Java 的明智选择。Java 的安全检查机制使得 Java 更具健壮性。

- **Java语言是安全的：**

  Java通常被用在网络环境中，为此，Java 提供了一个安全机制以防恶意代码的攻击。除了Java 语言具有的许多安全特性以外，Java 对通过网络下载的类具有一个安全防范机制（类 ClassLoader），如分配不同的名字空间以防替代本地的同名类、字节代码检查，并提供安全管理机制（类 SecurityManager）让 Java 应用设置安全哨兵。

- **Java 语言是可移植的：**

  这种可移植性来源于体系结构中立性，另外，Java 还严格规定了各个基本数据类型的长度。Java 系统本身也具有很强的可移植性，Java 编译器是用 Java 实现的，Java 的运行环境是用 ANSI C 实现的。

- **Java 语言是解释型的：**

  如前所述，Java 程序在 Java 平台上被编译为字节码格式，然后可以在实现这个 Java 平台的任何系统中运行。在运行时，Java 平台中的 Java 解释器对这些字节码进行解释执行，执行过程中需要的类在联接阶段被载入到运行环境中。

- **Java 是高性能的：**

  与那些解释型的高级脚本语言相比，Java 的确是高性能的。事实上，Java 的运行速度随着 JIT(Just-In-Time）编译器技术的发展越来越接近于 C++。

- **Java 语言是多线程的：**

  在 Java 语言中，线程是一种特殊的对象，它必须由 Thread 类或其子（孙）类来创建。通常有两种方法来创建线程：其一，使用型构为 Thread(Runnable) 的构造子类将一个实现了 Runnable 接口的对象包装成一个线程，其二，从 Thread 类派生出子类并重写 run 方法，使用该子类创建的对象即为线程。值得注意的是 Thread 类已经实现了 Runnable 接口，因此，任何一个线程均有它的 run 方法，而 run 方法中包含了线程所要运行的代码。线程的活动由一组方法来控制。Java 语言支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为 synchronized）。

- **Java 语言是动态的：**

  Java 语言的设计目标之一是适应于动态变化的环境。Java 程序需要的类能够动态地被载入到运行环境，也可以通过网络来载入所需要的类。这也有利于软件的升级。另外，Java 中的类有一个运行时刻的表示，能进行运行时刻的类型检查。

### 二、Java 基础语法

一个 Java 程序可以认为是一系列对象的集合，而这些对象通过调用彼此的方法来协同工作。下面简要介绍下类、对象、方法和实例变量的概念。

- **对象**：对象是类的一个实例，有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。
- **类**：类是一个模板，它描述一类对象的行为和状态。
- **方法**：方法就是行为，一个类可以有很多方法。逻辑运算、数据修改以及所有动作都是在方法中完成的。
- **实例变量**：每个对象都有独特的实例变量，对象的状态由这些实例变量的值决定。

------

#### 第一个Java程序

主要分三步：**编写（可以在记事本里运行）、编译（javac）、运行（java）**

![1719734733688](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409151537637.png)

下面看一个简单的 Java 程序，它将输出字符串 *Hello World*

```java
public class HelloWorld {
    public static void main(String[] args) {   		     	System.out.println("Hello World"); 
	}
}
```

![img](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409151537240.jpeg)

下面将逐步介绍如何保存、编译以及运行这个程序：

- 打开代码编辑器，把上面的代码添加进去；
- 把文件名保存为：HelloWorld.java；
- 打开 cmd 命令窗口，进入目标文件所在的位置，假设是 C:\
- 在命令行窗口输入 **javac HelloWorld.java** 按下回车键编译代码。如果代码没有错误，cmd 命令提示符会进入下一行（假设环境变量都设置好了）。
- 再键输入 **java HelloWorld** 按下回车键就可以运行程序了

你将会在窗口看到 Hello World

```
$ javac HelloWorld.java
$ java HelloWorld 
Hello World
```

如果遇到编码问题，我们可以使用 **-encoding** 选项设置 **utf-8** 来编译：

```
javac -encoding UTF-8 HelloWorld.java 
java HelloWorld 
```

------

#### 基本语法

编写 Java 程序时，应注意以下几点：

- **大小写敏感**：Java 是大小写敏感的，这就意味着标识符 Hello 与 hello 是不同的。
- **类名**：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 **MyFirstJavaClass** 。
- **方法名**：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
- **源文件名**：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存（切记 Java 是大小写敏感的），文件名的后缀为 **.java**。（如果文件名和类名不相同则会导致编译错误）。
- **主方法入口**：所有的 Java 程序由 **public static void main(String[] args)** 方法开始执行。

------

#### Java 标识符

Java 所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。

关于 Java 标识符，有以下几点需要注意：

- 所有的标识符都应该以字母（A-Z 或者 a-z）,美元符（$）、或者下划线（_）开始
- 首字符之后可以是字母（A-Z 或者 a-z）,美元符（$）、下划线（_）或数字的任何字符组合
- 关键字不能用作标识符
- 标识符是大小写敏感的
- 合法标识符举例：age、$salary、_value、__1_value
- 非法标识符举例：123abc、-salary

------

#### Java修饰符

像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：

- 访问控制修饰符 : default, public , protected, private
- 非访问控制修饰符 : final, abstract, static, synchronized

在后面的章节中我们会深入讨论 Java 修饰符。

------

#### Java 变量

Java 中主要有如下几种类型的变量

- 局部变量
- 类变量（静态变量）
- 成员变量（非静态变量）

------

#### Java 数组

数组是储存在堆上的对象，可以保存多个同类型变量。在后面的章节中，我们将会学到如何声明、构造以及初始化一个数组。

------

#### Java 枚举

Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的 bug。

例如，我们为果汁店设计一个程序，它将限制果汁为小杯、中杯、大杯。这就意味着它不允许顾客点除了这三种尺寸外的果汁。

##### 实例

```java
class FreshJuice {    
    enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }   
    FreshJuiceSize size; 
}   
public class FreshJuiceTest {    
	public static void main(String[] args){   				
		FreshJuice juice = new FreshJuice();      			 
			juice.size = FreshJuice.FreshJuiceSize.MEDIUM;    
    } 
}
```



**注意：**枚举可以单独声明或者声明在类里面。方法、变量、构造函数也可以在枚举中定义。

------

#### Java 关键字

下面列出了 Java 关键字。这些保留字不能用于常量、变量、和任何标识符的名称。

| 类别                 | 关键字                         | 说明                 |
| -------------------- | ------------------------------ | -------------------- |
| 访问控制             | private                        | 私有的               |
| protected            | 受保护的                       |                      |
| public               | 公共的                         |                      |
| default              | 默认                           |                      |
| 类、方法和变量修饰符 | abstract                       | 声明抽象             |
| class                | 类                             |                      |
| extends              | 扩充、继承                     |                      |
| final                | 最终值、不可改变的             |                      |
| implements           | 实现（接口）                   |                      |
| interface            | 接口                           |                      |
| native               | 本地、原生方法（非 Java 实现） |                      |
| new                  | 创建                           |                      |
| static               | 静态                           |                      |
| strictfp             | 严格浮点、精准浮点             |                      |
| synchronized         | 线程、同步                     |                      |
| transient            | 短暂                           |                      |
| volatile             | 易失                           |                      |
| 程序控制语句         | break                          | 跳出循环             |
| case                 | 定义一个值以供 switch 选择     |                      |
| continue             | 继续                           |                      |
| do                   | 运行                           |                      |
| else                 | 否则                           |                      |
| for                  | 循环                           |                      |
| if                   | 如果                           |                      |
| instanceof           | 实例                           |                      |
| return               | 返回                           |                      |
| switch               | 根据值选择执行                 |                      |
| while                | 循环                           |                      |
| 错误处理             | assert                         | 断言表达式是否为真   |
| catch                | 捕捉异常                       |                      |
| finally              | 有没有异常都执行               |                      |
| throw                | 抛出一个异常对象               |                      |
| throws               | 声明一个异常可能被抛出         |                      |
| try                  | 捕获异常                       |                      |
| 包相关               | import                         | 引入                 |
| package              | 包                             |                      |
| 基本类型             | boolean                        | 布尔型               |
| byte                 | 字节型                         |                      |
| char                 | 字符型                         |                      |
| double               | 双精度浮点                     |                      |
| float                | 单精度浮点                     |                      |
| int                  | 整型                           |                      |
| long                 | 长整型                         |                      |
| short                | 短整型                         |                      |
| 变量引用             | super                          | 父类、超类           |
| this                 | 本类                           |                      |
| void                 | 无返回值                       |                      |
| 保留关键字           | goto                           | 是关键字，但不能使用 |
| const                | 是关键字，但不能使用           |                      |

**注意：**Java 的 null 不是关键字，类似于 true 和 false，它是一个字面常量，不允许作为标识符使用。

------

#### Java注释

有三种注释：单行注释、多行注释、文档注释

- 单行注释 

  ```JAVA
  //单行注释
  ```

- 多行注释

  ```java
  /*
  	这是一段多行注释
  */
  ```

- 文档注释

  文档注释中的内容可以根据javadoc命令生成一个文档（API文档），这样子别人就可以根据文档来快速对写好的类以及类中的功能进行了解。

  命令写法：`javadoc -d 要生成的文件夹名字 -author -version 文件名.java`

  ![1719737940155](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1719737940155.png)

  打开index.html，如下，这是根据所编写代码里的文档注释生成的文档。要注意注释内容要写在注释对象的前面！![1719738513751](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1719738513751.png)

  ![1719738416935](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1719738416935.png)

  ```java
  /**
  	这是一段文档注释
  */
  ```

------

#### Java 空行

空白行或者有注释的行，Java 编译器都会忽略掉。

------

#### 继承

在 Java 中，一个类可以由其他类派生。如果你要创建一个类，而且已经存在一个类具有你所需要的属性或方法，那么你可以将新创建的类继承该类。

利用继承的方法，可以重用已存在类的方法和属性，而不用重写这些代码。被继承的类称为超类（super class），派生类称为子类（sub class）。

------

#### 接口

在 Java 中，接口可理解为对象间相互通信的协议。接口在继承中扮演着很重要的角色。

接口只定义派生要用到的方法，但是方法的具体实现完全取决于派生类。

------

#### Java 源程序与编译型运行区别

如下图所示：

![img](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409151537740.png)

### 三、一些基础知识

![1719734463046](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409151537899.png)

#### JVM 

即（Java Virtual Machine） Java虚拟机。实现了“一次编写，到处运行”，Java虚拟机相当于就是出国的翻译官，是一个虚构出来的计算机。与硬件平台不同，是一个虚构出来的软件平台，能模拟硬件平台的各个功能。JVM认的是.class文件。

#### JRE

即（Java Runtime Environment ）Java 运行环境。**JRE包含了JVM和一些标准的核心类库**，有了JRE就能运行Java程序了。

#### JDK

即（Java Development Kit）Java开发工具包。JDK包含了**JRE和很多工具**，如：

- javac 编译工具
- java 运行工具
- jdb 调试工具
- jhat 内存分析工具

有了JDK就能开发软件了。

> 从JDK9之后JDK目录就没有单独的JRE目录了，开始使用模块化的技术来让开发者能按照自己的应用创建一个最小的运行时，提高了运行效率。

![1719734672257](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409151537337.png)

----

#### Java编码规范

编写 Java 程序时，应注意以下几点：

- **大小写敏感**：Java 是大小写敏感的，这就意味着标识符 Hello 与 hello 是不同的。
- **类名**：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 **MyFirstJavaClass** 。
- **方法名**：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
- **源文件名**：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存（切记 Java 是大小写敏感的），文件名的后缀为 **.java**。（如果文件名和类名不相同则会导致编译错误）。
- **主方法入口**：所有的 Java 程序由 **public static void main(String[] args)** 方法开始执行。

静态变量（也称为类变量）的命名规范通常遵循驼峰命名法，并且通常使用全大写字母，单词之间用下划线分隔，并且要用 static 关键字明确标识。

- **使用驼峰命名法：** 静态变量的命名应该使用驼峰命名法，即首字母小写，后续每个单词的首字母大写。例如：`myStaticVariable`。
- **全大写字母：** 静态变量通常使用全大写字母，单词之间用下划线分隔。这被称为"大写蛇形命名法"（Upper Snake Case）。例如：`MY_STATIC_VARIABLE`。
- **描述性：** 变量名应该是有意义的，能够清晰地表达该变量的用途。避免使用单个字符或不具有明确含义的缩写。
- **避免使用缩写：** 尽量避免使用缩写，以提高代码的可读性。如果使用缩写是必要的，确保广泛理解，并在注释中进行解释。

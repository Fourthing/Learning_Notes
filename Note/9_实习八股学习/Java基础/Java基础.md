# Java基础

- [基础概念与常识](https://javaguide.cn/java/basis/java-basic-questions-01.html#基础概念与常识)
- - [Java 语言有哪些特点?](https://javaguide.cn/java/basis/java-basic-questions-01.html#java-语言有哪些特点)
  - [Java SE vs Java EE](https://javaguide.cn/java/basis/java-basic-questions-01.html#java-se-vs-java-ee)
  - [JVM vs JDK vs JRE](https://javaguide.cn/java/basis/java-basic-questions-01.html#jvm-vs-jdk-vs-jre)
  - [什么是字节码?采用字节码的好处是什么?](https://javaguide.cn/java/basis/java-basic-questions-01.html#什么是字节码-采用字节码的好处是什么)
  - [为什么说 Java 语言“编译与解释并存”？](https://javaguide.cn/java/basis/java-basic-questions-01.html#为什么说-java-语言-编译与解释并存)
  - [AOT 有什么优点？为什么不全部使用 AOT 呢？](https://javaguide.cn/java/basis/java-basic-questions-01.html#aot-有什么优点-为什么不全部使用-aot-呢)
  - [Oracle JDK vs OpenJDK](https://javaguide.cn/java/basis/java-basic-questions-01.html#oracle-jdk-vs-openjdk)
  - [Java 和 C++ 的区别?](https://javaguide.cn/java/basis/java-basic-questions-01.html#java-和-c-的区别)

- [基本语法](https://javaguide.cn/java/basis/java-basic-questions-01.html#基本语法)
- - [注释有哪几种形式？](https://javaguide.cn/java/basis/java-basic-questions-01.html#注释有哪几种形式)
  - [标识符和关键字的区别是什么？](https://javaguide.cn/java/basis/java-basic-questions-01.html#标识符和关键字的区别是什么)
  - [Java 语言关键字有哪些？](https://javaguide.cn/java/basis/java-basic-questions-01.html#java-语言关键字有哪些)
  - [自增自减运算符](https://javaguide.cn/java/basis/java-basic-questions-01.html#自增自减运算符)
  - [移位运算符](https://javaguide.cn/java/basis/java-basic-questions-01.html#移位运算符)
  - [continue、break 和 return 的区别是什么？](https://javaguide.cn/java/basis/java-basic-questions-01.html#continue、break-和-return-的区别是什么)
- [基本数据类型](https://javaguide.cn/java/basis/java-basic-questions-01.html#基本数据类型)
- - [Java 中的几种基本数据类型了解么？](https://javaguide.cn/java/basis/java-basic-questions-01.html#java-中的几种基本数据类型了解么)
  - [基本类型和包装类型的区别？](https://javaguide.cn/java/basis/java-basic-questions-01.html#基本类型和包装类型的区别)
  - [包装类型的缓存机制了解么？](https://javaguide.cn/java/basis/java-basic-questions-01.html#包装类型的缓存机制了解么)
  - [自动装箱与拆箱了解吗？原理是什么？](https://javaguide.cn/java/basis/java-basic-questions-01.html#自动装箱与拆箱了解吗-原理是什么)
  - [为什么浮点数运算的时候会有精度丢失的风险？](https://javaguide.cn/java/basis/java-basic-questions-01.html#为什么浮点数运算的时候会有精度丢失的风险)
  - [如何解决浮点数运算的精度丢失问题？](https://javaguide.cn/java/basis/java-basic-questions-01.html#如何解决浮点数运算的精度丢失问题)
  - [超过 long 整型的数据应该如何表示？](https://javaguide.cn/java/basis/java-basic-questions-01.html#超过-long-整型的数据应该如何表示)
- [变量](https://javaguide.cn/java/basis/java-basic-questions-01.html#变量)
- - [成员变量与局部变量的区别？](https://javaguide.cn/java/basis/java-basic-questions-01.html#成员变量与局部变量的区别)
  - [静态变量有什么作用？](https://javaguide.cn/java/basis/java-basic-questions-01.html#静态变量有什么作用)
  - [字符型常量和字符串常量的区别?](https://javaguide.cn/java/basis/java-basic-questions-01.html#字符型常量和字符串常量的区别)
- [方法](https://javaguide.cn/java/basis/java-basic-questions-01.html#方法)
- - [什么是方法的返回值?方法有哪几种类型？](https://javaguide.cn/java/basis/java-basic-questions-01.html#什么是方法的返回值-方法有哪几种类型)
  - [静态方法为什么不能调用非静态成员?](https://javaguide.cn/java/basis/java-basic-questions-01.html#静态方法为什么不能调用非静态成员)
  - [静态方法和实例方法有何不同？](https://javaguide.cn/java/basis/java-basic-questions-01.html#静态方法和实例方法有何不同)
  - [重载和重写有什么区别？](https://javaguide.cn/java/basis/java-basic-questions-01.html#重载和重写有什么区别)
  - [什么是可变长参数？](https://javaguide.cn/java/basis/java-basic-questions-01.html#什么是可变长参数)

---

## Java语言特点

- 首先是面向对象语言，有**继承、封装、多态**的语言特性
- 稳定：提供*自动垃圾回收与内存管理、异常处理* 机制
- 安全：提供了多重安全防护机制如*访问权限修饰符、限制程序直接访问操作系统资源*
- 多线程：语言里内置多线程机制，不用调用操作系统的多线程功能
- 多平台：字节码的存在使得Java代码 “一次编译，到处运行”
- 半解释半编译：之前的理解是到字节码这部分都是编译，后面字节码解释为机器码执行这里是解释；今天新学的JIT也属于是编译，只不过JIT编译的是字节码中的热点代码（源代码是`.class`），其余的热点代码之外的部分仍旧由解释器来解释执行，这是解释与变异并存的另一个体现。
- 较高效：还是字节码的功劳，字节码使得代码在不同的机器上运行时无需重复编译。后续还有JIT/AOT的优化，使得Java执行的效率相对还是比较高的。
- 网络编程很方便，支持好

## JDK→JRE→JVM→JIT/AOT

这里基本的知识已经掌握，主要可以关注一下JRE的变化，JRE自9版本开始之后就不需要区分JDK与JRE了，引入了模块系统，也就是说JDK不再采用JRE+...的划分方式，而是细分为更小的模块，通过`jlink`工具（随 Java 9 一起发布的新命令行工具，用于生成自定义 Java 运行时映像，该映像仅包含给定应用程序所需的模块）可以自己**定制**程序运行的最小可用JRE。

关注一下这个功能的用途：定制的、模块化的 Java 运行时映像有助于**简化 Java 应用的部署**和**节省内存**并**增强安全性和可维护性**。这对于**满足现代应用程序架构的需求，如虚拟化、容器化、微服务和云原生开发**，是非常重要的。

![JDK、JRE、JVM、JIT 这四者的关系](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202412221013829.png)

JVM是有很多发行版本的，比如Hotspot VM， 这是Oracle JDK 提供的默认JVM，提供JIT（**J**ust **I**n **T**ime Compilation）即时编译， 属于运行时编译。当 JIT 编译器完成第一次编译后，其会将字节码对应的机器码保存下来，下次可以直接使用。而我们知道，机器码的运行效率肯定是高于 Java 解释器的；还提供GC功能，也就是垃圾回收机制，主要包括串行、并行等多种垃圾回收算法和一个高性能的G1垃圾回收器。

![Java程序转变为机器代码的过程](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202412221026589.png)

> HotSpot 采用了惰性评估(Lazy Evaluation)的做法，根据二八定律，消耗大部分系统资源的只有那一小部分的代码（热点代码），而这也就是 JIT 所需要编译的部分。JVM 会根据代码每次被执行的情况收集信息并相应地做出一些优化，因此执行的次数越多，它的速度就越快。

Graal VM 提供**AOT(Ahead of Time Compilation)**和JIT机制，支持包括Java在内的多种编程语言，性能比较好，包含优化编译器。

> AOT 避免了 JIT 预热等各方面的开销，可以提高 Java 程序的启动速度，避免预热时间长。并且，AOT 还能减少内存占用和增强 Java 程序的安全性（AOT 编译后的代码不容易被反编译和修改），特别适合云原生场景。

![JIT vs AOT](https://oss.javaguide.cn/github/javaguide/java/basis/jit-vs-aot.png)

从图中可以看出AOT的优势是*启动速度快、内存占用少、打包体积小*；而JIT的优势在于峰值吞吐量和极低的延迟，对请求的处理能力更优。

> *拓展阅读*：
>
> [基本功 | Java即时编译器原理解析及实践 - 美团技术团队](https://tech.meituan.com/2020/10/22/java-jit-practice-in-meituan.html)
>
> [基于静态编译构建微服务应用](https://mp.weixin.qq.com/s/4haTyXUmh8m-dBQaEzwDJw)

---

## Java基础常识

### 基本语法
#### 注释有哪几种形式？
#### 标识符和关键字的区别是什么？
#### Java 语言关键字有哪些？
#### 自增自减运算符
#### 移位运算符
#### continue、break 和 return 的区别是什么？
### 基本数据类型
#### Java 中的几种基本数据类型了解么？
#### 基本类型和包装类型的区别？
#### 包装类型的缓存机制了解么？
#### 自动装箱与拆箱了解吗？原理是什么？
#### 为什么浮点数运算的时候会有精度丢失的风险？
#### 如何解决浮点数运算的精度丢失问题？
#### 超过 long 整型的数据应该如何表示？
### 变量
#### 成员变量与局部变量的区别？
#### 静态变量有什么作用？
#### 字符型常量和字符串常量的区别?
### 方法
#### 什么是方法的返回值？方法有哪几种类型？
#### 静态方法为什么不能调用非静态成员？
#### 静态方法和实例方法有何不同？
#### 重载和重写有什么区别？
#### 什么是可变长参数？

这八种基本类型都有对应的包装类分别为：`Byte`、`Short`、`Integer`、`Long`、`Float`、`Double`、`Character`、`Boolean` 。


- **用途**：除了定义一些常量和局部变量之外，我们在其他地方比如方法参数、对象属性中很少会使用基本类型来定义变量。并且，包装类型可用于泛型，而基本类型不可以。
- **存储方式**：基本数据类型的局部变量存放在 Java 虚拟机栈中的局部变量表中，基本数据类型的成员变量（未被 `static` 修饰 ）存放在 Java 虚拟机的堆中。包装类型属于对象类型，我们知道几乎所有对象实例都存在于堆中。
- **占用空间**：相比于包装类型（对象类型）， 基本数据类型占用的空间往往非常小。
- **默认值**：成员变量包装类型不赋值就是 `null` ，而基本类型有默认值且不是 `null`。
- **比较方式**：对于基本数据类型来说，`==` 比较的是值。对于包装数据类型来说，`==` 比较的是对象的内存地址。所有整型包装类对象之间值的比较，全部使用 `equals()` 方法。

**为什么说是几乎所有对象实例都存在于堆中呢？** 这是因为 HotSpot 虚拟机引入了 JIT 优化之后，会对对象进行逃逸分析，如果发现某一个对象并没有逃逸到方法外部，那么就可能通过标量替换来实现栈上分配，而避免堆上分配内存

**基本数据类型存放在栈中是一个常见的误区！** 基本数据类型的存储位置取决于它们的作用域和声明方式。如果它们是局部变量，那么它们会存放在栈中；如果它们是成员变量，那么它们会存放在堆/方法区/元空间中。



包装类型的缓存机制？



下面我们来看一个问题：下面的代码的输出结果是 `true` 还是 `false` 呢？



```java
Integer i1 = 40;
Integer i2 = new Integer(40);
System.out.println(i1==i2);
```

`Integer i1=40` 这一行代码会发生装箱，也就是说这行代码等价于 `Integer i1=Integer.valueOf(40)` 。因此，`i1` 直接使用的是缓存中的对象。而`Integer i2 = new Integer(40)` 会直接创建新的对象。

因此，答案是 `false` 。你答对了吗？

记住：**所有整型包装类对象之间值的比较，全部使用 equals 方法比较**。



从字节码中，我们发现装箱其实就是调用了 包装类的`valueOf()`方法，拆箱其实就是调用了 `xxxValue()`方法。



**什么是自动拆装箱？**

- **装箱**：将基本类型用它们对应的引用类型包装起来；
- **拆箱**：将包装类型转换为基本数据类型；

**如果频繁拆装箱的话，也会严重影响系统的性能。我们应该尽量避免不必要的拆装箱操作。**



`BigDecimal` 可以实现对浮点数的运算，不会造成精度丢失。通常情况下，大部分需要浮点数精确运算结果的业务场景（比如涉及到钱的场景）都是通过 `BigDecimal` 来做的。



BigInteger 内部使用 int[] 数组来存储任意大小的整形数据。

相对于常规整数类型的运算来说，BigInteger 运算的效率会相对较低。



反射的知识

成员变量与局部变量

```java
public class VariableExample {

    // 成员变量
    private String name;
    private int age;

    // 方法中的局部变量
    public void method() {
        int num1 = 10; // 栈中分配的局部变量
        String str = "Hello, world!"; // 栈中分配的局部变量
        System.out.println(num1);
        System.out.println(str);
    }

    // 带参数的方法中的局部变量
    public void method2(int num2) {
        int sum = num2 + 10; // 栈中分配的局部变量
        System.out.println(sum);
    }

    // 构造方法中的局部变量
    public VariableExample(String name, int age) {
        this.name = name; // 对成员变量进行赋值
        this.age = age; // 对成员变量进行赋值
        int num3 = 20; // 栈中分配的局部变量
        String str2 = "Hello, " + this.name + "!"; // 栈中分配的局部变量
        System.out.println(num3);
        System.out.println(str2);
    }
}
```



静态变量也就是被 `static` 关键字修饰的变量。它可以被类的所有实例共享，无论一个类创建了多少个对象，它们都共享同一份静态变量。也就是说，静态变量只会被分配一次内存，即使创建多个对象，这样可以节省内存。

通常情况下，静态变量会被 `final` 关键字修饰成为常量。



静态方法为什么不能调用非静态成员?

这个需要结合 JVM 的相关知识，主要原因如下：

1. 静态方法是属于类的，在类加载的时候就会分配内存，可以通过类名直接访问。而非静态成员属于实例对象，只有在对象实例化之后才存在，需要通过类的实例对象去访问。
2. 在类的非静态成员不存在的时候静态方法就已经存在了，此时调用在内存中还不存在的非静态成员，属于非法操作。


重载和重写有什么区别？

> 重载就是同样的一个方法能够根据输入数据的不同，做出不同的处理
>
> 重写就是当子类继承自父类的相同方法，输入数据一样，但要做出有别于父类的响应时，你就要覆盖父类方法

综上：重载就是同一个类中多个同名方法根据不同的传参来执行不同的逻辑处理。

综上：**重写就是子类对父类方法的重新改造，外部样子不能改变，内部逻辑可以改变。**



| 区别点     | 重载方法 | 重写方法                                                     |
| ---------- | -------- | ------------------------------------------------------------ |
| 发生范围   | 同一个类 | 子类                                                         |
| 参数列表   | 必须修改 | 一定不能修改                                                 |
| 返回类型   | 可修改   | 子类方法返回值类型应比父类方法返回值类型更小或相等           |
| 异常       | 可修改   | 子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等； |
| 访问修饰符 | 可修改   | 一定不能做更严格的限制（可以降低限制）                       |
| 发生阶段   | 编译期   | 运行期                                                       |


![image-20240927170744965](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409271707997.png)

# Day1_JUnit单元测试、反射及注解

## 一、JUnit单元测试

### 1. 了解

​       要想知道一段程序的效果好不好，性能怎么样，能不能实现预期效果，往往要进行测试。根据测试的过程是否可解释、可观测分为*黑盒测试* 和 *白盒测试*，黑盒测试只关注被测试系统的输入和输出，<u>不考虑内部实现</u>，只验证功能是否符合需求；而白盒测试则要求测试人员<u>了解代码结构和逻辑</u>，通过测试内部路径和条件来验证程序的正确性。

​        JUnit单元测试就是白盒测试的一种，提供了注解（如`@Test`）、断言（如`assertEquals`）和测试套件的功能，使开发者能够有效地**创建和管理测试用例**。

### 2. JUnit实例

要想了解JUnit到底发挥了什么作用,还得到具体的应用中去感受.假如现在有两个方法`add`和`sub`,分别实现两个整数的加和减功能。

```java
package com.junit;

public class JUnitDemo {
    /*
     * 加法
     * */
    public int add(int a, int b) {
        return a + b;
    }
    /*
     * 减法
     * */
    public int sub(int a, int b) {
        return a - b;
    }
}
```

可以看到在测试类中定义了一个临时变量结果`result`，两段测试语句，要想运行一段就得把另外一段注释掉，虽然这里只有两个方法，

```java
package com.junit;

public class JUnitTest {
    public static void main(String[] args) {
        //创建对象
        JUnitDemo demo = new JUnitDemo();
        //调用
        int result= demo.add(1,2);
        System.out.println(result);

        int result= demo.sub(2,3);
        System.out.println(result);
    }
}
```

这时候`JUnit`的作用就体现出来了，使用JUnit的一般步骤如下：

- 定义一个测试类（测试用例）
  - **测试类名** 一般叫做`ATest、CarTest……`（A，car都是被测试的类名）,即`测试类名+Test`
  - **测试包名** 建议定为`xxx.xxx.xx.test`
- 定义测试方法(可以独立运行)
  - **方法名** 一般命名为`test+测试方法`,不过这种为老式的测试命名方式,现在可以命名为更加自由具体的方式.
  - **返回值** 一般为`void`
  - **参数列表** 一般为**空**
  - 一般使用断言操作来处理结果
- 给方法加上`@test`（别忘了要导入对应依赖）

按照如上步骤进行操作,首先定义一个测试类,项目结构如下:

![image-20240927192307392](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409271923443.png)

编写测试类代码如下

```java
package com.niko.test;

import com.niko.junit.JUnitDemo;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    /*
    * 测试add方法
    * */

    @Test
    public void testAdd(){
        JUnitDemo demo = new JUnitDemo();
        int result = demo.add(1,2);
        System.out.println("测试add方法成功,结果为"+result);
    }
}
```

​         有时测试方法不会出现绿色的成功测试的提示，而是会出现红色的异常提示信息，比如下面的除零错误。

![image-20240927192318701](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409271923730.png)

​        并且有时测试成功通过显示为绿色但是输出的结果并不是我们所想要的，比如在之前的add实现方法中代码逻辑写错了，加号写成了减号，但是测试不会报异常。这时就应该使用**断言**机制(*Assert*)来解决。

​        使用Assert同样要导入对应的包，值得注意的是，在JUnit 5中，`Assert`类不再存在。取而代之的是，所有断言方法都位于`org.junit.jupiter.api.Assertions`类中。也就是说原本的句子：

```java
Assert.assertEquals(3,result);
```

变为

```java
Assertions.assertEquals(3,result);
```

使用到的方法为：![image-20240927200012184](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409272000219.png)

如果`add`方法返回的是`a-b`，那么运行测试后结果如下：

![使用](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409271958719.png)

改进后的测试方法如下：

```java
package com.niko.test;

import com.niko.junit.JUnitDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.AssertionError;

public class JUnitTest {
    /*
    * 测试add方法
    * */
    @Test
    public void testAdd(){
        JUnitDemo demo = new JUnitDemo();
        int result = demo.add(1,2);
        System.out.println("测试add方法成功,结果为"+result);

        //断言 断言这个计算的结果为3
        Assertions.assertEquals(3,result);
    }
    /*
    * 测试sub方法
    * */
    @Test
    public void testSub(){
        JUnitDemo demo = new JUnitDemo();
        int result = demo.sub(1,2);
        System.out.println("测试sub方法成功,结果为"+result);
        
        Assertions.assertEquals(-1,result);
    }
}
```

### 3`@Before`和`@After`注解

​        如果有许多大体重复或者类似的方法需要测试，就会有许多重复的操作，比如上面的申请JUnitDemo临时对象和result临时变量，造成代码的大量重复，如何解决呢？这里就用到两个特殊的注解，在每个测试方法运行之前或之后执行一次相同的操作。

​       在JUnit中，`@Before`和`@After`注解用于在每个测试方法之前和之后执行特定的代码。这两者在**JUnit 4**中比较常用，<u>而在JUnit 5中，它们被替换为`@BeforeEach`和`@AfterEach`。</u>

​       前者常用于初始化测试环境、设置共享的对象或资源。例如，连接数据库或创建测试数据。后者常用于清理工作，如关闭资源、删除测试数据等。

​       最终的测试类代码优化如下：

```java
package com.niko.test;

import com.niko.junit.JUnitDemo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    /*
    * 而 demo = new JUnitDemo(); 是在已经声明的类成员变量demo上进行赋值，意味着这个变量在类的所有方法中都可以访问。
    * */
    private JUnitDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new JUnitDemo();
        System.out.println("测试环境已设置");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("测试结束\n");
    }

    /*
     * 测试add方法
     * */
    @Test
    public void testAdd() {
        int result = demo.add(1, 2);
        System.out.println("测试add方法成功，结果为：" + result);
        Assertions.assertEquals(3, result, "加法结果应为3");
    }

    /*
     * 测试sub方法
     * */
    @Test
    public void testSub() {
        int result = demo.sub(1, 2);
        System.out.println("测试sub方法成功，结果为：" + result);
        Assertions.assertEquals(-1, result, "减法结果应为-1");
    }
}
```



## 二、反射

### 1.概述

​       使用Java进行软件设计时常常使用框架，框架也就是半成品软件，在此基础上进行开发省时省力，简化了开发过程，而**反射**正是框架设计过程中必不可缺的一部分，称其为框架设计的灵魂也不为过。

​       那么什么是反射？**将类的各个组成部分封装成为其他对象**，这就是反射机制。

### 2.反射起作用的环节

​       Java的*源代码*经由编译之后生成*字节码*文件`.class`，而Java运行环境的核心组成部分——Java虚拟机，是用来执行Java字节码文件的。具体来说，JVM 识别机器的特定操作系统和硬件架构，并将 Java 程序在编译后生成的字节码转化为机器能够理解和执行的指令，也就是*机器码*。

![image-20240928193632836](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409281936915.png)

​        Java 的类加载器（ClassLoader）是 Java 虚拟机的一部分，负责动态加载类文件到 Java 虚拟机中。类加载器的工作过程分为几个主要步骤：加载、链接和初始化。

​        Java 类加载过程分为三个主要步骤。首先，在*加载阶段*，类加载器从不同来源（如文件系统或网络）加载字节码文件（.class 文件），并将其**转换为 Class 对象**（也正是反射机制起作用的环节）。类是按需加载的，仅在实际需要时进行，故本身就具有动态的特性。接下来是*链接过程*，包括验证、准备和解析三个阶段。验证确保类文件符合 Java 虚拟机的规范，保障安全性；准备为静态变量分配内存并设置默认值；解析将符号引用转换为直接引用，可延迟到使用时进行（懒解析）。最后，在*初始化阶段*，Java 虚拟机执行类的静态初始化代码，包括静态变量的初始化和静态代码块的执行。

![image-20240928102415978](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409281931264.png) 

> ### 自定义类加载器
>
> ​       除了标准的类加载器外，开发者还可以定义自己的类加载器，通过继承 `ClassLoader` 类来实现。这可以用来控制类加载的方式，比如从网络、数据库等新颖的来源加载类，或者实现类的热替换等功能。
>
> ### 类加载的双亲委派机制
>
> ​       Java 使用双亲委派模型来避免类的重复加载，确保 Java 的安全性和一致性。在这个模型中，当一个类加载器需要加载一个类时，它会首先将加载请求委托给它的父类加载器，直到根加载器。如果父类加载器找不到这个类，子加载器才会尝试自己加载。这一机制阻止了用户自定义类覆盖 Java 核心类库的类。
>
> ​       总结来说，Java 的类加载器通过一系列的加载、链接和初始化过程，实现了类的动态加载和管理。其结构和机制设计，使得 Java 在安全性、效率上有着很好的表现。

### 3.反射的一些API操作

经过上面的分析，可能对反射有个粗略的理解，只知其一不知其二，使用反射又有哪些好处呢？不着急，先来学习一下反射的一些API操作，

| 反射部分       | 描述                                                         | 相关方法                                                     |
| -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Class 类       | 代表类的结构和元数据，获取类的名称、父类、接口、字段和方法等信息 | `forName(String name)`<br>`getClass()`<br>`getDeclaredClasses()` |
| Field 类       | 表示类中的字段，允许在运行时访问或修改字段的值               | `getDeclaredField(String name)`<br>`get(Object obj)`<br>`set(Object obj, Object value)` |
| Method 类      | 表示类中的方法，允许动态调用方法并获取方法的信息             | `getMethod(String name, Class<?>... parameterTypes)`<br>`invoke(Object obj, Object... args)` |
| Constructor 类 | 表示类的构造器，允许在运行时创建类的实例                     | `getConstructor(Class<?>... parameterTypes)`<br>`newInstance(Object... initargs)` |
| 数组反射       | 支持对数组的反射，获取数组的类型、长度和元素等信息           | `Array.newInstance(Class<?> componentType, int... dimensions)`<br>`Array.get(Object array, int index)`<br>`Array.set(Object array, int index, Object value)` |
| 动态代理       | 在运行时创建接口的代理实例，定义其行为                       | `Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)` |
| 访问权限控制   | 允许访问私有字段和方法，需通过 setAccessible 方法取消访问控制检查 | `setAccessible(boolean flag)`                                |

#### 获取Class对象的方式（三种方式对应Java代码三个阶段）

- `Class.forName("全类名")；` 将字节码文件加载进JVM内存，返回class对象，对应*Source源代码阶段*
  - 多用于配置文件，可将类名定义在配置文件中，读取文件以加载类，一般不会硬编码
- `类名.class` 通过类名的属性class来获取，对应*Class类对象阶段*
  - 多用于参数传递
- `对象.getClass()` 这是继承自父类Object类中定义的方法，返回的是此Object的运行时类，对应的是*Runtime运行时阶段*
  - 多用于对象的获取字节码的方式

 尝试使用三种方法来获取类名：

```java
package com.niko.reflect;

import com.niko.domain.Person;

public class ReflectDemo{
    /*
    * 获取Class类的三种方式
    * */
    public static void main(String[] args) throws ClassNotFoundException {

        //1.Class.forName("全类名")
        Class clazz = Class.forName("com.niko.domain.Person");
        //这里sout输出对象一般会调用对象的toString方法输出一个字符串
        System.out.println(clazz);

        //2.类名.class
        Class clavv=Person.class;
        System.out.println(clavv);

        //3.对象.getClass()
        Person person=new Person();
        Class <? extends Person> clabb=person.getClass();
        System.out.println(clabb);

        //试比较三个对象确定是否是同一个地址——同一个对象
        System.out.println(clazz == clavv);
        System.out.println(clazz == clabb);
        System.out.println(clabb == clavv);
    }
}

```

![image-20240929192538361](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409291925449.png)

如果出现如上的错误`ClassNotFoundException`则说明类名很可能写错了以至于找不到对应的运行时类。

![image-20240929193824427](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409291938485.png)

由结果可知，同一个字节码文件`(*.class)`在一次程序运行过程中，只会被加载一次，三种方式获取的Class对象都是同一个，位于同一个地址。

#### 使用Class对象

Class对象定义了大量的方法，

- 获取功能
  1. 获取成员变量们
     - `Field[] getFields()` :获取所有public修饰的成员变量
     - `Field getField(String name)`: 获取指定的public修饰的成员变量
     - `Field[] getDeclaredFields()`:获取所有的成员变量,不考虑修饰符
     - `Field getDeclaredField(String name)`:获取指定的单个成员变量,不考虑修饰符
  2. 获取构造方法们
     - `Constructor<?>[] getConstructors()`
     - `Constructor<?> getConstructor(类<?>...parameterTypes)`
     - `Constructor<?>[] getDeclaredConstructors()`
     - `Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)`
  3. 获取成员方法们
     - `Method[] getMethods()`
     - `Method getMethod(String name,类<?>...parameterTypes)`
     - `Method[] getDeclaredMethods()`
     - `Method getDeclaredMethod(String name,类<?>...parameterTypes)`
  4. 获取类名
     - `String getName()`
  
- Field 成员变量
  - 操作:
    1. **设置值**
       - `void set(Object obj,Object value)`
    2. **获取值**
       - `Object get (Object obj)`
    3. **忽略访问权限修饰符的安全检查**
       - `setAccessible(true)`:所谓的"暴力反射"
    
  - 示例代码
  
    ```java
    package com.niko.reflect;
    
    import com.niko.domain.Person;
    
    import java.lang.reflect.Field;
    
    public class ReflectDemo2 {
        /*
        * 获取功能
            1. 获取成员变量们
               - `Field[] getFields()`
               - `Field getField(String name)`
               - `Field[] getDeclaredFields()`
               - `Field getDeclaredField(String name)`
            2. 获取构造方法们
               - `Constructor<?>[] getConstructors()`
               - `Constructor<?> getConstructor(类<?>...parameterTypes)`
               - `Constructor<?>[] getDeclaredConstructors()`
               - `Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)`
            3. 获取成员方法们
               - `Method[] getMethods()`
               - `Method getMethod(String name,类<?>...parameterTypes)`
               - `Method[] getDeclaredMethods()`
               - `Method getDeclaredMethod(String name,类<?>...parameterTypes)`
            4. 获取类名
               - `String getName()`
        * */
        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
            //0.获取Person的Class对象
            Class personClass = Person.class;
            //1.`Field[] getFields()` :获取所有public修饰的成员变量
            Field[] Field = personClass.getFields();
            for (Field f : Field) {
                System.out.println(f.getName());
            }
    
            System.out.println("-----------");
            //2.`Field getField(String name)`: 获取指定的public修饰的成员变量
                Field a = personClass.getField("a");
    
                //获取成员变量a的值
                Person person = new Person();
                    //忽略访问权限修饰符的安全检查
                    a.setAccessible(true);
                Object value=a.get(person);
                System.out.println(value);
    
                //设置成员变量a的值
                a.set(person,"NiKo");
                System.out.println(person.toString());
                System.out.println("-----------");
    
            //3.`Field[] getDeclaredFields()`:获取所有的成员变量,不考虑修饰符(安全性不好)
            Field[] declaredFields = personClass.getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println(f);
            }
            //4.`Field getDeclaredField(String name)`:获取指定的单个成员变量,不考虑修饰符
            Field b=personClass.getDeclaredField("b");
            b.setAccessible(true);
            Object value2=b.get(person);
            System.out.println(value2);
    
        }
    }
    ```
  
    

- Constructor 构造方法

  - **创建对象**：

    - `T newInstance(Object...initargs)`

      ![image-20241007190440445](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410071904514.png)

      此方法已弃用，虽然依然能够使用，但是建议更换成下面图中的替代方法。

      ![image-20241007190333595](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410071903725.png)

    - 如果使用空参的构造来创建对象，则可以简化操作，直接调用Class对象的newInstance方法。

    - 示例代码

      ```java
      package com.niko.reflect;
      
      import com.niko.domain.Person;
      
      import java.lang.reflect.Constructor;
      import java.lang.reflect.Field;
      import java.lang.reflect.InvocationTargetException;
      
      public class ReflectDemo3 {
          /*
          * 获取功能
              1. 获取成员变量们
                 - `Field[] getFields()`
                 - `Field getField(String name)`
                 - `Field[] getDeclaredFields()`
                 - `Field getDeclaredField(String name)`
              2. 获取构造方法们
                 - `Constructor<?>[] getConstructors()`
                 - `Constructor<?> getConstructor(类<?>...parameterTypes)`
                 - `Constructor<?>[] getDeclaredConstructors()`
                 - `Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)`
              3. 获取成员方法们
                 - `Method[] getMethods()`
                 - `Method getMethod(String name,类<?>...parameterTypes)`
                 - `Method[] getDeclaredMethods()`
                 - `Method getDeclaredMethod(String name,类<?>...parameterTypes)`
              4. 获取类名
                 - `String getName()`
          * */
          public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
              //0.获取Person的Class对象
              Class personClass = Person.class;
              /*
                 2. 获取构造方法们
                 - `Constructor<?>[] getConstructors()`
                 - `Constructor<?> getConstructor(类<?>...parameterTypes)`
                 - `Constructor<?>[] getDeclaredConstructors()`
                 - `Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)`
               */
              Constructor constructor=personClass.getConstructor(String.class,int.class);
              System.out.println(constructor);
              //创建对象1
              Object person=constructor.newInstance("张三",23);
              System.out.println(person);
              System.out.println("----------------");
      
              Constructor constructor2=personClass.getConstructor();
              System.out.println(constructor2);
              //创建对象2
              Object person2=constructor2.newInstance();
              System.out.println(person2);
              System.out.println("---------------");
      
              //空参的情况
              Object o=personClass.newInstance();
              System.out.println(o);
          }
      }
      ```

  - Method：方法对象
  
    - 执行方法
  
      - `Object invoke(Object obj,Object... args)`
  
    - 获取方法的名称
  
      - `String getName()`获取方法名
  
    - 示例代码：
  
      ```java
      package com.niko.reflect;
      
      import com.niko.domain.Person;
      
      import java.lang.reflect.Constructor;
      import java.lang.reflect.InvocationTargetException;
      import java.lang.reflect.Method;
      
      
      public class ReflectDemo4 {
          /*
          * 获取功能
              1. 获取成员变量们
                 - `Field[] getFields()`
                 - `Field getField(String name)`
                 - `Field[] getDeclaredFields()`
                 - `Field getDeclaredField(String name)`
              2. 获取构造方法们
                 - `Constructor<?>[] getConstructors()`
                 - `Constructor<?> getConstructor(类<?>...parameterTypes)`
                 - `Constructor<?>[] getDeclaredConstructors()`
                 - `Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)`
              3. 获取成员方法们
                 - `Method[] getMethods()`
                 - `Method getMethod(String name,类<?>...parameterTypes)`
                 - `Method[] getDeclaredMethods()`
                 - `Method getDeclaredMethod(String name,类<?>...parameterTypes)`
              4. 获取类名
                 - `String getName()`
          * */
          public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
              //0.获取Person的Class对象
              Class personClass = Person.class;
              /*
              3. 获取成员方法们
                 - `Method[] getMethods()`
                 - `Method getMethod(String name,类<?>...parameterTypes)`
                 - `Method[] getDeclaredMethods()`
                 - `Method getDeclaredMethod(String name,类<?>...parameterTypes)`
              */
              //获取指定名称的方法
              Method eat_method=personClass.getMethod("eat");
              Person person=new Person();
              //执行方法
              eat_method.invoke(person);
      
              Method eat_method2=personClass.getMethod("eat",String.class);
              //执行方法
              eat_method2.invoke(person,"noodles");
      
              System.out.println("----------------");
      
              //获取所有public修饰的方法(包括一些Object的方法)
              Method[] methods=personClass.getMethods();
              for (Method method:methods){
                  System.out.println(method);
                  System.out.println(method.getName());
              }
      
              System.out.println("----------------");
              
              //获取类名
              System.out.println(personClass.getName());
          }
      }
      ```
  
      

### 4.反射实例

- 需求：写一个框架类`ReflectExample`，在不改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法。
- 思路
  - 实现：仅修改配置文件，不更改具体代码
    1. 配置文件
    2. 反射
  - 步骤
    1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
    2. 在程序中加载读取配置文件
    3. 使用反射技术来加载类文件进虚拟机内存
    4. 创建对象
    5. 执行方法
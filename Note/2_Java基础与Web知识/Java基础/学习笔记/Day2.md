## Day2

### 2024年7月2日11:40:17

> 时间有限，了解一小部分知识

Java是半解释半编译型语言，半动态半静态。

![img](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409081420322.png)

### 一、变量      基本数据类型    和   运算符

#### 1.变量

变量就是存储数据的*“房间”*，通过变量名、变量类型来区分内存中不同的数据。

> 插写一点有关编写程序的想法，上课讲到编写程序涉及**设计算法**和将**算法转换成代码**两个步骤。
>
> 算法描述了如何解决问题的思路和解决问题的步骤

#### 2.增强for循环

### 二、源类

> 小厂面试爱考。

描述类的类。数据库中有meta元（描述其他数据库的数据库）？同理Java里的meta class源类就是描述类的类。

### 三、动态语言

动态加载一个类，动态地调用其方法，还可以提高启动速度，不用预加载？不是运行前全部加载，而是在运行过程中一边运行一边加载。

创建对象的两种方法。

- 静态new  `Studnet s=new PositiveStudent();`

- 运用反射机制

1.`Class.forName("a.Student");//动态,运行时才加载，但是必须有，没有就会报错`

2.`a.Student s;//静态`

`Student s=(Student)Beans.instantiate(getClassLoader(),"a.Student")`  //“=”右侧Beans返回值为object类型，等效为new，第一个参数是类加载器ClassLoader

### 四、接口（Interfaces）

### 五、JDK源代码

### 六、ODBC、JDBC

访问数据库

> ODBC(Open Database Connectivity，开放数据库互连)是微软公司开放服务结构(WOSA,Windows Open Services Architecture)中有关数据库的一个组成部分，它建立了一组规范，并提供了一组对数据库访问的标准API（应用程序编程接口）。这些API利用SQL来完成其大部分任务。ODBC本身也提供了对SQL语言的支持，用户可以直接将SQL语句送给ODBC。

预编程SQL语句，更快更安全，尽量用这个。占位符在SQL语句及其复杂的时候不好用，聚名？具名？spring框架就是这方面的改进。


> [05-JDBC-API详解-ResultSet_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1s3411K7jH/?p=5&spm_id_from=pageDriver&vd_source=9b3a05f794c99eb04df1bfa879079bca)

## JDBC学习记录

> JDBC全称：**J**ava **D**ata**B**ase **C**onnectivity
>
> JDBC学习的是使用Java语言来操作关系型数据库的一套API。
>
> 这一套标准接口使得同一套Java代码，操作不同的关系型数据库

###  一、JDBC简单了解

先来看看七个步骤：![1720420575738](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720420575738.png)

JDBC实际上就是一套定义的操作所有关系型数据库的**接口**。各数据库厂商去实现这套接口，提供的数据库**驱动**jar包其实本质就是**实现类**，这也是我们实际执行的代码。这正是所谓的**面向接口编程**。

![1720421052904](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720421052904.png)

### 二、JDBC快速入门

#### 1.创建工程，导入驱动jar包并注册驱动

首先点击新建项目。

![1720422048575](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720422048575.png)

新建一个空项目，便于我们后面选择使用的JDK版本和语言级别。

![1720422174314](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720422174314.png)

点击右上角小齿轮->项目结构。

![1720422246673](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720422246673.png)

*项目设置->项目->SDK*，**SDK**选择Java1.8版本；![1720422296710](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720422296710.png)

**语言级别**选择对应的8版本，点击左下角的**“应用”**。![1720422366712](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720422366712.png)

接着我们切换到*项目设置->模块（Modules）*，点击"+"号，新建一个模块，起名为jdbc-demo，点击**“确定”**。

![1720422871522](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720422871522.png)

接下来我们需要导入驱动jar包，在项目新建一个文件夹`../jdbc-demo/lib`，用于存放驱动jar包。

![1720422998324](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720422998324.png)

可以去*MVN Repository*网站下载所需要的jar包（[Maven Repository: mysql » mysql-connector-java (mvnrepository.com)](https://mvnrepository.com/artifact/mysql/mysql-connector-java)），在搜索框输入*MySQL-Connecter-Java*，下载所需要的版本，这里下载的是5.1.48版本。

![1720423238303](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720423238303.png)

接着需要让工程能够识别这个jar包，右键点击这个jar包，点击**“添加为库*（Add as Library）*”**。跳出下面的界面。我们选择模块库即可，即在这个模块生效。

![1720423480486](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720423480486.png)

接下来我们开始编写代码，首先新建一个Java类。

![1720423598793](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720423598793.png)

![1720423675318](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720423675318.png)

前面是包名，后面是类名。创建完成之后在JDBCDemo中编写代码注册驱动。（用到的快捷操作：`Ctrl+shift+/`**注释代码块**、输入psvm按回车自动补全变成**主方法**、`Alt+Enter` **选择抛出异常选项**，这里选择添加异常到方法签名、`Ctrl + D` ：这个快捷键用于复制当前行并粘贴到下一行。）遇到异常，抛出就可以了，可以是程序最起码跑起来。

注册驱动这里的*com.mysql.jdbc.Driver*是固定的。不过在MySQL 5之后是会自动注册的。

![1720424586335](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720424586335.png)

#### 2. 获取连接

用到了`DriverManager`类的静态方法`getConnection`.

![1720424979682](C:\Users\Star\AppData\Roaming\Typora\typora-user-images\1720424979682.png)

可以看到有三个参数，顺便提一嘴，URL是统一资源定位符。

![完整的 URL](https://developer.mozilla.org/zh-CN/docs/Learn/Common_questions/Web_mechanics/What_is_a_URL/mdn-url-all.png)

```java
DriverManager.getConnection(url，username，password)
```

会报错提示需要先创建对应的局部变量，并且getConnection还有一个返回值。均还是使用Alt+Enter补全即可。

完整代码如下：

```java
//2.获取连接
String url="jdbc:mysql://localhost:3306/db";
String username="root";
String password="Aa@123456789";
Connection conn = DriverManager.getConnection(url, username, password);
```

#### 3. 定义SQL语句

```JAVA
//3.定义sql
String sql = "select * from houselist";
```

#### 4. 获取执行SQL对象

```JAVA
//4.获取执行sql的对象 Statement
Statement stmt = conn.createStatement();
```

接下来调用连接对象的方法来创建一个`Statement`类对象。

#### 5.执行SQL

一开始的语句会发生SQLException报错，有两个问题：

**SSL 连接警告**: 警告信息建议显式设置 `useSSL=false`，以避免没有服务器身份验证的 SSL 连接。（因为MySQL是默认要求SSL连接的）

**执行 SELECT 语句的错误**: `executeUpdate` 方法不能用于执行 `SELECT` 语句，应该使用 `executeQuery` 方法。

至于为什么采用`ResultSet`，因为 `ResultSet` 是用于处理 `SELECT` 查询返回的结果集。`SELECT` 查询会返回一组记录，而 `ResultSet` 提供了一种机制来遍历这些记录并访问每一列的数据。别忘了在开头import块那里加上语句`import java.sql.ResultSet;`

如果是Update操作，使用int没有问题。

```java
//5.执行sql
//int count =stmt.executeUpdate(sql); //返回值是受影响的行数
ResultSet rs = stmt.executeQuery(sql);
```

#### 6. 处理执行结果

根据需求自定义。

```JAVA
//6.处理结果
//System.out.println(count);
while (rs.next()) {
    int id = rs.getInt("houseid");
    String address = rs.getString("address");
    System.out.println("ID: " + id + ", Address: " + address);
}

```

#### 7.释放资源

由于栈的特性，先开的Connection需要后关闭。

```JAVA
//7.释放资源
stmt.close();
conn.close();
```

### 三、JDBC API详解

> 2024年7月9日18:08:13

####  1. DriverManager

***DriverManager***（驱动管理类）两个作用：

- 注册驱动
- 获取数据库连接

其中有两个静态方法十分重要：`getConnection()`、`registerDriver()`

其中`registerDriver()`在Driver的一个静态代码块里，所以真正注册驱动的是`registerDriver()`，在驱动类被加载进内存时候这个静态方法就自动执行了，完成了驱动的注册。

![image-20240709000311093](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091536953.png)

前面是**MySQL协议**`jdbc:mysql`，后面跟着的是**IP地址**(127.0.0.1也可以写为*localhost*)，接着是**端口号**、**数据库名称**，最后是**参数列表**`？参数1&参数2&...`。
![image-20240709000410897](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091536057.png)

#### 2. Connection 

***Connection*(数据库 连接/会话 对象)**的作用：

- 获取执行SQL的对象（会在后面重点学习）

  ![image-20240709001050670](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091535496.png)

- 管理事务

  ![image-20240709001128641](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091535812.png)

  复制第一个Demo类，来测试事务管理的功能，若现在有两个SQL原子性语句需要并发执行，要么同时执行成功要么同时失败，那么我们需要开启事务、提交事务。若出现异常，我们需要回滚事务，利用Java的`try/catch`语句来处理异常，快捷键`Ctrl+Alt+T`将代码段使用`try/catch`语句包围起来。

  要注意的是同一个Statement对象能执行两个Update语句，而不能执行两个Query语句，需要有两个Statement对象。
  
  在一个事务里的两个查询语句的ResultSet对象的声明位置和内存释放问题有待考虑：
  
  若是在try/catch语句块外声明，不能保证正确回滚，若在tyr语句块里面声明，那么释放也放在try语句块里又是否不妥？

#### 3. Statement 

只有一个功能：**执行SQL语句**。

有两个**方法**需要重点学习：

> ***DDL（Data Definition Language）***语句： `数据定义语言`，主要是进行定义/改变表的结构、数据类型、表之间的链接等操作。常用的语句关键字有 CREATE、DROP、ALTER 等。
>
> ***DML（Data Manipulation Language）***语句: `数据操纵语言`，主要是对数据进行增加、删除、修改操作。常用的语句关键字有 INSERT、UPDATE、DELETE 等。
>
> ***DQL（Data Query Language）***语句：`数据查询语言`，主要是对数据进行查询操作。常用关键字有 SELECT、FROM、WHERE 等。
>
> ***DCL（Data Control Language）***语句： `数据控制语言`，主要是用来设置/更改数据库用户权限。常用关键字有 GRANT、REVOKE 等。
> 一般人员很少用到DCL语句。

- `int executeUpdate(sql);`  执行DDL、DML语句

- `ResultSet executeQuery(sql);`  执行DQL语句

- `boolean execute(sql)；`  可执行任意语句，返回的bool值表示是否返回ResultSet对象

  ![屏幕截图 2024-07-09 003713](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091535936.png)

创建一个新类Demo3_Statement用以测试，

```java
package com.niko.jdbc;

import org.junit.Test;
import java.sql.*;

/*
 *  JDBC API 详解 Statement
 * */
public class JDBCDemo3_Statement {

    /*
    * 执行DML语句
    * */
    @Test
    public void testDML() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url="jdbc:mysql://localhost:3306/db?useSSL=false";
        String username="root";
        String password="Aa@123456789";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "update houselist set price=1400 where houseid =17";

        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count =stmt.executeUpdate(sql); //返回值是受影响的行数
        //ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果
        if(count>0){
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
        //System.out.println(count);

//        while (rs.next()) {
//            int id = rs.getInt("houseid");
//            String address = rs.getString("address");
//            System.out.println("ID: " + id + ", Address: " + address);
//        }

        //7.释放资源
        stmt.close();
        conn.close();
    }

    /*
     * 执行DDL语句
     * */
    @Test
    public void testDDL() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url="jdbc:mysql://localhost:3306/db?useSSL=false";
        String username="root";
        String password="Aa@123456789";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "CREATE database db2";

        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count =stmt.executeUpdate(sql); //执行完DDL语句，成功后返回值也可能是0
        //ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果
//        if(count>0){
//            System.out.println("success");
//        }else {
//            System.out.println("fail");
//        }
          System.out.println(count);

//        while (rs.next()) {
//            int id = rs.getInt("houseid");
//            String address = rs.getString("address");
//            System.out.println("ID: " + id + ", Address: " + address);
//        }

        //7.释放资源
        stmt.close();
        conn.close();
    }
}

```

可以看到编写了两个测试单元，分别用于测试DML和DDL。

需要注意的是在编写测试单元的过程中可能会出现`@Test`报错的情况，不要慌张，从本地的Maven仓库导入Junit的 jar包 即可，导入方法为`文件->项目结构->项目设置->库->点“+”号`，如下，我导入的版本是4.12。

另外把JDBC操作语句的错误抛出，抛出的错误范围大点，设置的是Exception。

![image-20240709153926401](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091539468.png)

接着运行程序，查询数据库能够发现对应的操作成功实现了。

#### 4. ResultSet 

***ResultSet*（结果集对象）**的作用：

- **封装了**DQL查询语句的结果
- 提供了一些方法用以获取查询结果。可以粗略地分为如下两类。

![image-20240709154553798](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091545856.png)

要注意：`ResultSet` **列的编号*（column index）*从1开始！！！**

##### JDBC API 案例

以后的应用场景常有：

首先从数据库中查询数据，把这些散着的数据使用Java对象封装起来，这些对象不是直接用来放到网页中去的，需要存储到容器中去，而集合又是专门用来存放对象的容器，再把集合交给对应的页面，页面再通过遍历集合等等操作，实现各种各样的显示。

![image-20240709162814304](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091628363.png)、

下面是具体操作步骤：

- 首先需要新建一个pojo包，里面存放用到的**实体类**，路径为`com.niko.pojo`，这样src目录下会自动多出两个文件夹，一个就是之前的包文件的文件夹`jdbc`，另一个是新建的包`pojo`。

  ![image-20240709164709066](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091647119.png)

  ![image-20240709164024548](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091640618.png)

- 接着编写Account.java，快捷键`Alt+Insert`选中变量自动添加`getter`和`setter`方法如下

  ```java
  package com.niko.pojo;
  
  public class Account {
      private int houseid;
      private String address;
      private double price;
  
      public int getHouseid() {
          return houseid;
      }
  
      public void setHouseid(int houseid) {
          this.houseid = houseid;
      }
  
      public double getPrice() {
          return price;
      }
  
      public void setPrice(double price) {
          this.price = price;
      }
  
      public String getAddress() {
          return address;
      }
  
      public void setAddress(String address) {
          this.address = address;
      }
  }
  
  ```

  继续添加`toString`方法便于查看，还是使用相同的快捷键添加。

  ![image-20240709164521862](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091645923.png)

- 接下来完成JDBC代码的编写，新建一个类叫做`JDBCExample1_ResultSet_HouseList`，与pojo包里的文件名字对应（养成好习惯）。

  ![image-20240709170553112](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407100017238.png)

  接着明确我们的实现思路：*定义实体类->从数据库查询数据（JDBC）->查询出来的数据封装到HouseList对象中->输出对象结果 或 进行网页显示等进一步的需求*。

  我们的实体类`HouseList`已经定义完成，接着我们在程序里要做的包括实体类实例化、数据库数据赋值给实体类`HouseList`、将实体类实例存入集合。

  关键代码如下：

  ```java
  public class JDBCExample1_ResultSet_HouseList {
  
      /*
      * 查询houselist房屋表数据，封装为HouseList对象中，并且存储到ArrayList集合中
      * 1. 定义实体类HouseList
      * 2. 查询数据，封装到HouseList对象中
      * */
      @Test
      public void test() throws Exception {
          //1.注册驱动
          Class.forName("com.mysql.jdbc.Driver");
  
          //2.获取连接
          String url="jdbc:mysql://localhost:3306/db?useSSL=false";
          String username="root";
          String password="Aa@123456789";
          Connection conn = DriverManager.getConnection(url, username, password);
  
          //3.定义sql
          String sql = "SELECT * FROM houselist";
  
          //4.获取执行sql的对象 Statement
          Statement stmt = conn.createStatement();
  
          //5.执行sql
          //int count =stmt.executeUpdate(sql); //返回值是受影响的行数
          ResultSet rs = stmt.executeQuery(sql);
  
          //创建集合（用到了泛型和多态）
          List<HouseList> list = new ArrayList<HouseList>();
  
          //6.处理结果
              //光标向下移动一行，并且判断当前行是否有数据
          while (rs.next()) {
              HouseList houseList=new HouseList();
              int id = rs.getInt("houseid");
              String address = rs.getString("address");
              double price = rs.getDouble("price");
  
              //赋值
              houseList.setHouseid(id);
              houseList.setAddress(address);
              houseList.setPrice(price);
  
              //存入集合
              list.add(houseList);
          }
  
          //查看数据是否输出成功了
          System.out.println(list);
  
          //7.释放资源
          rs.close();
          stmt.close();
          conn.close();
      }
      
  }
  ```

  一个对象（也就是表里的一行）的输出结果如下：

  ![image-20240709171943084](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091719140.png)

  要是没有在实体类里重载toString方法，会出现这样的输出结果：

  ![image-20240709172314139](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091723200.png)

  查资料可知，我们所看到的输出是Java中对象的默认`toString()`方法生成的结果。默认情况下，Java的`toString()`方法返回类名的完全限定名称（即包名+类名）后跟对象的哈希码的十六进制表示。

  具体来说，`com.niko.pojo.HouseList@1c2c22f3`表示：

  - `com.niko.pojo.HouseList`是对象的类名。
  - `1c2c22f3`是对象的哈希码的十六进制表示。

####  5.PreparedStatement

***PreparedStatement***就是继承自*Statement* 的执行SQL语句的对象，作用就是**预编译SQL语句并执行来预防<u>SQL注入问题</u>**。

##### 1）SQL注入问题

> 摘自维基百科[SQL注入 - 维基百科，自由的百科全书 (wikipedia.org)](https://zh.wikipedia.org/wiki/SQL注入)
>
> **SQL注入**（英语：SQL injection），也称**SQL注入**或**SQL注码**，是发生于应用程序与数据库层的[安全漏洞](https://zh.wikipedia.org/wiki/安全漏洞)。简而言之，是在输入的字符串之中注入[SQL](https://zh.wikipedia.org/wiki/SQL)指令，在设计不良的[程序](https://zh.wikipedia.org/wiki/计算机程序)当中忽略了字符检查，那么这些注入进去的恶意指令就会被[数据库](https://zh.wikipedia.org/wiki/資料庫)[服务器](https://zh.wikipedia.org/wiki/伺服器)误认为是正常的SQL指令而执行，因此遭到破坏或是入侵。
>
> 最简单的例子就是输入用户名和密码，这个过程中肯定会用到数据库的查询操作，比如说：
>
> ```sql
> SELECT * FROM users WHERE username = 'username' AND password = 'password';
> ```
>
> 如果攻击者输入 
>
> ```plaintext
> admin' -- 
> ```
>
> 则服务器端接收到后可能会形成如下错误的SQL查询：
>
> ```sql
> SELECT * FROM users WHERE username = 'admin' -- ' AND password = 'password';
> ```
>
> 注释符`--`后面的文本将被视为注释，因此该查询实际上变成了：
>
> ```sql
> SELECT * FROM users WHERE username = 'admin';
> ```
>
> 这样攻击者无需正确的密码即可成功登录。

因此`PreparedStatement`就相当于一道门卫岗，需要拦住特殊的非法查询，能增强数据库的安全性。（现在知道了为什么用户名或密码会限制特殊符号了）

>  idea快捷输入`sout`，回车后会自动补全为`System.out.println()`

```java
package com.niko.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 *  JDBC API 详解 PreparedStatement
 *  以用户登录为例
 *  附上SQL语句：
 	CREATE TABLE USER(
        id int,
        username VARCHAR(20),
        password VARCHAR(32)
	);
    INSERT INTO USER VALUES(1,'NIKO','123'),(2,'MONESY','456');
 * */

public class JDBCDemo5_PreparedStatement {

    /*
    * 正常登录
    * */
    @Test
    public void testDQL() throws Exception {



        //获取连接
        String url="jdbc:mysql://localhost:3306/db2?useSSL=false";
        String username="root";
        String password="Aa@123456789";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name="NIKO";
        String pwd="123";

        String sql="select * from user where username='"+name+"'and password='"+pwd+"'";

        //获取stmt对象
        Statement stmt=conn.createStatement();

        //执行sql
        ResultSet rs=stmt.executeQuery(sql);

        //判断登录是否成功(rs.next()的作用是判断当前行有无数据并下移一行)
        if(rs.next()) {
            System.out.println("SUCCESS");
        }else {
            System.out.println("FAIL");
        }

        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /*
     * SQL注入
     * */
    @Test
    public void testDQL_Injection() throws Exception {



        //获取连接
        String url="jdbc:mysql://localhost:3306/db2?useSSL=false";
        String username="root";
        String password="Aa@123456789";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name="NIKO";//随便写，不用管数据库里有没有
        String pwd="' OR '1'='1";

        String sql="select * from user where username='"+name+"'and password='"+pwd+"'";
        System.out.println(sql);

        //获取stmt对象
        Statement stmt=conn.createStatement();

        //执行sql
        ResultSet rs=stmt.executeQuery(sql);

        //判断登录是否成功(rs.next()的作用是判断当前行有无数据并下移一行)
        if(rs.next()) {
            System.out.println("SUCCESS 注入成功！");
        }else {
            System.out.println("FAIL");
        }

        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

}

```



##### 2）使用PreparedStatement解决问题

实际解决通过特殊字符的转义来实现。

使用方法：

- 获取 *PreparedStatement* 对象

  ```java
  //初始：sql注入本质就是在拼sql语句字符串
  String sql="select * from user where username='"+name+"'and password='"+pwd+"'";
  
  //解决：SQL语句中的参数值现在使用占位符代替
  String sql="select * from user where username=? and password=?";
  //调用conn对象的方法，将这个sql语句作为参数传入Pstmt对象
  PreparedStatement pstmt=conn.prepareStatement(sql);
  ```

- 设置参数值

  ​    参数按照顺序 一 一对应各个？号。

  ![image-20240709182235015](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407091822116.png)

  ​    调用`pstmt`的方法`setXxx()`，在此示例中用户名和密码两个都是字符串类型。

  ```java
  //设置？号的值
  pstmt.setString(1,name);
  pstmt.setString(2,pwd);
  ```

- 执行SQL并处理结果

  ​    要注意这里不能调用父类的带参数的`executeQuery`方法，因为预编译的特性，SQL语句已经和pstmt对象绑定，所以调用的是空参的同名方法。

  ```java
  	    //执行sql
          ResultSet rs=pstmt.executeQuery();
  
          //判断登录是否成功(rs.next()的作用是判断当前行有无数据并下移一行)
          if(rs.next()) {
              System.out.println("SUCCESS");
          }else {
              System.out.println("FAIL");
          }
  
          //释放资源
          rs.close();
          pstmt.close();
          conn.close();
      }
  ```

  ​    很显然，再次传入一样的账户名和密码进行SQL注入测试，输出FAIL表示登录失败，登录被拒绝。

  ![image-20240710000814234](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407100008361.png)

##### 3) PreparedStatement原理

`PreparedStatement`有这样几个好处：

- **预编译**SQL，提高SQL语句执行性能

  ​    我们已经学了Java代码是如何和MySQL数据库进行交互的：*Java代码将待执行的SQL语句发给MySQL服务器，MySQL服务器在接收SQL语句并执行后返回结果给Java代码。*

  ​    其中MySQL服务器在接受SQL语句之后并不是直接执行SQL代码的，而是需要经过 ***检查SQL语法*->*编译SQL得到可执行的函数* -> *执行SQL*** 几个步骤。其中前两个步骤----检查和编译 过程相比 执行 需要耗费相对更多的时间。

  ​    对于同样结构的SQL语句，比如

  ```sql
  SELECT * FROM USER WHERE USERNAME = ?
  setString(1,"Mike");
  setString(2,"Jane");
  ```

  ​    只需执行一次检查与编译步骤，节省了时间，因此能够提高性能。

  ​    但是值得注意的是`PreparedStatement`的预编译功能默认是关闭的，需要在数据库URL的后面加上参数`useServerPrepStmts=true`才能开启。

  ```java
  String url="jdbc:mysql://localhost:3306/db2?useSSL=false"?useServerPrepStmts=true;
  ```

- 解决**SQL注入**问题

  上一次我们学到Pstmt防止SQL注入的原理是 **将敏感字符进行转义**。

  为了可视化这个过程，我们还需要配置MySQL执行日志（重启MySQL服务器后生效），在MySQL安装过程中相信大家都碰到过`my.ini`这个配置文件，修改这个文件，加入

  ```ini
  # 将日志输出设置为文件
  log-output=FILE
  
  # 启用一般查询日志
  general-log=1
  
  # 指定一般查询日志文件的位置和名称
  general_log_file="D:\\mysql.log"
  
  # 启用慢查询日志
  slow-query-log=1
  
  # 指定慢查询日志文件的位置和名称
  slow_query_log_file="D:\\mysql_slow.log"
  
  # 设置慢查询的阈值时间为2秒（查询时间超过2秒的语句将被记录到慢查询日志中）
  long_query_time=2
  
  ```

  找不到这个文件的可以找找隐藏目录`C:\ProgramData\MySQL\MySQL Server 8.0\my.ini`（Windows）

  ![屏幕截图 2024-07-10 010300](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407100105227.png)

  >  关于如何查找MySQL安装目录，请参考[如何查看MySql的安装位置？_mysql安装路径怎么找-CSDN博客](https://blog.csdn.net/hxwflay/article/details/103063964)

  接着重启MySQL服务，这里使用的是以管理员身份运行的cmd，当然使用services.msc图形界面修改也可以。

  ```CMD
  C:\Windows\System32>net stop mysql
  MySQL 服务正在停止.
  MySQL 服务已成功停止。
  
  C:\Windows\System32>net start mysql
  MySQL 服务正在启动 .
  MySQL 服务已经启动成功。
  
  ```

  ​    查看log文件来了解是否开启了预编译，可以看到开启预编译之后确实是通过对敏感字符转义字符来实现。还可以测试一下同一结构的两个语句，可以发现只有一次prepare提示，两次execute提示，说明只有一次检查和编译过程，但是有两次执行过程。

  开启预编译之后：

  ![image-20240710013106378](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407100933639.png)

  开启预编译之前：

  ![image-20240710013225927](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407100132031.png)

### 四、数据库连接池和Druid数据源

​    从名字我们就可以初步猜测数据库连接池可以类比线程池，实际也确实如此，数据库连接池是一个用于管理数据库连接的**容器**，负责分配、管理**数据库连接*（Connection）***。在数据库初始化之前创建一个容器用于存放数据库连接。

![image-20240710013939485](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407100139579.png)

​    使用数据库连接池的好处有：

- 实现资源的重用
- 提升系统响应速度
- 避免数据库连接遗漏

​    数据库连接池允许应用程序重复使用一个现有的数据库连接，同时连接池会释放空闲时间超过最大空闲时间的数据库连接来避免因为没有释放数据库连接而引起的数据库连接遗漏。

#### 数据库连接池的实现

​    官方也就是Sun公司提供了一个数据库连接池**标准接口**`DataSource`，由各个第三方组织来实现此接口，功能就是获取连接。所以以后我们不再需要通过驱动类`DriverManager`来获取数据库连接了，而是使用上面的这个标准接口。

```java
Connection getConnection()
```

常见的数据库连接池有`DBCP、C3P0、Druid`.

> [Druid连接池介绍 · alibaba/druid Wiki (github.com)](https://github.com/alibaba/druid/wiki/Druid连接池介绍)
>
> **Druid连接池**是阿里巴巴开源的数据库连接池项目。Druid连接池为监控而生，内置强大的监控功能，监控特性不影响性能。功能强大，能防SQL注入，内置Loging能诊断Hack应用行为。是目前Java语言最好的数据库连接池之一。



#### Driud使用步骤及简单示例

##### 1.导入jar包

在之前两个blog写好的项目的基础上继续实践。

还是使用之前的MVN Repository[Maven Repository: com.alibaba » druid (mvnrepository.com)](https://mvnrepository.com/artifact/com.alibaba/druid)下载所需jar包，这里跟着教程下载的是1.1.12版本，按照之前的方法导入jar包，并添加为库（可以参考JDBC学习记录1-入门中导入mysql的jar包的过程）。

接下来创建一个新类`DruidDemo`，这里放在一个新的包`com.niko.druid`下。

![image-20240710101140920](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407101011021.png)



##### 2.定义配置文件

在`src`根目录下创建一个配置文件`druid.properties`，内容如下

配置文件的好处在于可以避免 ***硬编码***，使代码具有较高的**复用性**，有修改需求的时候也比较方便。简单了解了一下，大致语法是 ***“键=值”*** 的形式，（像下面的配置文件一般键名是固定的，键值由自己指定），注释使用# 号。

这让我回想起了`my.ini`，也是一样的语法，它们都是配置文件。

```java
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/db?useSSL=false&useServerPrepStmts=true
username=root
password=Aa@123456789
# 初始化连接数据（容器初始大小）
initialSize=5
# 最大连接数（容器上限大小）
maxActive=10
# 最大等待时间
maxWait=3000
```

至此配置文件创建成功。


##### 3. 加载配置文件
开始编写新类里的代码。

先定义一个`Properties`对象用于读取配置文件，它可以读取包括XML、Properties在内的符合key=value格式的配置文件.

接着我们已经编写好了`Properties`配置文件，接着需要调用`Properties`对象的方法`load`来加载配置文件。

> 相关知识参考了[Java读写配置文件——Properties类的简要使用笔记-CSDN博客](https://blog.csdn.net/justlpf/article/details/119930780)

![img](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407101108205.jpeg)

关键代码：

```java
Properties prop = new Properties();
prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));
```

完整代码：

```java
package com.niko.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*
* Druid数据库连接池实践
* */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包（已完成）
        //2.定义配置文件（已完成）

        //3.加载配置文件（根据具体需求确定）
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));
	   //这个语句是为了方便确认第三步里的文件路径的，但是实际尝试使用相对路径没有成功，干脆使用了绝对路径
        //System.out.println(System.getProperty("user.dir"))
      
}

```

> 新学的快捷键 `Alt+Shift+上下方向键`来移动光标处的一整行代码

##### 4. 获取数据库连接池对象

接着上面继续coding

```JAVA
//4.获取连接池对象
DataSource datasource=DruidDataSourceFactory.createDataSource(prop);
```

敲后面的方法，补前面的对象。

##### 5.获取连接

```JAVA
//5.获取数据库连接
Connection connection = datasource.getConnection(); System.out.println(connection);

//6.执行自己进一步想执行的操作
```

连接池创建好之后，就可以调用连接池的方法来管理、创建数据库连接了！

![image-20240710110136297](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407101101390.png)


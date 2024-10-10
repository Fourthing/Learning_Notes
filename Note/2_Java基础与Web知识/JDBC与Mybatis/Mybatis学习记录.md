## MyBatis学习记录

### 一、MyBatis初步了解

#### 1.JDBC有缺点！

先来看看JDBC的一般过程：

***获取Connection**-> **定义SQL语句**-> **获取PreparedStatement对象**-> **设置参数**-> **执行SQL**-> **处理结果**-> **释放资源***

- 硬编码问题

  将*SQL语句、URL、用户名、密码* 等作为字符串写到了代码中，一旦需要更改，就需要重新编译构建，*注册驱动、获取连接、获取SQL语句* 通通需要重新执行一遍，难以维护，复用性和封装性不高。

- 操作繁琐

  若使用了预编译`PreparedStatement`对象，需要*手动传入参数* ；若执行的是查询语句，调用的是executeQuery方法，则在处理结果步骤中需要手动封装结果集。

因此我们需要更好的方法！MyBatis应运而生。

#### 2.MyBatis简介

*MyBatis*是一个**持久层**框架，用于<u>简化JDBC开发</u>。它通过减少大量的 JDBC 代码简化了数据库交互的实现，并且将 SQL 语句映射到 Java 对象，并管理复杂的数据库关系。简单来说就是配置灵活，效率更高，更为动态。

另外MyBatis 可以轻松地与 Spring 框架集成，使能够利用 Spring 强大的依赖注入和事务管理功能，而且支持多级缓存（会话级和语句级，通过减少数据库访问来提高性能。

> JavaEE的三层架构是：**表现层、业务层、持久层**
>
> ***表现层***也就是我们常说的web层。它负责接收客户端请求，向客户端响应结果，通常客户端使用http协议请求 web 层，web 需要接收 http 请求，完成 http 响应。
>
> ***业务层***即 service 层。它负责业务逻辑处理，
> 业务层在业务处理时可能会依赖持久层，如果要对数据持久化需要保证事务一致性。
>
> ***持久层***即DAO层，主要负责数据持久化，简单的说就是负责将数据保存到数据库，和数据库进行交互的那一层代码，
>
> **框架**，可以理解为是建筑的骨架，是一个已经对基础的代码进行了封装并提供了相应的API的**半成品软件**，一套*可重用、具有通用性* 的**软件基础代码模型**。它省去了重复性的工作，提高了编程效率，使用相同的框架也提高了规范性。

MyBatis 是一个流行的开源 Java 持久层框架，它通过减少大量的 JDBC 代码简化了数据库交互的实现。MyBatis 提供了一种灵活且易于使用的解决方案，用于处理 SQL 操作，将 SQL 语句映射到 Java 对象，并管理复杂的数据库关系。

#### 3.MyBatis的优势

MyBatis是当下主流的持久层框架。它的核心竞争力在哪里？对于JDBC的上述缺陷解决了哪些？

##### 1）配置文件->解决硬编码问题

将字符串信息写到了配置文件中去，包括数据库连接信息和所需要的SQL语句。可用通过 *简单的XML或注解* 来**配置**和**映射** *原始类型、接口和Java pojo（即普通老式Java对象）* 成为 *数据库中的记录*。

##### 2）使用sqlSession->解决操作繁琐问题

*MyBatis* 免除了几乎所有的JDBC代码，用一行或者短短几行的代码就能完成之前繁琐的设置参数和获取结果集的工作。

### 二、MyBatis入门程序

总体过程为：

***数据库建表*-> *创建模块、导入坐标* ->*编写MyBatis核心配置文件* ->*编写SQL映射文件* ->*编码***

#### 1.数据库建表

执行下面的SQL语句

```sql
create database mybatis;
use mybatis;

drop table if exists tb_user;

create table tb_user (
    id int primary key auto_increment,
    username varchar(20),
    password varchar(20),
    gender char(1),
    addr varchar(30)
);

INSERT INTO tb_user VALUES (1, 'zhangsan', '123', '男', '北京');
INSERT INTO tb_user VALUES (2, '李四', '234', '女', '天津');
INSERT INTO tb_user VALUES (3, '王五', '11', '男', '西安');

```

执行结果如下：

![image-20240712111208071](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121114582.png)

#### 2.创建项目、导入模块

创建项目的过程可以参考[JDBC学习记录1-入门-CSDN博客](https://blog.csdn.net/spy47_/article/details/140285636#comments_33635363)，这里不再赘述。需要注意的是在创建模块时使用的是`Maven`创建，会自动生成一个`pom.xml`文件。

![image-20240712112327038](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121123071.png)

使用`MyBatis`的方式有两种（参考下图官方的安装文档）：

- [ ] 将对应的`jar`包文件置于类路径中，并添加为库（同样可参考前面的学习记录）。
- [x] 如果使用`Maven`来构建项目，则只需要在`pom.xml`中添加一段依赖代码。

>  [MyBatis中文网](https://mybatis.net.cn/)![image-20240712112657014](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121126052.png)

这里选用的是第二种方式，添加一段`mybatis`的依赖代码，要注意有两层，外层是`<dependencies>`，内层是`<dependency>`.

![image-20240712113226954](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121132025.png)

接着同样方法添加`mysql驱动`，

```xml
<!--mysql 驱动-->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.29</version>
</dependency>
```

添加`junit单元测试`的坐标信息，

```xml
<!--junit 单元测试-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
```

添加与日志`.log文件`相关的坐标信息，

```xml
<!-- 添加slf4j日志api -->
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.36</version>
    </dependency>

    <!-- 添加logback-classic依赖 -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.2.3</version>
    </dependency>

    <!-- 添加logback-core依赖 -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-core</artifactId>
      <version>1.2.3</version>
    </dependency>
```



#### 3.编写MyBatis核心配置文件

> 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。

之前提到了MyBatis的关于硬编码问题的解决方案是使用配置文件，接下来我们需要来编写配置文件了。

需要编写的配置文件类型包括XML文件和Mapper映射文件，前者用于处理数据库连接、加载映射文件，后者主要为`sql`映射文件，解决的是`sql`硬编码问题。

##### 1）编写一个XML文件

编写一个`mybatis-config.xml`，内容示例如下：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
          <!--数据库连接信息-->
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
      <!--加载sql映射文件-->
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```

其中带有$符号的地方需要改为自己的数据，如驱动类名、URL等等。

如果报URL not set 的错误，参考下面这篇博文解决。

[2021-03-30- idea报URI 未注册 (Settings | Languages & Frameworks | Schemas and DTDs)_uri 未注册(设置 | 语言和框架 | 架构和 dtd)-CSDN博客](https://blog.csdn.net/weixin_44427798/article/details/115319440)

![image-20240712152311140](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121523205.png)

```java
//官方文档示例
String resource = "org/mybatis/example/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
```

![image-20240712152326371](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121523406.png)

```java
//官方文档示例
DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
TransactionFactory transactionFactory = new JdbcTransactionFactory();
Environment environment = new Environment("development", transactionFactory, dataSource);
Configuration configuration = new Configuration(environment);
configuration.addMapper(BlogMapper.class);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
```

#### 4.编写SQL映射文件

也就是`Mapper`文件，此类文件的命名方式较为固定，为`对应的类名+Mapper.xml`，比如`UserMapper.xml`，我们创建一个此文件，放在`resource`目录下

![image-20240712154811904](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121548954.png)

![](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121548608.png)

![屏幕截图 2024-07-12 154822](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202407121552460.png)

[2021-03-30- idea报URI 未注册 (Settings | Languages & Frameworks | Schemas and DTDs)_uri 未注册(设置 | 语言和框架 | 架构和 dtd)-CSDN博客](https://blog.csdn.net/weixin_44427798/article/details/115319440)

#### 5.编码


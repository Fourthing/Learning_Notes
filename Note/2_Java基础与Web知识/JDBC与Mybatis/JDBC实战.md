## JDBC实战

### 1.首先准备环境，确定数据操作的需求（增删改查）

试实现一个连接数据库的具有增删改查功能的管理系统。

使用的IDE为![image-20240711123216945](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407111232979.png)

本文侧重实操，有些快捷键可能在其他IDE不适用。

#### 1）数据库表

```sql
drop table if exists tb_brand;
create table tb_brand(
    id int primary key auto_increment,  -- id 主键
    brand_name varchar(20),  -- 品牌名称
    company_name varchar(20),  -- 企业名称
    ordered int,  -- 排序字段
    description varchar(100),  -- 描述信息
    status int  -- 状态：0 未启用 1 启用
);

insert into tb_brand (brand_name, company_name, ordered, description, status)
values 
    ('三只松鼠', '三只松鼠股份有限公司', 5, '好吃不上火', 0),
    ('华为', '华为技术有限公司', 100, '华为致力于把数字世界带入每个人，每个家庭，每个组织，构建万物互联的智能世界', 1),
    ('小米', '小米科技有限公司', 50, 'are you ok', 1);

SELECT * FROM tb_brand;

```

在数据库里新建新的数据库表。

#### 2）实体类

实体类的属性需要与数据库表的字段相互对应，下面介绍一下新学到的快速建立`pojo`类的方法。

首先把创建表的DML语句中的字段全部复制到新建的Java类中，替换不一致的注释符:`“--”->"//"`。
> 快捷键`Ctrl+R`查找替换

![image-20240711121331658](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407111213683.png)

其次需要保留字段的名称，删除后面的类型标识，替换为"；"号。

> 按住Alt，鼠标左键选中后面的多行

![image-20240711121259749](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407111212782.png)

接着不要切换光标（现在默认还是多行的状态），移动到最前，键入`private String`（先全部设置为`String`类型，因为`String`类型的字段最多），后面再进一步修改类型。

![image-20240711121911279](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407111219329.png)

最后整理代码格式，完成实体类的属性设置。

> 快捷键`Ctrl+Alt+L` 一键整理代码格式
>
> 快捷键`Ctrl+Alt+Shift+L` 重新设置代码格式

![image-20240711122635374](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407111226438.png)

额外需要注意的是在实体类中基本数据类型建议使用其对应的包装类型。

这里的`int`类型有一个默认值0，而0常常是具有业务含义的，比如说这里代表了禁用，不符合实际业务需求，所以我们应转向包装类型。再次使用查找替换功能把int替换为Integer。

> 在Java中，`Integer`是基本数据类型`int`的包装类型。包装类型是Java提供的用于将基本数据类型包装成对象类型的类。在Java中，每个基本数据类型都有对应的包装类型：
>
> - `int` 对应 `Integer`
> - `byte` 对应 `Byte`
> - `short` 对应 `Short`
> - `long` 对应 `Long`
> - `float` 对应 `Float`
> - `double` 对应 `Double`
> - `char` 对应 `Character`
> - `boolean` 对应 `Boolean`
>
> 使用包装类型的主要原因包括：
>
> 1. **集合类**：Java的集合框架（如`ArrayList`，`HashMap`等）只能存储对象类型，不能存储基本数据类型。因此，包装类型被用于在集合类中存储基本数据类型。
> 2. **自动装箱与拆箱**：自动装箱（Autoboxing）是指将基本数据类型自动转换为其对应的包装类型的过程。自动拆箱（Unboxing）则是指将包装类型自动转换为其对应的基本数据类型的过程。这些操作在Java 5中引入，使得代码更加简洁。
> 3. **方法参数**：在某些情况下，我们可能需要将基本数据类型作为对象传递给方法，这时可以使用包装类型。

最后加入`setter`和`getter`以及`toString`方法，完成实体类的设置。

> 快捷键`Alt+Insert`在菜单栏里选择添加什么方法
>
> ![image-20240711124113386](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407111241438.png)

#### 3）测试用例

新建一个类`BrandTest`，用于存放各个操作的测试方法。放在`example`包下。

![image-20240711124607700](https://gitee.com/de1ores/csdn-picture-bed/raw/master/images/202407111246745.png)

至此前置准备全部完成。



### 2.增删改查操作

#### 1）查询所有数据（Select）

既然是JDBC实战，使用JDBC连接数据库的几个步骤都不能省略。

`（注册驱动->）获取Connection->定义SQL语句->获取Statement对象->执行SQL->处理结果->释放资源`（此过程有SQL注入风险，不用）

采用`pstmt`对象来完成：

***获取Connection**-> **定义SQL语句**-> **获取PreparedStatement对象**-> **设置参数**-> **执行SQL**-> **处理结果**-> **释放资源***

- ①获取连接*（Connection）*

  - 采用DriverManager

    ```java
    //1.获取连接
    String url="jdbc:mysql://localhost:3306/db2?useSSL=false&useServerPrepStmts=true";
    String username="root";
    String password="Aa@123456789";
    Connection connection =DriverManager.getConnection(url,username,password);
    ```

  - 采用数据库连接池

    ```java
     //1.获取连接（使用数据库连接池）
    Properties prop = new Properties();
    prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"))
    DataSource datasource=DruidDataSourceFactory.createDataSource(prop);
    Connection connection = datasource.getConnection();
    ```
    
    
  
- ②定义SQL语句

  这里没有?号，即需要的参数，因此不需要执行第四步使用load方法获取参数。

  ```java
  //2.定义SQL语句
  String sql = "select * from tb_brand";
  ```

- ③获取pstmt对象

  ```java
  //3.获取pstmt对象
  PreparedStatement preparedStatement = connection.prepareStatement(sql);
  ```

- ④获取参数（无必要）

- ⑤执行SQL

  ```java
  //5.执行SQL
  ResultSet resultSet = preparedStatement.executeQuery();
  ```

- ⑥处理结果

  由于是控制台应用，这一步涉及如何输出的问题，比较重要，但其实就是固定的重复性工作，需要考虑易读性和规范性以便下一步使用（如果还有的话）。

  已经学到的方法就是先读取结果集中的各字段封装到定义的对象中，再使用`ArrayList`这一`List`实现类来装载对象（别忘了泛型的尖括号）。

  首先我们需要获取数据，固定地，我们要遍历整个结果集`resultSet`，因此需要一个循环和`next`方法（判断当前行有无数据并且下移一行）。

  > 有一个小技巧，先输入resultSet的参数类型为Stirng的方法，再使用下面的快捷键补全左侧。好处就是可以自动对应变量名称，还可以选择Java里招人喜欢的驼峰命名方式。
  >
  > Ctrl+Alt+V 补全局部变量声明（Declare final）

  ```java
  //6.处理结果 List<Brand> 封装Brand对象，装载List集合
  List<Brand> brands = new ArrayList<>();
  while (resultSet.next()) {
  	//获取数据
      int id=resultSet.getInt("id");
      String brandName = resultSet.getString("brand_name");
      String companyName = resultSet.getString("company_name");
      int ordered=resultSet.getInt("ordered");
      String description = resultSet.getString("description");
      int status=resultSet.getInt("status");
  }
  System.out.println(brands);
  ```

  继续在`while`循环中键入，各字段的值已经准备完毕，接下来用这些字段来封装`Brand`对象（我们自己定义的Java对象）

  ```java
  //封装Brand对象
  Brand brand=new Brand();
  brand.setId(id);
  brand.setBrandName(brandName);
  brand.setCompanyName(companyName);
  brand.setOrdered(ordered);
  brand.setDescription(description);
  brand.setStatus(status);
  ```

  最后把这些对象放到`List`里就算完成这一步了！

  ```java
  //装载集合
  brands.add(brand);
  ```

- ⑦释放资源

  根据栈的特性先后释放资源

  ```java
  //7.释放资源
  resultSet.close();
  preparedStatement.close();
  connection.close();
  ```

#### 2）添加数据（Insert）

先把框架搭好，连接数据库的操作和之前大差不差。

![屏幕截图 2024-07-11 165957](C:/Users/Star/Pictures/Screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202024-07-11%20165957.png)

需要更改的部分从定义SQL语句开始。

```java
//2.定义SQL语句
String sql = "Insert Into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";
```

设置参数这一步在实际应用中可以改为接收从网页端传来的信息。要注意的是主键id不能为空，且逻辑上不应由用户来设置，因此不传入id这个参数，是由数据库自己分配的。

```java
//4.设置参数
String brandName="飘柔";
String companyName="飘柔公司";
int ordered=1;
String description="洗发水用飘柔";
int status=0;

preparedStatement.setString(1,brandName);
preparedStatement.setString(2,companyName);
preparedStatement.setInt(3,ordered);
preparedStatement.setString(4,description);
preparedStatement.setInt(5,status);
```

这三步连在一起，因为`executeUpdate`的返回值是一个`int`类型，后面的步骤需要作相应的更改。

```java
//5.执行SQL
int count = preparedStatement.executeUpdate();//受影响的行数
```

```java
//6.处理结果 只需要判断是否执行成功
if(count>0)
	System.out.println("Insert Success!");
else
	System.out.println("Insert Failure!");
```

```java
//7.释放资源
preparedStatement.close();
connection.close();
```

#### 3）删除数据（Delete）

删和改大致思路与增相同，直接给出代码，仅供参考。

```java
/*
 * 根据id删除数据
 * SQL：Delete From tb_brand where id=?
 * 有参数
 * 结果：bool值
 */
@Test
public void testDelete() throws Exception {
    // 1.获取连接（使用数据库连接池）
    Properties prop = new Properties();
    prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));
    DataSource datasource = DruidDataSourceFactory.createDataSource(prop);
    Connection connection = datasource.getConnection();

    // 2.定义SQL语句
    String sql = "DELETE FROM tb_brand WHERE id=?";

    // 3.获取PreparedStatement对象
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    // 4.设置参数
    int id = 6;
    preparedStatement.setInt(1, id);

    // 5.执行SQL
    int count = preparedStatement.executeUpdate(); // 受影响的行数

    // 6.处理结果，只需要判断是否执行成功
    if (count > 0) {
        System.out.println("Delete Success!");
    } else {
        System.out.println("Delete Failure!");
    }

    // 7.释放资源
    preparedStatement.close();
    connection.close();
}

```

#### 4）更改数据（Update)

```java
/*
 * 根据id修改数据
 * SQL：Update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?;
 * 有参数
 * 结果：bool值
 */
@Test
public void testUpdate() throws Exception {
    // 1.获取连接（使用数据库连接池）
    Properties prop = new Properties();
    prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));
    DataSource datasource = DruidDataSourceFactory.createDataSource(prop);
    Connection connection = datasource.getConnection();

    // 2.定义SQL语句
    String sql = "UPDATE tb_brand SET brand_name=?, company_name=?, ordered=?, description=?, status=? WHERE id=?;";

    // 3.获取PreparedStatement对象
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    // 4.设置参数
    // 这一块在实际应用中可以改为接收从网页端传来的信息
    String brandName = "炫迈";
    String companyName = "炫迈公司";
    int ordered = 10;
    String description = "根本停不下来";
    int status = 0;
    int id = 5;

    preparedStatement.setString(1, brandName);
    preparedStatement.setString(2, companyName);
    preparedStatement.setInt(3, ordered);
    preparedStatement.setString(4, description);
    preparedStatement.setInt(5, status);
    preparedStatement.setInt(6, id);

    // 5.执行SQL
    int count = preparedStatement.executeUpdate(); // 受影响的行数

    // 6.处理结果，只需要判断是否执行成功
    if (count > 0) {
        System.out.println("Update Success!");
    } else {
        System.out.println("Update Failure!");
    }

    // 7.释放资源
    preparedStatement.close();
    connection.close();
}
```


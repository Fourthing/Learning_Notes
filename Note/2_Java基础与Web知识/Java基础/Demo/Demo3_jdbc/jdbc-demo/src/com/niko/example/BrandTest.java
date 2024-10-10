package com.niko.example;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.niko.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * 品牌測試的增刪改查操作
 * */
    /*
     * 根据id更改数据
     * SQL：Update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?;
     * 有参数
     * 结果：bool值
     * */

public class BrandTest {
    //測試方法

    /*
     * 查询
     * SQL：select * from tb_brand
     * 无参数
     * 结果：List<Brand>
     * */
    @Test
    public void testSelectAll() throws Exception {
//        //1.获取连接(使用DriverManager驱动类)
//        String url="jdbc:mysql://localhost:3306/db2?useSSL=false&useServerPrepStmts=true";
//        String username="root";
//        String password="Aa@123456789";
//        Connection connection =DriverManager.getConnection(url,username,password);

        //1.获取连接（使用数据库连接池）

        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));

        DataSource datasource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection = datasource.getConnection();

        //2.定义SQL语句
        String sql = "select * from tb_brand";

        //3.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //4.获取参数（无必要）

        //5.执行SQL
        ResultSet resultSet = preparedStatement.executeQuery();

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

            //封装Brand对象
            Brand brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            //装载集合
            brands.add(brand);

        }
        System.out.println(brands);

        //7.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    /*
     * 添加数据
     * SQL：Insert Into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);
     * 有参数:除了主键
     * 结果：bool值
     * */
    @Test
    public void testInsert() throws Exception {
        //1.获取连接（使用数据库连接池）
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource datasource= DruidDataSourceFactory.createDataSource(prop);
        Connection connection = datasource.getConnection();

        //2.定义SQL语句
        String sql = "Insert Into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";

        //3.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //4.设置参数
        //这一块在实际应用中可以改为接收从网页端传来的信息
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

        //5.执行SQL
        int count = preparedStatement.executeUpdate();//受影响的行数

        //6.处理结果 只需要判断是否执行成功
        if(count>0){
            System.out.println("Insert Success!");
        }else{
            System.out.println("Insert Failure!");
        }

        //7.释放资源
        preparedStatement.close();
        connection.close();
    }

    /*
     * 根据id修改数据
     * SQL：Update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?;
     * 有参数
     * 结果：bool值
     * */
    @Test
    public void testUpdate() throws Exception {
        //1.获取连接（使用数据库连接池）
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource datasource= DruidDataSourceFactory.createDataSource(prop);
        Connection connection = datasource.getConnection();

        //2.定义SQL语句
        String sql = "Update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?;";

        //3.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //4.设置参数
        //这一块在实际应用中可以改为接收从网页端传来的信息
        String brandName="炫迈";
        String companyName="炫迈公司";
        int ordered=10;
        String description="根本停不下来";
        int status=0;
        int id=5;

        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        preparedStatement.setInt(6,id);

        //5.执行SQL
        int count = preparedStatement.executeUpdate();//受影响的行数

        //6.处理结果 只需要判断是否执行成功
        if(count>0){
            System.out.println("Update Success!");
        }else{
            System.out.println("Update Failure!");
        }

        //7.释放资源
        preparedStatement.close();
        connection.close();
    }

    /*
     * 根据id删除数据
     * SQL：Delete From tb_brand where id=?
     * 有参数
     * 结果：bool值
     * */
    @Test
    public void testDelete() throws Exception {
        //1.获取连接（使用数据库连接池）
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource datasource= DruidDataSourceFactory.createDataSource(prop);
        Connection connection = datasource.getConnection();

        //2.定义SQL语句
        String sql = "Delete From tb_brand where id=?";

        //3.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //4.设置参数
        int id=6;
        preparedStatement.setInt(1,id);

        //5.执行SQL
        int count = preparedStatement.executeUpdate();//受影响的行数

        //6.处理结果 只需要判断是否执行成功
        if(count>0){
            System.out.println("Delete Success!");
        }else{
            System.out.println("Delete Failure!");
        }

        //7.释放资源
        preparedStatement.close();
        connection.close();
    }

}



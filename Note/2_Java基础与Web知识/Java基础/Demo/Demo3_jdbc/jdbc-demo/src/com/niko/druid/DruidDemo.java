package com.niko.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*
* Druid数据库连接池
* */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包

        //2.定义配置文件

        //3.加载配置文件（根据具体需求确定）
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo3_jdbc\\jdbc-demo\\src\\druid.properties"));

        //4.获取连接池对象
        DataSource datasource=DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection connection = datasource.getConnection();
        System.out.println(connection);

        //6.执行自己想执行的操作

        //System.out.println(System.getProperty("user.dir"));
    }
}

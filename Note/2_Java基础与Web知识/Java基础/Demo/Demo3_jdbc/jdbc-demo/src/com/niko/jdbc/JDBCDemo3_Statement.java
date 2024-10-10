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

package com.niko.jdbc;

import org.junit.Test;

import java.sql.*;


/*
 *  JDBC API 详解 ResultSet
 * */
public class JDBCDemo4_ResultSet {

    /*
    * 执行DQL语句
    * */
    @Test
    public void testDQL() throws Exception {
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

        //6.处理结果
            //6.1光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()) {
            int id = rs.getInt("houseid");
            String address = rs.getString("address");
            double price = rs.getDouble("price");
            String status = rs.getString("status");
            System.out.println("ID: " + id + ", Address: " + address+ ", Price: " + price+ ", Status: " + status);
        }

        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


}

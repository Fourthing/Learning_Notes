package com.niko.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *  JDBC快速入门
 * */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url="jdbc:mysql://localhost:3306/db?useSSL=false";
        String username="root";
        String password="Aa@123456789";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "select * from houselist";

        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        //int count =stmt.executeUpdate(sql); //返回值是受影响的行数
        ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果
        //System.out.println(count);
        while (rs.next()) {
            int id = rs.getInt("houseid");
            String address = rs.getString("address");
            double price = rs.getDouble("price");
            System.out.println("ID: " + id + ", Address: " + address+ ", Price: " + price);
        }

        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

}

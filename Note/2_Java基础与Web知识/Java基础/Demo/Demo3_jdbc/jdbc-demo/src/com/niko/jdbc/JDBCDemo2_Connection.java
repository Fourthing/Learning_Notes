package com.niko.jdbc;

import java.sql.*;

/*
 *  JDBC详解Connection
 * */
public class JDBCDemo2_Connection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url="jdbc:mysql://localhost:3306/db?useSSL=false";
        String username="root";
        String password="Aa@123456789";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql1 = "select * from houselist";
        String sql2 = "select * from userlist";

        //4.获取执行sql的对象 Statement
        Statement stmt1 = conn.createStatement();
        Statement stmt2 = conn.createStatement();


        try {
            //开启事务
            conn.setAutoCommit(false);

            //5.执行sql
            //int count =stmt.executeUpdate(sql); //返回值是受影响的行数
            ResultSet rs1 = stmt1.executeQuery(sql1);
            ResultSet rs2 = stmt2.executeQuery(sql2);

            //6.处理结果
            //System.out.println(count);
            while (rs1.next()) {
                int id = rs1.getInt("houseid");
                String address = rs1.getString("address");
                System.out.println("ID: " + id + ", Address: " + address);
            }
            while (rs2.next()) {
                int id = rs2.getInt("id");
                String name = rs2.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            //提交事务
            conn.commit();

        } catch (SQLException e) {
            //回滚事务
            conn.rollback();

            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {

            //7.释放资源

            stmt2.close();
            stmt1.close();
            conn.close();
        }


    }

}

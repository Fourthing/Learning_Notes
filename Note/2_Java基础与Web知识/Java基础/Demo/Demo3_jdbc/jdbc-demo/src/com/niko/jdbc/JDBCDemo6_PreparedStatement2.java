package com.niko.jdbc;

import org.junit.Test;

import java.sql.*;


/*
 *  JDBC API  PreparedStatement原理
 * */

public class JDBCDemo6_PreparedStatement2 {

    /*
     * pstmt测试
     * */
    @Test
    public void testDQL_Pstmt() throws Exception {



        //获取连接
        String url="jdbc:mysql://localhost:3306/db2?useSSL=false&useServerPrepStmts=true";
        String username="root";
        String password="Aa@123456789";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name="NIKO";//随便写，不用管数据库里有没有
        //String pwd="' OR '1'='1";
        String pwd="123";

        String sql="select * from user where username= ? and password= ?";

        //获取pstmt对象
        PreparedStatement pstmt=conn.prepareStatement(sql);

        //设置？号的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

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

}

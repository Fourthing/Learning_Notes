package com.niko.jdbc;

import com.niko.pojo.HouseList;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
 *  JDBC API 详解 ResultSet
 * */
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

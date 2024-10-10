package com.niko;

import com.niko.pojo.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
* MyBatis 测试类
* */
public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        //官方文档示例
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        List<Users> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);

        //4.释放资源
        sqlSession.close();
    }
}

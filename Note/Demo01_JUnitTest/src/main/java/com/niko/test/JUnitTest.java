//package com.niko.test;
//
//import com.niko.junit.JUnitDemo;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.lang.AssertionError;
//
//public class JUnitTest {
//    @BeforeEach
//    public void setUp() {
//        System.out.println("Test setup");
//        JUnitDemo demo = new JUnitDemo();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        System.out.println("Test finished");
//    }
//    /*
//    * 测试add方法
//    * */
//    @Test
//    public void testAdd(){
//        JUnitDemo demo = new JUnitDemo();
//        int result = demo.add(1,2);
//        System.out.println("测试add方法成功,结果为"+result);
//
//        //断言 断言这个计算的结果为3
//        Assertions.assertEquals(3,result);
//    }
//
//    @Test
//    public void testSub(){
//        JUnitDemo demo = new JUnitDemo();
//        int result = demo.sub(1,2);
//        System.out.println("测试sub方法成功,结果为"+result);
//
//        Assertions.assertEquals(-1,result);
//    }
//}
package com.niko.test;

import com.niko.junit.JUnitDemo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    /*
    * 而 demo = new JUnitDemo(); 是在已经声明的类成员变量demo上进行赋值，意味着这个变量在类的所有方法中都可以访问。
    * */
    private JUnitDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new JUnitDemo();
        System.out.println("测试环境已设置");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("测试结束\n");
    }

    /*
     * 测试add方法
     * */
    @Test
    public void testAdd() {
        int result = demo.add(1, 2);
        System.out.println("测试add方法成功，结果为：" + result);
        Assertions.assertEquals(3, result, "加法结果应为3");
    }

    /*
     * 测试sub方法
     * */
    @Test
    public void testSub() {
        int result = demo.sub(1, 2);
        System.out.println("测试sub方法成功，结果为：" + result);
        Assertions.assertEquals(-1, result, "减法结果应为-1");
    }
}

package com.bh.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {
    @Test
    public  void  test() throws Exception {
        //加载驱动
        //获取数据
        //生成发送器
        //执行
        //释放资源
        Class.forName("com.mysql.cj.jdbc.Driver");
        //connection 数据连接对象
        String url ="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String user ="root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
        //statement传输数据
        Statement stm = conn.createStatement();

        //resultset 结果集对象
       // ResultSet rs = stm.executeQuery("");
        //释放资源
        conn.close();
        stm.close();
    }
}

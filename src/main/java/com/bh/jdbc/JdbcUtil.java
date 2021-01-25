package com.bh.jdbc;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.junit.Test;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.support.JdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    private  static Connection connection = null;
    private  static String dirverclassname = null;
    private static  String url = null;
    private  static String username  = null;
    private  static  String password = null;

    static {
        try {
            InputStream inputStream = JdbcUtils.class.getResourceAsStream("jdbcconfig.properties");

            Properties properties = new Properties();
            properties.load(inputStream);

            dirverclassname = properties.getProperty("driverclassname");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("passwrod");
            //加载驱动
            Class.forName(dirverclassname);
        } catch (IOException  e) {
            //e.printStackTrace();
            System.out.println("读取配置文件失败！");
        }catch (ClassNotFoundException cne){
            System.out.println("加载驱动失败！");
        }
    }

    public static Connection getConnection(){
        try {

            //connection 建立连接
            connection = DriverManager.getConnection(url, username,password);
        }catch (SQLException se){
            System.out.println("数据库连接失败！");
        }
        if (connection!=null){
            return connection;
        }
        return null;

    }

        @Test
        public  static  void  demoJdbc(){

        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select  * from  tb_branch");
            while (rs.next()){
                int sid = rs.getInt("id");
                String sname = rs.getString("branchname");
                String location = rs.getString("location");
                System.out.println(sid+"  "+sname+"  "+location);
                connection.close();
                statement.close();
                rs.close();
            }
        } catch (SQLException e) {
           // e.printStackTrace();
            System.out.println("传输失败！");
        }


        }





}

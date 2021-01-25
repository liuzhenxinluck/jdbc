package com.bh.jdbc;

import org.junit.Test;

import java.sql.*;

public class DemoJDBC {
    /*
     * 一、得到Connection
     * 二、得到Statement，发送select语句
     * 三、对查询返回的“表格”进行解析！
     */

    /*
     * 所有的java.sql.Driver实现类，都提供了static块，块内的代码就是把自己注册到
     * DriverManager中！
     */
    /*
     * jdbc4.0之后，每个驱动jar包中，在META-INFrvices目录下提供了一个名为java.sql.Driver的文件。
     * 文件的内容就是该接口的实现类名称！
     */

    @Test
    public    void demoJDBC() throws ClassNotFoundException, SQLException {
       /* //加载驱动
        String dirverclassname = "com.mysql.cj.jdbc.Driver";
        Class.forName(dirverclassname);
        //得到三大参数
        String url ="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String user ="root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url,user,password);*/

        /*
         * 二、对数据库做增、删、改
         * 1. 通过Connection对象创建Statement
         *     > Statement语句的发送器，它的功能就是向数据库发送sql语句！
         * 2. 调用它的int executeUpdate(String sql)，它可以发送DML、DDL
         */
        //通过connection得到statement对象
        Statement statement = GetConnection.getConnection().createStatement();
        //发送sql语句
         //int row = statement.executeUpdate("insert  into tb_branch value(3,'wangwu','yeno') ");
         //int row1 = statement.executeUpdate("update tb_branch set  id=1 where branchname ='zhangsan'");
         //int row3 = statement.executeUpdate("update tb_branch set  id=2 where branchname ='lisi'");
         //System.out.println(row3+"  "+row1);

        /*
         * 二、得到Statement，执行sql语句
         * 1. 得到Statement对象：
         *     Connection的createStatement()方法
         */
        ResultSet rs = statement.executeQuery("select  * from tb_branch");
        /*
         * 三、解析ResultSet
         * 1. 把行光标移动到第一行，可以调用next()方法完成！
         */
        while (rs.next()){
            int sid = rs.getInt("id");
            String sname = rs.getString("branchname");
            String location = rs.getString("location");
            System.out.println(sid+"  "+sname+"  "+location);
        }

        //释放资源
        GetConnection.getConnection().close();
        rs.close();
        statement.close();


    }
}

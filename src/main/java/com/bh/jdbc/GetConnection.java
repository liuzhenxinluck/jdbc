package com.bh.jdbc;

        import org.springframework.data.relational.core.sql.SQL;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public  class GetConnection {
    private static Connection connection=null;
    public static Connection getConnection(){
        //得到四大参数
        String dirverclassname = "com.mysql.cj.jdbc.Driver";
        String url ="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String user ="root";
        String password = "123456";

        try {
            //加载驱动
            Class.forName(dirverclassname);
            //connection 建立连接
            connection = DriverManager.getConnection(url, user,password);
            }catch (ClassNotFoundException cfe){
            System.out.println("加载驱动失败！");
            }catch (SQLException se){
            System.out.println("数据库连接失败！");
        }
        if (connection!=null){
            return connection;
        }
            return null;


    }
}

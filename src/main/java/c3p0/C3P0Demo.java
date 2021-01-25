package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo {
    //
    public void fun() throws PropertyVetoException, SQLException {
        //新建一个ComboPooledDataSource类对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //添加四大参数
        /*ds.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE");
        ds.setUser("root");
        ds.setPassword("123456");
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");*/
        //修改连接池的默认值

        /*ds.setAcquireIncrement(5);

        ds.setInitialPoolSize(20);
        //最大空闲连接数
        ds.setMinPoolSize(2);
        //最大连接数
        ds.setMaxPoolSize(50);*/

        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();
    }

    public  void  fun2() throws SQLException, PropertyVetoException {
        //新建一个ComboPooledDataSource类对象
        ComboPooledDataSource ds1 = new ComboPooledDataSource("oracle-config");
        /*ds1.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE");
        ds1.setUser("root");
        ds1.setPassword("123456");
        ds1.setDriverClass("com.mysql.cj.jdbc.Driver");*/

    /*    ds1.setAcquireIncrement(5);
        ds1.setInitialPoolSize(20);
        ds1.setMinPoolSize(2);
        ds1.setMaxPoolSize(50);*/

        Connection connection = ds1.getConnection();
        System.out.println(connection);
        connection.close();

    }
}

package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
//jdbcutils 工具类
public class JdbcUtils {
    private  static DataSource dataSource = new ComboPooledDataSource();

    //获取数据源
    public  static DataSource datasources(){
        return dataSource;
    }
    //获取连接信息
    public  static Connection getconnection(){
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }
}

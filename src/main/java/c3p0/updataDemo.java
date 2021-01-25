package c3p0;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class updataDemo {

    //更新  包括增删改
    //QueryRunner 的 update()方法可以用来执行 insert、update、delete 语句。
    @Test
    public  void  fun1(){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into tb_branch values(?,?,?)";
        try {
            queryRunner.update(JdbcUtils.getconnection(),sql,"10","wangwu01","123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void  fun2(){
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.datasources());
        String sql = "insert into tb_branch values(?,?,?)";
        try {
            queryRunner.update(sql,"11","liuyi","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查找
    //MapHandler：单行处理器！把结果集转换成 Map<String,Object>，其中列名为键！
    @Test
    public  void  fun3(){
        DataSource ds = JdbcUtils.datasources();
        QueryRunner qr = new QueryRunner(ds);
        String sql =" select  * from tb_branch where id = ?";
        try {
            Map<String,Object> map = qr.query(sql,new MapHandler(),"10");
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //mapListHandler:多行处理器！把结果集转换成 List<Map<String,Object>>；
    @Test
    public  void  fun4(){
        DataSource ds = JdbcUtils.datasources();
        QueryRunner qr = new QueryRunner(ds);
        String sql =" select  * from tb_branch ";
        try {
            List<Map<String,Object>> list = qr.query(sql,new MapListHandler());
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ColumnListHandler：多行单列处理器！把结果集转换成 List<Object>，使用 ColumnListHandler时需要指定某一列的名称或编号
    @Test
    public void fun5() throws SQLException {
        DataSource ds = JdbcUtils.datasources();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from tb_branch ";
        List<Object> list = qr.query(sql,new ColumnListHandler<>("branchname"));
        for(Object s : list) {
            System.out.println(s);
        }
    }
    //ScalarHandler：单行单列处理器！把结果集转换成 Object。
    @Test
    public void fun6() throws SQLException {
        DataSource ds = JdbcUtils.datasources();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select count(*) from tb_branch";
        Number number = (Number)qr.query(sql, new ScalarHandler());
        int cnt = number.intValue();
        System.out.println(cnt);
    }
}

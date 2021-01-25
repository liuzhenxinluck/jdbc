package com.bh.jdbc;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.jdbc.support.JdbcUtils;
import sun.nio.ch.IOUtil;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Demo01 {
    private  static Connection connection = GetConnection.getConnection();
    @Test
    public  void music() {
        try {
            Statement statement = GetConnection.getConnection().createStatement();
            String sql = "insert  into tb_music value(?,?,?)";
            PreparedStatement patat = connection.prepareStatement(sql);
            patat.setInt(1,1);
            patat.setString(2,"你若成风.mp3");
            byte[] bytes = IOUtils.toByteArray(new FileInputStream("D:\\CloudMusic\\你若成风.mp3"));
            Blob blob = new SerialBlob(bytes);
            patat.setBlob(3,blob);
            patat.executeUpdate();

        }catch (SQLException se ){
            se.printStackTrace();
            //System.out.println("连接失败！");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

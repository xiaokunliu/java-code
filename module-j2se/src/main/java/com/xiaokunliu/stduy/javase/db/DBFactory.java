package com.xiaokunliu.stduy.javase.db;

import java.sql.*;

public class DBFactory {

    public static void main(String[] args) {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String pwd = "wind";
        Connection conn = null;
        Statement pst = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
            String sql = "select * from bookstore";
            pst = conn.createStatement();
            rs = pst.executeQuery(sql);
            System.out.println(rs);
            rsm = rs.getMetaData();
            System.out.println(rsm);
            //System.out.println(conn);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

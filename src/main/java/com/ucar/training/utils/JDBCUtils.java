package com.ucar.training.utils;

import com.ucar.training.domain.User;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebWork", "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
    }

    public static void close(Connection conn, Statement statement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn, statement);
    }

/*    public static void main(String[] args) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            ps = conn.prepareStatement("select * from USERS where uname=? and pwd=?");
            ps.setObject(1,"123456");
            ps.setObject(2,"123456");
            rs = ps.executeQuery();
            if(rs == null){
                return;
            }
            while(rs.next()) {
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rs);
        }
        System.out.println(u);

    }*/
}

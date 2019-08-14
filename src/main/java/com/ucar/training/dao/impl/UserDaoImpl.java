package com.ucar.training.dao.impl;

import com.ucar.training.utils.JDBCUtils;
import com.ucar.training.dao.UserDao;
import com.ucar.training.domain.User;


import java.sql.*;
import java.util.*;

public class UserDaoImpl implements UserDao {


    //注册用户
    @Override
    public int userRegDao(User user) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into USERS values(?,?,?,?,?,?,?,?,?)");
            ps.setObject(1, user.getUname());
            ps.setObject(2, user.getPwd());
            ps.setObject(3, user.getAge());
            ps.setObject(4, user.getIsRoot());
            ps.setObject(5, user.getSex());
            ps.setObject(6, user.getTel());
            ps.setObject(7, user.getEmail());
            ps.setObject(8, user.getFav());
            ps.setObject(9, user.getSign());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps);
        }
        return 1;
    }

    //检查用户密码
    @Override
    public User userCheckPwdDao(String name, String pwd) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            ps = conn.prepareStatement("select * from USERS where uname=? and pwd=?");
            if (ps == null) {
                return null;
            }
            ps.setObject(1, name);
            ps.setObject(2, pwd);
            rs = ps.executeQuery();
            if (rs == null) {

            }
            while (rs.next()) {
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return u;
    }

    //用户修改密码
    @Override
    public boolean userChangePwdDao(String pwd) {
        return false;
    }


    ////根据用户名返回相应用户对象
    @Override
    public User getUserInfoDao(String name) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            ps = conn.prepareStatement("select * from USERS where uname=? ");
            ps.setObject(1, name);
            rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return u;
    }

    //根据用户名删除用户
    @Override
    public void userDelDao(String name) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from USERS where uname=? ");
            ps.setObject(1, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps);
        }
    }

    //根据用户名修改用户信息
    @Override
    public void userChangeDao(User user) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update USERS set age=?,sex=?,tel=?,email=?,fav=?,sign=? " +
                    " where uname = ? ");
            ps.setObject(1, user.getAge());
            ps.setObject(2, user.getSex());
            ps.setObject(3, user.getTel());

            ps.setObject(4, user.getEmail());
            ps.setObject(5, user.getFav());
            ps.setObject(6, user.getSign());
            ps.setObject(7, user.getUname());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps);
        }
    }



    //删除用户留言
    @Override
    public void msgDelDao(String name, String date) {
        /*for (User u : UserDaoImpl.getUsers()) {
            if (name.equals(u.getUname())) {
                //查看是否存在该留言
                if (u.getMessage().containsKey(date)) {
                    //删除该留言
                    u.getMessage().remove(date);
                }
            }
        }*/
    }


    //获取所有用户
    @Override
    public List<User> getUsersDao() {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = null;
        try {
            ps = conn.prepareStatement("select * from USERS ");
            rs = ps.executeQuery();
            users = new ArrayList<User>();
            while (rs.next()) {
                User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return users;
    }
}

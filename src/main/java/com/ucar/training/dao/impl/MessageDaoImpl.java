package com.ucar.training.dao.impl;

import com.ucar.training.dao.MessageDao;
import com.ucar.training.domain.Message;
import com.ucar.training.utils.JDBCUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    //保存用户留言
    @Override
    public void saveMsgDao(String name, String msg) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into MESSAGE(uname,msg) values(?,?)");
            ps.setObject(1, name);
            ps.setObject(2, msg);
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
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from MESSAGE where uname=? and createTime=?");
            ps.setObject(1, name);
            ps.setObject(2, date);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps);
        }
    }


    //获取所有留言
    @Override
    public List<Message> getAllMsgDao() {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> messages = new ArrayList<Message>();
        try {
            ps = conn.prepareStatement("select uname,msg,createTime from MESSAGE ");
            rs = ps.executeQuery();
            while (rs.next()) {
                Message m = new Message(rs.getString(1), rs.getString(2), rs.getTimestamp(3).toString());
                messages.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps);
        }
        return messages;
    }


    //根据用户名返回留言
    @Override
    public List<Message> getUserMsgDao(String name) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> messages = new ArrayList<Message>();
        try {
            ps = conn.prepareStatement("select uname,msg,createTime from MESSAGE where uname=?");
            ps.setObject(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Message m = new Message(rs.getString(1), rs.getString(2), rs.getTimestamp(3).toString());
                messages.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps);
        }
        return messages;
    }
}

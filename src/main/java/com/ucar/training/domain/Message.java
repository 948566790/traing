package com.ucar.training.domain;

public class Message {
    private String uname;
    private String msg;
    private String createTime;

    public Message() {
    }

    public Message(String uname, String msg) {
        this.uname = uname;
        this.msg = msg;
    }

    public Message(String uname, String msg, String createTime) {
        this.uname = uname;
        this.msg = msg;
        this.createTime = createTime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uname='" + uname + '\'' +
                ", msg='" + msg + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}

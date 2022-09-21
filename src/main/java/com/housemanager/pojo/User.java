package com.housemanager.pojo;

public class User {

    private Integer userid;

    private String username;

    private String password;

    private String name;

    private String pay_card;

    private String ID_card;

    private Integer status;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPay_card() {
        return pay_card;
    }

    public void setPay_card(String pay_card) {
        this.pay_card = pay_card;
    }

    public String getID_card() {
        return ID_card;
    }

    public void setID_card(String ID_card) {
        this.ID_card = ID_card;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", pay_card='" + pay_card + '\'' +
                ", ID_card='" + ID_card + '\'' +
                ", status=" + status +
                '}';
    }
}
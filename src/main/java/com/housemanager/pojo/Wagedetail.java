package com.housemanager.pojo;

public class Wagedetail {

    private String username;

    private Integer projectid;

    private Double projectamount;

    private String dates;

    private String projectname;

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Double getProjectamount() {
        return projectamount;
    }

    public void setProjectamount(Double projectamount) {
        this.projectamount = projectamount;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "Wagedetail{" +
                "username='" + username + '\'' +
                ", projectid=" + projectid +
                ", projectamount=" + projectamount +
                ", dates='" + dates + '\'' +
                '}';
    }
}

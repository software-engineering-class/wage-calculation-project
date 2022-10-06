package com.housemanager.pojo;

public class Department {
    private Integer departmentid;
    private String departmentname;
    private String departmentphone;
    private String address;

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getDepartmentphone() {
        return departmentphone;
    }

    public void setDepartmentphone(String departmentphone) {
        this.departmentphone = departmentphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentid=" + departmentid +
                ", departmentname='" + departmentname + '\'' +
                ", departmenyphone='" + departmentphone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
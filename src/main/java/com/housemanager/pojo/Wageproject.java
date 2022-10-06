package com.housemanager.pojo;

public class Wageproject {

    private Integer projectid;

    private String projectname;

    private Integer types;

    private String note;



    public static String [] type={"增项","减项","其他"};
    public String getTypesname() {
        if(types==null)return "";
        return type[types];
    }


    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Wageproject{" +
                "projectid=" + projectid +
                ", projectname='" + projectname + '\'' +
                ", types=" + types +
                ", note='" + note + '\'' +
                '}';
    }
}

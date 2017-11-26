package com.software.calendar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class student {

    @Id
    private String stuUserid;
    private String stuPassword;
    private String stuName;
    private String stuClass;
    private String stuAcademy;
    private String stuPhonenum;
    private Integer stuPermission;

    public Integer getStuPermission() {
        return stuPermission;
    }

    public void setStuPermission(Integer stuPermission) {
        this.stuPermission = stuPermission;
    }

    public student(){
    }

    public String getStuUserid() {
        return stuUserid;
    }

    public void setStuUserid(String stuUserid) {
        this.stuUserid = stuUserid;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    @Override
    public String toString() {
        return "student{" +
                "stuUserid='" + stuUserid + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuAcademy='" + stuAcademy + '\'' +
                ", stuPhonenum='" + stuPhonenum + '\'' +
                '}';
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuAcademy() {
        return stuAcademy;
    }

    public void setStuAcademy(String stuAcademy) {
        this.stuAcademy = stuAcademy;
    }

    public String getStuPhonenum() {
        return stuPhonenum;
    }

    public void setStuPhonenum(String stuPhonenum) {
        this.stuPhonenum = stuPhonenum;
    }
}

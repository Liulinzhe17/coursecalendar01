package com.software.calendar.bean;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;
import java.util.Set;

@Entity
public class student{

    @Id
    private String stuUserid;
    private String stuPassword;
    private String stuName;
    private String stuClass;
    private String stuAcademy;
    private String stuPhonenum;
    private Integer stuPermission;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "scourse", joinColumns = {
            @JoinColumn(name = "stuUserid", referencedColumnName = "stuUserid") }, inverseJoinColumns = {
            @JoinColumn(name = "courseId", referencedColumnName = "courseId") })
    private Set<course>courses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "staffairs", joinColumns = {
            @JoinColumn(name = "stuUserid", referencedColumnName = "stuUserid") }, inverseJoinColumns = {
            @JoinColumn(name = "affairsId", referencedColumnName = "affairsId") })
    private Set<Affairs>affairs;

    public student(){

    }

    public Set<Affairs> getAffairs() {
        return affairs;
    }

    public void setAffairs(Set<Affairs> affairs) {
        this.affairs = affairs;
    }

    public Set<course> getCourses() {
        return courses;
    }

    public void setCourses(Set<course> courses) {
        this.courses = courses;
    }

    public Integer getStuPermission() {
        return stuPermission;
    }

    public void setStuPermission(Integer stuPermission) {
        this.stuPermission = stuPermission;
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

package com.software.calendar.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/*教师实体类*/
@Entity
public class teacher {
    @Id
    private String teacherUserid;
    private String teacherPassword;
    private String teacherName;
    private String teacherAcademy;
    private String teacherPhonenum;
    private Integer teacherPermission;
    private String teacherTitle;

    @ManyToMany(mappedBy = "teachers")
    private Set<course> courses;

    public Integer getTeacherPermission() {
        return teacherPermission;
    }

    public void setTeacherPermission(Integer teacherPermission) {
        this.teacherPermission = teacherPermission;
    }

    public teacher() {
    }

    public String getTeacherUserid() {
        return teacherUserid;
    }

    public void setTeacherUserid(String teacherUserid) {
        this.teacherUserid = teacherUserid;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }


    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAcademy() {
        return teacherAcademy;
    }

    public void setTeacherAcademy(String teacherAcademy) {
        this.teacherAcademy = teacherAcademy;
    }

    public String getTeacherPhonenum() {
        return teacherPhonenum;
    }

    public void setTeacherPhonenum(String teacherPhonenum) {
        this.teacherPhonenum = teacherPhonenum;
    }

    @JsonIgnore
    public Set<course> getCourses() {
        return courses;
    }

    public void setCourses(Set<course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "teacherUserid='" + teacherUserid + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAcademy='" + teacherAcademy + '\'' +
                ", teacherPhonenum='" + teacherPhonenum + '\'' +
                '}';
    }
}

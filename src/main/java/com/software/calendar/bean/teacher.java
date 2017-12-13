package com.software.calendar.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

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

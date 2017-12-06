package com.software.calendar.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class coursedata {

    @Id
    private String courseId;
    private Integer courseWeektime;
    private Integer courseWeek;
    private String courseHomework;
    private String courseOutline;
    private String courseData;

    public coursedata(){

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseWeektime() {
        return courseWeektime;
    }

    public void setCourseWeektime(Integer courseWeektime) {
        this.courseWeektime = courseWeektime;
    }

    public Integer getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(Integer courseWeek) {
        this.courseWeek = courseWeek;
    }

<<<<<<< HEAD
=======
    @Override
    public String toString() {
        return "coursedata{" +
                "courseId='" + courseId + '\'' +
                ", courseWeektime=" + courseWeektime +
                ", courseWeek=" + courseWeek +
                ", courseHomework='" + courseHomework + '\'' +
                ", courseOutline='" + courseOutline + '\'' +
                ", courseData='" + courseData + '\'' +
                '}';
    }

>>>>>>> cx
    public String getCourseHomework() {
        return courseHomework;
    }

    public void setCourseHomework(String courseHomework) {
        this.courseHomework = courseHomework;
    }

    public String getCourseOutline() {
        return courseOutline;
    }

    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline;
    }

    public String getCourseData() {
        return courseData;
    }

    public void setCourseData(String courseData) {
        this.courseData = courseData;
    }
}

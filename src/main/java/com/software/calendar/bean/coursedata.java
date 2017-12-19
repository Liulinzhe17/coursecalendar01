package com.software.calendar.bean;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(IdWeektime.class)
public class coursedata implements Serializable{
    @Id
    private String courseId;
    @Id
    private Integer courseWeektime;
    private Integer courseWeek;
    private String courseHomework;
    private String courseOutline;
    private String courseData;

    public String getCourseid() {
        return courseId;
    }

    public void setCourseid(String courseid) {
        this.courseId = courseid;
    }
    public Integer getWeektime() {
        return courseWeektime;
    }

    public void setWeektime(Integer weektime) {
        this.courseWeektime = weektime;
    }

    public Integer getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(Integer courseWeek) {
        this.courseWeek = courseWeek;
    }

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

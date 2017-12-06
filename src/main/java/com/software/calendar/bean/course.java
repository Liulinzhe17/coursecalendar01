package com.software.calendar.bean;


import javax.persistence.ManyToMany;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class course{


    @Id
    private String courseId;
    private String courseName;
    private Integer courseTimestart;
    private Integer courseTimeend;
    private String courseAcademy;
    private String courseAddress;
    private Integer courseWeek;
    private Integer courseWeekstart;
    private Integer courseWeekend;


    @ManyToMany(mappedBy = "courses")
    private Set<student> students;

    public course(){

    }

    @Override
    public String toString() {
        return "course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTimestart=" + courseTimestart +
                ", courseTimeend=" + courseTimeend +
                ", courseAcademy='" + courseAcademy + '\'' +
                ", courseAddress='" + courseAddress + '\'' +
                ", courseWeek=" + courseWeek +
                ", courseWeekstart=" + courseWeekstart +
                ", courseWeekend=" + courseWeekend +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseTimestart() {
        return courseTimestart;
    }

    public void setCourseTimestart(Integer courseTimestart) {
        this.courseTimestart = courseTimestart;
    }

    public Integer getCourseTimeend() {
        return courseTimeend;
    }

    public void setCourseTimeend(Integer courseTimeend) {
        this.courseTimeend = courseTimeend;
    }

    public String getCourseAcademy() {
        return courseAcademy;
    }

    public void setCourseAcademy(String courseAcademy) {
        this.courseAcademy = courseAcademy;
    }

    public String getCourseAddress() {
        return courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    public Integer getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(Integer courseWeek) {
        this.courseWeek = courseWeek;
    }

    public Integer getCourseWeekstart() {
        return courseWeekstart;
    }

    public void setCourseWeekstart(Integer courseWeekstart) {
        this.courseWeekstart = courseWeekstart;
    }

    public Integer getCourseWeekend() {
        return courseWeekend;
    }

    public void setCourseWeekend(Integer courseWeekend) {
        this.courseWeekend = courseWeekend;
    }

    @JsonIgnore
    public Set<student> getStudents() {
        return students;
    }

    public void setStudents(Set<student> students) {
        this.students = students;
    }

}

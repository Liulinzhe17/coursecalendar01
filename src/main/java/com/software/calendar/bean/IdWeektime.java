package com.software.calendar.bean;

import java.io.Serializable;

public class IdWeektime implements Serializable {
    private String courseId;
    private Integer courseWeektime;
    public IdWeektime(){
    }
    public IdWeektime(String courseid,Integer weektime){
        this.courseId=courseid;
        this.courseWeektime=weektime;
    }

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

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((courseWeektime == null) ? 0 : courseWeektime.hashCode());
        result = PRIME * result + ((courseId == null) ? 0 : courseId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final IdWeektime other = (IdWeektime) obj;
        if (courseWeektime == null) {
            if (other.courseWeektime != null)
                return false;
        } else if (!courseWeektime.equals(other.courseWeektime))
            return false;
        if (courseId == null) {
            if (other.courseId != null)
                return false;
        } else if (!courseId.equals(other.courseId))
            return false;
        return true;
    }
}

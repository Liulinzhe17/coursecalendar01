package com.software.calendar.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/*班级实体类*/
@Entity
public class Classes {
    @Id
    private String classesId;

    private String classesName;

    private String majorId;

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }
}

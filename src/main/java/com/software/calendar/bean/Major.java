package com.software.calendar.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/*专业实体类*/
@Entity
public class Major {
    @Id
    private String majorId;

    private String majorName;

    private String academyId;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }
}

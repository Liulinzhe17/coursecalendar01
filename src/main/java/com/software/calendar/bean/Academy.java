package com.software.calendar.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/*学院实体类*/
@Entity
public class Academy {
    @Id
    private String academyId;

    private String academyName;

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }
}

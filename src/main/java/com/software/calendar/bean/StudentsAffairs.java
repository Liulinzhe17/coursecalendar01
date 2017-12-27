package com.software.calendar.bean;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentsAffairs implements Serializable {
    private String stuUserid;
    private Integer affairsId;

    public StudentsAffairs() {
    }

    public String getStuUserid() {
        return stuUserid;
    }

    public void setStuUserid(String stuUserid) {
        this.stuUserid = stuUserid;
    }

    public Integer getAffairsId() {
        return affairsId;
    }

    public void setAffairsId(Integer affairsId) {
        this.affairsId = affairsId;
    }
}

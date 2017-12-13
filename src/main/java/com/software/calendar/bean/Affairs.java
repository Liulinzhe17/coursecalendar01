package com.software.calendar.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.GeneratedValue;
=======
>>>>>>> cx
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Affairs {
    @Id
<<<<<<< HEAD
    @GeneratedValue
=======
>>>>>>> cx
    private Integer affairsId;
    private String affairsName;
    private Integer affairsTimestart;
    private Integer affairsTimeend;
    private String affairsCreaterid;
    private String affairsAddress;
    private String affairsIntroduction;
    private Integer affairsWeek;
    private Integer affairsWeekstart;
    private Integer affairsWeekend;

    @ManyToMany(mappedBy = "affairs")
    private Set<student> students;

    public Affairs() {
    }

    public Integer getAffairsId() {
        return affairsId;
    }

    public void setAffairsId(Integer affairsId) {
        this.affairsId = affairsId;
    }

    public String getAffairsName() {
        return affairsName;
    }

    public void setAffairsName(String affairsName) {
        this.affairsName = affairsName;
    }

    public Integer getAffairsTimestart() {
        return affairsTimestart;
    }

    public void setAffairsTimestart(Integer affairsTimestart) {
        this.affairsTimestart = affairsTimestart;
    }

    public Integer getAffairsTimeend() {
        return affairsTimeend;
    }

    public void setAffairsTimeend(Integer affairsTimeend) {
        this.affairsTimeend = affairsTimeend;
    }

    public String getAffairsCreaterid() {
        return affairsCreaterid;
    }

    public void setAffairsCreaterid(String affairsCreaterid) {
        this.affairsCreaterid = affairsCreaterid;
    }

    public String getAffairsAddress() {
        return affairsAddress;
    }

    public void setAffairsAddress(String affairsAddress) {
        this.affairsAddress = affairsAddress;
    }

    public String getAffairsIntroduction() {
        return affairsIntroduction;
    }

    public void setAffairsIntroduction(String affairsIntroduction) {
        this.affairsIntroduction = affairsIntroduction;
    }

    public Integer getAffairsWeek() {
        return affairsWeek;
    }

    public void setAffairsWeek(Integer affairsWeek) {
        this.affairsWeek = affairsWeek;
    }

    public Integer getAffairsWeekstart() {
        return affairsWeekstart;
    }

    public void setAffairsWeekstart(Integer affairsWeekstart) {
        this.affairsWeekstart = affairsWeekstart;
    }

    public Integer getAffairsWeekend() {
        return affairsWeekend;
    }

    public void setAffairsWeekend(Integer affairsWeekend) {
        this.affairsWeekend = affairsWeekend;
    }

    @JsonIgnore
    public Set<student> getStudents() {
        return students;
    }

    public void setStudents(Set<student> students) {
        this.students = students;
    }
}

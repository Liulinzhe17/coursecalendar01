package com.software.calendar.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scalendar {
    @Id
    private String scalendarId;
    private String scalendarTermstart;
    private String scalendarTermend;
    private String scalendarHoliday;

    public String getScalendarId() {
        return scalendarId;
    }

    public void setScalendarId(String scalendarId) {
        this.scalendarId = scalendarId;
    }

    public String getScalendarTermstart() {
        return scalendarTermstart;
    }

    public void setScalendarTermstart(String scalendarTermstart) {
        this.scalendarTermstart = scalendarTermstart;
    }

    public String getScalendarTermend() {
        return scalendarTermend;
    }

    public void setScalendarTermend(String scalendarTermend) {
        this.scalendarTermend = scalendarTermend;
    }

    public String getScalendarHoliday() {
        return scalendarHoliday;
    }

    public void setScalendarHoliday(String scalendarHoliday) {
        this.scalendarHoliday = scalendarHoliday;
    }

    public Scalendar() {
    }
}

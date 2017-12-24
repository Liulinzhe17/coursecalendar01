package com.software.calendar.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.util.List;

public class ScalendarReturn {
    private String scalendarId;
    private String scalendarTermstart;
    private String scalendarTermend;
    private List<String> scalendarHoliday;

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

    public List<String> getScalendarHoliday() {
        return scalendarHoliday;
    }

    public void setScalendarHoliday(List<String> scalendarHoliday) {
        this.scalendarHoliday = scalendarHoliday;
    }

    public ScalendarReturn() {
    }
}

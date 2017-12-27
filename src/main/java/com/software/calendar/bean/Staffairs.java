package com.software.calendar.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Staffairs {
    @EmbeddedId
    private StudentsAffairs id;

    public Staffairs() {
    }

    public StudentsAffairs getId() {
        return id;
    }

    public void setId(StudentsAffairs id) {
        this.id = id;
    }
}

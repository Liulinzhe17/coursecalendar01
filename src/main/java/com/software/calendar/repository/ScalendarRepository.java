package com.software.calendar.repository;

import com.software.calendar.bean.Academy;
import com.software.calendar.bean.Scalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScalendarRepository extends JpaRepository<Scalendar,String> {

}

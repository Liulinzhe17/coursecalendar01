package com.software.calendar.repository;

import com.software.calendar.bean.coursedata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface coursedataRepository extends JpaRepository<coursedata,String> {
        coursedata findByCourseIdAndCourseWeektime(String id,Integer week);
}

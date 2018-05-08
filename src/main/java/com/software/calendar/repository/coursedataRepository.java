package com.software.calendar.repository;

import com.software.calendar.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface coursedataRepository extends JpaRepository<coursedata,IdWeektime> {
        coursedata findByCourseIdAndCourseWeektime(String id,Integer week);
//        @Query("Update coursedata Set course_outline=?1 where  course_id=?2 and course_weektime=?3")
//        int savebycidandweektime(String con,String name,Integer address);
}

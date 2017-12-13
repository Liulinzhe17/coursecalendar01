package com.software.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.software.calendar.bean.course;

public interface courseRepository extends JpaRepository<course,String> {
//    student findByStuUseridAndStuPassword(String id, String pwd);
    course findByCourseId(String id);
}

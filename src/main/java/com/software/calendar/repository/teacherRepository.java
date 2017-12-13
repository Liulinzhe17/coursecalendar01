package com.software.calendar.repository;

import com.software.calendar.bean.teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teacherRepository extends JpaRepository<teacher,String> {
}

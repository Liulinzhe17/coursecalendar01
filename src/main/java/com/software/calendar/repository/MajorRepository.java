package com.software.calendar.repository;

import com.software.calendar.bean.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major,String> {
    /*根据学院id查询专业*/
    public List<Major>findByAcademyId(String academyId);
}

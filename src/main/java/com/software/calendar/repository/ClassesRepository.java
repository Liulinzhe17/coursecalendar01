package com.software.calendar.repository;

import com.software.calendar.bean.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassesRepository extends JpaRepository<Classes,String> {
    /*根据专业id查询班级*/
    public List<Classes>findByMajorId(String majorId);

}

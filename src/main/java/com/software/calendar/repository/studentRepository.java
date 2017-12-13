package com.software.calendar.repository;

import com.software.calendar.bean.student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface studentRepository extends JpaRepository<student,String> {
    student findByStuUseridAndStuPassword(String id, String pwd);
    student findByStuPhonenum(String phone);

    /*根据班级id查询学生*/
    public List<student> findByStuClass(String stuClass);

    /*根据学号查询学生*/
    public student findByStuUserid(String stuUserid);
}

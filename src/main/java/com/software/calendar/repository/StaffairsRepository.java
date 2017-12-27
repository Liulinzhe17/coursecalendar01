package com.software.calendar.repository;

import com.software.calendar.bean.Staffairs;
import com.software.calendar.bean.StudentsAffairs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffairsRepository extends JpaRepository<Staffairs,StudentsAffairs> {

}

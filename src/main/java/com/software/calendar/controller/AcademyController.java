package com.software.calendar.controller;

import com.software.calendar.bean.Academy;
import com.software.calendar.bean.Result;
import com.software.calendar.repository.AcademyRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academy")
public class AcademyController {
    @Autowired
    AcademyRepository academyRepo;

    /*查询所有学院*/
    @RequestMapping("/get")
    public Result<Academy> get() {
        System.out.println("******查询学院******");
        List<Academy> list = academyRepo.findAll();
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);

    }


}
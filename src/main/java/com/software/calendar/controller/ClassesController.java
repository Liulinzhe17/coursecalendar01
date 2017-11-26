package com.software.calendar.controller;

import com.software.calendar.bean.Classes;
import com.software.calendar.bean.Result;
import com.software.calendar.repository.ClassesRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    ClassesRepository classesRepo;

    /*根据专业id查询班级*/
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public Result<Classes> get(String majorId) {
        System.out.println("******根据专业id查询班级******");
        List<Classes> list = classesRepo.findByMajorId(majorId);
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);

    }

}
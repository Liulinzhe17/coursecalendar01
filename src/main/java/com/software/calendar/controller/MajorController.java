package com.software.calendar.controller;

import com.software.calendar.bean.Major;
import com.software.calendar.bean.Result;
import com.software.calendar.repository.MajorRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    MajorRepository majorRepo;

    /*根据学院id查询专业*/
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result<Major> search(@RequestParam String academyId) {
        System.out.println("******根据学院id查询专业******");
        List<Major> list = majorRepo.findByAcademyId(academyId);
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);

    }


}
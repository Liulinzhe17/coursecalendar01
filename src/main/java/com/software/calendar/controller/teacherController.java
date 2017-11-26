package com.software.calendar.controller;

import com.software.calendar.bean.Result;
import com.software.calendar.bean.student;
import com.software.calendar.bean.teacher;
import com.software.calendar.controller.teacherController;
import com.software.calendar.repository.teacherRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class teacherController {
    @Autowired
    teacherRepository teacherRepo;

    /*查询所有用户*/
    @RequestMapping("/get")
    public Result<teacher> get() {
        System.out.println("******查询所有教师******");
        List<teacher> list = teacherRepo.findAll();
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);

    }


    /*增加一个用户*/
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody teacher tea){
        System.out.println("******新增教师******");
        teacherRepo.save(tea);
        return ResultUtil.success();
    }

    /*批量增加用户*/
    @RequestMapping(value = "/adds",method = RequestMethod.POST)
    @ResponseBody
    public Result adds(@RequestBody teacher[] teaArray){
        System.out.println("******批量新增教师******");
        for (int i=0;i<teaArray.length;i++){
            teacherRepo.save(teaArray[i]);
        }
        return ResultUtil.success();
    }

    /*删除一个用户*/
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam String teacherUserid){
        System.out.println("******删除教师******");
        //根据teacherUserid查询到要删除的列
        teacherRepo.delete(teacherUserid);
        return ResultUtil.success();

    }

    /*批量删除用户*/
    @RequestMapping(value = "/deletes",method = RequestMethod.POST)
    @ResponseBody
    public Result deletes(@RequestBody String[] teacherUseridArray){
        System.out.println("******批量删除教师******");
        //根据teacherUserid查询到要删除的列
        for (String teacherUserid : teacherUseridArray){
            teacherRepo.delete(teacherUserid);
        }
        return ResultUtil.success();
    }

    /*修改一个用户*/
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result update(teacher tea){
        System.out.println("******更新教师******");
        teacherRepo.saveAndFlush(tea);
        return ResultUtil.success();
    }
}


package com.software.calendar.controller;

import com.software.calendar.bean.Result;
import com.software.calendar.bean.student;
import com.software.calendar.repository.studentRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/student")
public class studentController {


    @Autowired
    studentRepository studentRepo;

    /*查询所有用户*/
    @RequestMapping("/list")
    public Result<student> list() {
        System.out.println("******查询所有学生******");
        List<student> list = studentRepo.findAll();
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);

    }

    /*根据班级id查询学生*/
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public Result search(@RequestParam String stuClass){
        System.out.println("******根据班级id查询学生******");
        List<student> list = studentRepo.findByStuClass(stuClass);
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);
    }

    /*增加一个用户*/
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody student stu){
        System.out.println("******新增学生******");
        studentRepo.save(stu);
        return ResultUtil.success();
    }

    /*批量增加用户*/
    @RequestMapping(value = "/adds",method = RequestMethod.POST)
    @ResponseBody
    public Result adds(@RequestBody student[] stuArray){
        System.out.println("******批量新增学生******");
        for (int i=0;i<stuArray.length;i++){
            studentRepo.save(stuArray[i]);
        }
        return ResultUtil.success();
    }

    /*删除一个用户*/
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam String stuUserid){
        System.out.println("******删除学生******");
        //根据stuUserid查询到要删除的列
        studentRepo.delete(stuUserid);
        return ResultUtil.success();

    }

    /*批量删除用户*/
    @RequestMapping(value = "/deletes",method = RequestMethod.POST)
    @ResponseBody
    public Result deletes(@RequestBody String[] stuUseridArray){
        System.out.println("******批量删除学生******");
        //根据stuUserid查询到要删除的列
        for (String stuUserid : stuUseridArray){
            studentRepo.delete(stuUserid);
        }
        return ResultUtil.success();
    }

    /*修改一个用户*/
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody student stu){
        System.out.println("******更新学生******");
        studentRepo.saveAndFlush(stu);
        return ResultUtil.success();
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Integer IsLogin(String id,String pwd){
        student s =studentRepo.findByStuUseridAndStuPassword(id,pwd);
        if(s!=null&&s.getStuPhonenum()!=null)return 1;
        else if(s!=null&&s.getStuPhonenum()!=null)return 2;
        else return 0;
    }
    @RequestMapping(value="/forget",method = RequestMethod.POST)
    public Integer Forget(String phone, String pwd){
        student s =studentRepo.findByStuPhonenum(phone);
        s.setStuPassword(pwd);
        studentRepo.saveAndFlush(s);
        return 1;
    }
}

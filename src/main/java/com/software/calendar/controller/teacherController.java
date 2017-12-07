package com.software.calendar.controller;

import com.software.calendar.bean.Result;
import com.software.calendar.bean.student;
import com.software.calendar.bean.teacher;
import com.software.calendar.controller.teacherController;
import com.software.calendar.repository.teacherRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class teacherController {
    @Autowired
    teacherRepository teacherRepo;

    /*查询所有用户*/
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result<teacher> list() {
        System.out.println("******查询所有教师******");
        List<teacher> list = teacherRepo.findAll();
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);

    }

    /*分页查询*/
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public Result<teacher>listPage(@RequestParam int pageNum ,int pageSize){
        System.out.println("******分页查询******");
        Pageable pageable=new PageRequest(pageNum,pageSize);
        Page<teacher> page = teacherRepo.findAll(pageable);
        System.out.println("本页总共有：" + page.getNumberOfElements() + "条数据");
        return ResultUtil.success(page);
    }

    /*增加一个用户*/
    @RequestMapping(value = "/{teacherUserid}",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@PathVariable("teacherUserid")String teacherUserid,@RequestBody teacher tea){
        System.out.println("******新增教师******");
        teacherRepo.save(tea);
        return ResultUtil.success();
    }

    /*批量增加用户*/
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public Result adds(@RequestBody teacher[] teaArray){
        System.out.println("******批量新增教师******");
        for (int i=0;i<teaArray.length;i++){
            teacherRepo.save(teaArray[i]);
        }
        return ResultUtil.success();
    }

    /*删除一个用户*/
    @RequestMapping(value = "/{teacherUserid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("teacherUserid")String teacherUserid){
        System.out.println("******删除教师******");
        //根据teacherUserid查询到要删除的列
        teacherRepo.delete(teacherUserid);
        return ResultUtil.success();

    }

    /*批量删除用户*/
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deletes(@RequestBody String[] teacherUseridArray){
        System.out.println("******批量删除教师******");
        //根据teacherUserid查询到要删除的列
        for (String teacherUserid : teacherUseridArray){
            try{
                teacherRepo.delete(teacherUserid);
            }catch (Exception e){
                return ResultUtil.error(400,"教师id不存在");
            }
        }
        return ResultUtil.success();
    }

    /*修改一个用户*/
    @RequestMapping(value = "/{teacherUserid}",method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable("teacherUserid")String teacherUserid,@RequestBody teacher tea){
        System.out.println("******更新教师******");
        teacherRepo.saveAndFlush(tea);
        return ResultUtil.success();
    }
}


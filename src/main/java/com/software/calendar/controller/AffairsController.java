package com.software.calendar.controller;

import com.software.calendar.bean.*;
import com.software.calendar.repository.AffairsRepository;
import com.software.calendar.repository.StaffairsRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/affairs")
public class AffairsController {
    @Autowired
    AffairsRepository affairsRepo;

    @Autowired
    StaffairsRepository staffairsRepo;

    //查询所有事务
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public Result<Affairs> list(){
        System.out.println("******查询所有事务******");
        List<Affairs> list = affairsRepo.findAll();
        System.out.println("总共查询到：" + list.size() + "条数据");
        return ResultUtil.success(list);
    }

    //增加一个事务
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Affairs affairs){
        System.out.println("******增加一个事务******");
        affairsRepo.save(affairs);
        return ResultUtil.success();
    }

    //事务与学生绑定
    @RequestMapping(value = "/{affairsId}",method = RequestMethod.POST)
    @ResponseBody
    public Result bind(@PathVariable("affairsId")Integer affairsId, @RequestBody String[] stuUseridArray){
        System.out.println("******事务与学生绑定******");
        for (String stuUserid : stuUseridArray){
            StudentsAffairs id=new StudentsAffairs();
            id.setAffairsId(affairsId);
            id.setStuUserid(stuUserid);

            Staffairs sa=new Staffairs();
            sa.setId(id);

            staffairsRepo.save(sa);
        }
        return ResultUtil.success();
    }

    //删除一个事务
    @RequestMapping(value = "/{affairsId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("affairsId")Integer affairsId){
        System.out.println("******删除一个事务******");
        affairsRepo.delete(affairsId);
        return ResultUtil.success();
    }
}

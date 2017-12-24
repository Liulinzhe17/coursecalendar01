package com.software.calendar.controller;

import com.software.calendar.bean.Classes;
import com.software.calendar.bean.Result;
import com.software.calendar.bean.Scalendar;
import com.software.calendar.bean.ScalendarReturn;
import com.software.calendar.repository.ClassesRepository;
import com.software.calendar.repository.ScalendarRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/scalendars")
public class ScalendarController {
    @Autowired
    ScalendarRepository scalendarRepo;

    /*根据校历id查询校历内容*/
    @RequestMapping(value = "/{scalendarId}",method = RequestMethod.GET)
    public Result<ScalendarReturn> get(@PathVariable("scalendarId")String scalendarId) {
        System.out.println("******根据校历id查询校历内容******");
        Scalendar sc = scalendarRepo.findOne(scalendarId);
        //返回给前台的数据模型
        ScalendarReturn sr = new ScalendarReturn();
        sr.setScalendarId(sc.getScalendarId());
        sr.setScalendarTermstart(sc.getScalendarTermstart());
        sr.setScalendarTermend(sc.getScalendarTermend());
        String[] holidayStrings;
        if (sc.getScalendarHoliday()!=null){
            holidayStrings = sc.getScalendarHoliday().split(",");
        }else {
            holidayStrings = new String[0];
        }

        List<String>holidayList = new ArrayList<String>();
        for (int i=0;i<holidayStrings.length;i++){
            holidayList.add(holidayStrings[i]);
        }
        sr.setScalendarHoliday(holidayList);
        return ResultUtil.success(sr);

    }

    /*更新校历内容*/
    @RequestMapping(value = "/{scalendarId}",method = RequestMethod.PUT)
    public Result put(@PathVariable("scalendarId")String scalendarId, @RequestBody ScalendarReturn sr){
        System.out.println("******更新校历内容******");
        Scalendar sc = new Scalendar();
        sc.setScalendarId(sr.getScalendarId());
        sc.setScalendarTermstart(sr.getScalendarTermstart());
        sc.setScalendarTermend(sr.getScalendarTermend());
        List<String>holidayList=sr.getScalendarHoliday();
        for (int i=0;i<holidayList.size();i++){
            if (i<1){
                sc.setScalendarHoliday(holidayList.get(i));
            }else {
                sc.setScalendarHoliday(sc.getScalendarHoliday()+","+holidayList.get(i));
            }

        }
        scalendarRepo.saveAndFlush(sc);
        return ResultUtil.success();
    }
}
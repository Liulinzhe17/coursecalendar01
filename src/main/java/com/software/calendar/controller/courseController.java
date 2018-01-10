package com.software.calendar.controller;

import com.software.calendar.bean.*;
import com.software.calendar.repository.courseRepository;
import com.software.calendar.repository.coursedataRepository;
import com.software.calendar.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/courses")
public class courseController {

    @Autowired
    courseRepository courseRepo;

    @Autowired
    coursedataRepository coursedataRepo;

    @Autowired
    studentRepository studentRepo;

    @RequestMapping(value="/findweek",method = RequestMethod.POST)

    public String findweek(String id){//这里的参数名要和ajax传过来的对应 查询单个课程的周数
        course c = courseRepo.findByCourseId(id);
        int start = c.getCourseWeekstart();
        int end = c.getCourseWeekend();
        return start+"-"+end;
    }

    @RequestMapping(value="/getheader",method = RequestMethod.POST)//查询单个课程的标题信息
    public course getheader(String cid){
        course c = courseRepo.findByCourseId(cid);
        return c;
    }
    @RequestMapping(value="/coursedata",method=RequestMethod.POST)//查询课程具体信息
    public coursedata coursedatas(String cid,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        return cd;
    }

    @RequestMapping(value="/teacherinfo",method=RequestMethod.POST)//查询对应课程的教师信息
    public Set<teacher> teacherinfo(String cid){
        course c = courseRepo.findByCourseId(cid);
        return c.getTeachers();
    }


    @RequestMapping(value="/updatec_outline",method=RequestMethod.POST)//更新大纲
    public int updatec_outline(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        System.out.println(cd.toString());
        cd.setCourseOutline(con);
        coursedataRepo.saveAndFlush(cd);
        return 1;
    }

    @RequestMapping(value="/updatec_homework",method=RequestMethod.POST)//更新作业
    public int updatec_homework(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        cd.setCourseHomework(con);
        coursedataRepo.saveAndFlush(cd);
        return 1;
    }

    @RequestMapping(value="/getallcourse",method = RequestMethod.POST)//所有课程
    public Set<course> getallcourse(String stuUserid){
        student stu = studentRepo.findByStuUserid(stuUserid);
        return stu.getCourses();
    }
    @RequestMapping(value="/stuUserid/weektime",method = RequestMethod.GET)//本周课程
    public Set<course> getcourses(String stuUserid,String weektime){
        int we = Integer.parseInt(weektime);
        student stu = studentRepo.findByStuUserid(stuUserid);
        Set<course> courses = stu.getCourses();
        Iterator<course> it = courses.iterator();
        for(int index=0;index<courses.size();index++){
            course nextc =  it.next();
            int weekstart = nextc.getCourseWeekstart();
            int weekend = nextc.getCourseWeekend();
            if(we<weekstart||we>weekend){
                it.remove();
                index--;
            }
        }
        return courses;
    }
    @RequestMapping(method = RequestMethod.GET)//查询所有课程
    public List<course> allcourses(){
        List<course> list = courseRepo.findAll();
        return list;
    }
    @RequestMapping(value = "/courseId",method = RequestMethod.GET)//查询单个详情
    public course getcourse(String courseId){
        return courseRepo.findByCourseId(courseId);
    }
    @RequestMapping(method = RequestMethod.POST)//新建课程
    public int addcourse(@RequestBody course c){
        System.out.println(c.toString());
        courseRepo.saveAndFlush(c);
        return 1;
    }
    @RequestMapping(method = RequestMethod.PUT)//更新课程
    public int updatecourse(@RequestBody course c){
        courseRepo.saveAndFlush(c);
        return 1;
    }
    @RequestMapping(value = "/courseId",method = RequestMethod.DELETE)//删除课程
    public int deletecourse(String courseId){
        courseRepo.delete(courseId);
        return 1;
    }
    @RequestMapping(method = RequestMethod.DELETE)//批量删除课程
    public int deletecourses(@RequestBody String[] courseIdArray){
        for (String courseId : courseIdArray){
            studentRepo.delete(courseId);
        }
        return 1;
    }
    public String dateToWeek(String datetime) {//日期格式转周几
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "1", "2", "3", "4", "5", "6", "7" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    @RequestMapping(value = "/busy",method = RequestMethod.GET)//单天是否忙碌
    public int busy(String date){
//        String s = dateToWeek("2017-01-01");
        Calendar start = Calendar.getInstance();
        start.set(2017, 0, 1);
        Long startTIme = start.getTimeInMillis();

        Calendar end = Calendar.getInstance();
        end.set(2017, 11, 30);
        Long endTime = end.getTimeInMillis();

        Long oneDay = 1000 * 60 * 60 * 24l;

        Long time = startTIme;
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(df.format(d));
            time += oneDay;
        }
        return 1;
    }
}

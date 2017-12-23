package com.software.calendar.controller;

import com.software.calendar.bean.*;
import com.software.calendar.repository.courseRepository;
import com.software.calendar.repository.coursedataRepository;
import com.software.calendar.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    public String findweek(String id){//这里的参数名要和ajax传过来的对应
        course c = courseRepo.findByCourseId(id);
        int start = c.getCourseWeekstart();
        int end = c.getCourseWeekend();
        return start+"-"+end;
    }

    @RequestMapping(value="/findcourse",method = RequestMethod.POST)
    public course findhea(String cid){
        course c = courseRepo.findByCourseId(cid);
        return c;
    }
    @RequestMapping(value="/coursedata",method=RequestMethod.POST)
    public coursedata coursedatas(String cid,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        return cd;
    }

    @RequestMapping(value="/teacherinfo",method=RequestMethod.POST)
    public Set<teacher> teacherinfo(String cid){
        course c = courseRepo.findByCourseId(cid);
        return c.getTeachers();
    }


    @RequestMapping(value="/updatec_outline",method=RequestMethod.POST)
    public int updatec_outline(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        System.out.println(cd.toString());
        cd.setCourseOutline(con);
        coursedataRepo.saveAndFlush(cd);
        return 1;
    }

    @RequestMapping(value="/updatec_homework",method=RequestMethod.POST)
    public int updatec_homework(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        cd.setCourseHomework(con);
        coursedataRepo.saveAndFlush(cd);
        return 1;
    }

    @RequestMapping(value="/getallcourse",method = RequestMethod.POST)
    public Set<course> getallcourse(String stuserid){
        student stu = studentRepo.findByStuUserid(stuserid);
        return stu.getCourses();
    }
    @RequestMapping(value="/stuUserid/weektime",method = RequestMethod.GET)//本周课程
    public Set<course> getcourses(String stuserid,String weektime){
        int we = Integer.parseInt(weektime);
        student stu = studentRepo.findByStuUserid(stuserid);
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
    @RequestMapping(value = "/courseId",method = RequestMethod.GET)//获取单个详情
    public course getcourse(String courseId){
        return courseRepo.findByCourseId(courseId);
    }
    @RequestMapping(method = RequestMethod.POST)//新建课程
    public int addcourse(@RequestBody course c){
        System.out.println(c.toString());
        courseRepo.saveAndFlush(c);
        return 1;
    }
    @RequestMapping(value = "/{courseId}",method = RequestMethod.PUT)//更新课程
    public int updatecourse(@PathVariable("courseId")String courseId,@RequestBody course c){
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
}

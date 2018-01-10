package com.software.calendar.controller;

import com.software.calendar.bean.*;
import com.software.calendar.repository.courseRepository;
import com.software.calendar.repository.coursedataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/course")
public class courseController {

    @Autowired
    courseRepository courseRepo;

    @Autowired
    coursedataRepository coursedataRepo;

    @RequestMapping(value="/findweek",method = RequestMethod.POST)

    public String Findweek(String id){//这里的参数名要和ajax传过来的对应
        course c = courseRepo.findByCourseId(id);
        int start = c.getCourseWeekstart();
        int end = c.getCourseWeekend();
        return start+"-"+end;
    }

    @RequestMapping(value="/findcourse",method = RequestMethod.POST)
    public course Findhea(String cid){
        course c = courseRepo.findByCourseId(cid);
        return c;
    }
    @RequestMapping(value="/finddata",method=RequestMethod.POST)
    public coursedata Finddata(String cid,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        return cd;
    }

    @RequestMapping(value="/findteacher",method=RequestMethod.POST)
    public Set<teacher> Findteacher(String cid){
        course c = courseRepo.findByCourseId(cid);
        return c.getTeachers();
    }


    @RequestMapping(value="/updatec_outline",method=RequestMethod.POST)
    public int Updatec_outline(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        System.out.println(cd.toString());
        cd.setCourseOutline(con);
        coursedataRepo.saveAndFlush(cd);
        return 1;
    }

    @RequestMapping(value="/updatec_homework",method=RequestMethod.POST)
    public int Updatec_homework(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        cd.setCourseHomework(con);
        coursedataRepo.saveAndFlush(cd);
        return 1;
    }

    @RequestMapping(value="/getallcourse",method = RequestMethod.POST)
    public course Getallcourse(String stuid){
        course c = courseRepo.findByCourseId(stuid);
        return c;
    }

    @RequestMapping(method = RequestMethod.GET)//查询所有课程
    public List<course> allcourses(){
        List<course> list = courseRepo.findAll();
        return list;
    }

}

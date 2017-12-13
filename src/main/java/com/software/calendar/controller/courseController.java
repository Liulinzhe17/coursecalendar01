package com.software.calendar.controller;


import com.software.calendar.bean.course;
import com.software.calendar.bean.coursedata;
import com.software.calendar.repository.courseRepository;
import com.software.calendar.repository.coursedataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/course")
public class courseController {

    @Autowired
    courseRepository courseRepo;

    @Autowired
    coursedataRepository coursedataRepo;

    @RequestMapping(value="/findweek",method = RequestMethod.POST)
    public String Findweek(String id){
        course c = courseRepo.findByCourseId(id);
        int start = c.getCourseWeekstart();
        int end = c.getCourseWeekend();
        return start+"-"+end;
    }

    @RequestMapping(value="/finddata",method=RequestMethod.POST)
    public coursedata Findcdata(String cid,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        return cd;
    }


    @RequestMapping(value="/updatec_outline",method=RequestMethod.POST)
    public int Updatec_outline(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        System.out.println(cd.toString());
//        cd.setCourseOutline(con);
        coursedataRepo.saveAndFlush(cd);

        return 1;
    }

    @RequestMapping(value="/updatec_homework",method=RequestMethod.POST)
    public int Updatec_homework(String cid,String con,String week){
        int we = Integer.parseInt(week);
        coursedata cd = coursedataRepo.findByCourseIdAndCourseWeektime(cid,we);
        System.out.println(cd.toString());
//        cd.setCourseHomework(con);
        coursedataRepo.saveAndFlush(cd);

        return 1;
    }
}

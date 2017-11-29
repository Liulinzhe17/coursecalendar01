package com.software.calendar.controller;

import com.software.calendar.bean.Result;
import com.software.calendar.bean.course;
import com.software.calendar.bean.student;
import com.software.calendar.repository.studentRepository;
import com.software.calendar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    /*分页查询*/
    @RequestMapping(value = "/listPage",method = RequestMethod.POST)
    @ResponseBody
    public Result<student>listPage(@RequestParam int pageNum ,int pageSize){
        System.out.println("******分页查询******");
        Pageable pageable=new PageRequest(pageNum,pageSize);
        Page<student> page = studentRepo.findAll(pageable);
        System.out.println("本页总共有：" + page.getNumberOfElements() + "条数据");
        return ResultUtil.success(page);
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

    /*判断一个用户空闲状态*/
    @RequestMapping(value = "/isFree",method = RequestMethod.POST)
    @ResponseBody
    public Result isFree(@RequestParam String stuUserid ,int weekday ,int start ,int end ,int week){
        System.out.println("******判断学生的空闲状态******");
        
        int status=1;//status=1表示有空，status=0表示没空。
        student stu=studentRepo.findByStuUserid(stuUserid);

        //若学生没课，直接return
        if (stu.getCourses().isEmpty()){
            return ResultUtil.success(status);
        }

        //若学生*weekday*一天没课，直接return
        for (course c : stu.getCourses()){
            //如果weekday有课即：星期有重叠
            if (c.getCourseWeek()==weekday){
                //将[start,end]放进arr1数组里
                int[] arr1=new int[end-start+1];
                for (int i=start,j=0;i<=end;i++,j++){
                    arr1[j]=i;
                }

                //将[timestart,timeend]放进arr2数组里
                int[] arr2=new int[c.getCourseTimeend()-c.getCourseTimestart()+1];
                for (int i=c.getCourseTimestart(),j=0;i<=c.getCourseTimeend();i++,j++){
                    arr2[j]=i;
                }

                //arr是有序数组的交集
                ArrayList<Integer> arr = new ArrayList<Integer>();
                int i = 0, j = 0;
                while (i < arr1.length && (j < arr2.length)) {
                    if (arr1[i] < arr2[j])
                        i++;
                    else if (arr1[i] > arr2[j])
                        j++;
                    else {
                        arr.add(arr1[i]); // 这里应该先加入，然后再加1
                        i++;j++;
                    }
                }
                //如果[start,end]和[timestart,timeend]的交集>0即：课程节数有重叠
                if (arr.size()>0){
                    //如果week在[weekstart,weekend]之内即：课程周重叠
                    if (c.getCourseWeekstart()<=week&&c.getCourseWeekend()>=week){
                        status=0;
                        return ResultUtil.success(status);
                    }
                }
            }
        }
        return ResultUtil.success(status);
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

package com.ldp.itcast.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.service.CourseService;
import com.ldp.itcast.util.ExcelDeal;

@Controller
public class CourseController {
	
	@Resource
	private CourseService service;
	
	/**
	 * 
	 * Course 注册方法
	 * @param course
	 * @param file
	 * @return
	 */
	@RequestMapping("/course/saveCourse.action")
	public String saveCourse(Course course,@RequestParam(value="file",required=true)MultipartFile file){
		int counts=0;
		if(!file.isEmpty()){
			System.out.println("找到文件:"+file.getOriginalFilename());
			ExcelDeal deal = new ExcelDeal();
			List<Course> courses = deal.readExcel(file);
			//保存到数据库
			for(Course course2:courses){
				System.out.println(course2.toString());
				//判断是否存在该数据
				int count = this.service.findCourseName(course2.getCname());
				if(count==0){
					this.service.saveCourse(course2);
					counts++;
				}else{
					continue;
				}
			}
			System.out.println("共保存数据数目为："+counts);
		}else{
			System.out.println("未找到文件,存储表单数据:");
			//保存到数据库
			System.out.println("表单数据 value:"+course.toString());
			this.service.saveCourse(course);
		}
		/*this.service.saveCourse(course);*/
		return "redirect:/course/toregister.action";
	}
	/*
	 * to jsp mapping
	 */
	@RequestMapping("/course/toregister.action")
	public String toCourseRegister(){
		return "/course/CourseRegister.jsp";
	}
	
	/***
	 * 
	 * 注册课程的时候检测是否已经存在该课程了
	 * @param name
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/course/result.action", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public boolean result(String name,HttpServletResponse response){
		System.out.println("Ajax获取值:"+name);
		System.out.println("11111");
		int result = this.service.findCourseName(name);
		/*response.setContentType("application/json;charset=UTF-8");*/
		/*response.setCharacterEncoding("UTF-8");*/
		System.out.println("查询条目数:"+result);
		if(result==1){
			return false;
		}
		return true;
	}
}

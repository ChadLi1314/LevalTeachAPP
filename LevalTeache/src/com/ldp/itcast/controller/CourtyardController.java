package com.ldp.itcast.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldp.itcast.domain.Courtyard;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.service.CourtyardService;

@Controller
public class CourtyardController {

	@Resource
	private CourtyardService service;
	
	//注册院级
	@RequestMapping("/courtyard/Register.action")
	public String toCourtyard(){
		System.out.println("已经转向");
		return "/Courtyard/CourtyardRegister.jsp";
		
	}
	
	@RequestMapping("/courtyard/insert.action")
	public String insertCourtyard(Courtyard courtyard){
		System.out.println(courtyard.toString());
		boolean result = this.service.insertCourtyard(courtyard);
		System.out.println(result);
		return "/Courtyard/CourtyardRegister.jsp";
	}
	
	//注册教师
	@RequestMapping("/teacher/save.action")
	public String saveTeacher(Teacher teacher,Integer i_id){
		teacher.setT_id(CreateTid());
		teacher.setPassword(String.valueOf(teacher.getT_id()));
		/*teacher.setI_id(i_id);*/
		System.out.println("得到数据:"+teacher.toString());
		System.out.println("得到数据i_id:"+i_id);
		Map map = new HashMap();
		map.put("teacher", teacher);
		map.put("i_id", i_id);
		boolean result = this.service.saveTeacher(map);
		System.out.println(result);
		return "redirect:/courtyard/TeacherRegister.action";
	}
	
	@RequestMapping("/courtyard/TeacherRegister.action")
	public String findAllcoutyard(Model model){
		List<Courtyard> list = this.service.findCourtyardAll();
		for(Courtyard courtyard:list){
			System.out.println(courtyard.toString());
		}
		model.addAttribute("courtyard", list);
		return "/teacher/TeacherRegister.jsp";
	}
	
	//测试错误页面
	
	@RequestMapping("/teacher/403.action")
	public String to403(){
		return "/error/403.jsp";
	}
	@RequestMapping("/teacher/404.action")
	public String to404(){
		return "/error/404.jsp";
	}
	@RequestMapping("/teacher/405.action")
	public String to405(){
		return "/error/405.jsp";
	}
	
	public int CreateTid(){
		int count=0,r;
		StringBuffer str = new StringBuffer();
		Random random = new Random();
		while(count<6){
			r=random.nextInt(10);
			System.out.println(r+"  "+count);
			str.append(r);
			count++;
		}
		int i = Integer.parseInt(str.toString());
		Teacher teacher = this.service.findTeacherId(i);
		if(teacher==null){
			return i;
		}else{
			CreateTid();
		}
		return 0;
	}
	
}

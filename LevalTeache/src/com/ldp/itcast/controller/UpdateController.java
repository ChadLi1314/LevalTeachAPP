package com.ldp.itcast.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldp.itcast.domain.Courtyard;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.service.CourtyardService;

@Controller
public class UpdateController {
	
	@Resource
	private CourtyardService service;
	

	/***
	 * 
	 * 获取院级信息，返回给更新页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/update/update.action")
	public String update(Model model){
		List<Courtyard> courtyards = this.service.findCourtyardAll();
		for(Courtyard courtyard:courtyards){
			System.out.println(courtyard.toString());
		}
		model.addAttribute("courtyard", courtyards);
		return "/all/Update.jsp";
	}
	
	/**
	 * 
	 * Ajax发送ID过来，获得教师信息Json返回前台显示
	 * @param i_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update/i_id.action", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public List<Teacher> findI_id(Integer i_id){
		System.out.println(i_id);
		List<Teacher> teachers = this.service.findTeacherList(i_id);
		for(Teacher teacher:teachers){
			System.out.println(teacher.toString());
		}
		return teachers;
	}
	/**
	 * 
	 * 选择了教师，得到教师信息返回到更新页面
	 * @param t_id
	 * @return
	 */
	@RequestMapping("/update/teacherT_id.action")
	public String teacherT_id(Integer t_id,Model model){
		System.out.println(t_id);
		Teacher teacher = this.service.findTeacherId(t_id);
		System.out.println(teacher.toString());
		model.addAttribute("teacher", teacher);
		return "/teacher/TeacherUpdate.jsp";
	}
	
	/**
	 * 更新教师信息
	 * @param teacher
	 * @return
	 */
	@RequestMapping("/update/teacherupdate.action")
	public String teacherupdate(Teacher teacher){
		System.out.println(teacher.toString());
		boolean result = this.service.updateTeacherT_id(teacher);
		System.out.println("更新结果:"+result);
		return "redirect:/update/update.action";
	}
}

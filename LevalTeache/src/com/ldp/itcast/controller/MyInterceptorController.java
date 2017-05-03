package com.ldp.itcast.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ldp.itcast.domain.Manager;
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.domain.Teacher;
import com.sun.xml.internal.ws.api.pipe.NextAction;

public class MyInterceptorController implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
			// TODO Auto-generated method stub
			System.out.println("◊Ó÷’¿πΩÿ!");
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("∫Û÷√¿πΩÿ!");
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("«∞÷√¿πΩÿ!");
		Student student = (Student) request.getSession().getAttribute("student");
		Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		if(student!=null){
			return true;
		}
		if(teacher!=null){
			return true;
		}
		if(manager!=null){
			return true;
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return true;
	}

}

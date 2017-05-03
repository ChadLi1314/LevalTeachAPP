package com.ldp.itcast.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("HelloTestController")
public class TestController {

	/**
	 * android ²âÊÔ
	 */
	@RequestMapping(value="/hello.action",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public Object hello(String username,Integer password){
		System.out.println("½øÀ´ÁË......"+username+" || "+password);
		return "hello springmv--->android";
		
	}
}

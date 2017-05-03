package com.ldp.itcast.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ldp.itcast.domain.Student;
import com.ldp.itcast.service.StudentService;
import com.ldp.itcast.util.ExcelDeal;

@Controller
public class StudentController {

	@Resource
	private StudentService service;
	
	//controller在加载的时候，会同时创建/user/list;/user/list.action
	//所以无论加不加.action都可以访问得到和web.xml中配置的.action无关
	@RequestMapping("/student/list.action")
	public String StudentTest(Model model){
		List<Student> list = this.service.findStudent(null);
		for(Student student:list){
			System.out.println(student.toString());
		}
		model.addAttribute("studentList", list);
		System.err.println("Over Controller Method！");
		return "/student/listTest.jsp";
	}
	
	
	//注册学生信息
	/**
	 * save all student
	 */
	@RequestMapping("/student/save.action")
	public String saveStudent(Student student,@RequestParam(value="file",required=true)MultipartFile file){
		System.out.println(file.getOriginalFilename());
		student.setStatus(0);
		System.out.println(student.toString());
		boolean result=false;
		int counts=0;
		if(!file.isEmpty()){
			//解析excel文件并得到结果
			System.out.println("找到文件"+file.getOriginalFilename());
			ExcelDeal deal = new ExcelDeal();
			List<Student> students = deal.readExcelWithOldVersion(file);
			//保存到数据库
			for(Student student2 : students){
				System.out.println("解析出对象:"+student2.toString());
				//判断是否存在该数据
				int count = this.service.findStudentCount(student2.getS_id());
				if(count==0){
					result = this.service.saveStudentAll(student2);
					counts++;
				}else{
					continue;
				}
			}
			System.out.println("共记录数据条数:"+counts);
		}else{
			System.out.println("未找到文件,存储表单数据:");
			//保存到数据库
			if(student.getS_id()==null){
				System.out.println("也没有得到表单数据!");
			}else{
				result = this.service.saveStudentAll(student);
			}
		}
		//转化为file
		/*CommonsMultipartFile multipartFile = (CommonsMultipartFile) file;
		DiskFileItem diskFileItem = (DiskFileItem) multipartFile.getFileItem();
		File file2 = diskFileItem.getStoreLocation(); 经过测试会出现NullPointException异常*/
		System.out.println("saveStudent result："+result);
		return "/student/StudentRegister.jsp";
	}
	
	
	
	
	/*
	 * into jsp method
	 */
	@RequestMapping("/student/toStudentRegister.action")
	public String toStudentRegister(){
		return "/student/StudentRegister.jsp";
	}
}

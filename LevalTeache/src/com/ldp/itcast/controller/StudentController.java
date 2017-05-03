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
	
	//controller�ڼ��ص�ʱ�򣬻�ͬʱ����/user/list;/user/list.action
	//�������ۼӲ���.action�����Է��ʵõ���web.xml�����õ�.action�޹�
	@RequestMapping("/student/list.action")
	public String StudentTest(Model model){
		List<Student> list = this.service.findStudent(null);
		for(Student student:list){
			System.out.println(student.toString());
		}
		model.addAttribute("studentList", list);
		System.err.println("Over Controller Method��");
		return "/student/listTest.jsp";
	}
	
	
	//ע��ѧ����Ϣ
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
			//����excel�ļ����õ����
			System.out.println("�ҵ��ļ�"+file.getOriginalFilename());
			ExcelDeal deal = new ExcelDeal();
			List<Student> students = deal.readExcelWithOldVersion(file);
			//���浽���ݿ�
			for(Student student2 : students){
				System.out.println("����������:"+student2.toString());
				//�ж��Ƿ���ڸ�����
				int count = this.service.findStudentCount(student2.getS_id());
				if(count==0){
					result = this.service.saveStudentAll(student2);
					counts++;
				}else{
					continue;
				}
			}
			System.out.println("����¼��������:"+counts);
		}else{
			System.out.println("δ�ҵ��ļ�,�洢������:");
			//���浽���ݿ�
			if(student.getS_id()==null){
				System.out.println("Ҳû�еõ�������!");
			}else{
				result = this.service.saveStudentAll(student);
			}
		}
		//ת��Ϊfile
		/*CommonsMultipartFile multipartFile = (CommonsMultipartFile) file;
		DiskFileItem diskFileItem = (DiskFileItem) multipartFile.getFileItem();
		File file2 = diskFileItem.getStoreLocation(); �������Ի����NullPointException�쳣*/
		System.out.println("saveStudent result��"+result);
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

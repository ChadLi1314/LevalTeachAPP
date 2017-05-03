package com.ldp.itcast.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Student;

public class ExcelDeal {
	
	/*CELL_TYPE_NUMERIC 数值型 0
	CELL_TYPE_STRING 字符串型 1
	CELL_TYPE_FORMULA 公式型 2
	CELL_TYPE_BLANK 空值 3
	CELL_TYPE_BOOLEAN 布尔型 4
	CELL_TYPE_ERROR 错误 5*/
	
	/*@Test
	public void readExcelWithOldVersion(){
		try {
			//java 工程下的java文件要访问WebRoot下的文件，必须使用绝对路径new File("WebRoot/file/2.xlsx")
			Workbook workbook = WorkbookFactory.create(new FileInputStream(new File("WebRoot/file/2.xlsx")));
			int sheetNum = workbook.getNumberOfSheets();//得到工作薄总量
			List<Student> list = new ArrayList<Student>();
			for(int i=0;i<sheetNum;i++){
				Sheet sheet = workbook.getSheetAt(i);//得到工作薄
				if(sheet==null){
					continue;
				}
				System.out.println("This is "+i+" 工作薄!开始解析Excel表格");
				int rowNum = sheet.getLastRowNum()+1;//or sheet.getPhysicalNumberOfRows()得到总行数
				for(int j=1;j<rowNum;j++){
					Row row = sheet.getRow(j);
					if(row==null){
						continue;
					}
					StringBuffer buffer = new StringBuffer();
					String[] str1 = null;
					int cellsNum = row.getLastCellNum()+1;//or row.getPhysicalNumberOfCells()得到总的列单元
					for(int k=0;k<cellsNum;k++){
						Cell cell = row.getCell(k);
						if(cell==null){
							continue;
						}
						cell.setCellType(1);
						System.out.println(j+" 行-"+k+" 列:"+"cell String 类型："+cell.getStringCellValue());
						buffer.append(cell.getStringCellValue()+" ");
						String str = buffer.toString();
						str1 = str.split(" ");
					}
					Student student = new Student();
					student.setS_id(Integer.parseInt(str1[0]));
					student.setSname(str1[1]);
					student.setSex(str1[2]);
					student.setGrade(str1[3]);
					student.setStatus(0);
					list.add(student);
				}
				System.out.println();
			}
			
			for(Student student:list){
				System.out.println(student.toString());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	public List<Course> readExcel(MultipartFile file){
		try {
			//java 工程下的java文件要访问WebRoot下的文件，必须使用绝对路径new File("WebRoot/file/1.xls")
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			int sheetNum = workbook.getNumberOfSheets();//得到工作薄总量
			List<Course> list = new ArrayList<Course>();
			for(int i=0;i<sheetNum;i++){
				Sheet sheet = workbook.getSheetAt(i);//得到工作薄
				if(sheet==null){
					continue;
				}
				System.out.println("This is "+i+" 工作薄!开始解析Excel表格");
				int rowNum = sheet.getLastRowNum()+1;//or sheet.getPhysicalNumberOfRows()得到总行数
				for(int j=1;j<rowNum;j++){
					Row row = sheet.getRow(j);
					if(row==null){
						continue;
					}
					int cellsNum = row.getLastCellNum()+1;//or row.getPhysicalNumberOfCells()得到总的列单元
					for(int k=0;k<cellsNum;k++){
						Cell cell = row.getCell(k);
						if(cell==null){
							continue;
						}
						cell.setCellType(1);
						System.out.println(j+" 行-"+k+" 列:"+"cell String 类型："+cell.getStringCellValue());
						Course course = new Course();
						course.setCname(cell.getStringCellValue());
						list.add(course);
					}
				}
				System.out.println();
			}
			for(Course course:list){
				System.out.println("解析成功，并成功addList:"+course.toString());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public List<Student> readExcelWithOldVersion(MultipartFile file){
		try {
			//java 工程下的java文件要访问WebRoot下的文件，必须使用绝对路径new File("WebRoot/file/2.xlsx")
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			int sheetNum = workbook.getNumberOfSheets();//得到工作薄总量
			List<Student> list = new ArrayList<Student>();
			for(int i=0;i<sheetNum;i++){
				Sheet sheet = workbook.getSheetAt(i);//得到工作薄
				if(sheet==null){
					continue;
				}
				System.out.println("This is "+i+" 工作薄!开始解析Excel表格");
				int rowNum = sheet.getLastRowNum()+1;//or sheet.getPhysicalNumberOfRows()得到总行数
				for(int j=1;j<rowNum;j++){
					Row row = sheet.getRow(j);
					if(row==null){
						continue;
					}
					StringBuffer buffer = new StringBuffer();
					String[] str1 = null;
					int cellsNum = row.getLastCellNum()+1;//or row.getPhysicalNumberOfCells()得到总的列单元
					for(int k=0;k<cellsNum;k++){
						Cell cell = row.getCell(k);
						if(cell==null){
							continue;
						}
						cell.setCellType(1);
						System.out.println(j+" 行-"+k+" 列:"+"cell String 类型："+cell.getStringCellValue());
						buffer.append(cell.getStringCellValue()+" ");
						String str = buffer.toString();
						str1 = str.split(" ");
					}
					Student student = new Student();
					student.setS_id(Integer.parseInt(str1[0]));
					student.setSname(str1[1]);
					student.setSex(str1[2]);
					student.setGrade(str1[3]);
					student.setStatus(0);
					student.setPassword(str1[0]);
					list.add(student);
				}
				System.out.println();
			}
			
			for(Student student:list){
				System.out.println(student.toString());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

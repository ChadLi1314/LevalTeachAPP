package com.ldp.itcast.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.ldp.itcast.domain.Analyzes;

public class ExcelDesk {
	
	/**
	 * 创建03版excel 格式为:xls
	 */
	public void createExcelWithOldVersion(List<Analyzes> analyzes){
		//1.create excel and open .xls file
		Workbook workbook = new HSSFWorkbook();
		try {
			// 2.文件流
			FileOutputStream outputStream = new FileOutputStream(new File("C:/Users/Administrator/Desktop/1.xls"));
			// 3.创建工作薄
			Sheet sheet1 = workbook.createSheet("Sheet 1");
			//4.在第一个工作薄的基础上创建第一行
			Row row2 = sheet1.createRow((short)0);
			Cell cell11 = row2.createCell(0);
			Cell cell12 = row2.createCell(1);
			Cell cell13 = row2.createCell(2);
			Cell cell14 = row2.createCell(3);
			cell11.setCellValue("教师ID");
			cell12.setCellValue("分数");
			cell13.setCellValue("院系");
			cell14.setCellValue("排名");
			int count =1;
			
			for(int i=0;i<analyzes.size();i++){
				Row row1 = sheet1.createRow(count);
				Analyzes analyzes2 = analyzes.get(i);
				//5.在第一行的基础上创建一列单元格
				Cell cell1 = row1.createCell(0);
				cell1.setCellValue(analyzes2.getA_id());
				Cell cell2 = row1.createCell(1);
				cell2.setCellValue(analyzes2.getResult());
				Cell cell3 = row1.createCell(2);
				cell3.setCellValue(analyzes2.getIname());
				Cell cell4 = row1.createCell(3);
				cell4.setCellValue(count);
				count++;
			}
			
			// Excel对象输出   关闭Excel对象   关闭文件流
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			CreateExcelWithNewVersion(analyzes);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void CreateExcelWithNewVersion(List<Analyzes> analyzes){
		//创建Excel对象create excel and open .xlsx file
		Workbook workbook = new XSSFWorkbook();	//03版和07版不同也就在这里workbook
		try {
			//创建文件流
			FileOutputStream outputStream = new FileOutputStream(new File("C:/Users/Administrator/Desktop/2.xlsx"));
			//创建工作薄
			Sheet sheet1 = workbook.createSheet("Sheet1");
			//创建一行
			Row row2 = sheet1.createRow((short)0);
			Cell cell11 = row2.createCell(0);
			Cell cell12 = row2.createCell(1);
			Cell cell13 = row2.createCell(2);
			Cell cell14 = row2.createCell(3);
			cell11.setCellValue("教师ID");
			cell12.setCellValue("分数");
			cell13.setCellValue("院系");
			cell14.setCellValue("排名");
			int count =1;
			//加入数据
			for(int i=0;i<analyzes.size();i++){
				Row row1 = sheet1.createRow(count);
				Analyzes analyzes2 = analyzes.get(i);
				//5.在第一行的基础上创建一列单元格
				Cell cell1 = row1.createCell(0);
				cell1.setCellValue(analyzes2.getA_id());
				Cell cell2 = row1.createCell(1);
				cell2.setCellValue(analyzes2.getResult());
				Cell cell3 = row1.createCell(2);
				cell3.setCellValue(analyzes2.getIname());
				Cell cell4 = row1.createCell(3);
				cell4.setCellValue(count);
				count++;
			}
		
			//Excel对象输出	
			workbook.write(outputStream); 
			//关闭Excel对象
			workbook.close();
			//关闭文件流
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

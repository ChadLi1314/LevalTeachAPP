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
	 * ����03��excel ��ʽΪ:xls
	 */
	public void createExcelWithOldVersion(List<Analyzes> analyzes){
		//1.create excel and open .xls file
		Workbook workbook = new HSSFWorkbook();
		try {
			// 2.�ļ���
			FileOutputStream outputStream = new FileOutputStream(new File("C:/Users/Administrator/Desktop/1.xls"));
			// 3.����������
			Sheet sheet1 = workbook.createSheet("Sheet 1");
			//4.�ڵ�һ���������Ļ����ϴ�����һ��
			Row row2 = sheet1.createRow((short)0);
			Cell cell11 = row2.createCell(0);
			Cell cell12 = row2.createCell(1);
			Cell cell13 = row2.createCell(2);
			Cell cell14 = row2.createCell(3);
			cell11.setCellValue("��ʦID");
			cell12.setCellValue("����");
			cell13.setCellValue("Ժϵ");
			cell14.setCellValue("����");
			int count =1;
			
			for(int i=0;i<analyzes.size();i++){
				Row row1 = sheet1.createRow(count);
				Analyzes analyzes2 = analyzes.get(i);
				//5.�ڵ�һ�еĻ����ϴ���һ�е�Ԫ��
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
			
			// Excel�������   �ر�Excel����   �ر��ļ���
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
		//����Excel����create excel and open .xlsx file
		Workbook workbook = new XSSFWorkbook();	//03���07�治ͬҲ��������workbook
		try {
			//�����ļ���
			FileOutputStream outputStream = new FileOutputStream(new File("C:/Users/Administrator/Desktop/2.xlsx"));
			//����������
			Sheet sheet1 = workbook.createSheet("Sheet1");
			//����һ��
			Row row2 = sheet1.createRow((short)0);
			Cell cell11 = row2.createCell(0);
			Cell cell12 = row2.createCell(1);
			Cell cell13 = row2.createCell(2);
			Cell cell14 = row2.createCell(3);
			cell11.setCellValue("��ʦID");
			cell12.setCellValue("����");
			cell13.setCellValue("Ժϵ");
			cell14.setCellValue("����");
			int count =1;
			//��������
			for(int i=0;i<analyzes.size();i++){
				Row row1 = sheet1.createRow(count);
				Analyzes analyzes2 = analyzes.get(i);
				//5.�ڵ�һ�еĻ����ϴ���һ�е�Ԫ��
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
		
			//Excel�������	
			workbook.write(outputStream); 
			//�ر�Excel����
			workbook.close();
			//�ر��ļ���
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

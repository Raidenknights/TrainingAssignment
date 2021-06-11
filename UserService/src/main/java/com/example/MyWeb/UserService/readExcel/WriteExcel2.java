package com.example.MyWeb.UserService.readExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;

public class WriteExcel2 {
	public void outputFile(ArrayList<String> arr1,ArrayList<String> arr2) throws IOException {
		HashMap<Integer,String> hsmp1 = new HashMap<Integer,String>();
		
		for(int i=0;i<arr2.size();i++) {
			hsmp1.put(i,"White");
		}
		
		for(int i=1;i<arr2.size();i++) {
			if(arr1.contains(arr2.get(i))) {
				hsmp1.put(i,"Green");
			}
			for(int j=1;j<arr2.size();j++) {
				String input =arr2.get(i);
				System.out.println(input+" "+i+" "+arr2.get(j) );
				if(i==j)
					continue;
				if(input.equals(arr2.get(j))) {
					if(arr2.contains(arr2.get(j))) {
						hsmp1.put(i, "Red");
					}
					else
						hsmp1.put(i, "Blue");
				}
			}
		}
		
		try {
			String filename="C:/Users/manas/Desktop/Output2.xls";
			HSSFWorkbook workbook1 = new HSSFWorkbook();
			HSSFSheet sheet = workbook1.createSheet("January");  
			 //HSSFCellStyle my_style = workbook.createCellStyle();
			/*HSSFFont my_font=workbook.createFont();
			 HSSFFont my_font1=workbook.createFont();
			 HSSFFont my_font2=workbook.createFont();*/
			 HSSFFont my_font3=workbook1.createFont();
			 HSSFFont my_font4=workbook1.createFont();
			 HSSFFont my_font5=workbook1.createFont();
			
			//INSERTING VALUES FOR INPUT2.xlsx
			for(int i=0;i<arr2.size();i++) {
				HSSFRow rowhead1 = sheet.createRow(i);
				Cell cell1 =rowhead1.createCell(2);
				if(hsmp1.get(i).equals("Red")) {
					 HSSFCellStyle my_style = workbook1.createCellStyle();
					my_font3.setColor(IndexedColors.RED.getIndex());
					my_style.setFont(my_font3);
					cell1.setCellStyle(my_style);
					cell1.setCellValue(arr2.get(i));
				}
				
				else if(hsmp1.get(i).equals("Blue")) {
					 HSSFCellStyle my_style = workbook1.createCellStyle();
					my_font4.setColor(IndexedColors.BLUE.getIndex());
					my_style.setFont(my_font4);
					
					cell1.setCellStyle(my_style);
					cell1.setCellValue(arr2.get(i));
				}
				else if(hsmp1.get(i).equals("Green")) {
					 HSSFCellStyle my_style = workbook1.createCellStyle();
					my_font5.setColor(IndexedColors.GREEN.getIndex());
					my_style.setFont(my_font5);
					
					cell1.setCellStyle(my_style);
					cell1.setCellValue(arr2.get(i));
				}
				else
					cell1.setCellValue(arr2.get(i));
				
			}
			
			//rowhead.createCell(0).setCellValue("Output");
			FileOutputStream fileOut = new FileOutputStream(filename);  
			workbook1.write(fileOut);  
			//closing the Stream  
			fileOut.close();  
			//closing the workbook  
			workbook1.close();  
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

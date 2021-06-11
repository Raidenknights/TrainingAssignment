package com.example.MyWeb.UserService.readExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class WriteExcel {
	public void outputFile(ArrayList<String> arr1,ArrayList<String> arr2) throws IOException {
				
				//creating new maps
				HashMap<Integer,String> hsmp = new HashMap<Integer,String>();
				HashMap<Integer,String> hsmp1 = new HashMap<Integer,String>();
				
				//Initialize all maps with White
				for(int i=0;i<arr1.size();i++) {
					hsmp.put(i,"White");
				}
				for(int i=0;i<arr2.size();i++) {
					hsmp1.put(i,"White");
				}
				
				
				//finding Different types of Duplicates for Input1
				for(int i=1;i<arr1.size();i++) {
					if(arr2.contains(arr1.get(i))) {
						hsmp.put(i,"Green");
					}
					for(int j=1;j<arr1.size();j++) {
						String input =arr1.get(i);
						System.out.println(input+" "+i+" "+arr1.get(j) );
						if(i==j)
							continue;
						if(input.equals(arr1.get(j))) {
							if(arr2.contains(arr1.get(j))) {
								hsmp.put(i, "Red");
							}
							else
								hsmp.put(i, "Blue");
						}
					}
				}
				
				//Finding different types of Duplicates for Input2
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
							if(arr1.contains(arr2.get(j))) {
								hsmp1.put(i, "Red");
							}
							else
								hsmp1.put(i, "Blue");
						}
					}
				}
				
				//Printing Hashmaps for better clarity
				System.out.println(hsmp);
				System.out.println(hsmp1);
				
				//Finding greater size ArrayList
				int size=0;
				if(arr1.size()>=arr2.size())
					size=arr1.size();
				else
					size=arr2.size();
				
				//Inserting in excel
				try {
				
				//Name and Place of Output file
				String filename="C:/Users/manas/Desktop/Output1.xls";
				HSSFWorkbook workbook = new HSSFWorkbook(); 
				HSSFSheet sheet = workbook.createSheet("January");  
				 HSSFFont my_font=workbook.createFont();
				 HSSFFont my_font1=workbook.createFont();
				 HSSFFont my_font2=workbook.createFont();

				 
				 //INSERTING VALUES FOR INPUT1.xlsx
				for(int i=0;i<size;i++) {
					HSSFRow rowhead = sheet.createRow(i);
					Cell cell =rowhead.createCell(1);
					Cell cell1 =rowhead.createCell(2);
					
					
					if(i<arr1.size())
					{
					if(hsmp.get(i).equals("Red")) {
						 HSSFCellStyle my_style = workbook.createCellStyle();
						my_font.setColor(IndexedColors.RED.getIndex());
						my_style.setFont(my_font);
						cell.setCellStyle(my_style);
						cell.setCellValue(arr1.get(i));
						
					}
					
					else if(hsmp.get(i).equals("Blue")) {
						 HSSFCellStyle my_style = workbook.createCellStyle();
						my_font1.setColor(IndexedColors.BLUE.getIndex());
						my_style.setFont(my_font1);
						
						cell.setCellStyle(my_style);
						cell.setCellValue(arr1.get(i));

					}
					else if(hsmp.get(i).equals("Green")) {
						 HSSFCellStyle my_style = workbook.createCellStyle();
						my_font2.setColor(IndexedColors.GREEN.getIndex());
						my_style.setFont(my_font2);
						
						cell.setCellStyle(my_style);
						cell.setCellValue(arr1.get(i));

					}
					else
						cell.setCellValue(arr1.get(i));
					}
					
					//Will enter the condition on if size is less than 
					if(i<arr2.size())
					{
					if(hsmp1.get(i).equals("Red") && hsmp1.get(i)!=null ) {
						 HSSFCellStyle my_style = workbook.createCellStyle();
							my_font.setColor(IndexedColors.RED.getIndex());
							my_style.setFont(my_font);
							cell1.setCellStyle(my_style);
							cell1.setCellValue(arr2.get(i));
					}
					else if(hsmp1.get(i).equals("Blue") && hsmp1.get(i)!=null) {
						 HSSFCellStyle my_style = workbook.createCellStyle();
							my_font1.setColor(IndexedColors.BLUE.getIndex());
							my_style.setFont(my_font1);
							cell1.setCellStyle(my_style);
							cell1.setCellValue(arr2.get(i));
					}
					else if(hsmp1.get(i).equals("Green") && hsmp1.get(i)!=null) {
						 HSSFCellStyle my_style = workbook.createCellStyle();
							my_font2.setColor(IndexedColors.GREEN.getIndex());
							my_style.setFont(my_font2);
							cell1.setCellStyle(my_style);
							cell1.setCellValue(arr2.get(i));
					}
					else 
						cell1.setCellValue(arr2.get(i));
					}

				FileOutputStream fileOut = new FileOutputStream(filename);  
				workbook.write(fileOut);  
				//closing the Stream  
				fileOut.close();  
				//closing the workbook  
				workbook.close();  
			}}
			catch(Exception e) {
				System.out.println(e);
			}

	}

}

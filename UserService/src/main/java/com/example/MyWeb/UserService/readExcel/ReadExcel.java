package com.example.MyWeb.UserService.readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	 public static void main(String args[]) {
			try {
				File file = new File("C:/Users/manas/Desktop/Input1.xlsx");
				File file2 = new File("C:/Users/manas/Desktop/Input2.xlsx");
				FileInputStream fis = new FileInputStream(file);
				FileInputStream fis2 = new FileInputStream(file2);
				
				XSSFWorkbook wb=new XSSFWorkbook(fis);
				XSSFWorkbook wb1 = new XSSFWorkbook(fis2);
				
				XSSFSheet sheet=wb.getSheetAt(0); 
				XSSFSheet sheet1=wb1.getSheetAt(0);
				
				
				ArrayList<String> arr = new ArrayList<String>();
				ArrayList<String> arr1 = new ArrayList<String>();
				
				Iterator<Row> itr = sheet.iterator();
				while(itr.hasNext()) { 
					Row row = itr.next();  
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						System.out.println(cell.toString());
						arr.add(cell.toString());
					}
				}
				Iterator<Row> itr1 = sheet1.iterator();
				while(itr1.hasNext()) {
					Row row1= itr1.next();
					Iterator<Cell> cellIterator = row1.cellIterator();
					while(cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						System.out.println(cell.toString());
						arr1.add(cell.toString());
					}
				}
				System.out.println(arr1);
				System.out.println(arr);
				WriteExcel wrec = new WriteExcel();
				//WriteExcel2 wrec1 = new WriteExcel2();
				wrec.outputFile(arr,arr1);
				//wrec1.outputFile(arr, arr1);
				wb.close();
				wb1.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
	 }
}

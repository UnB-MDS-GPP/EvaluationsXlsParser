package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import reader.ExcelFileReader;
import reader.ListFiles;
import reader.XlsRowFieldsStorage;

public class TestExcelFileReader {
	private ExcelFileReader rowFieldStorage;
	
	@Before
	public void setUp() throws Exception {
		this.rowFieldStorage = new ExcelFileReader();
	}

	@Test
	public void shouldGetAreaReview() throws IOException{
		ExcelFileReader excelFR = new ExcelFileReader();
		ExcelFileReader excelFR_2 = new ExcelFileReader();
		
		excelFR.setFileName("./src/xls/2007/Antropologia_Arqueologia.xls");
		excelFR.setYear(2007);
		
		excelFR_2.setFileName("./src/xls/2010/Artes_Musica.xls");
		excelFR_2.setYear(2010);
		
		assertEquals(excelFR.getAreaReview(),"ANTROPOLOGIA / ARQUEOLOGIA");
		assertEquals(excelFR_2.getAreaReview(),"ARTES / MÚSICA");	
	}
	/*
	@Test
	public void shouldGetEvaluationFromXlsFile(){
		ArrayList<String> files = ListFiles.getAllXlsFilesFromFolder("../xls/2007/");
		File folder = new File(path);
		assertEquals(0, files.size());
	}*/

}

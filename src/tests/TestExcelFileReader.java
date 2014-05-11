package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import reader.ExcelFileReader;

public class TestExcelFileReader {
	private ExcelFileReader rowFieldStorage;

	@Before
	public void setUp() throws Exception {
		this.rowFieldStorage = new ExcelFileReader();
	}

	@Test
	public void shouldGetAreaReview() throws IOException{
		ExcelFileReader excelFR_1 = new ExcelFileReader();
		ExcelFileReader excelFR_2 = new ExcelFileReader();

		excelFR_1.setFileName("./src/xls/2007/Antropologia_Arqueologia.xls");
		excelFR_1.setYear(2007);

		excelFR_2.setFileName("./src/xls/2010/Artes_Musica.xls");
		excelFR_2.setYear(2010);

		assertEquals(excelFR_1.getAreaReview(),"ANTROPOLOGIA / ARQUEOLOGIA");
		assertEquals(excelFR_2.getAreaReview(),"ARTES / MÚSICA");	
	}

	@Test
	public void shouldGetEvaluationFromXlsFile() throws IOException{
		ExcelFileReader excelFR_1 = new ExcelFileReader();
		ExcelFileReader excelFR_2 = new ExcelFileReader();

		excelFR_1.setFileName("./src/xls/2007/Antropologia_Arqueologia.xls");
		excelFR_1.setYear(2007);

		excelFR_2.setFileName("./src/xls/2010/Direito.xls");
		excelFR_2.setYear(2010);

		assertEquals("./src/xls/2007/Antropologia_Arqueologia.xls", excelFR_1.getFileName());
		assertEquals(2007, excelFR_1.getYear());

		assertEquals(excelFR_1.getEvaluationFromXslFile().get(0).getAcronym(), "UFRJ");
		assertEquals(excelFR_1.getEvaluationFromXslFile().get(0).getName(), "ANTROPOLOGIA SOCIAL");

		assertEquals(excelFR_1.getEvaluationFromXslFile().get(14).getAcronym(), "UFRJ");
		assertEquals(excelFR_1.getEvaluationFromXslFile().get(14).getName(), "ARQUEOLOGIA");

		assertEquals(excelFR_2.getEvaluationFromXslFile().get(0).getAcronym(), "PUC/SP");
		assertEquals(excelFR_2.getEvaluationFromXslFile().get(0).getName(), "DIREITO");

		assertEquals(excelFR_2.getEvaluationFromXslFile().get(58).getAcronym(), "URI");
		assertEquals(excelFR_2.getEvaluationFromXslFile().get(58).getName(), "DIREITO");
	}
}

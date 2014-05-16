package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import main.Generator;

public class TestGenerator {

	@Test
	public void shouldgenerateDataFromYear() {
		Generator gen = new Generator();

		assertEquals(true, gen.generateDataFromYear(2000));
		assertEquals(false, gen.generateDataFromYear(3000));
	}

	@Test
	public void shouldMainMethodGetTheYearByArgsAndSaveTheXlsFilesOfTheseYears() {
		String [] args = new String[] { "2000", "2001", "ABC", "2002" };

		Generator.main(args);
	}
}

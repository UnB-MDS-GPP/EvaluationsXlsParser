package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import models.Bean;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import reader.XlsRowFieldsStorage;

import Database.BuildEvaluation;

public class TestBuildEvaluation {

	private BuildEvaluation evaluation;

	@Before
	public void setUp() throws Exception {
		XlsRowFieldsStorage data = new XlsRowFieldsStorage();
		this.evaluation = new BuildEvaluation(data);
	}

	@Test
	public void shouldSaveOnDatabase() throws ClassNotFoundException, SQLException {
		XlsRowFieldsStorage outro = new XlsRowFieldsStorage();
		outro.setYear(2007);
		outro.setAcronym("acronym");
		outro.setName("Qualquer coisa");
		BuildEvaluation bEvaluation = new BuildEvaluation(outro);
		bEvaluation.saveToDatabase();
		outro = new XlsRowFieldsStorage();
		outro.setYear(2007);
		outro.setAcronym("acronym");
		outro.setName("Qualquer coisa");
		
	}
	@Test
	public void shouldCheckRelation() throws ClassNotFoundException, SQLException {
		XlsRowFieldsStorage outro = new XlsRowFieldsStorage();
		
	
	}

}

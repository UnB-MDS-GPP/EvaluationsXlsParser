package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import libraries.DataBaseStructures;

import org.junit.Before;
import org.junit.Test;

import Database.DatabaseEvaluationBuilder;

public class TesteDatabaseEvaluationBuilder {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws IOException, ClassNotFoundException, SQLException {
		DatabaseEvaluationBuilder db1 = new DatabaseEvaluationBuilder();
		DatabaseEvaluationBuilder db2 = new DatabaseEvaluationBuilder();

		assertEquals(false, db1.createListXlsRowFieldsStorage(2017));

		db2.createListXlsRowFieldsStorage(2000);
		DataBaseStructures dbStruct = new DataBaseStructures();
		dbStruct.dropDB();
	}
}

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import reader.EvaluationXlsRowFieldsStorage;

public class TestEvaluationXlsRowFieldsStorage {
	private EvaluationXlsRowFieldsStorage rowFieldStorage;

	@Before
	public void setUp() throws Exception {
		this.rowFieldStorage = new EvaluationXlsRowFieldsStorage();
	}

	@Test
	public void shoudSetAndSetAllFields() {
		this.rowFieldStorage.setAcronym("An Acronym");
		this.rowFieldStorage.setArticlesPublishedConferenceProceedings(10);
		this.rowFieldStorage.setArticlesPublishedJournals(5);
		this.rowFieldStorage.setArtisticProduction(7);
		this.rowFieldStorage.setChapters(11);
		this.rowFieldStorage.setCollections(66);
		this.rowFieldStorage.setDissertations(55);
		this.rowFieldStorage.setDoctorateYear(1999);
		this.rowFieldStorage.setTrienalEvaluation(789);
		this.rowFieldStorage.setEntries(3);
		this.rowFieldStorage.setInetegralText(87);
		this.rowFieldStorage.setMastersDegreeYear(2000);
		this.rowFieldStorage.setModality("Acad");
		this.rowFieldStorage.setName("A course name here");
		this.rowFieldStorage.setPermanentTeachers(123);
		this.rowFieldStorage.setTheses(33);
		this.rowFieldStorage.setPublishedWorks(22);
		this.rowFieldStorage.setYear(2010);

		assertEquals(this.rowFieldStorage.getAcronym(), "An Acronym");
		assertEquals(10, this.rowFieldStorage.getArticlesPublishedConferenceProceedings(), 0);
		assertEquals(5, this.rowFieldStorage.getArticlesPublishedJournals(), 0);
		assertEquals(7, this.rowFieldStorage.getArtisticProduction(), 0);
		assertEquals(11, this.rowFieldStorage.getChapters(), 0);
		assertEquals(66, this.rowFieldStorage.getCollections(), 0);
		assertEquals(55, this.rowFieldStorage.getDissertations(), 0);
		assertEquals(1999, this.rowFieldStorage.getDoctorateYear(), 0);
		assertEquals(789, this.rowFieldStorage.getTrienalEvaluation(), 0);
		assertEquals(3, this.rowFieldStorage.getEntries(), 0);
		assertEquals(87, this.rowFieldStorage.getInetegralText(), 0);
		assertEquals(2000, this.rowFieldStorage.getMastersDegreeYear(), 0);
		assertEquals("Acad", this.rowFieldStorage.getModality());
		assertEquals("A course name here", this.rowFieldStorage.getName());
		assertEquals(123, this.rowFieldStorage.getPermanentTeachers(), 0);
		assertEquals(33, this.rowFieldStorage.getTheses(), 0);
		assertEquals(22, this.rowFieldStorage.getPublishedWorks(), 0);
		assertEquals(2010, this.rowFieldStorage.getYear(), 0);
	}
}

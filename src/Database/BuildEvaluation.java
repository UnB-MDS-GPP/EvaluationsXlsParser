package Database;

import java.sql.SQLException;
import java.util.ArrayList;

import models.*;
import reader.XlsRowFieldsStorage;

public class BuildEvaluation {
	private XlsRowFieldsStorage data;
	public BuildEvaluation(XlsRowFieldsStorage data) {
		this.data = data;
		
	}
	
	public void saveToDatabase() throws ClassNotFoundException, SQLException {
		Article article = new Article();
		Book book = new Book();
		Course course = new Course();
		Evaluation evaluation = new Evaluation();
		Institution institution = new Institution();
		
		ArrayList<Course> courses = Course.getWhere("name", this.data.getName(), false);  
		if (courses.size()==0){
			course.setName(this.data.getName());
		} 
		
		ArrayList<Institution> institutions = Institution.getWhere("acronym", this.data.getAcronym(), false);  
		if (institutions.size()==0){
			institution.setAcronym(this.data.getAcronym());
		} 
		
		article.setPublishedConferenceProceedings(this.data.getPublishedConferenceProceedings());
		article.setPublishedJournals(this.data.getPublishedJournals());
		
		book.setChapters(this.data.getChapters());
		book.setCollections(this.data.getCollections());
		book.setEntries(this.data.getEntries());
		book.setIntegralText(this.data.getIntegralText());
		
		evaluation.setArtisticProduction(this.data.getArtisticProduction());
		evaluation.setDissertations(this.data.getDissertations());
		evaluation.setDoctorateStartYear(this.data.getDoctorateYear());
		evaluation.setMasterDegreeStartYear(this.data.getMastersDegreeYear());
		evaluation.setModality(this.data.getModality());
		evaluation.setPermanentTeachers(this.data.getPermanentTeachers());
		evaluation.setTheses(this.data.getTheses());
		evaluation.setTriennialEvaluation(this.data.getTrienalEvaluation());
		evaluation.setYear(this.data.getYear());
	}
}

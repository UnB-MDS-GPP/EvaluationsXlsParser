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
		Article article = this.databaseArticle();
		Book book = this.databaseBook();
		Course course = this.databaseCourse();
		Institution institution = this.databaseInstitution();	
		Evaluation evaluation = this.databaseEvaluation();
		
		article.save();
		book.save();
		evaluation.setIdArticles(article.getId());
		evaluation.setIdBooks(book.getId());
		
		ArrayList<Bean> beans = this.setCourseInstitutionRelation(course, institution);
		
		course = (Course)beans.get(0);
		institution = (Institution)beans.get(1);
		
		evaluation.setIdCourse(course.getId());
		evaluation.setIdInstitution(institution.getId());
		
		institution.save();
	}
	
	private Article databaseArticle(){
		Article article = new Article();
		
		article.setPublishedConferenceProceedings(this.data.getPublishedConferenceProceedings());
		article.setPublishedJournals(this.data.getPublishedJournals());
		
		return article;
	}
	
	private Book databaseBook() {
		Book book = new Book();
		
		book.setChapters(this.data.getChapters());
		book.setCollections(this.data.getCollections());
		book.setEntries(this.data.getEntries());
		book.setIntegralText(this.data.getIntegralText());
		
		return book;
	}
	
	private Course databaseCourse() throws ClassNotFoundException, SQLException{
		Course course = new Course();
		
		ArrayList<Course> courses = Course.getWhere("name", this.data.getName(), false);  
		if (courses.size()==0){
			course.setName(this.data.getName());
			return course;
		} else{
			return courses.get(0);
		}
	}
	
	private Institution databaseInstitution() throws ClassNotFoundException, SQLException{
		Institution institution = new Institution();
		
		ArrayList<Institution> institutions = Institution.getWhere("acronym", this.data.getAcronym(), false);  
		if (institutions.size()==0){
			institution.setAcronym(this.data.getAcronym());
			return institution;
		} else{
			return institutions.get(0);
		}
	}
	
	private Evaluation databaseEvaluation(){
		Evaluation evaluation = new Evaluation();
		
		evaluation.setArtisticProduction(this.data.getArtisticProduction());
		evaluation.setDissertations(this.data.getDissertations());
		evaluation.setDoctorateStartYear(this.data.getDoctorateYear());
		evaluation.setMasterDegreeStartYear(this.data.getMastersDegreeYear());
		evaluation.setModality(this.data.getModality());
		evaluation.setPermanentTeachers(this.data.getPermanentTeachers());
		evaluation.setTheses(this.data.getTheses());
		evaluation.setTriennialEvaluation(this.data.getTrienalEvaluation());
		evaluation.setYear(this.data.getYear());
		
		return evaluation;
	}
	
	private ArrayList<Bean> setCourseInstitutionRelation(Course course, Institution institution) throws ClassNotFoundException, SQLException{
		ArrayList<Bean> beans = new ArrayList<Bean>(); 
		ArrayList<Course> courses = Course.getWhere("name", this.data.getName(), false);  
		ArrayList<Institution> institutions = Institution.getWhere("acronym", this.data.getAcronym(), false);  
		
		if(courses.size()==0 && institutions.size()==0){
			course.save();
			institution.addCourse(course);
			institution.save();
			
			beans.add(course);
			beans.add(institution);
		} else if(courses.size()>0 && institutions.size()==0){
			institution.addCourse(courses.get(0));
			institution.save();
			
			beans.add(courses.get(0));
			beans.add(institution);
		} else if(institutions.size()>0 && courses.size()==0){
			course.addInstitution(institutions.get(0));
			course.save();
			
			beans.add(course);
			beans.add(institutions.get(0));
		}
		return beans;
	}
}

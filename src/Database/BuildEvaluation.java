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

		evaluation.save();
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
		} else {
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
		boolean courseAlreadyExists = Course.alreadyExistsWith("name", course.getName());
		boolean institutionAlreadyExists = Institution.alreadyExistsWith("acronym", institution.getAcronym());

		if(!courseAlreadyExists && !institutionAlreadyExists){
			course.save();
			institution.save();

			institution.addCourse(course);

			beans.add(course);
			beans.add(institution);
		} else if(courseAlreadyExists && !institutionAlreadyExists){
			course = Course.getWhere("name", course.getName(), false).get(0);

			institution.save();

			institution.addCourse(course);

			beans.add(course);
			beans.add(institution);
		} else if(institutionAlreadyExists && !courseAlreadyExists){
			institution = Institution.getWhere("acronym", institution.getAcronym(), false).get(0);

			course.save();

			course.addInstitution(institution);

			beans.add(course);
			beans.add(institution);
		} else { // already has course and institution saved on the database
			course = Course.getWhere("name", course.getName(), false).get(0);
			institution = Institution.getWhere("acronym", institution.getAcronym(), false).get(0);

			if(!course.hasInstitution(institution))
				course.addInstitution(institution); // Add a new relation if it's course doesn't have it

			beans.add(course);
			beans.add(institution);
		}

		return beans;
	}
}

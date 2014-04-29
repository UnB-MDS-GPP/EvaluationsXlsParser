package reader;

public class XlsRowFieldsStorage {
	private Integer evaluationYear; // Evaluation file year 2007 or 2010
	private String intitutionAcronym; // C12 --> Institution field
	private String courseName; // D12 --> Course field
	private String evaluationModality; // E12 --> Evaluation field
	private Integer evaluationMastersDegreeYear; // F12 --> Evaluation field
	private Integer evaluationDoctorateYear; // G12 --> Evaluation field
	private Integer trienalEvaluation; // H12 --> Evaluation field
	private Integer evaluationPermanentTeachers; // I12 --> Evaluation field
	private Integer evaluationTheses; // J12 --> Evaluation field
	private Integer evaluationDissertations; // K12 --> Evaluation field
	private Integer articlesPublishedJournals; // --> Article field 
	private Integer articlesPublishedConferenceProceedings; // --> Article field
	private Integer bookInetegralText; // AE12 --> Book field
	private Integer bookChapters; // AF12 --> Book field
	private Integer bookCollections; // AG12 --> Book field
	private Integer bookEntries; // AH12 --> Book field
	private Integer evaluationPublishedWorks; // 2007: Sum of V12, W12, X12, Y12, X12, AA12, AB12, AC12, AD12 --> Evaluation field
	private Integer evaluationArtisticProduction; // 2010: AI12 --> Evaluation field
	
	public Integer getEvaluationYear() {
		return evaluationYear;
	}
	public void setEvaluationYear(Integer evaluationYear) {
		this.evaluationYear = evaluationYear;
	}
	public String getIntitutionAcronym() {
		return intitutionAcronym;
	}
	public void setIntitutionAcronym(String intitutionAcronym) {
		this.intitutionAcronym = intitutionAcronym;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getEvaluationModality() {
		return evaluationModality;
	}
	public void setEvaluationModality(String evaluationModality) {
		this.evaluationModality = evaluationModality;
	}
	public Integer getEvaluationMastersDegreeYear() {
		return evaluationMastersDegreeYear;
	}
	public void setEvaluationMastersDegreeYear(Integer evaluationMastersDegreeYear) {
		this.evaluationMastersDegreeYear = evaluationMastersDegreeYear;
	}
	public Integer getEvaluationDoctorateYear() {
		return evaluationDoctorateYear;
	}
	public void setEvaluationDoctorateYear(Integer evaluationDoctorateYear) {
		this.evaluationDoctorateYear = evaluationDoctorateYear;
	}
	public Integer getTrienalEvaluation() {
		return trienalEvaluation;
	}
	public void setTrienalEvaluation(Integer trienalEvaluation) {
		this.trienalEvaluation = trienalEvaluation;
	}
	public Integer getEvaluationPermanentTeachers() {
		return evaluationPermanentTeachers;
	}
	public void setEvaluationPermanentTeachers(Integer evaluationPermanentTeachers) {
		this.evaluationPermanentTeachers = evaluationPermanentTeachers;
	}
	public Integer getEvaluationTheses() {
		return evaluationTheses;
	}
	public void setEvaluationTheses(Integer evaluationTheses) {
		this.evaluationTheses = evaluationTheses;
	}
	public Integer getEvaluationDissertations() {
		return evaluationDissertations;
	}
	public void setEvaluationDissertations(Integer evaluationDissertations) {
		this.evaluationDissertations = evaluationDissertations;
	}
	public Integer getArticlesPublishedJournals() {
		return articlesPublishedJournals;
	}
	public void setArticlesPublishedJournals(Integer articlesPublishedJournals) {
		this.articlesPublishedJournals = articlesPublishedJournals;
	}
	public Integer getArticlesPublishedConferenceProceedings() {
		return articlesPublishedConferenceProceedings;
	}
	public void setArticlesPublishedConferenceProceedings(
			Integer articlesPublishedConferenceProceedings) {
		this.articlesPublishedConferenceProceedings = articlesPublishedConferenceProceedings;
	}
	public Integer getBookInetegralText() {
		return bookInetegralText;
	}
	public void setBookInetegralText(Integer bookInetegralText) {
		this.bookInetegralText = bookInetegralText;
	}
	public Integer getBookChapters() {
		return bookChapters;
	}
	public void setBookChapters(Integer bookChapters) {
		this.bookChapters = bookChapters;
	}
	public Integer getBookCollections() {
		return bookCollections;
	}
	public void setBookCollections(Integer bookCollections) {
		this.bookCollections = bookCollections;
	}
	public Integer getBookEntries() {
		return bookEntries;
	}
	public void setBookEntries(Integer bookEntries) {
		this.bookEntries = bookEntries;
	}
	public Integer getEvaluationPublishedWorks() {
		return evaluationPublishedWorks;
	}
	public void setEvaluationPublishedWorks(Integer evaluationPublishedWorks) {
		this.evaluationPublishedWorks = evaluationPublishedWorks;
	}
	public Integer getEvaluationArtisticProduction() {
		return evaluationArtisticProduction;
	}
	public void setEvaluationArtisticProduction(Integer evaluationArtisticProduction) {
		this.evaluationArtisticProduction = evaluationArtisticProduction;
	}

	
}

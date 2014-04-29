package reader;

public class XlsRowFieldsStorage {
	private Integer evaluationYear; // Evaluation file year 2007 or 2010
	private String intitutionAcronym; // C12 --> Institution field
	private String courseName; // D12 --> Course field
	private String evaluationModality; // E12 --> Evaluation field
	private Integer evaluationMastersDegreeYear; // F12 --> Evaluation field
	private Integer evaluationDoctorateYear; // G12 --> Evaluation field
	private Integer evaluationTrienalEvaluation; // H12 --> Evaluation field
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

	public Integer getYear() {
		return evaluationYear;
	}
	public void setYear(Integer year) {
		this.evaluationYear = year;
	}
	public String getAcronym() {
		return intitutionAcronym;
	}
	public void setAcronym(String acronym) {
		this.intitutionAcronym = acronym;
	}
	public String getName() {
		return courseName;
	}
	public void setName(String name) {
		this.courseName = name;
	}
	public String getModality() {
		return evaluationModality;
	}
	public void setModality(String modality) {
		this.evaluationModality = modality;
	}
	public Integer getMastersDegreeYear() {
		return evaluationMastersDegreeYear;
	}
	public void setMastersDegreeYear(Integer mastersDegreeYear) {
		this.evaluationMastersDegreeYear = mastersDegreeYear;
	}
	public Integer getDoctorateYear() {
		return evaluationDoctorateYear;
	}
	public void setDoctorateYear(Integer doctorateYear) {
		this.evaluationDoctorateYear = doctorateYear;
	}
	public Integer getTrienalEvaluation() {
		return evaluationTrienalEvaluation;
	}
	public void setTrienalEvaluation(Integer trienalEvaluation) {
		this.evaluationTrienalEvaluation = trienalEvaluation;
	}
	public Integer getPermanentTeachers() {
		return evaluationPermanentTeachers;
	}
	public void setPermanentTeachers(Integer permanentTeachers) {
		this.evaluationPermanentTeachers = permanentTeachers;
	}
	public Integer getTheses() {
		return evaluationTheses;
	}
	public void setTheses(Integer theses) {
		this.evaluationTheses = theses;
	}
	public Integer getDissertations() {
		return evaluationDissertations;
	}
	public void setDissertations(Integer dissertations) {
		this.evaluationDissertations = dissertations;
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
	public Integer getInetegralText() {
		return bookInetegralText;
	}
	public void setInetegralText(Integer inetegralText) {
		this.bookInetegralText = inetegralText;
	}
	public Integer getChapters() {
		return bookChapters;
	}
	public void setChapters(Integer chapters) {
		this.bookChapters = chapters;
	}
	public Integer getCollections() {
		return bookCollections;
	}
	public void setCollections(Integer collections) {
		this.bookCollections = collections;
	}
	public Integer getEntries() {
		return bookEntries;
	}
	public void setEntries(Integer entries) {
		this.bookEntries = entries;
	}
	public Integer getPublishedWorks() {
		return evaluationPublishedWorks;
	}
	public void setPublishedWorks(Integer publishedWorks) {
		this.evaluationPublishedWorks = publishedWorks;
	}
	public Integer getArtisticProduction() {
		return evaluationArtisticProduction;
	}
	public void setArtisticProduction(Integer artisticProduction) {
		this.evaluationArtisticProduction = artisticProduction;
	}
}

package reader;

public class EvaluationXlsRowFieldsStorage {
	private Integer year; // Evaluation file year 2007 or 2010
	private String acronym; // C12 --> Institution field
	private String name; // D12 --> Course field
	private String modality; // E12 --> Evaluation field
	private Integer mastersDegreeYear; // F12 --> Evaluation field
	private Integer doctorateYear; // G12 --> Evaluation field
	private Integer trienalEvaluation; // H12 --> Evaluation field
	private Integer permanentTeachers; // I12 --> Evaluation field
	private Integer theses; // J12 --> Evaluation field
	private Integer dissertations; // K12 --> Evaluation field
	private Integer articlesPublishedJournals; // --> Article field 
	private Integer articlesPublishedConferenceProceedings; // --> Article field
	private Integer inetegralText; // AE12 --> Book field
	private Integer chapters; // AF12 --> Book field
	private Integer collections; // AG12 --> Book field
	private Integer entries; // AH12 --> Book field
	private Integer publishedWorks; // 2007: Sum of V12, W12, X12, Y12, X12, AA12, AB12, AC12, AD12 --> Evaluation field
	private Integer artisticProduction; // 2010: AI12 --> Evaluation field

	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public Integer getMastersDegreeYear() {
		return mastersDegreeYear;
	}
	public void setMastersDegreeYear(Integer mastersDegreeYear) {
		this.mastersDegreeYear = mastersDegreeYear;
	}
	public Integer getDoctorateYear() {
		return doctorateYear;
	}
	public void setDoctorateYear(Integer doctorateYear) {
		this.doctorateYear = doctorateYear;
	}
	public Integer getTrienalEvaluation() {
		return trienalEvaluation;
	}
	public void setTrienalEvaluation(Integer trienalEvaluation) {
		this.trienalEvaluation = trienalEvaluation;
	}
	public Integer getPermanentTeachers() {
		return permanentTeachers;
	}
	public void setPermanentTeachers(Integer permanentTeachers) {
		this.permanentTeachers = permanentTeachers;
	}
	public Integer getTheses() {
		return theses;
	}
	public void setTheses(Integer theses) {
		this.theses = theses;
	}
	public Integer getDissertations() {
		return dissertations;
	}
	public void setDissertations(Integer dissertations) {
		this.dissertations = dissertations;
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
		return inetegralText;
	}
	public void setInetegralText(Integer inetegralText) {
		this.inetegralText = inetegralText;
	}
	public Integer getChapters() {
		return chapters;
	}
	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}
	public Integer getCollections() {
		return collections;
	}
	public void setCollections(Integer collections) {
		this.collections = collections;
	}
	public Integer getEntries() {
		return entries;
	}
	public void setEntries(Integer entries) {
		this.entries = entries;
	}
	public Integer getPublishedWorks() {
		return publishedWorks;
	}
	public void setPublishedWorks(Integer publishedWorks) {
		this.publishedWorks = publishedWorks;
	}
	public Integer getArtisticProduction() {
		return artisticProduction;
	}
	public void setArtisticProduction(Integer artisticProduction) {
		this.artisticProduction = artisticProduction;
	}
}

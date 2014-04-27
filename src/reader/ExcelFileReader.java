package reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelFileReader {
	private Vector dataHolder;
	private String fileName;
	private int year;

	public ExcelFileReader() {
	}

	public ExcelFileReader(String fileName, int year) {
		this.fileName = fileName;
		this.year = year;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	private Vector readExcelFile() throws IOException {
		// A vector os cells
		Vector cellVectorHolder = new Vector();

		// Creating Input Stream
		FileInputStream myInput = new FileInputStream(this.fileName);

		// Create a POIFSFileSystem object
		POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

		// Create a workbook using the File System
		HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

		// Get the first sheet from workbook
		HSSFSheet mySheet = myWorkBook.getSheetAt(0);

		// Iterator to iterate through the cells
		Iterator rowIter = mySheet.rowIterator();

		while(rowIter.hasNext()) {
			HSSFRow myRow = (HSSFRow) rowIter.next();
			Iterator cellIter = myRow.cellIterator();
			Vector cellStoreVector = new Vector();

			while(cellIter.hasNext()) {
				HSSFCell myCell = (HSSFCell) cellIter.next();
				cellStoreVector.addElement(myCell);
			}

			cellVectorHolder.addElement(cellStoreVector);
		}

		return cellVectorHolder;
	}

	public String getAreaReview() {
		Vector cellStoreVector = (Vector)this.dataHolder.elementAt(5);
		String area = "";

		for(int i = 0; i < cellStoreVector.size(); i++) {
			HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(i);

			if( myCell.toString().length() > 0 )
				area += myCell.toString();
		}

		int index = area.indexOf(":") + 1;
		area = area.substring(index, area.length());

		return area;
	}

	public ArrayList<EvaluationXlsRowFieldsStorage> getEvaluationFromXslFile() throws IOException {
		ArrayList<EvaluationXlsRowFieldsStorage> rowData = new ArrayList<EvaluationXlsRowFieldsStorage>();
		EvaluationXlsRowFieldsStorage evaluation;

		int startRow = 11;
		this.dataHolder = this.readExcelFile(); // xls file rows

		for (int i=startRow; i < this.dataHolder.size();i++) {
			Vector cellStoreVector = (Vector)this.dataHolder.elementAt(i); // single row

			if( this.isRowEmpty(cellStoreVector) ) // Do not continue if its the end of the file
				break;

			evaluation = new EvaluationXlsRowFieldsStorage();

			evaluation.setAcronym(this.getAcronym(cellStoreVector));
			evaluation.setArticlesPublishedConferenceProceedings(this.getArticlesPublishedConferenceProceedings(cellStoreVector));
			evaluation.setArticlesPublishedJournals(this.getArticlesPublishedJournals(cellStoreVector));
			evaluation.setArtisticProduction(this.getArtisticProduction(cellStoreVector, this.year));
			evaluation.setChapters(this.getChapters(cellStoreVector));
			evaluation.setCollections(this.getCollections(cellStoreVector));
			evaluation.setDissertations(this.getDissertations(cellStoreVector));
			evaluation.setDoctorateYear(this.getDoctorateYear(cellStoreVector));
			evaluation.setEntries(this.getEntries(cellStoreVector));
			evaluation.setInetegralText(this.getInetegralText(cellStoreVector));
			evaluation.setMastersDegreeYear(this.getMastersDegreeYear(cellStoreVector));
			evaluation.setModality(this.getModality(cellStoreVector));
			evaluation.setName(this.getName(cellStoreVector));
			evaluation.setPermanentTeachers(this.getPermanentTeachers(cellStoreVector));
			evaluation.setPublishedWorks(this.getPublishedWorks(cellStoreVector, this.year));
			evaluation.setTheses(this.getTheses(cellStoreVector));
			evaluation.setTrienalEvaluation(this.getTrienalEvaluation(cellStoreVector));
			evaluation.setYear(this.year);

			rowData.add(evaluation);
		}

		return rowData;
	}

	private String getAcronym(Vector cellStoreVector) {
		return this.getValueFromCell(cellStoreVector, 2);
	}

	private String getName(Vector cellStoreVector) {
		return this.getValueFromCell(cellStoreVector, 3);
	}

	private String getModality(Vector cellStoreVector) {
		return this.getValueFromCell(cellStoreVector, 4);
	}

	private Integer getMastersDegreeYear(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 5);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getDoctorateYear(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 6);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getTrienalEvaluation(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 7);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getPermanentTeachers(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 8);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getTheses(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 9);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getDissertations(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 10);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getArticlesPublishedJournals(Vector cellStoreVector) {
		return 0;
	}

	private Integer getArticlesPublishedConferenceProceedings(Vector cellStoreVector) {
		return 0;
	}

	private Integer getInetegralText(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 30);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getChapters(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 31);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getCollections(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 32);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getEntries(Vector cellStoreVector) {
		String data = this.getValueFromCell(cellStoreVector, 33);
		Double value;

		try {
			value = Double.parseDouble(data);
		} catch(Exception e) {
			value = 0.0;
		}

		return value.intValue();
	}

	private Integer getPublishedWorks(Vector cellStoreVector, int year) {
		String data;
		Double value;

		if( year == 2010 ) {
			data = this.getValueFromCell(cellStoreVector, 21);

			try {
				value = Double.parseDouble(data);
			} catch(Exception e) {
				value = 0.0;
			}

			return value.intValue();
		} else {
			Double sumFields = 0.0;

			for(int i = 0; i <= 8; i++) {
				data = this.getValueFromCell(cellStoreVector, 21+i);

				try {
					value = Double.parseDouble(data);
				} catch(Exception e) {
					value = 0.0;
				}

				sumFields += value;
			}

			return sumFields.intValue();
		}
	}

	private Integer getArtisticProduction(Vector cellStoreVector, int year) {
		Double value;

		if( year == 2010 ) {
			String data = this.getValueFromCell(cellStoreVector, 34);

			try {
				value = Double.parseDouble(data);
			} catch(Exception e) {
				value = 0.0;
			}

			return value.intValue();
		} else
			return 0;
	}

	private boolean isRowEmpty(Vector cellStoreVector) {
		boolean empty = true;

		for(int i = 0; i < cellStoreVector.size(); i++) {
			HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(i);

			if( myCell.toString().replaceAll("\\s+","").length() > 0 ) {
				empty = false;
				break;
			}
		}

	    return empty;
	}

	private String getValueFromCell(Vector cellStoreVector, int index) {
		String value = "";
		HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(index);
		value = myCell.toString();

		return value;
	}
}

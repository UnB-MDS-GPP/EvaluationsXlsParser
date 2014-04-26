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

	public void printCellDataToConsole() throws IOException {
		int startRow = 11;
		this.dataHolder = this.readExcelFile(); // xls file rows

		for (int i=startRow; i < this.dataHolder.size();i++) {
			Vector cellStoreVector = (Vector)this.dataHolder.elementAt(i); // single row
			if( this.isRowEmpty(cellStoreVector) )
				break;

			System.out.println(this.getPublishedWorks(cellStoreVector, this.year));
			/*for (int j=0; j < cellStoreVector.size();j++) {
				HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();

				//System.out.println("I: "+i+"\nJ: "+j+"\n");
				System.out.print(stringCellValue+"\t");
			}

			System.out.println();*/
		}
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
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 5));
	}

	private Integer getDoctorateYear(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 6));
	}

	private Integer getTrienalEvaluation(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 7));
	}

	private Integer getPermanentTeachers(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 8));
	}

	private Integer getTheses(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 9));
	}

	private Integer getDissertations(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 10));
	}

	private Integer getArticlesPublishedJournals(Vector cellStoreVector) {
		return 0;
	}

	private Integer getArticlesPublishedConferenceProceedings(Vector cellStoreVector) {
		return 0;
	}

	private Integer getInetegralText(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 30));
	}

	public Integer getChapters(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 31));
	}

	public Integer getCollections(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 32));
	}

	public Integer getEntries(Vector cellStoreVector) {
		return Integer.parseInt(this.getValueFromCell(cellStoreVector, 33));
	}

	public Integer getPublishedWorks(Vector cellStoreVector, int year) {
		if( year == 2010 )
			return Integer.parseInt(this.getValueFromCell(cellStoreVector, 21));
		else {
			Double sumFields = 0.0;

			for(int i = 0; i <= 8; i++)
				sumFields += Double.parseDouble(this.getValueFromCell(cellStoreVector, 21+i));

			return Integer.parseInt(sumFields.toString());
		}
	}

	public Integer getArtisticProduction(Vector cellStoreVector, int year) {
		if( year == 2010 )
			return Integer.parseInt(this.getValueFromCell(cellStoreVector, 34));
		else
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

package reader;

import java.io.FileInputStream;
import java.io.IOException;
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

	public ExcelFileReader() {
	}

	public ExcelFileReader(String fileName) {
		this.fileName = fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
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

			System.out.println(this.getAcronym(cellStoreVector));
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

	public String getAcronym(Vector cellStoreVector) {
		String acronym = "";
		HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(2);
		acronym = myCell.toString();

		return acronym;
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
}

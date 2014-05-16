package Database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import libraries.DataBaseStructures;
import reader.ExcelFileReader;
import reader.ListFiles;
import reader.XlsRowFieldsStorage;

public class DatabaseEvaluationBuilder {

	public DatabaseEvaluationBuilder() {
		// TODO Auto-generated constructor stub
	}

	int i, j;
	DataBaseStructures dsStructures;
	ArrayList<String> files;
	
	public boolean createListXlsRowFieldsStorage(int year) {
		this.setXlsFilesFromFolder(year);

		if (files.size() != 0) {
			if (this.initializeDatabase()) {
				this.passToDatabaseEachFile(year);
			}

			return true;
		} else {
			System.out.println("The year "+year+" could not be saved");
			return false;
		}
	}
	
	private void setXlsFilesFromFolder(int year) {
		if (ListFiles.getAllXlsFilesFromFolder("./src/xls/" + year + "/") != null) {
			this.files = ListFiles.getAllXlsFilesFromFolder("./src/xls/" + year + "/");
		} else {
			this.files = new ArrayList<String>();
		}
	}

	private boolean initializeDatabase() {
		boolean initialized;

		try {
			dsStructures = new DataBaseStructures();
			dsStructures.initDB();
			initialized = true;
		} catch (Exception e) {
			System.out.println("Could not create the database");
			e.printStackTrace();
			initialized = false;
		}

		return initialized;
	}

	private void passToDatabaseEachFile(int year) {
		ArrayList<XlsRowFieldsStorage> xlsRowData = new ArrayList<XlsRowFieldsStorage>();
		System.out.println("\t---=== " + year + " ===---");
		System.out.println("Total de arquivos de " + year + ": "+ files.size() + "\n");

		for (i = 0; i < files.size(); i++) {
			System.out.println("Saving the data from file '"+ files.get(i) +"' into database.");

			ExcelFileReader xlsReader = new ExcelFileReader(files.get(i), year);

			try {
				xlsRowData = xlsReader.getEvaluationFromXslFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.println("Total lines from archive: "+ xlsRowData.size());

			this.passToDataBaseAllRowsFromAFile(xlsRowData);
		}

	}

	private void passToDataBaseAllRowsFromAFile(ArrayList<XlsRowFieldsStorage> xlsRowData) {
		for (j = 0; j < xlsRowData.size(); j++) {
			BuildEvaluation buildE = new BuildEvaluation(xlsRowData.get(j));

			try {
				buildE.saveToDatabase();
				System.out.println("Saved into the database the row "+ (j + 1) + ".");
			} catch (Exception e) {
				System.out.println(
						"Could not save into the database the row"
						+ (j + 1)
						+ " of the file '"
						+ files.get(i) + "'");

				e.printStackTrace();
				break;
			}
		}
	}
}
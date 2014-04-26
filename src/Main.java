import java.io.IOException;
import java.util.ArrayList;

import reader.*;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> files = ListFiles.getAllXlsFilesFromFolder("./src/xls/2007/");
		ArrayList<EvaluationXlsRowFieldsStorage> xlsRowData;
		ExcelFileReader xlsReader = new ExcelFileReader(files.get(0), 2007);

		xlsRowData = xlsReader.getEvaluationFromXslFile();
		System.out.println(xlsRowData.size());
	}
}

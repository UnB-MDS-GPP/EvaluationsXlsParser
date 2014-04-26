import java.io.IOException;
import java.util.ArrayList;

import reader.*;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> files = ListFiles.getAllXlsFilesFromFolder("./src/xls/2007/");
		ArrayList<EvaluationXlsRowFieldsStorage> xlsRowData;

		for(String file : files) {
			ExcelFileReader xlsReader = new ExcelFileReader(file, 2007);

			xlsRowData = xlsReader.getEvaluationFromXslFile();
			System.out.println(xlsRowData.size());
		}
	}
}

import java.io.IOException;

import reader.*;

public class Main {

	public static void main(String[] args) throws IOException {
		String file = ListFiles.getAllXlsFilesFromFolder("./src/xls/2007/").get(0);

		ExcelFileReader xlsReader = new ExcelFileReader(file);

		xlsReader.printCellDataToConsole();
	}
}

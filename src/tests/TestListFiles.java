package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import reader.ListFiles;

public class TestListFiles {

	@Test
	public void shouldGivenAFolderReturnAListOfXlsFiles() {
		ArrayList<String> filesList;

		ListFiles file = new ListFiles(); //pra passar 100% no teste.
		filesList = ListFiles.getAllXlsFilesFromFolder("./src/xls/2007/");
		String xlsFile = filesList.get(0);

		assertEquals(45, filesList.size());
		assertEquals(".xls",xlsFile.substring(xlsFile.length()-4, xlsFile.length()));

		filesList = ListFiles.getAllXlsFilesFromFolder("./src/xls/2010/");
		xlsFile = filesList.get(0);

		assertEquals(48, filesList.size());
		assertEquals(".xls", xlsFile.substring(xlsFile.length()-4, xlsFile.length()));
	}

}
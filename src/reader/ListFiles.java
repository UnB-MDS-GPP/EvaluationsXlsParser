package reader;

import java.io.File;
import java.util.ArrayList;

public class ListFiles {

	public ListFiles(){
		
	}
	public static ArrayList<String> getAllXlsFilesFromFolder(String path) {
		ArrayList<String> filesList = new ArrayList<String>();

		String files;
		File folder = null;
		try{
			folder = new File(path);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(folder.listFiles() != null){
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();

				if (files.endsWith(".xls")){// || files.endsWith(".XLS")) {
					filesList.add(path+files);
				}
			}
		}
		
		return filesList;
		} else return null;
	}
}
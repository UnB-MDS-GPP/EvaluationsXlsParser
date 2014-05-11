/*import java.io.IOException;
import java.util.ArrayList;

import libraries.DataBaseStructures;
import reader.*;
import Database.*;

public class Main {

	public static void main(String[] args) throws IOException {
		DataBaseStructures dbStructures;
		int i, j;

		try {
			dbStructures = new DataBaseStructures();
			dbStructures.initDB();
		} catch(Exception e) {
			System.out.println("Nao pode criar o banco");
			e.printStackTrace();
		}

		ArrayList<String> files = ListFiles.getAllXlsFilesFromFolder("./src/xls/2007/");
		ArrayList<XlsRowFieldsStorage> xlsRowData;

		System.out.println("\t---=== 2007 ===---");
		System.out.println("Total de arquivos de 2007: "+files.size()+"\n");
		for(i=0; i < files.size(); i++) {
			System.out.println("Salvando os dados do arquivo '"+files.get(i)+"' no banco.");
			ExcelFileReader xlsReader = new ExcelFileReader(files.get(i), 2007);

			xlsRowData = xlsReader.getEvaluationFromXslFile();
			System.out.println("Total de linhas do arquivo: "+xlsRowData.size());

			for(j=0; j < xlsRowData.size(); j++) {
				BuildEvaluation buildE = new BuildEvaluation(xlsRowData.get(j));

				try {
					buildE.saveToDatabase();
					System.out.println("Foi salvo no banco a linha "+(j+1)+".");
				} catch(Exception e) {
					System.out.println("Nao pode salvar no banco os dados da linha "+(j+1)+" do arquivo '"+files.get(i)+"'");
					e.printStackTrace();
					break;
				}
			}
		}
/*
		System.out.println("\t---=== 2010 ===---");
		files = ListFiles.getAllXlsFilesFromFolder("./src/xls/2010/");
		for(String file : files) {
			ExcelFileReader xlsReader = new ExcelFileReader(file, 2010);

			xlsRowData = xlsReader.getEvaluationFromXslFile();
			System.out.println(xlsRowData.size());
		}

		try {
			dbStructures = new DataBaseStructures();
			dbStructures.dropDB();
		} catch(Exception e) {
			System.out.println("Nao pode deletar o banco");
			e.printStackTrace();
		}*/
	//}
//}

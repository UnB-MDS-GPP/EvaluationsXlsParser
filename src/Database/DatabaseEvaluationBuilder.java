package Database;

import java.io.IOException;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import libraries.DataBaseStructures;
import reader.*;
import sun.org.mozilla.javascript.internal.ast.IfStatement;

public class DatabaseEvaluationBuilder {

	public DatabaseEvaluationBuilder() {
		// TODO Auto-generated constructor stub
	}

	int i, j;
	DataBaseStructures dsStructures;

	ArrayList<String> files = ListFiles
			.getAllXlsFilesFromFolder("./src/xls/2007/");
	ArrayList<XlsRowFieldsStorage> xlsRowData;

	public void createListXlsRowFieldsStorage(int ano) throws IOException {

		if (ano == 2007) {
			try {
				dsStructures = new DataBaseStructures();
				dsStructures.initDB();
			} catch (Exception e) {
				System.out.println("Nao pode criar o banco");
				e.printStackTrace();
			}
			System.out.println("\t---=== 2007 ===---");
			System.out.println("Total de arquivos de 2007: " + files.size() + "\n");
			for (i = 0; i < files.size(); i++) {
				System.out.println("Salvando os dados do arquivo '"
						+ files.get(i) + "' no banco.");
				ExcelFileReader xlsReader = new ExcelFileReader(files.get(i),
						2007);
				try {
					xlsRowData = xlsReader.getEvaluationFromXslFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Total de linhas do arquivo: "
						+ xlsRowData.size());

				for (j = 0; j < xlsRowData.size(); j++) {
					BuildEvaluation buildE = new BuildEvaluation(
							xlsRowData.get(j));

					try {
						buildE.saveToDatabase();
						System.out.println("Foi salvo no banco a linha "
								+ (j + 1) + ".");
					} catch (Exception e) {
						System.out
								.println("Nao pode salvar no banco os dados da linha "
										+ (j + 1)
										+ " do arquivo '"
										+ files.get(i) + "'");
						e.printStackTrace();
						break;
					}
				}
			}
		} else if (ano == 2010) {
			try {
				dsStructures = new DataBaseStructures();
				dsStructures.initDB();
			} catch (Exception e) {
				System.out.println("Nao pode criar o banco");
				e.printStackTrace();
			}
			files = ListFiles.getAllXlsFilesFromFolder("./src/xls/2010/");

			System.out.println("\t---=== 2010 ===---");
			System.out.println("Total de arquivos de 2010: " + files.size()
					+ "\n");
			for (i = 0; i < files.size(); i++) {
				System.out.println("Salvando os dados do arquivo '"
						+ files.get(i) + "' no banco.");
				ExcelFileReader xlsReader = new ExcelFileReader(files.get(i),
						2010);

				xlsRowData = xlsReader.getEvaluationFromXslFile();
				System.out.println("Total de linhas do arquivo: "
						+ xlsRowData.size());

				for (j = 0; j < xlsRowData.size(); j++) {
					BuildEvaluation buildE = new BuildEvaluation(
							xlsRowData.get(j));

					try {
						buildE.saveToDatabase();
						System.out.println("Foi salvo no banco a linha "
								+ (j + 1) + ".");
					} catch (Exception e) {
						System.out
								.println("Nao pode salvar no banco os dados da linha "
										+ (j + 1)
										+ " do arquivo '"
										+ files.get(i) + "'");
						e.printStackTrace();
						break;
					}
				}
			}
		}
		else{
			System.out.println("Ano não armazenado");
		}

	}

}
package main;

import java.util.ArrayList;

import Database.DatabaseEvaluationBuilder;

public class Generator {

	public static void main(String [] args) {
		Generator main = new Generator();
		Integer tempYear;
		ArrayList<Integer> years = new ArrayList<Integer>();

		for(String strYear : args) {
			try {
				tempYear = Integer.parseInt(strYear);
				years.add(tempYear);
			} catch(NumberFormatException e) {
				System.out.println(strYear+" is a invalid year number");
			}
		}

		for(Integer year : years) {
			main.generateDataFromYear(year);
		}
	}

	public boolean generateDataFromYear(Integer year) {
		DatabaseEvaluationBuilder dbBuilder = new DatabaseEvaluationBuilder();
		return dbBuilder.createListXlsRowFieldsStorage(year);
	}
}

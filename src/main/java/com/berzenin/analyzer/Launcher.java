package com.berzenin.analyzer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lombok.extern.java.Log;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;

@Log
public class Launcher {

//	private static Set<String> allStrings;
//	private static Set<String> shortWords;
//	private static Launcher launcher;
//
//	public static void main(String[] args) {
//		launcher = new Launcher();
//		String link = "C:\\Users\\Fylyp\\Desktop\\tech_tasks\\src\\main\\resources\\com\\berzenin\\analyzer\\words.txt";
//		Path testFilePath = Paths.get(link);
//		log.info("File with strings: " + testFilePath.getFileName().toString());
//		launcher.setArrayListFoString(testFilePath);
//		launcher.setListWithConcatenatedString();
//
//	}
//
//	private void setArrayListFoString(Path testFilePath) {
//		try {
//			allStrings = (Set<String>) Files.readAllLines(testFilePath, UTF_8);
//			log.info("Strings, total count: " + Integer.toString(allStrings.size()));
//		} catch (IOException e) {
//			log.severe(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	private List<String> setListWithConcatenatedString() {
////		Set<String> concatenatedString = new TreeSet<>();
//		shortWords = new TreeSet<>();
//		boolean end = true;
//		int countrer = 0;
//		int listSize = allStrings.size();
//		for (; countrer < listSize;) {
//			if (!checkStringForContainsAnotherString(allStrings., allStrings)) {
//				shortWords.add(allStrings.get(0));
//				allStrings.remove(allStrings.get(0));
//				countrer++;
//			}
//		}
////		for (String shortString: allStrings) {
////			int i = 0;
////			for (;i<allStrings.size();i++) {
////				String concatString = allStrings.get(i);
////				if(concatString.length()>shortString.length()) {
////					if (checkShortSting (concatString, shortString)) {
////					}
////					else concatenatedString.add(concatString);
////				}
////			}
////		}
//		log.info("List of concat word: ");
//		allStrings.forEach(st -> System.out.println(st));
//		log.info("List of short word: ");
//		shortWords.forEach(st -> System.out.println(st));
//		return null;
//	}
//
////	private static boolean checkShortSting (String concatString, String shortString) {
////		boolean check = false;
////		if (concatString.contains(shortString)) {
////			check = true;
////		}
////		String partOfConcatString = concatString.substring(shortString.length());
////		log.info(partOfConcatString);
////		return check;		
////	}
//
//	private String splitSpring(String concatString, String shortString) {
//		String partOfConcatString = concatString.substring(shortString.length());
////		log.info(partOfConcatString);
//		return partOfConcatString;
//	}
//
////	private boolean checkRestPartStringForContainsAnotherString () {
////		
////	}
//
//	private boolean checkStringForContainsAnotherString(String concatString, Set<String> words) {
//		for (String st : words) {
//			if (st.length() > concatString.length() && concatString.contains(st)) {
//				return true;
//			}
//		}
//		return false;
//	}

}

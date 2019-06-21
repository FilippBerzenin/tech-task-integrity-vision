package com.berzenin.analyzer;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.java.Log;

@Log
public class App {
	
	private static App launcher;
	private static List<String> allStrings;
	private static List<String> shortWords;
	private static List<String> concatWords;
	
	private static int smallestWordSize;

	public static void main(String[] args) {
		launcher = new App();
//		String link = "C:\\Users\\Fylyp\\Desktop\\tech_tasks\\src\\main\\resources\\com\\berzenin\\analyzer\\words.txt";
		String link = "C:\\Users\\Fylyp\\Desktop\\words.txt";
		
		Path testFilePath = Paths.get(link);
		log.info("File with strings: " + testFilePath.getFileName().toString());
		allStrings = launcher.setArrayListFoString(testFilePath);
		launcher.setListFoConcatWords();
		System.out.println(concatWords.size());
		concatWords.forEach(s -> System.out.println(s));
//		launcher.workWithAllStringsList ();
	}
	
	public List<String> setArrayListFoString(Path testFilePath) {
		Instant start = Instant.now();
		try {
			allStrings = Files.readAllLines(testFilePath, UTF_8);
			allStrings = allStrings.subList(0, 100000);
			log.info("Strings, total count: " + Integer.toString(allStrings.size()));
			return  allStrings;
		} catch (IOException e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
		Instant finish = Instant.now();
		double timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("setArrayListFoString " + "execution time: " + timeElapsed / 1000);
		return allStrings;
	}

	private void setListFoConcatWords() {
		Instant start = Instant.now();
		concatWords = new ArrayList<>();
		for (String wordForConcatAnalyz : allStrings) {
			if (analyzWorldForConcat (wordForConcatAnalyz)) {
				concatWords.add(wordForConcatAnalyz);
			}
		}
		Instant finish = Instant.now();
		double timeElapsed = Duration.between(start, finish).toMillis();
//		System.out.println("setListFoConcatWords " + "execution time: " + timeElapsed / 1000);
	}
	
	public boolean analyzWorldForConcat (String wordForConcatAnalyz) {
		Instant start = Instant.now();
		for (String shortWord : allStrings) {
			if (!wordForConcatAnalyz.equals(shortWord) && allConditionsForConcat(wordForConcatAnalyz, shortWord)) {
				Instant finish = Instant.now();
				double timeElapsed = Duration.between(start, finish).toMillis();
//				System.out.println("setListFoConcatWords " + "execution time: " + timeElapsed / 1000);
				return true;
			}
		}
		Instant finish = Instant.now();
		double timeElapsed = Duration.between(start, finish).toMillis();
//		System.out.println("setListFoConcatWords " + "execution time: " + timeElapsed / 1000);
		return false;
	}
	
	private boolean allConditionsForConcat (String wordForConcatAnalyz, String shortWord) {
		if (shortWord.length()==0) {
			return false;
		}
		if (wordForConcatAnalyz.length()<shortWord.length()) {
			return false;
		}
		if (wordForConcatAnalyz.contains(shortWord) && checkForConcatPertOfWord (wordForConcatAnalyz, shortWord)) {
			return true;
		}
		return false;
	}
	
	private boolean checkForConcatPertOfWord (String concatString, String shortString) {
		String part = splitSpring(concatString, shortString);
		if (part.length()==0) {
			return true;
		}
		else {
			for (String shortWord : allStrings) {
				if (allConditionsForConcat(part, shortWord)) {
					return true;
				}
			}
		}
		return false;		
	}
	
	public String splitSpring(String concatString, String shortString) {
	return concatString.replace(shortString, "");
}

	private void workWithAllStringsList () {
		shortWords = new LinkedList<>();
		concatWords = new LinkedList<>();
		for (String st: allStrings) {
			if (checkListWithStringsForContainsAnotherString (allStrings, st)) {
				shortWords.add(st);
			} else {
				concatWords.add(st);
			}
		}
		
//		log.info("List of concat word: ");
//		System.out.println(concatWords.size());
//		concatWords.forEach(st -> System.out.println(st));
		log.info("List of short word: ");
		shortWords.forEach(st -> System.out.println(st));
		
	}
	
	private boolean checkListWithStringsForContainsAnotherString (List<String> words, String word) {
		for (String st : words) {
		if (st.length() > word.length() && st.contains(word)) {
			return true;
		}
	}
	return false;
	}
}

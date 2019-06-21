package com.berzenin.analyzer;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.java.Log;

@Log
public class App {
	
	private static App launcher;
	private static List<String> allStrings;
	private static List<StringWithPart> conWord;

	public static void main(String[] args) {
		Instant start = Instant.now();
		launcher = new App();
		String link = "C:\\Users\\Samsung\\Desktop\\tech-task\\tech-task-integrity-vision\\src\\main\\resources\\com\\berzenin\\analyzer\\words.txt";
		
		Path testFilePath = Paths.get(link);
		log.info("File with strings: " + testFilePath.getFileName().toString());
		allStrings = launcher.setArrayListFoString(testFilePath);
		launcher.setListFoConcatWords();
		System.out.println(conWord.size());
		launcher.printResult();
		Instant finish = Instant.now();
		double timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("App " + "execution time: " + timeElapsed / 1000);
	}
	
	public void printResult () {
		List<StringWithPart> sortedList = conWord.stream()
			.sorted(Comparator.comparing(StringWithPart::getNameLength))
			.collect(Collectors.toList());
//		sortedList.forEach((s -> System.out.println(s)));
		if (sortedList.size()==0) {
			log.info("Upps list empty ");	
		}
		log.info("All concatenate words: "+conWord.size());
		log.info("last concatenate word: "+sortedList.get(conWord.size()-1));
		log.info("last but one concatenate word: "+sortedList.get(conWord.size()-2));
	}
	
	public List<String> setArrayListFoString(Path testFilePath) {
		Instant start = Instant.now();
		try {
			allStrings = Files.readAllLines(testFilePath, UTF_8);
//			allStrings = allStrings.subList(0, 10000);
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
		conWord = new ArrayList<>();
		int count = 1;
		for (String wordForConcatAnalyz : allStrings) {
			StringWithPart st = new StringWithPart();
			st.setName(wordForConcatAnalyz);
			for (String shortWord : allStrings) {
				if (!wordForConcatAnalyz.equals(shortWord) && 
						wordForConcatAnalyz.contains(shortWord)) {
					st.getParts().add(shortWord);					
				}
			}
			if (st.getParts().size()>1 && checkWordForConcatWithPart(st)) {
				conWord.add(st);
			}
			log.info("count: "+count++);
		}
	}
	
	public boolean checkWordForConcatWithPart (StringWithPart st) {
		String name;
		for (int k = 0;k<st.getParts().size();k++) {
			name = st.getName();
			name= name.replace(st.getParts().get(k), "");
			for (int i = k;i<st.getParts().size();i++) {
				name = name.replace(st.getParts().get(i), "");
				if (name.length()==0) {
					return true;
				}
			}
		}
		return false;
	}
	
//	public boolean analyzWorldForConcat (String wordForConcatAnalyz) {
//		for (String shortWord : allStrings) {
//			if (!wordForConcatAnalyz.equals(shortWord) && allConditionsForConcat(wordForConcatAnalyz, shortWord)) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	private boolean allConditionsForConcat (String wordForConcatAnalyz, String shortWord) {
//		if (shortWord.length()==0) {
//			return false;
//		}
//		if (wordForConcatAnalyz.length()<shortWord.length()) {
//			return false;
//		}
//		if (wordForConcatAnalyz.contains(shortWord) && checkForConcatPertOfWord (wordForConcatAnalyz, shortWord)) {
//			return true;
//		}
//		return false;
//	}
//	
//	private boolean checkForConcatPertOfWord (String concatString, String shortString) {
//		String part = splitSpring(concatString, shortString);
//		if (part.length()==0) {
//			return true;
//		}
//		else {
//			for (String shortWord : allStrings) {
//				if (allConditionsForConcat(part, shortWord)) {
//					return true;
//				}
//			}
//		}
//		return false;		
//	}
//	
//	public String splitSpring(String concatString, String shortString) {
//	return concatString.replace(shortString, "");
//}
//
////	private void workWithAllStringsList () {
////		shortWords = new LinkedList<>();
////		concatWords = new LinkedList<>();
////		for (String st: allStrings) {
////			if (checkListWithStringsForContainsAnotherString (allStrings, st)) {
////				shortWords.add(st);
////			} else {
////				concatWords.add(st);
////			}
////		}
////		
//////		log.info("List of concat word: ");
//////		System.out.println(concatWords.size());
//////		concatWords.forEach(st -> System.out.println(st));
////		log.info("List of short word: ");
////		shortWords.forEach(st -> System.out.println(st));
////		
////	}
//	
//	private boolean checkListWithStringsForContainsAnotherString (List<String> words, String word) {
//		for (String st : words) {
//		if (st.length() > word.length() && st.contains(word)) {
//			return true;
//		}
//	}
//	return false;
//	}
}

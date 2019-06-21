package com.berzenin.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.java.Log;

@Log
class TestApp {
	
	private static List<String> allStrings;
	
	private static App launcher;
	
	@BeforeEach
	public void setParametrs () {
		launcher = new App();
		String link = "C:\\Users\\Fylyp\\Desktop\\words.txt";
		
		Path testFilePath = Paths.get(link);
		log.info("File with strings: " + testFilePath.getFileName().toString());
		allStrings = launcher.setArrayListFoString(testFilePath);
	}
	
	@Test
	void test() {
		String concatString = "catsdogcats";
		String shortString = "cats";
		assertEquals("dog", launcher.splitSpring(concatString, shortString));
	}
	
	@Test
	public void analyzWorldForConcatTest () {
		// Bad argument
		assertEquals(false, allStrings.contains("Filippppp"));
		// First concat words from really array
		List<String> words = Arrays.asList("abolishable", 
				"absorbabilities", "absorb", "abilities",
				"absorbability", "absorb", "ability",
				"absorbable", "absorb", "able",
				"abstractable", "abstract", "able",
				"acceptabilities", "accept", "abilities",
				"acceptability", "accept", "ability",
				"acceptable", "accept", "able",
				"acceptably", "accept", "able",
				"accomplishable", "accomplish", "able",
				"accountabilities", "account", "abilities",
				"accountability","account", "ability",
				"accountable", "account", "able",
				"accountably", "account", "ably",
				"accreditable", "accredit", "able");
		assertEquals(true, allStrings.containsAll(words));
		// Bad argument

		//abolishable
		assertEquals(true, launcher.analyzWorldForConcat("abolishable"));
		assertEquals(false, launcher.analyzWorldForConcat("able"));
		assertEquals(false, launcher.analyzWorldForConcat("abolish"));
		// absorbability
		assertEquals(false, launcher.analyzWorldForConcat("absorb"));
		assertEquals(false, launcher.analyzWorldForConcat("ability"));
		assertEquals(true, launcher.analyzWorldForConcat("absorbability"));
	}

}

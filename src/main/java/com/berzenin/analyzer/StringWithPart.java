package com.berzenin.analyzer;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StringWithPart {
	
	private String name;
	private List <String> parts;
	
	StringWithPart () {
		parts = new ArrayList<>();
	}
	
	public int getNameLength () {
		return this.name.length();
	}

}

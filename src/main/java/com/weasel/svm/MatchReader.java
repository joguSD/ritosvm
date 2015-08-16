package com.weasel.svm;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import models.Match;

import org.codehaus.jackson.map.ObjectMapper;

import Lambda.MatchFunction;

public class MatchReader {

	private static Match readMatch(String json) {

		ObjectMapper mapper = new ObjectMapper();
		Match match = null;

		try {
			match = mapper.readValue(json, Match.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return match;
	}

	//Fetch matches from a file
	public static void scrollMatches(String region, MatchFunction function) {

		Stream<String> lines = null;
		Path path = Paths.get("./matches/" + region.toUpperCase()
				+ "_Objects.json");

		try {
			lines = Files.lines(path);
			
			lines.forEach(line -> function.yield(readMatch(line)));
			
			lines.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
}

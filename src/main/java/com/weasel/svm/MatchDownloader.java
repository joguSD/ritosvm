package com.weasel.svm;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class MatchDownloader {
	private static final String apiKey = "79f23fb6-bffb-4bbd-8eda-f5b2641060ad";
	private static final String urlFormat = "https://%s.api.pvp.net/api/lol/%s/v2.2/match/%d?includeTimeline=false&api_key=%s";

	public static String getMatch(long match, String region) throws InterruptedException {
		String requestString = String.format(urlFormat, region, region, match, apiKey);
		URL url;
		while (true) {
			try {
				url = new URL(requestString);
				HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
				Scanner scanner = new Scanner(hurl.getInputStream());
				String response = scanner.useDelimiter("\\Z").next();
				scanner.close();
				return response;
			} catch (IOException e) {
				// if we get a 429 (too many requests) just sleep and retry
				//FIXME - is there a better way to check if it's a 429...?
				if (e.getMessage().contains("code: 429")) { 
					Thread.sleep(12000);
				} else {
					e.printStackTrace();
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void getMatches(String region) {
		FileWriter file;
		String response;
		JSONParser parser = new JSONParser();

		try {
			JSONArray json = (JSONArray) parser.parse(new FileReader("./matches/" + region.toUpperCase() + ".json"));
			file = new FileWriter("./matches/" + region.toUpperCase() + "_Objects.json");

			int counter = 0;
			Iterator<Long> it = json.iterator();

			// for every match found in the region file
			while (it.hasNext()) {
				counter++;
				long match = it.next();
				response = getMatch(match, region);
				// if response is not null write the json string to file
				if (response != null) {
					file.write(response);
					if (it.hasNext()) file.write("\n");
				}		
				System.out.print(response != null ? "." : "x");
				if (counter % 50 == 0) {
					System.out.print("\n");
				}
			}
			file.close();
			System.out.println("Downloaded: " + counter + " matches.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

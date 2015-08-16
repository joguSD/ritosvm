package com.weasel.svm;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MatchDownloader {
	private static final String apiKey = "c5bdc00b-25f1-4534-bcaf-edede824ffbf";
	private static final String urlFormat = "https://%s.api.pvp.net/api/lol/%s/v2.2/match/%d?includeTimeline=false&api_key=%s";
	
	public static String getMatch(long match, String region){
		String requestString = String.format(urlFormat, region,region,match,apiKey);
		URL url;
		try {
			url = new URL(requestString);
	    	HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
	    	Scanner scanner = new Scanner(hurl.getInputStream());
	    	String response = scanner.useDelimiter("\\Z").next();
	    	scanner.close();
	    	return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void getMatches(String region){
		FileWriter file;
		String response;
		JSONObject matchJson;
		JSONParser parser = new JSONParser();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {			
			JSONArray json = (JSONArray) parser.parse(new FileReader("./matches/"+region.toUpperCase()+".json"));
			file = new FileWriter("./matches/"+region.toUpperCase()+"_Objects.json");
			
			int counter = 0;
			file.write("[");
			Iterator<Long> it = json.iterator();
			while(it.hasNext()) {
				long match = it.next();
				response = getMatch(match, region);
				if(response != null) {
					matchJson = (JSONObject) parser.parse(response);
					file.write(gson.toJson(matchJson));
					if(it.hasNext()){
						file.write(",");
					}
					counter++;
					System.out.print(".");
					if(counter % 20 == 0) {
						System.out.print("\n");
					}	
				}		
				Thread.sleep(1250);
			}
			file.write("]");
			file.close();
			System.out.println("Downloaded: "+counter+" matches.");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}

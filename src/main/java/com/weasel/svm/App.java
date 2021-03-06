package com.weasel.svm;

/**
 * Hello world!
 *
 */

public class App {

	public static void main(String[] args) {
//		long match = 2005587476;
		String region = "na";
//		//String response = MatchDownloader.getMatch(match, region);
//		//System.out.println(response);
//		MatchDownloader.getMatches(region);
		
		MatchReader.scrollMatches(region, match -> {
			System.out.println(match.getParticipants().get(0).getStats().isWinner());
			System.out.println(match.getParticipants().get(0).getHighestAchievedSeasonTier());
		});
	}
}

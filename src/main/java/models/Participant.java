package models;

public class Participant {
	private int participantId;
	private int championId;
	//TODO Runes
	private ParticipantStats stats;
	private int teamId;
	private String spell1Id;
	private String spell2Id;
	private String highestAchievedSeasonTier;
	//TODO Masteries
	
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getSpell1Id() {
		return spell1Id;
	}
	public void setSpell1Id(String spell1Id) {
		this.spell1Id = spell1Id;
	}
	public String getSpell2Id() {
		return spell2Id;
	}
	public void setSpell2Id(String spell2Id) {
		this.spell2Id = spell2Id;
	}
	public ParticipantStats getStats() {
		return stats;
	}
	public void setStats(ParticipantStats stats) {
		this.stats = stats;
	}
	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}
	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}

}

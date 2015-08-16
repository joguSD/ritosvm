package models;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {
	private String matchVersion;
	private String matchType;
	private int matchDuration;
	private String queueType;
	private String season;
	private int mapId;
	private String region;
	private long matchId;
	private String matchMode;
	private List<Participant> participants;
	
	public String getMatchVersion() {
		return matchVersion;
	}
	public void setMatchVersion(String matchVersion) {
		this.matchVersion = matchVersion;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public int getMatchDuration() {
		return matchDuration;
	}
	public void setMatchDuration(int matchDuration) {
		this.matchDuration = matchDuration;
	}
	public String getQueueType() {
		return queueType;
	}
	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public long getMatchId() {
		return matchId;
	}
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
	public String getMatchMode() {
		return matchMode;
	}
	public void setMatchMode(String matchMode) {
		this.matchMode = matchMode;
	}
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
	
}

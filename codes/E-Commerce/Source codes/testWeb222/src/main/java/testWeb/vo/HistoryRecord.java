package testWeb.vo;

public class HistoryRecord {
	private int HistoryRecordID;
	private String exploration_time;
	private String treasure;
	private String picture;
	private String robotname;
	private int newHistoryRecordID;
	private String newexploration_time;
	private String newtreasure;
	private String newPicture;
	private String newRobotname;
	
	public int getNewHistoryRecordID() {
		return newHistoryRecordID;
	}
	public void setNewHistoryRecordID(int newHistoryRecordID) {
		this.newHistoryRecordID = newHistoryRecordID;
	}
	public String getNewexploration_time() {
		return newexploration_time;
	}
	public void setNewexploration_time(String newexploration_time) {
		this.newexploration_time = newexploration_time;
	}
	public String getNewtreasure() {
		return newtreasure;
	}
	public void setNewtreasure(String newtreasure) {
		this.newtreasure = newtreasure;
	}
	public String getNewPicture() {
		return newPicture;
	}
	public void setNewPicture(String newPicture) {
		this.newPicture = newPicture;
	}
	public String getNewRobotname() {
		return newRobotname;
	}
	public void setNewRobotname(String newRobotname) {
		this.newRobotname = newRobotname;
	}
	public String getRobotname() {
		return robotname;
	}
	public void setRobotname(String robotname) {
		this.robotname = robotname;
	}
	public HistoryRecord() {
		
	}
	public HistoryRecord(int historyRecordID, String robotname, String exploration_time, String treasure, String picture) {
		super();
		HistoryRecordID = historyRecordID;
		this.robotname = robotname;
		this.exploration_time = exploration_time;
		this.treasure = treasure;
		this.picture = picture;
	}
	
	public int getHistoryRecordID() {
		return HistoryRecordID;
	}
	public void setHistoryRecordID(int historyRecordID) {
		HistoryRecordID = historyRecordID;
	}
	public String getExploration_time() {
		return exploration_time;
	}
	public void setExploration_time(String exploration_time) {
		this.exploration_time = exploration_time;
	}
	public String getTreasure() {
		return treasure;
	}
	public void setTreasure(String treasure) {
		this.treasure = treasure;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}

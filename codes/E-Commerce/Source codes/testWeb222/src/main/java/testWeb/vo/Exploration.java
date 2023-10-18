package testWeb.vo;

public class Exploration {
	private String robotname;
	private String timestamp;
	private String statistic_of_treasure;
	private String newrobotname;
	public String getNewrobotname() {
		return newrobotname;
	}
	public void setNewrobotname(String newrobotname) {
		this.newrobotname = newrobotname;
	}
	public String getRobotname() {
		return robotname;
	}
	public void setRobotname(String robotname) {
		this.robotname = robotname;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatistic_of_treasure() {
		return statistic_of_treasure;
	}
	public void setStatistic_of_treasure(String statistic_of_treasure) {
		this.statistic_of_treasure = statistic_of_treasure;
	}
	public Exploration(String robotname, String timestamp, String statistic_of_treasure) {
		super();
		this.robotname = robotname;
		this.timestamp = timestamp;
		this.statistic_of_treasure = statistic_of_treasure;
	}
	public Exploration() {
		super();
	}
}

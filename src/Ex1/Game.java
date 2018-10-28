package Ex1;

import java.util.InputMismatchException;

public class Game {
	
	
	private String  homeTeam;
	private String  guestTeam;
	private int guestTeamScore;
	private int homeTeamScore;
	private final int TEAM_NAME_LENGTH = 3;	
	
	public Game(String homeTeam, String guestTeam, int homeTeamScore, int guestTeamScore) {
		setHomeTeam(homeTeam);
		setGuestTeam(guestTeam);
		setHomeTeamScore(homeTeamScore);
		setGuestTeamScore(guestTeamScore);
	}
	
	public Game(String homeTeam, String guestTeam) {
		setHomeTeam(homeTeam);
		setGuestTeam(guestTeam);
	}
	public String getGuestTeam() {
		return guestTeam;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		if(homeTeam.length() == TEAM_NAME_LENGTH)
			this.homeTeam = homeTeam;
		else
			throw new InputMismatchException("Team name - 3 lettes!");
	}
	public int getGuestTeamScore() {
		return guestTeamScore;
	}
	public void setGuestTeam(String guestTeam) {
		if(guestTeam.length() == TEAM_NAME_LENGTH)
			this.guestTeam = guestTeam;
		else
			throw new InputMismatchException("Team name - 3 lettes!");
	}
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setGuestTeamScore(int guestTeamScore) {
		if(guestTeamScore >= 0)
			this.guestTeamScore = guestTeamScore;
		else
			throw new InputMismatchException("Team's score must be grater than 0!");			
	}
	public void setHomeTeamScore(int homeTeamScore) {
		if(homeTeamScore >= 0)
			this.homeTeamScore = homeTeamScore;
		else
			throw new InputMismatchException("Team's score must be grater than 0!");
	}

}

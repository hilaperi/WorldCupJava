package Ex1;

import java.util.InputMismatchException;

import javafx.scene.paint.Color;

public class Team {

	private String countryName;
	private Color firstColor;
	private Color secondaryColor;

	public Team(String countryName, Color firstColor, Color secondaryColor) {
		setCountryName(countryName);
		setfirstColor(firstColor);
		setsecondaryColor(secondaryColor);
	}

	public void setCountryName(String countryName) {		
		if(countryName.length() == 3)
			this.countryName = countryName;
		else
			throw new InputMismatchException("State name must include 3 lettes!");
	}
	public String getCountryName() {
		return countryName;

	}
	public Color getfirstColor() {
		return firstColor;

	}
	public void setfirstColor(Color firstColor) {
		this.firstColor = firstColor;
	}
	public void setsecondaryColor(Color secondaryColor) {
		this.secondaryColor = secondaryColor;
	}
	public Color getsecondaryColor() {
		return secondaryColor;
	}


	@Override
	public String toString() {
		return "Team [countryName=" + countryName + ", firstColor=" + firstColor + ", secondaryColor=" + secondaryColor
				+ "]";
	}
}

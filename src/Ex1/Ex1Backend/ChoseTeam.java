package Ex1.Ex1Backend;

import java.io.IOException;

import Ex1.Game;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChoseTeam {
	
	final static double HEIGHT =400;
	final static double WIDTH =200;
	private static final int SPACE = 30;
	static VBox layot = new VBox(10);
	static VBox layot2 = new VBox(10);
	static GridPane main = new GridPane();
	static VBox vbox = new VBox();
	static Button lblL1 = new Button();
	static Button lblL2 = new Button();
	static Button save = new Button("Save");
	static TextField txtR1 = new TextField();
	static TextField txtR2 = new TextField();
	static Text textTeam = new Text("HOME");
	static Text textTeam2 = new Text("GUEST");
	//static FifaWorldCupDataFileManager b=new FifaWorldCupDataFileManager(null, null);
	private static Game gettxtR1;
	public static void displayNewMatch (String title) {	
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		textTeam.setFill(Color.WHITE);
		textTeam2.setFill(Color.WHITE);
		txtR1.setPromptText("Enter Score Here"); 
		txtR2.setPromptText("Enter Score Here"); 
		main.addRow(0, textTeam, textTeam2);
		main.addRow(1, lblL1, lblL2);
		main.addRow(2, txtR1, txtR2);
		main.setAlignment(Pos.CENTER);
		layot.setStyle("-fx-background-color: #8a000b");
		layot.getChildren().addAll(main,save);
		layot.setAlignment(Pos.CENTER);	
		
		
		
	
	
		Scene scene = new Scene(layot,HEIGHT,WIDTH);
		window.setScene(scene);
		window.show();
		
	}
	public static void displayMatch (String title) {	
		
		Stage window2 = new Stage();
		window2.initModality(Modality.APPLICATION_MODAL);
		window2.setTitle(title);
		window2.setMinWidth(250);
		
		layot2.setStyle("-fx-background-color: #8a000b");
		
		
		
		
		
		Scene scene = new Scene(layot2,HEIGHT,WIDTH);
		window2.setScene(scene);
		window2.show();
		
	}
		
	public String gettxtR1(){
		return txtR1.getText();
		
	}
	public String gettxtR2(){
		return txtR2.getText();
		
	}

}


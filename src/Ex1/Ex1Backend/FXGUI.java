package Ex1.Ex1Backend;
import Ex1.FifaWorldCupData;
import Ex1.FifaWorldCupDataFileManager;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FXGUI extends Application{
	
	private static FifaWorldCupData managr;
	//private static FifaWorldCupData manager;
	final double HEIGHT =1200;
	final double WIDTH =600;

	public static void main(String[] args) throws IOException{
		managr = new FifaWorldCupDataFileManager(".\\teams.bin", ".\\games.bin");
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		MainPane theMainPane=new MainPane();
		Scene scene = new Scene(theMainPane,HEIGHT,WIDTH);
		stage.setTitle("Fifa"); 
		stage.setScene(scene);
		stage.show();
		
		
	}

}

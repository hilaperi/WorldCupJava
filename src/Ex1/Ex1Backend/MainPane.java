package Ex1.Ex1Backend;
import Ex1.FifaWorldCupData;
import Ex1.FifaWorldCupDataFileManager;
import Ex1.Team;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Cursor;
import javafx.scene.layout.GridPane;
import java.util.Random;

public class MainPane extends VBox {
	
	
	private Team currentTeam;
	private FifaWorldCupData manager;

	private final int SPACE = 30;
	private HBox image1 = new HBox();
	private HBox team = new HBox();
	private HBox buttom = new HBox();
	private HBox imageSlider = new HBox();
	private VBox imageSliderCircle = new VBox();
	private HBox imageSlider3 = new HBox();
	private HBox imageSlider4 = new HBox();
	private List<String> list = new ArrayList<String>();
	private List<String> listR = new ArrayList<String>();
	int j;
	double orgCliskSceneX, orgReleaseSceneX, orgCliskSceneXR, orgReleaseSceneXR;
	Button lbutton, rButton, lbutton2, rButton2;
	Text textTeam, textTeam1;
	Label lbl1L, lbl2L, lbl1R, lbl2R;
	ImageView imageView;
	ImageView imageView2;
	GridPane root = new GridPane();
	GridPane root2 = new GridPane();
	GridPane teamNameL = new GridPane();
	GridPane teamNameR = new GridPane();
	public MainPane(String teamsFileName, String gamesFileName) throws IOException {	
		manager = new FifaWorldCupDataFileManager(teamsFileName, gamesFileName);
		currentTeam =manager.nextTeam();			
	}
	
	public MainPane() {
		setupimage();
		setupimageSliderLeft();
		setupimageSliderRight();
		setupButton();
		setupSpacing();
	}

	private void setupimage() {
		ImageView image = new ImageView("file:.\\logo.png");
		image1.getChildren().addAll(image);
		image1.setAlignment(Pos.CENTER);
		image1.setStyle("-fx-background-color: #8a000b");
		getChildren().addAll(image1);
	}

	private void setupimageSliderLeft() {
		try {
			Circle circle1R = new Circle();
			circle1R.setRadius(5);
			circle1R.setFill(randomColor());
			circle1R.setStroke(Color.BLACK);
			Circle circle2R = new Circle();
			circle2R.setRadius(5);
			circle2R.setFill(randomColor());
			circle2R.setStroke(Color.BLACK);
			Text textL = new Text("ARG");
			textL.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
			addToList();

			root2 = new GridPane();
			teamNameL = new GridPane();
			lbl1L = new Label("First Color:");
			lbl2L = new Label("Second Color:");
			lbutton = new Button("<");
			rButton = new Button(">");
			j = 0;
			Image images[] = new Image[list.size()];
			for (int i = 0; i < list.size(); i++) {
				images[i] = new Image(list.get(i));
			}

			imageView = new ImageView(images[j]);
			imageView.setCursor(Cursor.CLOSED_HAND);

			imageView.setOnMouseReleased(e -> {
				orgReleaseSceneX = e.getSceneX();
				if (orgCliskSceneX > orgReleaseSceneX) {
					lbutton.fire();
				} else {
					rButton.fire();
				}				
			});

			rButton.setOnAction(e -> {
				j = j + 1;
				if (j == list.size()) {
					j = 0;
				}
				imageView.setImage(images[j]);
				textL.setText("h");
				circle1R.setFill(randomColor());
				circle2R.setFill(randomColor());
				textL.setText(listR.get(j).replace("file:.\\Photos\\", "").replace(".png", "").toUpperCase());
			});

			lbutton.setOnAction(e -> {
				j = j - 1;
				if (j == 0 || j > list.size() + 1 || j == -1) {
					j = list.size() - 1;
				}
				imageView.setImage(images[j]);
				textL.setText("h");
				circle1R.setFill(randomColor());
				circle2R.setFill(randomColor());
				textL.setText(listR.get(j).replace("file:.\\Photos\\", "").replace(".png", "").toUpperCase());
			});
			teamNameL.addRow(0, textL);
			teamNameL.setStyle("-fx-background-color: blue");
			teamNameL.setAlignment(Pos.BOTTOM_RIGHT);
			imageSlider.setAlignment(Pos.CENTER_LEFT);
			imageSlider.getChildren().addAll(lbutton, imageView, rButton);
			imageSliderCircle.setStyle("-fx-background-color: blue");
			root2.addRow(0, lbl1L, circle1R);
			root2.addRow(1, lbl2L, circle2R);
			root2.setStyle("-fx-background-color: blue");
			root2.setAlignment(Pos.BOTTOM_RIGHT);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setupimageSliderRight() {
		try {

			Circle circle1L = new Circle();
			circle1L.setRadius(5);
			circle1L.setFill(randomColor());
			circle1L.setStroke(Color.BLACK);

			Circle circle2L = new Circle();
			circle2L.setRadius(5);
			circle2L.setFill(randomColor());
			circle2L.setStroke(Color.BLACK);
			Text textR = new Text("ARG");
			textR.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

			
			lbl1R = new Label("First Color:");
			lbl2R = new Label("Second Color:");
			teamNameR = new GridPane();
			root = new GridPane();
			addToListRight();
			
			lbutton2 = new Button("<");
			rButton2 = new Button(">");
			j = 0;
			Image imagesR[] = new Image[listR.size()];
			for (int i = 0; i < listR.size(); i++) {
				imagesR[i] = new Image(listR.get(i));
			}

			imageView2 = new ImageView(imagesR[j]);
			imageView2.setCursor(Cursor.CLOSED_HAND);

			imageView2.setOnMouseReleased(e -> {
				orgReleaseSceneXR = e.getSceneX();
				if (orgCliskSceneXR > orgReleaseSceneXR) {
					lbutton2.fire();
				} else {
					rButton2.fire();
				}
			});

			lbutton2.setOnAction(e -> {
				j = j + 1;
				if (j == listR.size()) {
					j = 0;
				}
				imageView2.setImage(imagesR[j]);
				circle2L.setFill(randomColor());
				circle1L.setFill(randomColor());
				textR.setText(listR.get(j).replace("file:.\\Photos\\", "").replace(".png", "").toUpperCase());
			
			});

			rButton2.setOnAction(e -> {
				j = j - 1;
				if (j == 0 || j > listR.size() + 1 || j == -1) {
					j = listR.size() - 1;
				}
				imageView2.setImage(imagesR[j]);
				circle2L.setFill(randomColor());
				circle1L.setFill(randomColor());
				textR.setText(listR.get(j).replace("file:.\\Photos\\", "").replace(".png", "").toUpperCase());
			});
			teamNameR.addRow(0, textR);
			teamNameR.setAlignment(Pos.CENTER_LEFT);
			imageSlider4.setStyle("-fx-background-color: blue");
			
			imageSlider4.getChildren().addAll(teamNameL, teamNameR);
			imageSlider.setAlignment(Pos.CENTER_RIGHT);
			imageSlider.getChildren().addAll(lbutton2, imageView2, rButton2);
			imageSlider.setStyle("-fx-background-color: blue");
			root.addRow(0, lbl1R, circle1L);
			root.addRow(1, lbl2R, circle2L);
			imageSlider3.setStyle("-fx-background-color: blue");
			root.setAlignment(Pos.CENTER_LEFT);
			imageSlider3.getChildren().addAll(root2, root);
			getChildren().addAll(imageSlider4,imageSlider, imageSlider3);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addToListRight() {
		listR.add("file:.\\Photos\\arg.png");
		listR.add("file:.\\Photos\\aus.png");
		listR.add("file:.\\Photos\\bel.png");
		listR.add("file:.\\Photos\\bra.png");
		listR.add("file:.\\Photos\\col.png");
		listR.add("file:.\\Photos\\crc.png");
		listR.add("file:.\\Photos\\cro.png");
		listR.add("file:.\\Photos\\den.png");
		listR.add("file:.\\Photos\\egy.png");
		listR.add("file:.\\Photos\\eng.png");
		listR.add("file:.\\Photos\\esp.png");
		listR.add("file:.\\Photos\\fra.png");
		listR.add("file:.\\Photos\\ger.png");
		listR.add("file:.\\Photos\\irn.png");
		listR.add("file:.\\Photos\\isl.png");
		listR.add("file:.\\Photos\\jpn.png");
		listR.add("file:.\\Photos\\kor.png");
		listR.add("file:.\\Photos\\ksa.png");
		listR.add("file:.\\Photos\\mar.png");
		listR.add("file:.\\Photos\\mex.png");
		listR.add("file:.\\Photos\\nga.png");
		listR.add("file:.\\Photos\\pan.png");
		listR.add("file:.\\Photos\\per.png");
		listR.add("file:.\\Photos\\pol.png");
		listR.add("file:.\\Photos\\por.png");
		listR.add("file:.\\Photos\\rus.png");
		listR.add("file:.\\Photos\\sen.png");
		listR.add("file:.\\Photos\\srb.png");
		listR.add("file:.\\Photos\\sui.png");
		listR.add("file:.\\Photos\\swe.png");
		listR.add("file:.\\Photos\\tun.png");
		listR.add("file:.\\Photos\\uru.png");

	}

	private void addToList() {
		list.add("file:.\\Photos\\arg.png");
		list.add("file:.\\Photos\\aus.png");
		list.add("file:.\\Photos\\bel.png");
		list.add("file:.\\Photos\\bra.png");
		list.add("file:.\\Photos\\col.png");
		list.add("file:.\\Photos\\crc.png");
		list.add("file:.\\Photos\\cro.png");
		list.add("file:.\\Photos\\den.png");
		list.add("file:.\\Photos\\egy.png");
		list.add("file:.\\Photos\\eng.png");
		list.add("file:.\\Photos\\esp.png");
		list.add("file:.\\Photos\\fra.png");
		list.add("file:.\\Photos\\ger.png");
		list.add("file:.\\Photos\\irn.png");
		list.add("file:.\\Photos\\isl.png");
		list.add("file:.\\Photos\\jpn.png");
		list.add("file:.\\Photos\\kor.png");
		list.add("file:.\\Photos\\ksa.png");
		list.add("file:.\\Photos\\mar.png");
		list.add("file:.\\Photos\\mex.png");
		list.add("file:.\\Photos\\nga.png");
		list.add("file:.\\Photos\\pan.png");
		list.add("file:.\\Photos\\per.png");
		list.add("file:.\\Photos\\pol.png");
		list.add("file:.\\Photos\\por.png");
		list.add("file:.\\Photos\\rus.png");
		list.add("file:.\\Photos\\sen.png");
		list.add("file:.\\Photos\\srb.png");
		list.add("file:.\\Photos\\sui.png");
		list.add("file:.\\Photos\\swe.png");
		list.add("file:.\\Photos\\tun.png");
		list.add("file:.\\Photos\\uru.png");

	}

	private void setupButton() {
		Button new_match = new Button("New match");
		Button matchs = new Button("Matchs");
		buttom.getChildren().addAll(new_match, matchs);
		buttom.setAlignment(Pos.BOTTOM_CENTER);
		getChildren().addAll(buttom);
		
		new_match.setOnAction(e -> ChoseTeam.displayNewMatch("Add new game"));
		matchs.setOnAction(e -> ChoseTeam.displayMatch("Recent Matches"));

	}

	private Color randomColor() {
		Random random = new Random();
		return Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
	}

	private void setupSpacing() {

		team.setSpacing(SPACE / 2);
		buttom.setSpacing(SPACE / 2);
		buttom.setPadding(new Insets(13, 100, 13, 100));
		imageSlider.setSpacing(SPACE / 2);
		imageSlider3.setSpacing(150);
		imageSlider.setPadding(new Insets(10,10,5,5));
		imageSlider3.setPadding(new Insets(15,30,15,15));
		root2.setPadding(new Insets(0, 400, 0, 230));
		imageSlider4.setSpacing(170);
		imageSlider4.setPadding(new Insets(15,10,0,5));
		teamNameL.setPadding(new Insets(0, 400, 0, 300));
		
	}
	
	
}
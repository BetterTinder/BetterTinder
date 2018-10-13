import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UserProfile {
	ArrayList<String> images = new ArrayList<String>();
	Image image;
	ImageView view = new ImageView();
	Text userBio;

	public UserProfile() {
		//import method to return the array
		getBio();
		images.add("profile.jpg");
		images.add("Test1.JPG");
		image = new Image(images.get(0));
		change(image);
	}

	public ImageView change(Image image) {
		view.setImage(image);
		view.setFitWidth(250);
		view.setFitHeight(250);
		view.setX(105);
		view.setY(30);
		view.setScaleX(1);
		view.setScaleY(1);
		view.setPreserveRatio(true);
		return view;
	}

	public void getBio() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("BioTest.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String bio = null;
		try {
			bio = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (bio !=null) {
			sb.append(bio).append("\n");
			try {
				bio = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String userBioString = sb.toString();
		userBio = new Text(userBioString);
	}

	public void start(Stage ProfileStage) {
		//Pane
		StackPane borderPane = new StackPane();
		Scene ProfileScene = new Scene(borderPane, 400, 500); 
		VBox vbox = new VBox();
		
		
		//Left Scroll
		Button leftscroll = new Button("<");
		leftscroll.setPadding(new Insets(15,15,15,15));
		leftscroll.setLayoutX(400);
		leftscroll.setLayoutY(400);
		

		leftscroll.setOnAction(click->{
			Collections.rotate(images, 1);
			image = new Image(images.get(0));
			view=change(image);
			System.out.println(images.get(0));
		});

		//Right Scroll
		Button rightscroll = new Button(">");

		rightscroll.setPadding(new Insets(15,15,15,15));


		rightscroll.setOnAction(click->{
			Collections.rotate(images, -1);
			image = new Image(images.get(0));
			view = change(image);
			System.out.println(images.get(0));
		});

		//Add text and image to Pane
		userBio.setX(20.0f);
		userBio.setY(350.0f);
		borderPane.getChildren().addAll(view,userBio,leftscroll);

		//Stage
		ProfileStage.setResizable(false);
		ProfileStage.setTitle("Riddle Vision");
		ProfileStage.setScene(ProfileScene); 
		ProfileStage.show(); 
	}
}


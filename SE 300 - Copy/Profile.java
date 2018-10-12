
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
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Profile extends Application{
	ArrayList<String> images = new ArrayList<String>();
	Image image;
	ImageView view = new ImageView();

	public Profile() {
		//import method to return the array
		images.add("profile.jpg");
		images.add("Test1.JPG");
		image = new Image(images.get(0));
		change(image);
	}

	public ImageView change(Image image) {
		view.setImage(image);
		view.setFitWidth(250);
		view.setFitHeight(250);
		view.setPreserveRatio(true);
		view.setX(130);
		view.setY(30);
		return view;
	}

	public void start(Stage ProfileStage) {
		//Pane
		BorderPane borderPane = new BorderPane();
		Scene ProfileScene = new Scene(borderPane, 400, 500); 

		//Left Scroll
		Button leftscroll = new Button("<");
		leftscroll.setPadding(new Insets(15,15,15,15));
		borderPane.setLeft(leftscroll);
		borderPane.setMargin(leftscroll, new Insets(250, 50, 50, 50));
		leftscroll.setOnAction(click->{
			Collections.rotate(images, 1);
			image = new Image(images.get(0));
			view=change(image);
			System.out.println(images.get(0));
		});

		//Right Scroll
		Button rightscroll = new Button(">");
		rightscroll.setPadding(new Insets(15,15,15,15));
		borderPane.setRight(rightscroll);
		borderPane.setMargin(rightscroll, new Insets(250, 50, 50, 50));
		rightscroll.setOnAction(click->{
			Collections.rotate(images, -1);
			image = new Image(images.get(0));
			view = change(image);
			System.out.println(images.get(0));
		});


		borderPane.getChildren().add(view);
		//Stage
		ProfileStage.setResizable(false);
		ProfileStage.setTitle("Riddle Vision");
		ProfileStage.setScene(ProfileScene); 
		ProfileStage.show(); 
	}
}

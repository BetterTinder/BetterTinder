
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Profile extends Application{
	ArrayList<String> imagesList = new ArrayList<String>();
	Image image; ImageView view = new ImageView();
	Text userBio;
	String name = new String("Keanu Reeves"); //Assuming the name will be passed in as a parameter from the manager

	public Profile() {
		//import method to return the array
		getBio();
		imagesList.add("profile.jpg");
		imagesList.add("Test1.JPG");
		image = new Image(imagesList.get(0));
		change(image);
	}

	public ImageView change(Image image) {
		view.setImage(image);
		view.setFitWidth(250);
		view.setFitHeight(250);
		view.setTranslateX(1);
		view.setTranslateY(-90);
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
		userBio.setWrappingWidth(400);
	}

	public VBox getLeftBtn(){
		//Left Scroll
		Button leftscroll = new Button("<");
		VBox lvbox = new VBox();
		lvbox.setTranslateX(50);
		lvbox.setTranslateY(150);
		lvbox.getChildren().add(leftscroll);
		leftscroll.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Collections.rotate(imagesList, 1);
				image = new Image(imagesList.get(0));
				view=change(image);
				//	System.out.println(imagesList.get(0));
			}
		});
		return lvbox;
	}

	public VBox getRightBtn() {
		Button rightscroll = new Button(">");
		VBox rvbox = new VBox();
		rvbox.setTranslateX(325);
		rvbox.setTranslateY(150);
		rvbox.getChildren().add(rightscroll);
		rightscroll.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Collections.rotate(imagesList, -1);
				image = new Image(imagesList.get(0));
				view = change(image);
				//				System.out.println(imagesList.get(0));
			}
		});
		return rvbox;
	}

	public VBox getAddBtn() {
		Button add = new Button("Add");
		VBox addVBox = new VBox();
		addVBox.setTranslateX(120);
		addVBox.setTranslateY(295);
		addVBox.getChildren().add(add);
		add.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Stage getImageStage = new Stage();
				FileChooser photoChosen = new FileChooser();
				checkFileChooser(photoChosen);
				photoChosen.setTitle("Riddle Vision: Grab A Photo");
				File file = photoChosen.showOpenDialog(getImageStage);
				if (file !=null) {
					String filename = file.getName(); //grabs the name of the imported photo
					imagesList.add(filename); //adds it to the list
					System.out.print(imagesList);
					String directory = ("P:\\eclipse-workplace\\SE 300\\");//The directory
					String reLocateFileName = directory + filename;//The directory + The files name
					file.renameTo(new File(reLocateFileName)); //adds the image to directory
				}
			}
			private void checkFileChooser(FileChooser photoChosen) {
				photoChosen.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("JPG", "*.Jpg"),
						new FileChooser.ExtensionFilter("PNG", "*.Png"),
						new FileChooser.ExtensionFilter("jpg", "*.jpg"),
						new FileChooser.ExtensionFilter("png", "*.png")
						);
			}

		});

		return addVBox;
	}

	public VBox getRemoveBtn() {
		Button remove = new Button("Remove");
		VBox removeVBox = new VBox();
		removeVBox.setTranslateX(220);
		removeVBox.setTranslateY(295);
		removeVBox.getChildren().add(remove);
		remove.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				String currentfile=	imagesList.get(0);
				imagesList.remove(0);
				System.out.println(currentfile);
				File fileRemove = new File(currentfile);
				fileRemove.delete(); //remove from the directory
			}
		});
		return removeVBox;
	}

	public VBox getSettingBtn() {
		Button setting = new Button("Settings");
		VBox setVBox = new VBox();
		setVBox.setTranslateX(1);
		setVBox.setTranslateY(1);
		setVBox.getChildren().add(setting);

		setting.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				//		System.out.println("Settings");
			}
		});
		return setVBox;

	}

	public void start(Stage ProfileStage) {
		//Pane
		StackPane borderPane = new StackPane();
		Scene ProfileScene = new Scene(borderPane, 400, 500); 

		//Add the Buttons
		borderPane.getChildren().addAll(getLeftBtn(),getRightBtn(),getAddBtn(),
				getRemoveBtn());//getSettingBtn());

		//Add text and image to Pane
		Text username = new Text(name); //Converts the parameter name to a text
		username.setTranslateX(4.0f);
		username.setTranslateY(-230.0f);
		userBio.setTranslateX(10.0f);
		userBio.setTranslateY(100.0f);
		borderPane.getChildren().addAll(username,userBio,view);

		//Stage
		ProfileStage.setResizable(false);
		ProfileStage.setTitle("Riddle Vision");
		ProfileStage.setScene(ProfileScene); 
		ProfileStage.show(); 
	}
}

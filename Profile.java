
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Profile extends GridPane{
	String directory = System.getProperty("user.dir"); String dir = directory + ("\\\\");
	ArrayList<String> imagesList = new ArrayList<String>();
	Image image; ImageView view = new ImageView();
	String name = new String("Keanu Reeves"); //Assuming the name will be passed in as a parameter from the manager
	/**
	 * 
	 * @param grid1
	 * @param grid2
	 */
	Profile(GridPane grid1, Setting grid2) {
		HBox Hbox1 = new HBox(268);
		Hbox1.setTranslateX(40);
		Hbox1.setTranslateY(165);
		Hbox1.getChildren().addAll(getLeftBtn(),getRightBtn());
		HBox Hbox2 = new HBox(5);
		Hbox2.setTranslateX(1);
		Hbox2.setTranslateY(1);
		Hbox2.getChildren().addAll(getSettingBtn(grid1,grid2),getAddBtn(),getRemoveBtn());
		imagesList.add("profile.jpg"); //must change to get default image or the first image
		imagesList.add("Test1.jpg");
		image = new Image(imagesList.get(0));
		change(image);
		this.setGridLinesVisible(true);
		this.getChildren().addAll(Hbox2,Hbox1,view,getname());
	}

	public ImageView change(Image image) {
		view.setImage(image);
		view.setFitWidth(250);
		view.setFitHeight(250);
		view.setTranslateX(1);
		view.setTranslateY(70);
		view.setScaleX(1);
		view.setScaleY(1);
		view.setPreserveRatio(true);
		return view;
	}

	public Text getBio() {
		BufferedReader br = null;
		Text userBio;
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
		//	 TODO Auto-generated catch block
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
		userBio.setTranslateX(10.0f);
		userBio.setTranslateY(230.0f);
		return userBio;
	}

	public Button getLeftBtn(){
		//Left Scroll
		Button leftscroll = new Button("<");
		leftscroll.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Collections.rotate(imagesList, 1);
				image = new Image(imagesList.get(0));
				view=change(image);
				//System.out.println(imagesList.get(0));
			}
		});
		return leftscroll;
	}

	public Button getRightBtn() {
		Button rightscroll = new Button(">");
		rightscroll.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Collections.rotate(imagesList, -1);
				image = new Image(imagesList.get(0));
				view = change(image);
			}
		});
		return rightscroll;
	}

	public Button getAddBtn() { //Reads the file
		Button add = new Button("Add");
		add.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Stage getImageStage = new Stage();
				FileChooser photoChosen = new FileChooser();
				checkFileChooser(photoChosen);
				photoChosen.setTitle("Riddle Vision: Grab A Photo");
				File file = photoChosen.showOpenDialog(getImageStage);
				//So no error pops up in the console if the user decided to cancel, because a photo is not required
				if (file !=null) {
					if (imagesList.size()<5){
					String filename = file.getName(); //grabs the name of the imported photo
					imagesList.add(2,filename); //adds it to the list
					String reLocateFileName = dir + filename;//The directory + The files name
					file.renameTo(new File(reLocateFileName)); //adds the image to directory
				}}
				System.out.print(imagesList.size());
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
		return add;
	}

	public Button getRemoveBtn() {
		Button remove = new Button("Remove");
		remove.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				String currentfile=	imagesList.get(0);
				imagesList.remove(0);
				System.out.println(currentfile);
				File fileRemove = new File(currentfile);
				fileRemove.delete(); //remove from the directory
			}
		});
		return remove;
	}

	public Button getSettingBtn(GridPane gridPane1, Setting gridPane2) {
		Button setting = new Button("Settings");
		setting.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				gridPane1.getChildren().add(gridPane2);
			}
		});
		return setting;
	}

	public Text getname() {
		Text username = new Text(name); //Converts the parameter name to a text
		username.setTranslateX(4.0f);
		username.setTranslateY(-70.0f);
		return username;
	}

}

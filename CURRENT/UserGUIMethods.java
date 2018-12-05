import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UserGUIMethods extends GridPane{
	String directory = System.getProperty("user.dir"); String dir = directory + ("\\\\");
	ArrayList<String> imagesList = new ArrayList<String>(); ArrayList<String> imagesListCopy = new ArrayList<String>(); 
	Image image; ImageView view = new ImageView();
	UserID userID = new UserID();
	String currentUser;

	UserGUIMethods(HBox hBox, GridPane rootpane) {
		currentUser();
	}
	public void currentUser() {
		try {
			currentUser = userID.getUserID();
		} catch (IOException e) {
			userID.alertUser();
		}
	}
	/**
	 * 
	 * @return hBox
	 * Has the left and right scroll buttons
	 */
	public HBox getHbox1() {
		HBox Hbox1 = new HBox(260);
		Hbox1.setTranslateX(40);
		Hbox1.setTranslateY(165);
		Hbox1.getChildren().addAll(getLeftBtn(),getRightBtn());
		return Hbox1;
	}
	/**
	 * 
	 * @param sett
	 * @param rootpane
	 * @return
	 */
	public HBox getHbox2(HBox hbox, GridPane rootpane) {
		HBox Hbox2 = new HBox(5);
		Hbox2.setTranslateX(1);
		Hbox2.setTranslateY(1);
		Hbox2.getChildren().addAll(getAddBtn(),getRemoveBtn(),getSettingBtn(hbox, rootpane));
		Hbox2.getChildren().add(sendBio(getBio()));
		return Hbox2;
	}
	/**
	 * Getting the user's pictures from SQL
	 */
	public void grabImageFromSQL() {
		imagesList.add("profile.jpg"); //must change to get default image or the first image
		imagesList.add("Test1.jpg");
		imagesListCopy.add("profile.jpg");
		imagesListCopy.add("Test1.jpg");
		image = new Image(imagesList.get(0));
		change(image);
	}
	/**
	 * 
	 * returns an image of a star for the review
	 */
	public ImageView getReviewImage() {
		ImageView view = new ImageView();
		image = new Image("star.png");
		view.setImage(image);
		view.setFitWidth(25);
		view.setFitHeight(25);
		view.setTranslateX(250.0f);
		view.setTranslateY(-70.0f);
		view.setScaleX(1);
		view.setScaleY(1);
		view.setPreserveRatio(true);
		return view;
	}
	/**
	 * 
	 * reads for the review rating and displays it to the profile
	 */
	public Text getReviewRating() {
		SQLData Database = SQLData.getInstance();
		Database.makeCon(Database);
		String[] col = {"Review"};
		String rev = Database.readData(currentUser, col).get(0);
		Database.closeCon();
		Text review = new Text("Rating: "+rev+"/5.00");
		review.setWrappingWidth(400);
		review.setTranslateX(230.0f);
		review.setTranslateY(-70.0f);
		return review;
	}
	/**
	 * 
	 * @param image
	 * @return it updates the pane with correct image when scrolling
	 */
	public ImageView change(Image image) {
		view.setImage(image);
		view.setFitWidth(250);
		view.setFitHeight(250);
		view.setTranslateX(75);
		view.setTranslateY(70);
		view.setScaleX(1);
		view.setScaleY(1);
		//view.setPreserveRatio(true);
		return view;
	}
	/**
	 * 
	 * @return finds and displays the user's bio information as a text on the pane
	 */
	public TextField getBio() {
		TextField bio = new TextField();
		bio.setMaxWidth(400);
		bio.setTranslateX(10.0f);
		bio.setTranslateY(230.0f);
		return bio;
	}
	/**
	 * 
	 * @param bio
	 * @return
	 */
	public Button sendBio(TextField bio) {
		Button sendbio = new Button("Send Bio");
		sendbio.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SQLData sqlData = SQLData.getInstance();
				sqlData.makeCon(sqlData);
				String[] column = {"Bio"};
				String[] values = {bio.getText()};
				System.out.println("This is the current bio:"+values);
				sqlData.updateData(currentUser, column, values);
				sqlData.closeCon();
			}
		});		
		return sendbio;
	}
	/**
	 * 
	 * @return the other user's bio from SQL that the current user matched with
	 */

	/**
	 * 
	 * @return the left button with its action event to shift the array of images to the left, calls the change method
	 */
	public Button getLeftBtn(){
		Button leftscroll = new Button("<");
		leftscroll.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Collections.rotate(imagesList, 1);
				image = new Image(imagesList.get(0));
				view=change(image);
				//System.out.println(imagesList);
				//System.out.println(imagesListCopy);	
			}
		});
		return leftscroll;
	}
	/**
	 * 
	 * @return
	 */
	public Button getRightBtn() {
		Button rightscroll = new Button(">");
		rightscroll.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Collections.rotate(imagesList, -1);
				image = new Image(imagesList.get(0));
				view = change(image);
				//	System.out.println(imagesList);
				//	System.out.println(imagesListCopy);	
			}
		});

		return rightscroll;
	}
	/**
	 * 
	 * @return the right button with its action event to shift the array of images to the right, calls change method
	 */
	public Button getAddBtn() { //Reads the file
		Button add = new Button("Add");
		add.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Stage getImageStage = new Stage();
				FileChooser photoChosen = new FileChooser();
				checkFileChooser(photoChosen);
				photoChosen.setTitle("Riddle Vision: Grab A Photo");
				File file = photoChosen.showOpenDialog(getImageStage);
				if (file !=null) {
					if (imagesList.size()<5){
						String filename = file.getName(); 
						imagesListCopy.add(filename);
						imagesList.clear();
						for (int j = 0 ; j<imagesListCopy.size();j++) {
							System.out.println(imagesList);
							imagesList.add(imagesListCopy.get(j));
						}
						String reLocateFileName = dir + filename;
						file.renameTo(new File(reLocateFileName));
						//		System.out.println(imagesList);
						//		System.out.println(imagesListCopy);
						System.out.println(imagesList.size());
					}else {

					}

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
		return add;
	}
	/**
	 * 
	 * @return removes the first image being displayed from the imagelist
	 */
	public Button getRemoveBtn() {
		Button remove = new Button("Remove");
		remove.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				String currentfile=	imagesList.get(0);
				imagesList.remove(0);
				imagesListCopy.clear();
				for (int j = 0 ; j<imagesList.size();j++) { //update the main
					//System.out.println(imagesList);
					imagesListCopy.add(imagesList.get(j));
				}
				//System.out.println(currentfile);
				File fileRemove = new File(currentfile);
				fileRemove.delete(); //remove from the directory

			}
		});
		return remove;
	}
	/**
	 * 
	 * @param hBox 
	 * @param hBox 
	 * @return setting button calls for the setting class and changes panes
	 */
	public Button getSettingBtn(HBox hbox, GridPane root) {
		Setting set = new Setting(hbox,root);
		Button setting = new Button("Settings");
		setting.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				root.getChildren().clear();
				root.getChildren().add(set);
				set.runOnButton();
			}
		});
		return setting;
	}
	/**
	 * 
	 * @return reads and displays the user's name
	 */
	public Text getname() {
		SQLData Database = SQLData.getInstance();
		Database.makeCon(Database);
		String[] col = {"FirstName","LastName"};
		String FName = Database.readData(currentUser, col).get(0);
		String LName = Database.readData(currentUser, col).get(1);
		Database.closeCon();
		Text username = new Text(FName+" "+LName);
		username.setTranslateX(110.0f);
		username.setTranslateY(-70.0f);
		return username;
	}
}



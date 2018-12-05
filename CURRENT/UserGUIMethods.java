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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UserGUIMethods extends GridPane{
	String directory = System.getProperty("user.dir"); String dir = directory + ("\\\\");
	ArrayList<String> imagesList = new ArrayList<String>(); ArrayList<String> imagesListCopy = new ArrayList<String>(); 
	Image image; ImageView view = new ImageView();
	UserID userID = new UserID();
	String currentUser;
	TextField bio = new TextField("Enter new bio");

	UserGUIMethods(HBox hBox, GridPane rootpane) {
		currentUser();
	}
	/**
	 * reads the UserId text file
	 */
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
		review.setFont(Font.font("Lucida Bright"));
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
	 * @return moves the image to the left by coolection.roatate the array list +1
	 */
	public Button getLeftBtn(){
		Button leftscroll = new Button("<");
		leftscroll.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 15));
		leftscroll.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
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
	 * @return moves the image to the right by coolection.roatate the array list -1
	 */
	public Button getRightBtn() {
		Button rightscroll = new Button(">");
		rightscroll.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 15));
		rightscroll.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
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
	 * @return Adds the image (string name) to the array list
	 */
	public Button getAddBtn() { //Reads the file
		Button add = new Button("Add");
		add.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		add.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		add.setMinSize(85, 20);
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
	 * @return removes the first image being displayed from the image list
	 */
	public Button getRemoveBtn() {
		Button remove = new Button("Remove");
		remove.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		remove.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		remove.setMinSize(85, 20);
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

}
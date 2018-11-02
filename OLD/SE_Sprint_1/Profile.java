
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Profile extends GridPane{
	String directory = System.getProperty("user.dir"); String dir = directory + ("\\\\");
	ArrayList<String> imagesList = new ArrayList<String>(); ArrayList<String> imagesListCopy = new ArrayList<String>(); 
	Image image; ImageView view = new ImageView();
	String name = new String("Keanu Reeves"); //Assuming the name will be passed in as a parameter from the manager

	Profile() {
		Manager manager = new Manager();
		Stage stage = new Stage();
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		
		HBox Hbox1 = new HBox(270);
		Hbox1.setTranslateX(40);
		Hbox1.setTranslateY(165);
		Hbox1.getChildren().addAll(getLeftBtn(),getRightBtn());
		HBox Hbox2 = new HBox(5);
		Hbox2.setTranslateX(1);
		Hbox2.setTranslateY(1);
		Hbox2.getChildren().addAll(getAddBtn(),getRemoveBtn(),getSettingBtn());
				//,getReviewImage());
		HBox Hbox3 = new HBox(5);
		Hbox3.getChildren().addAll(manager.MainPane(stage));
		
		imagesList.add("profile.jpg"); //must change to get default image or the first image
		imagesList.add("Test1.jpg");
		imagesListCopy.add("profile.jpg");
		imagesListCopy.add("Test1.jpg");
		image = new Image(imagesList.get(0));
		change(image);
		
		this.setStyle(style);
		this.getChildren().addAll(Hbox3,Hbox2,Hbox1,view,getname(),getReviewRating(),getBio(),getReviewImage());
	}
	/**
	 * 
	 * returns an image of a star for the review
	 */
	public ImageView getReviewImage() {
		Image reviewImage;
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
		BufferedReader br = null;
		Text review;
		/*
		try {
			br = new BufferedReader(new FileReader("Review.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String reviewString = null;
		try {
			reviewString= br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (reviewString !=null) {
			sb.append(reviewString).append("\n");
			try {
				reviewString = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String reviewString2 = sb.toString();
		*/
		String reviewString2 = new String("5.0");
		review = new Text(reviewString2);
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
		view.setTranslateX(80);
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
	public Text getBio() {
		BufferedReader br = null;
		Text userBio;
		/*
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
		*/
		String userBioString = new  String("Hello my name is Keanu Reeve, falling in love and having a relationship are two different things.");
		userBio = new Text(userBioString);
		userBio.setWrappingWidth(400);
		userBio.setTranslateX(10.0f);
		userBio.setTranslateY(230.0f);
		return userBio;
	}
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
				//So no error pops up in the console if the user decided to cancel, because a photo is not required
				if (file !=null) {
					if (imagesList.size()<5){ //No more than 5 images
						String filename = file.getName(); 
						imagesListCopy.add(filename); //Add the file to the copy
						imagesList.clear(); //delete the main
						for (int j = 0 ; j<imagesListCopy.size();j++) { //update the main
							System.out.println(imagesList);
							imagesList.add(imagesListCopy.get(j));
						}
						String reLocateFileName = dir + filename;//The directory + The files name
						file.renameTo(new File(reLocateFileName)); //adds the image to directory
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
	 * @return setting button calls for the setting class and changes panes
	 */
	public Button getSettingBtn() {
		Button setting = new Button("Settings");
		setting.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Manager manager = new Manager();
				Stage stage = new Stage();
				manager.startSet(stage);
			}
		});
		return setting;
	}
	/**
	 * 
	 * @return reads and displays the user's name
	 */
	public Text getname() {
		Text username = new Text(name); //Converts the parameter name to a text
		username.setTranslateX(110.0f);
		username.setTranslateY(-70.0f);
		return username;
	}
}

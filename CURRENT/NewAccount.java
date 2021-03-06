import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
/**
 * 
 * @author Chris
 *
 */
public class NewAccount extends Setting  {

	/**
	 * the new account pane constructor. It adds things to the pane
	 * @param hbox
	 * @param prof
	 */
	TextField name = new TextField();
	TextField FirstName = new TextField();
	TextField LastName = new TextField();
	TextField Password = new TextField();
	
	NewAccount(HBox hbox, Profile prof) {
		super(hbox, prof);
		getAgeSlider(ageSlider);
		getAgeSlider(ageMinSlider);
		getAgeSlider(ageMaxSlider);
		getMatchPercent();   
		String style = "-fx-background-color: #52858F";
		name.setMaxWidth(150);
		name.setPromptText("Enter Username");
		FirstName.setMaxWidth(150);
		FirstName.setPromptText("Enter First Name");
		LastName.setMaxWidth(150);
		LastName.setPromptText("Enter Last Name");
		Password.setMaxWidth(150);
		Password.setPromptText("Enter Password");
		
		/*
        Label username = new Label("Username:");
        Label userFirst = new Label("First Name:");
        Label userLast = new Label("Last Name:");
        Label pass = new Label("Password:");
		 */

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(1,25,0,25));
		gridPane.setStyle(style);
		gridPane.add(name,0,0);
		gridPane.add(Password,1,0);
		gridPane.add(FirstName,0,2);
		gridPane.add(LastName,1,2);
		gridPane.add(comboBox,1,6);
		gridPane.add(genPrefLabel, 0, 5);
		gridPane.add(genIdenLabel, 0, 4);
		gridPane.add(genderPref, 1, 5);
		gridPane.add(genderIden, 1, 4);
		gridPane.add(match, 0, 7);
		gridPane.add(matchPercentage, 1, 7);
		gridPane.add(age, 0, 8);
		gridPane.add(ageSlider, 1, 8);
		gridPane.add(location, 0, 6);
		gridPane.add(agePref, 0, 9);
		gridPane.add(ageMin, 0, 10);
		gridPane.add(ageMinSlider, 1, 10);
		gridPane.add(ageMax, 0, 11);
		gridPane.add(ageMaxSlider, 1, 11);
		gridPane.add(intrest, 0, 12);
		gridPane.add(dog, 0, 13);
		gridPane.add(dogBox, 1, 13);
		gridPane.add(dogHave, 0, 14);
		gridPane.add(dogHaveBox, 1, 14);
		gridPane.add(vegetarian, 0, 15);
		gridPane.add(vegetarianBox, 1, 15);
		gridPane.add(movie, 0, 16);
		gridPane.add(movieBox, 1, 16);
		gridPane.add(walking, 0, 17);
		gridPane.add(walkingBox, 1, 17);
		gridPane.add(music, 0, 18);
		gridPane.add(musicBox, 1, 18);
		gridPane.add(democracy, 0, 19);
		gridPane.add(democracyBox, 1, 19);
		gridPane.add(save, 1, 20);

		//event handlers for the combo boxes
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(comboBox.getValue()!=null && dogHaveBox.getValue()!=null && vegetarianBox.getValue()!=null && movieBox.getValue()!=null && walkingBox.getValue()!=null && musicBox.getValue()!=null && democracyBox.getValue()!=null && genderPref.getValue()!=null&&genderIden.getValue()!=null) {
					if (ageMinSlider.getValue()<=ageMaxSlider.getValue()) {
						sendToProfile();
						System.out.println("Changes saved");
						//sendToDatabase isn't here, because I left it in Settings
						userToDatabase(name, FirstName, LastName, Password, matchPercentage, ageMinSlider, ageMaxSlider, comboBox, ageSlider, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderPref, genderIden);
					}
					else {
						System.out.println("correct yo age");
					}
				}
				else
					System.out.println("Please fill in all values");

			}

			/**
			 * this sends the user to the profile screen after creating their account
			 */
			private void sendToProfile() {
				gridPane.getChildren().clear();
				gridPane.getChildren().add(prof);
			}
		});

		this.getChildren().add(gridPane);
	}    
	/**
	 * sends the newAccount specific vars to the SQL database
	 * @param name
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public void userToDatabase(TextField name, TextField firstName, TextField lastName, TextField password, Slider matchPercentage, Slider ageMinSlider, Slider ageMaxSlider, ComboBox<String> comboBox, Slider ageSlider,
			ComboBox<String> comboBox2, ComboBox<String> comboBox3, ComboBox<String> comboBox4, ComboBox<String> comboBox5, ComboBox<String> comboBox6, 
			ComboBox<String> comboBox7, ComboBox<String> comboBox8, ComboBox<String> genderBox, ComboBox<String> genderBox1) {
		String userID = name.getText();
		UserID makeID = new UserID();
		makeID.makeUserID(userID);
		//userID.makeUserID(userID); //need to make a label for the userID and then have this method grab it            
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		int ageInt = (int)ageSlider.getValue();
		int ageMinInt = (int)ageMinSlider.getValue();
		int ageMaxInt = (int)ageMaxSlider.getValue();
		int matchInt = (int)matchPercentage.getValue();
		String ageVal = new String(Integer.toString(ageInt));
		String ageMinVal = new String(Integer.toString(ageMinInt));
		String ageMaxVal = new String(Integer.toString(ageMaxInt));
		String matchVal = new String(Integer.toString(matchInt));
		String[] values = {name.getText(), password.getText(), firstName.getText(), lastName.getText(), comboBox.getValue(),ageVal,comboBox2.getValue(),comboBox3.getValue(),comboBox4.getValue(),comboBox5.getValue(),comboBox6.getValue(),comboBox7.getValue(),comboBox8.getValue(),genderBox.getValue(),genderBox1.getValue(),ageMinVal,ageMaxVal,matchVal};
		sqlData.newUser("Username, Password, FirstName, LastName, Location, Age, Dog, One_Night, Vegetarian, Movie, Exercise, Music, Relationship, Gender, Gender_Preference, Min_Age, Max_Age, Match", values);
		sqlData.closeCon();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bad Luck");
	}
    /**
     * testing code
     */
    public void testNewAccount() {
		System.out.println("testing");
		makenew();
		testValid();
		printVals();
	}
    /**
     * testing code
     */
	public void makenew() {
		setStringVar(name);
		setStringVar(Password);
		setStringVar(FirstName);
		setStringVar(LastName);
		setRandomVar(comboBox);
		setRandomVar(dogBox);
		setRandomVar(dogHaveBox);
		setRandomVar(vegetarianBox);
		setRandomVar(movieBox);
		setRandomVar(walkingBox);
		setRandomVar(musicBox);
		setRandomVar(democracyBox);
		setRandomVar(genderIden);
		setRandomVar(genderPref);
		setSliderVar(ageSlider);
		setSliderVar(ageMinSlider);
		setSliderVar(ageMaxSlider);
		setSliderMatchVar(matchPercentage);
	}
	/**
	 * testing code
	 * @param text
	 */
	public void setStringVar(TextField text) {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String randString = buffer.toString();
	    text.setText(randString);
	    System.out.println(text.getText());
	}
	/**
	 * testing code
	 * @param combo
	 */
	public void setRandomVar(ComboBox<String> combo) {
		combo.getSelectionModel().select((int) (Math.random()*3));
		System.out.println(combo.getValue());
	}
	/**
	 * testing code
	 * @param slider
	 */
	public void setSliderVar(Slider slider) {
		slider.setValue((Math.random()*100));
		System.out.println(slider.getValue());
	}
	/**
	 * testing code
	 * @param slider
	 */
	public void setSliderMatchVar(Slider slider) {
		slider.setValue((Math.random()*60));
		System.out.println(slider.getValue());
	}
	/**
	 * testing code
	 */
	public void testValid() {
		if(comboBox.getValue()!=null && dogHaveBox.getValue()!=null && vegetarianBox.getValue()!=null && movieBox.getValue()!=null && walkingBox.getValue()!=null && musicBox.getValue()!=null && democracyBox.getValue()!=null && genderPref.getValue()!=null&&genderIden.getValue()!=null) {
    		if (ageMinSlider.getValue()<=ageMaxSlider.getValue()) {
    			System.out.println("Profile Valid!");
    			//sendToDatabase isn't here, because I left it in Settings
    			userToDatabase(name, FirstName, LastName, Password, matchPercentage, ageMinSlider, ageMaxSlider, comboBox, ageSlider, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderIden, genderPref);
    		}
    		else {
    			System.out.println("Please correct your age preferences");
    		}
    	}
    	else
    		System.out.println("Please fill in all values");
    	}
	/**
	 * testing code
	 */
	public void printVals() {
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		String[] desiredcol = {"Username", "Password", "FirstName", "LastName", "Location", "Age", "Dog", "One_Night", "Vegetarian", "Movie", "Exercise", "Music", "Relationship", "Gender", "Gender_Preference", "Min_Age", "Max_Age", "Match"};
		System.out.println(sqlData.readData(name.getText(), desiredcol));
		sqlData.closeCon();
	}
}
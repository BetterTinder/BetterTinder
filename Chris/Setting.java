import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.sql.SQLException;
/**
 * 
 * @author CHRIS G. yeet
 *
 */
public class Setting extends GridPane  {
	
	//age slider declarations
	Slider ageSlider = new Slider();
	Slider ageMinSlider = new Slider();
	Slider ageMaxSlider = new Slider();
	Slider matchPercentage = new Slider();
	Button save = new Button("Apply Changes");
	
	//combo box declarations
	ComboBox<String> genderPref = new ComboBox<String>(getGenderOptions());
	ComboBox<String> genderIden = new ComboBox<String>(getGenderOptions());
	ComboBox<String> comboBox = new ComboBox<String>(getLocOptions());
	ComboBox<String> dogBox = new ComboBox<String>(getResponse());
	ComboBox<String> dogHaveBox = new ComboBox<String>(getResponse());
	ComboBox<String> vegetarianBox = new ComboBox<String>(getResponse());
	ComboBox<String> movieBox = new ComboBox<String>(getResponse());
	ComboBox<String> walkingBox = new ComboBox<String>(getResponse());
	ComboBox<String> musicBox = new ComboBox<String>(getResponse());
	ComboBox<String> democracyBox = new ComboBox<String>(getResponse());
	
	//label declarations
	Label age = new Label("Age:");
	Label genPrefLabel = new Label("Gender preference:");
	Label genIdenLabel = new Label("Gender:");
	Label location = new Label("Location:");
	Label intrest = new Label("Intrests:");
	Label agePref = new Label("Age preference:");
	Label ageMin = new Label("From:");
	Label ageMax = new Label("To:");
	Label dog = new Label("Do you like dogs?");
	Label dogHave = new Label("Do you enjoy one night stands?");
	Label vegetarian = new Label("Are you vegetarian?");
	Label movie = new Label("Do you like staying in?");
	Label walking = new Label("Do you enjoy excersizing?");
	Label music = new Label("Do you like music?");
	Label match = new Label("What match percent do you desire?");
	Label democracy = new Label("Do you want a long term relationship?");
	
	/**
	 * a constructor, the constructor for the setting pane
	 * @param hbox
	 * @param rootpane
	 */
	Setting(HBox hbox, GridPane rootpane) {

		GridPane gridPane = addGrid();
		getAgeSlider(ageSlider);
		getAgeSlider(ageMinSlider);
		getAgeSlider(ageMaxSlider);
		getMatchSlider(matchPercentage);
		//Below are Test Case Methods, should be later removed for instead the JUnit
		getSave(hbox, rootpane);
		this.getChildren().add(gridPane);
	}
	public ObservableList<String> getGenderOptions() {
		ObservableList<String> gender= 
				FXCollections.observableArrayList(
						"Male",
						"Female",
						"Other"
						);
		return gender;
	}
	public ObservableList<String> getResponse() {
		ObservableList<String> yesno = 
				FXCollections.observableArrayList(
						"Yes",
						"No",
						"Prefer not to answer"
						);
		return yesno;
	}
	public ObservableList<String> getLocOptions() {
		ObservableList<String> options = 
				FXCollections.observableArrayList(
						"Holly Hill",
						"Port Orange",
						"Daytona",
						"Deland",
						"Ormond Beach"
						);
		return options;
	}
	public void getMatchSlider(Slider matchSlider) {
		matchSlider.setMin(0);
		matchSlider.setMax(100);
		matchSlider.setValue(75);
		matchSlider.setBlockIncrement(5);
		matchSlider.setMajorTickUnit(10);
		matchSlider.setShowTickLabels(true);
		matchSlider.setShowTickMarks(true);
		matchSlider.setSnapToTicks(true);
	}
	//mashed three methods into one
	public void getAgeSlider(Slider ageSlider) {
		ageSlider.setMin(18);
		ageSlider.setMax(60);
		ageSlider.setValue(18);
		ageSlider.setBlockIncrement(5);
		ageSlider.setMajorTickUnit(5);
		ageSlider.setShowTickLabels(true);
		ageSlider.setShowTickMarks(true);
		ageSlider.setSnapToTicks(true);
	}
	
	public GridPane addGrid() {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(25));
		gridPane.add(comboBox,1,2);
		gridPane.add(genPrefLabel, 0, 1);
		gridPane.add(genIdenLabel, 0, 0);
		gridPane.add(genderPref, 1, 1);
		gridPane.add(genderIden, 1, 0);
		gridPane.add(match, 0, 3);
		gridPane.add(matchPercentage, 1, 3);
		gridPane.add(age, 0, 4);
		gridPane.add(ageSlider, 1, 4);
		gridPane.add(location, 0, 2);
		gridPane.add(intrest, 0, 8);
		gridPane.add(agePref, 0, 5);
		gridPane.add(ageMin, 0, 6);
		gridPane.add(ageMinSlider, 1, 6);
		gridPane.add(ageMax, 0, 7);
		gridPane.add(ageMaxSlider, 1, 7);
		gridPane.add(dog, 0, 9);
		gridPane.add(dogBox, 1, 9);
		gridPane.add(dogHave, 0, 10);
		gridPane.add(dogHaveBox, 1, 10);
		gridPane.add(vegetarian, 0, 11);
		gridPane.add(vegetarianBox, 1, 11);
		gridPane.add(movie, 0, 12);
		gridPane.add(movieBox, 1, 12);
		gridPane.add(walking, 0, 13);
		gridPane.add(walkingBox, 1, 13);
		gridPane.add(music, 0, 14);
		gridPane.add(musicBox, 1, 14);
		gridPane.add(democracy, 0, 15);
		gridPane.add(democracyBox, 1, 15);
		gridPane.add(save, 1, 500);
		return gridPane;
	}
	private void getSave(HBox hbox, GridPane rootpane) {
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (ageMinSlider.getValue()<=ageMaxSlider.getValue()) {
					sendToDataBase(matchPercentage, ageMinSlider, ageMaxSlider, comboBox, ageSlider, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderPref, genderIden);
					sendToProfile(hbox,rootpane);
					System.out.println("Changes saved");
				}
				else {
					System.out.print("Please input correct age limits");
				}
			}
		});
	}
	/**
	 * this method will send all the comboBox values to SQL
	 * @param comboBox
	 * @param comboBox1
	 * @param comboBox2
	 * @param comboBox3
	 * @param comboBox4
	 * @param comboBox5
	 * @param comboBox6
	 * @param comboBox7
	 * @param comboBox8
	 * @param genderBox
	 * @param genderBox1
	 */
	public void sendToDataBase(Slider matchPercentage, Slider ageMinSlider, Slider ageMaxSlider, ComboBox<String> comboBox, Slider ageSlider,
			ComboBox<String> comboBox2, ComboBox<String> comboBox3, ComboBox<String> comboBox4, ComboBox<String> comboBox5, ComboBox<String> comboBox6, 
			ComboBox<String> comboBox7, ComboBox<String> comboBox8, ComboBox<String> genderBox, ComboBox<String> genderBox1) {
		SQLData sqlData = SQLData.getInstance();
		String ageVal = new String(Double.toString(ageSlider.getValue()));
		String ageMinVal = new String(Double.toString(ageSlider.getValue()));
		String ageMaxVal = new String(Double.toString(ageSlider.getValue()));
		String matchVal = new String(Double.toString(ageSlider.getValue()));
		String[] values = {comboBox.getValue(),ageVal,comboBox2.getValue(),comboBox3.getValue(),comboBox4.getValue(),comboBox5.getValue(),comboBox6.getValue(),comboBox7.getValue(),comboBox8.getValue(),genderBox.getValue(),genderBox1.getValue(),ageMinVal,ageMaxVal,matchVal};
		sqlData.newUser("Location, Age, Dog, One Night, Vegetarian, Movie, Excercise, Music, Relationship, Gender, Gender Preference, Min Age, Max Age, Match", values);
		//print statements I'll delete later
		System.out.println(ageSlider.getValue());
		System.out.println(comboBox2.getValue());
		System.out.println(comboBox3.getValue());
		System.out.println(comboBox4.getValue());
		System.out.println(comboBox5.getValue());
		System.out.println(comboBox6.getValue());
		System.out.println(comboBox7.getValue());
		System.out.println(comboBox8.getValue());
		System.out.println(genderBox.getValue());
		System.out.println(genderBox1.getValue());
		System.out.println(ageMinSlider.getValue());
		System.out.println(ageMaxSlider.getValue());
		System.out.println(matchPercentage.getValue());
	}
	/**
	 * closes setting and sends the user back to profile
	 * @param hbox 
	 */
	private void sendToProfile(HBox hbox,GridPane rootpane) {
		Profile profile = new Profile(hbox, rootpane);
		this.getChildren().add(profile);
	}

}
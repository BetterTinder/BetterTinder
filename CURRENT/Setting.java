import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 * Setting class, where all your settings needs are met
 * @author CHRIS G.
 *
 */
public class Setting extends GridPane  {
	//label declarations
	Label age = new Label("Your Age:");
	Label genPrefLabel = new Label("Gender preference:");
	Label genIdenLabel = new Label("Gender:");
	Label location = new Label("Location:");
	Label intrest = new Label("Intrests:");
	Label agePref = new Label("Age preference:");
	Label ageMin = new Label("From:");
	Label ageMax = new Label("To:");
	Label dog = new Label("Do you like dogs?");
	Label dogHave = new Label("Do you enjoy one night stands?");
	Label vegetarian = new Label("Do you eat meat?");
	Label movie = new Label("Do you enjoy film?");
	Label walking = new Label("Do you enjoy excersizing?");
	Label music = new Label("Do you like music?");
	Label match = new Label("What match percent do you desire?");
	Text democracy = new Text("Do you want a long term relationship?");
	

	//age slider declarations
	Slider ageSlider = new Slider();
	Slider ageMinSlider = new Slider();
	Slider ageMaxSlider = new Slider();
	Slider matchPercentage = new Slider();
	Button save = new Button("Apply Changes");	
	UserID userID = new UserID();
	
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
		getMatchPercent();
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
	/**
	 * an iniatializer
	 */
	public void getMatchPercent() {
		matchPercentage.setMin(0);
		matchPercentage.setMax(100);
		matchPercentage.setValue(75);
		matchPercentage.setBlockIncrement(5);
		matchPercentage.setMajorTickUnit(10);
		matchPercentage.setShowTickLabels(true);
		matchPercentage.setShowTickMarks(true);
		matchPercentage.setSnapToTicks(true);
	}
	public void getAgeSlider(Slider slide) {
		slide.setMin(18);
		slide.setMax(60);
		slide.setValue(18);
		slide.setBlockIncrement(5);
		slide.setMajorTickUnit(5);
		slide.setShowTickLabels(true);
		slide.setShowTickMarks(true);
		slide.setSnapToTicks(true);
	}
	
	public GridPane addGrid() {
		GridPane gridPane = new GridPane();
		gridPane.setVgap(3);
		gridPane.setPadding(new Insets(3,25,0,25));
		String value = "-fx-text-fill: white;";
		
		age.setStyle(value);
		genPrefLabel.setStyle(value);
		genIdenLabel.setStyle(value);
		location.setStyle(value);
		intrest.setStyle(value);
		agePref.setStyle(value);
		ageMin.setStyle(value);
		ageMax.setStyle(value);
		dog.setStyle(value);
		dogHave.setStyle(value);
		vegetarian.setStyle(value);
		movie.setStyle(value);
		walking.setStyle(value);
		music.setStyle(value); 
		match.setStyle(value);
		democracy.setFill(Color.WHITE);
		
		
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
		democracy.setWrappingWidth(200);
		gridPane.add(democracyBox, 1, 15);
		gridPane.add(save, 1, 16);
		return gridPane;
	}
	/**
	 * save event handler
	 * @param hbox
	 * @param rootpane
	 */
	private void getSave(HBox hbox, GridPane rootpane) {
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (ageMinSlider.getValue()<=ageMaxSlider.getValue()) {
					updateDataBase(matchPercentage, ageMinSlider, ageMaxSlider, comboBox, ageSlider, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderPref, genderIden);
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
	public void updateDataBase(Slider matchPercentage, Slider ageMinSlider, Slider ageMaxSlider, ComboBox<String> comboBox, Slider ageSlider,
			ComboBox<String> comboBox2, ComboBox<String> comboBox3, ComboBox<String> comboBox4, ComboBox<String> comboBox5, ComboBox<String> comboBox6, 
			ComboBox<String> comboBox7, ComboBox<String> comboBox8, ComboBox<String> genderBox, ComboBox<String> genderBox1) {
			if (ageMinSlider.getValue()<=ageMaxSlider.getValue()) {	
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
				String currentUser = " ";
				try {
					currentUser = userID.getUserID();
				} catch (IOException e) {
					e.printStackTrace();
				}
				String[] column = {"Location", "Age", "Dog", "One_Night", "Vegetarian", "Movie", "Exercise", "Music", "Relationship", "Gender", "Gender_Preference", "Min_Age", "Max_Age", "Match"};
				String[] values = {comboBox.getValue(),ageVal,comboBox2.getValue(),comboBox3.getValue(),comboBox4.getValue(),comboBox5.getValue(),comboBox6.getValue(),comboBox7.getValue(),comboBox8.getValue(),genderBox.getValue(),genderBox1.getValue(),ageMinVal,ageMaxVal,matchVal};
				System.out.println(values);
				sqlData.updateData(currentUser, column, values);
				sqlData.closeCon();
			}
			else {
				System.out.println("Please correct your age preferences");
			}
		}
	/**
	 * sets the combo boxes to their value in SQL
	 */
	public void runOnButton() {
		setDefaultVal(comboBox, "Location");
		setDefaultVal(dogBox, "Dog");
		setDefaultVal(dogHaveBox, "One_Night");
		setDefaultVal(vegetarianBox, "Vegetarian");
		setDefaultVal(movieBox, "Movie");
		setDefaultVal(walkingBox, "Exercise");
		setDefaultVal(musicBox, "Music");
		setDefaultVal(democracyBox, "Relationship");
		setDefaultVal(genderIden, "Gender");
		setDefaultVal(genderPref, "Gender_Preference");
		setSliderVal(ageSlider, "Age");
		setSliderVal(ageMinSlider, "Min_Age");
		setSliderVal(ageMaxSlider, "Max_Age");
		setSliderVal(matchPercentage, "Match");
	}
	/**
	 * sets the starting val of the sliders by pulling from the database
	 * @param slide
	 * @param collumn
	 */
	private void setSliderVal(Slider slide, String collumn) {
		String currentUser = " ";
		try {
			currentUser = userID.getUserID();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		String[] desiredcol = {collumn};
		List<String> percentLst = sqlData.readData(currentUser, desiredcol);
		String percentStr = new String(percentLst.get(0)); 
		Double percentVal = new Double(percentStr);
		slide.setValue(percentVal);
		sqlData.closeCon();
	}
	/**
	 * sets the starting val of the combo boxes by pulling from the database
	 * @param combo
	 * @param collum
	 **/
	public void setDefaultVal(ComboBox<String> combo, String collumn)
	{
		String currentUser = " ";
		try {
			currentUser = userID.getUserID();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] desiredcol = {collumn};
		List<String> hollHill = new ArrayList<String>();
		hollHill.add("Holly Hill");
		List<String> daytona = new ArrayList<String>();
		daytona.add("Daytona");
		List<String> deland = new ArrayList<String>();
		deland.add("De land");
		List<String> ormondBeach = new ArrayList<String>();
		ormondBeach.add("Ormond Beach");
		List<String> portOrange = new ArrayList<String>();
		portOrange.add("Port Orange");
		List<String> male = new ArrayList<String>();
		male.add("Male");
		List<String> fem = new ArrayList<String>();
		fem.add("Female");
		List<String> other = new ArrayList<String>();
		other.add("Other");
		List<String> yes = new ArrayList<String>();
		yes.add("Yes");
		List<String> no = new ArrayList<String>();
		no.add("No");
		List<String> non = new ArrayList<String>();
		non.add("Prefer not to answer");
		int index = 5;
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		if(sqlData.readData(currentUser, desiredcol).equals(hollHill) || sqlData.readData(currentUser, desiredcol).equals(yes) || sqlData.readData(currentUser, desiredcol).equals(male))
			index = 0;
		else if(sqlData.readData(currentUser, desiredcol).equals(portOrange) || sqlData.readData(currentUser, desiredcol).equals(no) || sqlData.readData(currentUser, desiredcol).equals(fem))
			index = 1;
		else if(sqlData.readData(currentUser, desiredcol).equals(daytona) || sqlData.readData(currentUser, desiredcol).equals(non) || sqlData.readData(currentUser, desiredcol).equals(other))
			index = 2;
		else if(sqlData.readData(currentUser, desiredcol).equals(deland))
			index = 3;
		else if(sqlData.readData(currentUser, desiredcol).equals(ormondBeach))
			index = 4;
		else
			System.out.println("ERROR");
		combo.getSelectionModel().select(index);
		sqlData.closeCon();
	}
	/**
	 * closes setting and sends the user back to profile
	 * @param hbox 
	 */
	private void sendToProfile(HBox hbox,GridPane rootpane) {
		Profile profile = new Profile(hbox, rootpane);
		this.getChildren().add(profile);
	}
	/**
	 * testing code
	 */
	public void testSetting() {
		System.out.print("testing");
		readVars();
		setRandomVars(comboBox, "Location");
		setRandomVars(dogBox, "Dog");
		setRandomVars(dogHaveBox, "One_Night");
		setRandomVars(vegetarianBox, "Vegetarian");
		setRandomVars(movieBox, "Movie");
		setRandomVars(walkingBox, "Exercise");
		setRandomVars(musicBox, "Music");
		setRandomVars(democracyBox, "Relationship");
		setRandomVars(genderIden, "Gender");
		setRandomVars(genderPref, "Gender_Preference");
		setSliderVars(ageSlider, "Age");
		setSliderVars(ageMinSlider, "Min_Age");
		setSliderVars(ageMaxSlider, "Max_Age");
		setSliderMatchVars(matchPercentage, "Match");
	}
	/**
	 * testing code
	 */
	public void readVars() {
		setDefaultValPrint(comboBox, "Location");
		setDefaultValPrint(dogBox, "Dog");
		setDefaultValPrint(dogHaveBox, "One_Night");
		setDefaultValPrint(vegetarianBox, "Vegetarian");
		setDefaultValPrint(movieBox, "Movie");
		setDefaultValPrint(walkingBox, "Exercise");
		setDefaultValPrint(musicBox, "Music");
		setDefaultValPrint(democracyBox, "Relationship");
		setDefaultValPrint(genderIden, "Gender");
		setDefaultValPrint(genderPref, "Gender_Preference");
		setSliderValPrint(ageSlider, "Age");
		setSliderValPrint(ageMinSlider, "Min_Age");
		setSliderValPrint(ageMaxSlider, "Max_Age");
		setSliderValPrint(matchPercentage, "Match");
	}
	/**
	 * testing code
	 * @param slider
	 * @param col
	 */
	public void setSliderVars(Slider slider, String col) {
		slider.setValue((Math.random()*100));
		String currentUser = "Chris";
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		String[] desiredcol = {col};
		String[] column = {col};
		int slideInt = (int)slider.getValue();
		String slideVal = new String(Integer.toString(slideInt));
		String[] values = {slideVal};
		sqlData.updateData(currentUser, column, values);
		System.out.println("This is testing updating the values in SQL, the following things should be the same");
		System.out.println(slider.getValue());
		System.out.println(sqlData.readData(currentUser, desiredcol));
		sqlData.closeCon();
	}
	/**
	 * testing code
	 * @param slider
	 * @param col
	 */
	public void setSliderMatchVars(Slider slider, String col) {
		slider.setValue((Math.random()*60));
		String currentUser = "Chris";
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		String[] desiredcol = {col};
		String[] column = {col};
		int slideInt = (int)slider.getValue();
		String slideVal = new String(Integer.toString(slideInt));
		String[] values = {slideVal};
		sqlData.updateData(currentUser, column, values);
		System.out.println("This is testing updating the values in SQL, the following things should be the same");
		System.out.println(slider.getValue());
		System.out.println(sqlData.readData(currentUser, desiredcol));
		sqlData.closeCon();
	}
	/**
	 * testing code
	 * @param combo
	 * @param collumn
	 */
	public void setRandomVars(ComboBox<String> combo, String collumn) {
		combo.getSelectionModel().select((int) (Math.random()*3));
		String currentUser = "Chris";
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		String[] desiredcol = {collumn};
		String[] column = {collumn};
		String[] values = {combo.getValue()};
		sqlData.updateData(currentUser, column, values);
		System.out.println("This is testing updating the values in SQL, the following things should be the same");
		System.out.println(combo.getValue());
		System.out.println(sqlData.readData(currentUser, desiredcol));
		sqlData.closeCon();
	}
	/**
	 * testing code
	 * @param slide
	 * @param collumn
	 */
	public void setSliderValPrint(Slider slide, String collumn) {
		String currentUser = "Chris";
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		String[] desiredcol = {collumn};
		List<String> percentLst = sqlData.readData(currentUser, desiredcol);
		String percentStr = new String(percentLst.get(0));
		Double percentVal = new Double(percentStr);
		slide.setValue(percentVal);
		System.out.println("This is testing the retrieval of the default values from SQL, the following things should be the same");
		System.out.println(slide.getValue());
		System.out.println(sqlData.readData(currentUser, desiredcol));
		sqlData.closeCon();
	}
	/**
	 * sets the starting val of the combo boxes by pulling from the database, except for location
	 * @param combo
	 * @param collum
	 **/
	public void setDefaultValPrint(ComboBox<String> combo, String collumn)
	{
		String currentUser = "Chris";
		String[] desiredcol = {collumn};
		List<String> hollHill = new ArrayList<String>();
		hollHill.add("Holly Hill");
		List<String> daytona = new ArrayList<String>();
		daytona.add("Daytona");
		List<String> deland = new ArrayList<String>();
		deland.add("Deland");
		List<String> ormondBeach = new ArrayList<String>();
		ormondBeach.add("Ormond Beach");
		List<String> portOrange = new ArrayList<String>();
		portOrange.add("Port Orange");
		List<String> male = new ArrayList<String>();
		male.add("Male");
		List<String> fem = new ArrayList<String>();
		fem.add("Female");
		List<String> other = new ArrayList<String>();
		other.add("Other");
		List<String> yes = new ArrayList<String>();
		yes.add("Yes");
		List<String> no = new ArrayList<String>();
		no.add("No");
		List<String> non = new ArrayList<String>();
		non.add("Prefer not to answer");
		int index = 5;
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		if(sqlData.readData(currentUser, desiredcol).equals(hollHill) || sqlData.readData(currentUser, desiredcol).equals(yes) || sqlData.readData(currentUser, desiredcol).equals(male))
			index = 0;
		else if(sqlData.readData(currentUser, desiredcol).equals(portOrange) || sqlData.readData(currentUser, desiredcol).equals(no) || sqlData.readData(currentUser, desiredcol).equals(fem))
			index = 1;
		else if(sqlData.readData(currentUser, desiredcol).equals(daytona) || sqlData.readData(currentUser, desiredcol).equals(non) || sqlData.readData(currentUser, desiredcol).equals(other))
			index = 2;
		else if(sqlData.readData(currentUser, desiredcol).equals(deland))
			index = 3;
		else if(sqlData.readData(currentUser, desiredcol).equals(ormondBeach))
			index = 4;
		else
			System.out.println("ERROR");
		combo.getSelectionModel().select(index);
		System.out.println("This is testing the retrieval of the default values from SQL, the following things should be the same");
		System.out.println(combo.getValue());
		System.out.println(sqlData.readData(currentUser, desiredcol));
		sqlData.closeCon();
	}
}
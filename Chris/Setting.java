import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * 
 * @author CHRIS G. I MADE THIS
 *
 */
public class Setting extends Pane  {

    //Sting lists for the combo boxes
    ObservableList<String> options = 
    	    FXCollections.observableArrayList(
    	        "Holly Hill",
    	        "Port Orange",
    	        "Daytona",
    	        "Deland",
    	        "Ormond Beach"
    	    );
    ObservableList<String> yesno = 
    	    FXCollections.observableArrayList(
    	        "Yes",
    	        "No",
    	        "Prefer not to answer"
    	    );
    ObservableList<String> option = 
    	    FXCollections.observableArrayList(
    	        "18",
    	        "19",
    	        "20",
    	        "21",
    	        "22",
    	        "23",
    	        "24",
    	        "25",
    	        "26",
    	        "27",
    	        "28",
    	        "29",
    	        "30",
    	        "31",
    	        "32",
    	        "33",
    	        "34",
    	        "35",
    	        "36",
    	        "37",
    	        "38",
    	        "39",
    	        "40"
    	    );
    ObservableList<String> optionn = 
    	    FXCollections.observableArrayList(
    	        "Male",
    	        "Female",
    	        "Other"
    	    );
    
    //combo box declarations
    ComboBox<String> genderPref = new ComboBox<String>(optionn);
    ComboBox<String> genderIden = new ComboBox<String>(optionn);
    ComboBox<String> comboBox = new ComboBox<String>(options);
    ComboBox<String> ageBox = new ComboBox<String>(option);
    ComboBox<String> dogBox = new ComboBox<String>(yesno);
    ComboBox<String> dogHaveBox = new ComboBox<String>(yesno);
    ComboBox<String> vegetarianBox = new ComboBox<String>(yesno);
    ComboBox<String> movieBox = new ComboBox<String>(yesno);
    ComboBox<String> walkingBox = new ComboBox<String>(yesno);
    ComboBox<String> musicBox = new ComboBox<String>(yesno);
    ComboBox<String> democracyBox = new ComboBox<String>(yesno);
    
    //label declarations
    String style = "-fx-background-color: rgba(255, 255, 255, 1);";
    Button save = new Button("Apply Changes");
    Label age = new Label("Age:");
    Label genPrefLabel = new Label("Gender preference:");
    Label genIdenLabel = new Label("Gender:");
    Label location = new Label("Location:");
    Label intrest = new Label("Intrests:");
    Label dog = new Label("Do you like dogs?");
    Label dogHave = new Label("Do you have a dog?");
    Label vegetarian = new Label("Do you eat meat?");
    Label movie = new Label("Do you enjoy movies?");
    Label walking = new Label("Do you enjoy walking?");
    Label music = new Label("Do you like music?");
    Label democracy = new Label("Do you love democracy?");
    Label fuck = new Label("Do you want a quick fuck?");
    
    Setting() {

        
        //adding all of it to the gridpane
        GridPane gridPane = new GridPane();
        gridPane.setStyle(style);
        gridPane.setPadding(new Insets(25));
        gridPane.add(comboBox,1,3);
        gridPane.add(genPrefLabel, 0, 0);
        gridPane.add(genIdenLabel, 0, 1);
        gridPane.add(genderPref, 1, 0);
        gridPane.add(genderIden, 1, 1);
        gridPane.add(age, 0, 2);
        gridPane.add(ageBox, 1, 2);
        gridPane.add(location, 0, 3);
        gridPane.add(intrest, 0, 4);
        gridPane.add(dog, 0, 5);
        gridPane.add(dogBox, 1, 5);
        gridPane.add(dogHave, 0, 6);
        gridPane.add(dogHaveBox, 1, 6);
        gridPane.add(vegetarian, 0, 7);
        gridPane.add(vegetarianBox, 1, 7);
        gridPane.add(movie, 0, 8);
        gridPane.add(movieBox, 1, 8);
        gridPane.add(walking, 0, 9);
        gridPane.add(walkingBox, 1, 9);
        gridPane.add(music, 0, 10);
        gridPane.add(musicBox, 1, 10);
        gridPane.add(democracy, 0, 11);
        gridPane.add(democracyBox, 1, 11);
        gridPane.add(save, 400, 500);
        //event handlers for the combo boxes
        genderPref.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("Gender preferne fuck you danielle ce:");
            	System.out.println(genderPref.getValue());
            }
        });
        genderIden.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to identify as preference:");
            	System.out.println(genderIden.getValue());
            	}
        });
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their location");
            	System.out.println(comboBox.getValue());
            	}
        });
        ageBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their age");
            	System.out.println(ageBox.getValue());
            	}
        });
        dogBox.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(dogBox.getValue());
            	}
        });
        dogHaveBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(dogHaveBox.getValue());
            	}
        });
        dogHaveBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(dogHaveBox.getValue());
            	}
        });
        vegetarianBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(vegetarianBox.getValue());
            	}
        });
        movieBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(movieBox.getValue());
            	}
        });
        walkingBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(walkingBox.getValue());
            	}
        });
        musicBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(musicBox.getValue());
            	}
        });
        democracyBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(democracyBox.getValue());
            	}
        });
        
        //pseudo code methods to sending values to SQL 
        save.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	if(comboBox.getValue()!=null && ageBox.getValue()!=null && dogHaveBox.getValue()!=null && vegetarianBox.getValue()!=null && movieBox.getValue()!=null && walkingBox.getValue()!=null && musicBox.getValue()!=null && democracyBox.getValue()!=null && genderPref.getValue()!=null&&genderIden.getValue()!=null) {
                sendToDataBase(comboBox, ageBox, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderPref, genderIden);
            	System.out.println("Changes saved");
            	}
            	}
        });
        this.getChildren().add(gridPane);
    }
    /**
     * 
     * @param comboBox
     * @param ageBox
     * @param dogBox
     * @param dogHaveBox
     * @param vegetarianBox
     * @param movieBox
     * @param walkingBox
     * @param musicBox
     * @param democracyBox
     * @param genderPref
     * @param genderIden
     * sends all combo box values to the SQL 
     */
    public void sendToDataBase(ComboBox comboBox, ComboBox ageBox, ComboBox dogBox, ComboBox dogHaveBox, ComboBox vegetarianBox, ComboBox movieBox, ComboBox walkingBox, ComboBox musicBox, ComboBox democracyBox, ComboBox genderPref, ComboBox genderIden) {
    	//sendtoDatabase(comboBox.getValue());
    	//sendtoDatabase(ageBox.getValue());
    	//sendtoDatabase(dogBox.getValue());
    	//sendtoDatabase(dogHaveBox.getValue());
    	//sendtoDatabase(vegetarianBox.getValue());
    	//sendtoDatabase(movieBox.getValue());
    	//sendtoDatabase(walkingBox.getValue());
    	//sendtoDatabase(musicBox.getValue());
    	//sendtoDatabase(democracyBox.getValue());
    	//sendtoDatabase(genderPref.getValue());
    	//sendtoDatabase(genderIden.getValue());
    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("Running Settings GUI");
    }

}
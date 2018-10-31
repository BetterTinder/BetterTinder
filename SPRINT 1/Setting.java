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
import javafx.stage.Stage;

/**
 * 
 * @author CHRIS G.
 * Allows for the user to change their databse. It extends GridPane
 *
 */
public class Setting extends GridPane  {

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
    ComboBox<String> genderBox = new ComboBox<String>(optionn);
    ComboBox<String> genderBox1 = new ComboBox<String>(optionn);
    ComboBox<String> comboBox = new ComboBox<String>(options);
    ComboBox<String> comboBox1 = new ComboBox<String>(option);
    ComboBox<String> comboBox2 = new ComboBox<String>(yesno);
    ComboBox<String> comboBox3 = new ComboBox<String>(yesno);
    ComboBox<String> comboBox4 = new ComboBox<String>(yesno);
    ComboBox<String> comboBox5 = new ComboBox<String>(yesno);
    ComboBox<String> comboBox6 = new ComboBox<String>(yesno);
    ComboBox<String> comboBox7 = new ComboBox<String>(yesno);
    ComboBox<String> comboBox8 = new ComboBox<String>(yesno);
    
    //label declarations
    String style = "-fx-background-color: rgba(255, 255, 255, 1);";
    Button save = new Button("Apply");
    Label agg = new Label("Age:");
    Label gen = new Label("Gender preference:");
    Label geb = new Label("Gender:");
    Label loc = new Label("Location:");
    Label inr = new Label("Intrests:");
    Label dog = new Label("Do you like dogs?");
    Label doge = new Label("Do you have a dog?");
    Label veg = new Label("Do you eat meat?");
    Label mov = new Label("Do you enjoy movies?");
    Label wal = new Label("Do you enjoy walking?");
    Label mus = new Label("Do you like music?");
    Label dem = new Label("Do you love democracy?");
    
    Setting() {

        
        //adding all of it to the gridpane
        GridPane gridPane = new GridPane();
        gridPane.setStyle(style);
        gridPane.setPadding(new Insets(25));
        gridPane.add(comboBox,1,3);
        gridPane.add(gen, 0, 0);
        gridPane.add(geb, 0, 1);
        gridPane.add(genderBox, 1, 0);
        gridPane.add(genderBox1, 1, 1);
        gridPane.add(agg, 0, 2);
        gridPane.add(comboBox1, 1, 2);
        gridPane.add(loc, 0, 3);
        gridPane.add(inr, 0, 4);
        gridPane.add(dog, 0, 5);
        gridPane.add(comboBox2, 1, 5);
        gridPane.add(doge, 0, 6);
        gridPane.add(comboBox3, 1, 6);
        gridPane.add(veg, 0, 7);
        gridPane.add(comboBox4, 1, 7);
        gridPane.add(mov, 0, 8);
        gridPane.add(comboBox5, 1, 8);
        gridPane.add(wal, 0, 9);
        gridPane.add(comboBox6, 1, 9);
        gridPane.add(mus, 0, 10);
        gridPane.add(comboBox7, 1, 10);
        gridPane.add(dem, 0, 11);
        gridPane.add(comboBox8, 1, 11);
        gridPane.add(save, 400, 500);
        //event handlers for the combo boxes
        genderBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like sleep with the gender of:");
            	System.out.println(genderBox.getValue());
            }
        });
        genderBox1.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to identify as:");
            	System.out.println(genderBox1.getValue());
            	}
        });
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their location");
            	System.out.println(comboBox.getValue());
            	}
        });
        comboBox1.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their age");
            	System.out.println(comboBox1.getValue());
            	}
        });
        comboBox2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox2.getValue());
            	}
        });
        comboBox3.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox3.getValue());
            	}
        });
        comboBox3.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox3.getValue());
            	}
        });
        comboBox4.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox4.getValue());
            	}
        });
        comboBox5.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox5.getValue());
            	}
        });
        comboBox6.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox6.getValue());
            	}
        });
        comboBox7.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox7.getValue());
            	}
        });
        comboBox8.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox8.getValue());
            	}
        });
    save.setOnAction(new EventHandler<ActionEvent>() {
      	 
        @Override
        public void handle(ActionEvent event) {
        	System.out.println("Changes saved");
            sendToDataBase(comboBox, comboBox1, comboBox2, comboBox3, comboBox4, comboBox5, comboBox6, comboBox7, comboBox8, genderBox, genderBox1);
            Manager manager = new Manager();
			Stage stage = new Stage();
			manager.startProfile(stage); //Sends you to Profile
        	}
    });
    this.getChildren().add(gridPane);
}
/**
 * 
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
 * sends all combo box values to the SQL 
 */
public void sendToDataBase(ComboBox comboBox, ComboBox comboBox1, ComboBox comboBox2, ComboBox comboBox3, ComboBox comboBox4, ComboBox comboBox5, ComboBox comboBox6, ComboBox comboBox7, ComboBox comboBox8, ComboBox genderBox, ComboBox genderBox1) {
	//sendtoDatabase(comboBox.getValue());
	//sendtoDatabase(comboBox1.getValue());
	//sendtoDatabase(comboBox2.getValue());
	//sendtoDatabase(comboBox3.getValue());
	//sendtoDatabase(comboBox4.getValue());
	//sendtoDatabase(comboBox5.getValue());
	//sendtoDatabase(comboBox6.getValue());
	//sendtoDatabase(comboBox7.getValue());
	//sendtoDatabase(comboBox8.getValue());
	//sendtoDatabase(genderBox.getValue());
	//sendtoDatabase(genderBox1.getValue());
}
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("Running Settings GUI");
    }

}
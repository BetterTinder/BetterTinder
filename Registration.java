import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class Registration extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration");

        ObservableList<String> options = 
        	    FXCollections.observableArrayList(
        	        "Scranton",
        	        "Port Orange",
        	        "Daytona",
        	        "Disney",
        	        "I dont know/unsure",
        	        "600 Pennsylvania Ave.",
        	        "1725 Slough Ave",
        	        "Detroit",
        	        "Asia",
        	        "South Africa",
        	        "Not listed"
        	    );

        ComboBox comboBox = new ComboBox(options);
        TextField ID = new TextField();
        TextField FirstName = new TextField();
        TextField LastName = new TextField();
        TextField Password = new TextField();
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
        	        "42",
        	        "69"
        	    );
        ObservableList<String> optionn = 
        	    FXCollections.observableArrayList(
        	        "Male",
        	        "Female",
        	        "None",
        	        "Assault vehicle",
        	        "Yes/all",
        	        "Transgendered",
        	        "Chinese"
        	    );
        ComboBox genderBox = new ComboBox(optionn);
        ComboBox genderBox1 = new ComboBox(optionn);
        ComboBox comboBox1 = new ComboBox(option);
        
        Button save = new Button("Save Account");
        Label userID = new Label("User ID:");
        Label userFirst = new Label("First Name:");
        Label userLast = new Label("Last Name:");
        Label pass = new Label("Password:");
        Label agg = new Label("Age:");
        Label gen = new Label("Gender preference:");
        Label geb = new Label("Gender:");
        Label loc = new Label("Location:");
        
        GridPane gridPane = new GridPane();
        gridPane.add(userID,0,0);
        gridPane.add(ID,1,0);
        gridPane.add(pass,0,1);
        gridPane.add(Password,1,1);
        gridPane.add(userFirst,0,2);
        gridPane.add(FirstName,1,2);
        gridPane.add(userLast,0,3);
        gridPane.add(LastName,1,3);
        gridPane.add(gen, 0, 4);
        gridPane.add(genderBox, 1, 4);
        gridPane.add(geb, 0, 5);
        gridPane.add(genderBox1, 1, 5);
        gridPane.add(agg, 0, 6);
        gridPane.add(comboBox1, 1, 6);
        gridPane.add(loc, 0, 7);
        gridPane.add(comboBox,1,7);
        gridPane.add(save, 2, 8);
        
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
        comboBox1.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their age");
            	System.out.println(comboBox1.getValue());
            	}
        });
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their location");
            	System.out.println(comboBox.getValue());
            	}
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("Changes saved");
            	}
        });

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
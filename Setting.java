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


public class Setting extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Settings");

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
        ObservableList<String> yesno = 
        	    FXCollections.observableArrayList(
        	        "Yes",
        	        "No"
        	    );
        ComboBox comboBox2 = new ComboBox(yesno);
        ComboBox comboBox3 = new ComboBox(yesno);
        ComboBox comboBox4 = new ComboBox(yesno);
        ComboBox comboBox5 = new ComboBox(yesno);
        ComboBox comboBox = new ComboBox(options);
        ObservableList<String> option = 
        	    FXCollections.observableArrayList(
        	        "10",
        	        "11",
        	        "13",
        	        "14",
        	        "15",
        	        "16",
        	        "17",
        	        "18",
        	        "19",
        	        "20",
        	        "21",
        	        "22",
        	        "23",
        	        "24",
        	        "25"
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
        
        Button save = new Button("Apply Changes");
        Label agg = new Label("Age:");
        Label gen = new Label("Gender preference:");
        Label geb = new Label("Gender:");
        Label loc = new Label("Location:");
        Label inr = new Label("Intrests:");
        Label dog = new Label("Do you like dogs?");
        Label doge = new Label("Do you have a dog?");
        Label veg = new Label("Do you eat meat?");
        Label mov = new Label("Do you enjoy watching movies?");
        
        GridPane gridPane = new GridPane();
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
        gridPane.add(save, 400, 500);
        
        genderBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change who they sleep with");
            	System.out.println(genderBox.getValue());
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
        genderBox1.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to identigy as");
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

        Scene scene = new Scene(gridPane, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
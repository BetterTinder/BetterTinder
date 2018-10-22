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

/**
 * 
 * @author super
 *
 */
public class Setting extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Settings");

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
        	        "No"
        	    );
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
        	        "25",
        	        "26",
        	        "27",
        	        "28",
        	        "29",
        	        "30"
        	    );
        ObservableList<String> optionn = 
        	    FXCollections.observableArrayList(
        	        "Male",
        	        "Female",
        	        "Other"
        	    );
        ComboBox genderBox = new ComboBox(optionn);
        ComboBox genderBox1 = new ComboBox(optionn);
        ComboBox comboBox = new ComboBox(options);
        ComboBox comboBox1 = new ComboBox(option);
        ComboBox comboBox2 = new ComboBox(yesno);
        ComboBox comboBox3 = new ComboBox(yesno);
        ComboBox comboBox4 = new ComboBox(yesno);
        ComboBox comboBox5 = new ComboBox(yesno);
        ComboBox comboBox6 = new ComboBox(yesno);
        ComboBox comboBox7 = new ComboBox(yesno);
        ComboBox comboBox8 = new ComboBox(yesno);
        ComboBox comboBox9 = new ComboBox(yesno);
        ComboBox comboBox10 = new ComboBox(yesno);

        
        Button save = new Button("Apply Changes");
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
        gridPane.add(wal, 0, 9);
        gridPane.add(comboBox6, 1, 9);
        gridPane.add(mus, 0, 10);
        gridPane.add(comboBox7, 1, 10);
        gridPane.add(dem, 0, 11);
        gridPane.add(comboBox8, 1, 11);
        gridPane.add(save, 400, 500);
        
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
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

        
        Button save = new Button("Apply Changes");
        Button ins = new Button("Current Interests");
        Label agg = new Label("Age:");
        Label gen = new Label("Gender preference:");
        Label geb = new Label("Gender:");
        Label loc = new Label("Location:");
        Label inr = new Label("Intrests:");
        ObservableList<String> options = 
        	    FXCollections.observableArrayList(
        	        "Scranton",
        	        "Port Orange",
        	        "Daytona"
        	    );
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
        	        "21"
        	    );
        ObservableList<String> optionn = 
        	    FXCollections.observableArrayList(
        	        "male",
        	        "female",
        	        "",
        	        "assault vehicle",
        	        "yes/all"
        	    );
        ComboBox genderBox = new ComboBox(optionn);
        ComboBox genderBox1 = new ComboBox(optionn);
        ComboBox comboBox1 = new ComboBox(option);
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
        gridPane.add(ins, 1, 4);
        gridPane.add(save, 400, 500);
        
        genderBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change who they sleep with");
            	System.out.println(genderBox.getValue());
            	}
        });
        genderBox1.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to identigy as");
            	System.out.println(genderBox.getValue());
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
        ins.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their interests");
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
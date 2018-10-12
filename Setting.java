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

        Button male = new Button("Male");
        Button fem = new Button("Female");
        Button age = new Button("Current Age");
        Button save = new Button("Apply Changes");
        Button ins = new Button("Current Interests");
        Label agg = new Label("Age:");
        Label gen = new Label("Gender preference:");
        Label loc = new Label("Location:");
        Label inr = new Label("Intrests:");
        ObservableList<String> options = 
        	    FXCollections.observableArrayList(
        	        "Scranton",
        	        "Port Orange",
        	        "Daytona"
        	    );
        ComboBox comboBox = new ComboBox(options);
        GridPane gridPane = new GridPane();
        gridPane.add(comboBox,1,2);
        gridPane.add(gen, 0, 0);
        gridPane.add(male, 1, 0);
        gridPane.add(fem, 2, 0);
        gridPane.add(agg, 0, 1);
        gridPane.add(age, 1, 1);
        gridPane.add(loc, 0, 2);
        gridPane.add(inr, 0, 3);
        gridPane.add(ins, 1, 3);
        gridPane.add(save, 400, 500);
        
        male.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to sleep with men");
            	}
        });
        fem.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to sleep with women");
            	}
        });
        age.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their age");
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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Settings extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setHeight(500);
    	primaryStage.setWidth(400);
        primaryStage.setTitle("Settings");
        Button gen = new Button();
        gen.setText("Change Gender Preferance");
        gen.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their gender preference");
            	}
        });
        Button age = new Button();
        age.setText("Change Age");
        age.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their age");
            	}
        });
        Button save = new Button();
        save.setText("Apply Changes");
        save.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("Changes saved");
            	}
        });
        StackPane root = new StackPane();
        root.getChildren().add(gen);
        root.getChildren().add(age);
        root.getChildren().add(save);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}


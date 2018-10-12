import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class QuestPane extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setHeight(500);
    	primaryStage.setWidth(400);
        primaryStage.setTitle("Help!");
        Button btn = new Button();
        btn.setText("Help");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	primaryStage.setTitle("Info");
                btn.setText("Hello. Better Tinder is an application that is designed to match users based on multiple parameters in order generate matches that contain poeple you have more in common with. Another unique feature is the ability to rate users on a scale of one to five and see those reviews on any users profile, including their own!");
                System.out.println("Hello. Better Tinder is an application that is designed to match users based on multiple parameters in order generate matches that contain poeple you have more in common with. Another unique feature is the ability to rate users on a scale of one to five and see those reviews on any users profile, including their own!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}


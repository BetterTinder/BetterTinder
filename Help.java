import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Help extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Help");

        Button help = new Button("Help");
        
        GridPane gridPane = new GridPane();

        gridPane.add(help, 0, 0);
        
        help.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	Label heln = new Label("Hello. Better Tinder is an application that is designed to match users based on multiple parameters in order generate matches that contain poeple you have more in common with. Another unique feature is the ability to rate users on a scale of one to five and see those reviews on any users profile, including their own!");
            	gridPane.add(heln, 1, 0);
            	System.out.println("Hello. Better Tinder is an application that is designed to match users based on multiple parameters in order generate matches that contain poeple you have more in common with. Another unique feature is the ability to rate users on a scale of one to five and see those reviews on any users profile, including their own!");
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
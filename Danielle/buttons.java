import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class buttons extends HBox {
	
	public static void main(String[] args) {
		System.out.println("BUttons");
	}

	/*
	public static void main(String[] args) {
		launch(args);
	}
	 */

	//public void start(Stage stage) throws Exception {
	buttons () {
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		Button helpButton = new Button("Help");
		helpButton.setMinWidth(85);
		helpButton.setOnAction(event ->{
			System.out.println("Help Button");			
		});

		Button button2 = new Button("My Profile");
		button2.setMinWidth(85);
		button2.setOnAction(event ->{
			System.out.println("Button 2");			
		});

		Button button3 = new Button("Find");
		button3.setMinWidth(85);
		button3.setOnAction(event ->{
			System.out.println("Button 3");			
		});

		Button button4 = new Button("Matched");	
		button4.setMinWidth(85);
		button4.setOnAction(event ->{
			System.out.println("Button 4");			
		});

		hbox.getChildren().addAll(helpButton, button2, button3, button4);
		
		this.getChildren().add(hbox);
		
		/*
		stage.setScene(new Scene(hbox));
		stage.setMaxWidth(400);
		stage.show();
		 */
	}

}

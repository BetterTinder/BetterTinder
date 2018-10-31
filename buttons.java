import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class buttons extends GridPane {
	
	public static void main(String[] args) {
		System.out.println("Bad Luck");
	}

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
		GridPane gridPane = new GridPane();
		gridPane.add(hbox,0,0);
		
		/*
		GridPane gridPane = new GridPane();
		gridPane.add(helpButton, 0, 520);
		gridPane.add(button2, 1, 520);
		gridPane.add(button3, 2, 520);
		gridPane.add(button4, 3, 520);
		helpButton.setAlignment(Pos.BOTTOM_CENTER);
		button2.setAlignment(Pos.BOTTOM_CENTER);
		button3.setAlignment(Pos.BOTTOM_CENTER);
		button4.setAlignment(Pos.BOTTOM_CENTER);
		this.getChildren().add(gridPane);
		
		stage.setScene(new Scene(hbox));
		stage.setMaxWidth(400);
		stage.show();
		 */
		this.getChildren().add(gridPane);
	}

}

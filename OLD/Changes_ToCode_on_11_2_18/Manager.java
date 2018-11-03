import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sun.java2d.cmm.Profile;
/**
 * 
 * @author Michael Fornito and also Chris did some stuff
 *
 */
public class Manager extends Application {
	GridPane rootpane = new GridPane();
	Setting setting = new Setting(); //this is used in profile; Chris
	Profile profile = new Profile(rootpane,setting); //This will be global
	Help help = new Help();//This will be global
	NewAccount newAcc = new NewAccount(rootpane, profile);
	LoginScreen login = new LoginScreen(rootpane, newAcc, profile);
	//buttons buttons = new buttons()

	//hbox.getChildren().addAll(helpButton, button2, button3, button4);

	public static void main(String[] args) {
		launch(args);	
	}

	public void start(Stage stage) {
		//profile.setHgap(50);
		//profile.add(buttons,0,500);
		rootpane.getChildren().add(login);// This method would be in each button
		//rootpane.getChildren().add(buttons);

		Scene scene = new Scene(rootpane,400,520);
		stage.setScene(scene);
		stage.show();
	}

	public HBox addButtons(GridPane grid1) {
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);

		Button helpBtn = new Button("Help");
		helpBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
		helpBtn.setMinSize(85, 20);
		helpBtn.setOnAction(event -> {
			System.out.println("Help Button");	
			Help helps = new Help();
			rootpane.getChildren().add(helps);
		});

		Button profileBtn = new Button("My Profile");
		profileBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
		profileBtn.setMinSize(85, 20);
		profileBtn.setOnAction(event -> {
			System.out.println("My Profile");
			Setting sett = new Setting();
			Profile prof = new Profile(rootpane,sett);
			rootpane.getChildren().add(prof);
		});
		
		Button findBtn = new Button("Find");
		findBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
		findBtn.setMinSize(85, 20);
		findBtn.setOnAction(event -> {
			System.out.println("Find");
		});
		
		Button matchedBtn = new Button("Matched");
		matchedBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
		matchedBtn.setMinSize(85, 20);
		matchedBtn.setOnAction(event -> {
			System.out.println("Matched");
		});
		
		btnBox.getChildren().addAll(helpBtn,profileBtn,findBtn,matchedBtn);



		return btnBox;
	}
}
//Add the buttons with the action events
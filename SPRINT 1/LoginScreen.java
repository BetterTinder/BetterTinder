import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScreen extends GridPane {
	int change = 0;
	private Button signInButton, newAccountButton;
	private TextField usernameField;
	private PasswordField passwordField;
	private HBox siBox, naBox;
	private Label welcomeLabel, usernameLabel, passwordLabel;
	Manager manager = new Manager();
	public static void main(String[] args) {
		System.out.println("Login runnin");
	}
	/**
	 * 
	 * @param grid1
	 * @param newAcc
	 * @param profile
	 */
	LoginScreen() {

		//Create Grid Pane
	
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		this.setStyle(style);
		this.setAlignment(Pos.CENTER);
		this.setVgap(20);
		this.setHgap(50);
		//		gridPane.setGridLinesVisible(true);
		this.setPrefSize(400, 525);

		//create all labels
		welcomeLabel = new Label("Welcome to Riddle Vision");
		welcomeLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		welcomeLabel.setMinSize(200, 100);
		welcomeLabel.setWrapText(true);

		usernameLabel = new Label("Username:");

		passwordLabel = new Label("Password:");

		//create fields
		usernameField = new TextField();
		usernameField.setPromptText("Username");

		passwordField = new PasswordField();
		passwordField.setPromptText("Password");

		//create Buttons
		signInButton = new Button("Sign In");

		newAccountButton = new Button("New Account");

		//create HBox for buttons
		siBox = new HBox(10);
		siBox.setAlignment(Pos.CENTER);
		siBox.getChildren().add(signInButton);

		naBox = new HBox(10);
		naBox.setAlignment(Pos.CENTER);
		naBox.getChildren().add(newAccountButton);

		//Add Controls to Grid Pane
		this.add(welcomeLabel, 0, 0);
		this.add(usernameLabel, 0, 1);
		this.add(usernameField, 0, 2);
		this.add(passwordLabel, 0, 3);
		this.add(passwordField, 0, 4);
		this.add(siBox, 0 ,5);
		this.add(naBox, 0, 6);

		//Functionality for Buttons
		signInButton.setOnAction(event -> {
			String username = new String();
			String password = new String();

			username = usernameField.getText();
			password = passwordField.getText();			

			if (username.equals("u") && password.equals("p")) { 
				usernameField.clear();
				passwordField.clear();
				System.out.println("Signed In");
				Manager manager = new Manager();
				Stage stage = new Stage();
				manager.startProfile(stage); //switches to profile
				change=1;
			}
			if (username.isEmpty()) {
				createAlert(Alert.AlertType.ERROR, "No username was entered!");
			} else if (password.isEmpty()) {
				createAlert(Alert.AlertType.ERROR, "No password was entered!");		
			} else {
				boolean valid = checkLoginInformation("LoginInformation.txt",username,password);

				if (valid == true) {
					createAlert(Alert.AlertType.CONFIRMATION, "Signed In!");
					usernameField.clear();
					passwordField.clear();
					System.out.println("Signed In");
					Manager manager = new Manager();
					Stage stage = new Stage();
					manager.startProfile(stage); //switches to profile
				}
				else {
					createAlert(Alert.AlertType.ERROR, "Try Again!");
				}
			}
		});


		newAccountButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Manager manager = new Manager();
				Stage stage = new Stage();
				manager.startNewAcc(stage); //switches to new account
			}
		});

		//return
	}

	private Alert createAlert(Alert.AlertType type, String string) {
		Alert alert = new Alert(type);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();
		return alert;
	}

	private boolean checkLoginInformation(String fileName, String username, String password) {

		List<String> loginInfo = new ArrayList<String>();
		Boolean valid = false;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				loginInfo.add(line);
			}
			reader.close();
		}	catch (Exception e) {
			System.err.format("Exception occured trying to read '%s'.", fileName);
			e.printStackTrace();
		}

		String splitBy = ",";
		int count = 0;
		int size = loginInfo.size();

		while (count < size && valid == false) {
			String line = loginInfo.get(count);
			String[] info = line.split(splitBy);
			if (info[0].equals(username)) {
				if (info[1].equals(password)) {
					valid = true;
				}
			} else {
				valid = false;
			}
			count++;
		}
		return valid;

	}
}

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class loginScreen extends Pane {
	
	private Button signInButton, newAccountButton;
	private TextField usernameField;
	private PasswordField passwordField;
	private HBox siBox, naBox;
	private Label welcomeLabel, usernameLabel, passwordLabel;
	
	public static void main(String[] args) {
		System.out.println("Login runnin");
	}
	
	loginScreen(GridPane grid1, NewAccount newAcc, Profile profile) {
		
		//Create Grid Pane
		GridPane gridPane = new GridPane();
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		gridPane.setStyle(style);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		gridPane.setHgap(50);
//		gridPane.setGridLinesVisible(true);
		gridPane.setPrefSize(400, 520);

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
		siBox = new HBox();
		siBox.setAlignment(Pos.CENTER);
		siBox.getChildren().add(signInButton);
		
		naBox = new HBox();
		naBox.setAlignment(Pos.CENTER);
		naBox.getChildren().add(newAccountButton);
		
		//Add Controls to Grid Pane
		gridPane.add(welcomeLabel, 0, 0);
		gridPane.add(usernameLabel, 0, 1);
		gridPane.add(usernameField, 0, 2);
		gridPane.add(passwordLabel, 0, 3);
		gridPane.add(passwordField, 0, 4);
		gridPane.add(siBox, 0 ,5);
		gridPane.add(naBox, 0, 6);
		
		//Functionality for Buttons
		signInButton.setOnAction(event -> {
			String username = new String();
			String password = new String();
			
			username = usernameField.getText();
			password = passwordField.getText();			
			
			if (username.isEmpty()) {
				createAlert(Alert.AlertType.ERROR, "No username was entered!");
			} else if (password.isEmpty()) {
				createAlert(Alert.AlertType.ERROR, "No password was entered!");		
			} else {
				if (username.equals("username") && password.equals("password")) {
					createAlert(Alert.AlertType.CONFIRMATION, "Signed In!");
					usernameField.clear();
					passwordField.clear();
					System.out.println("Signed In");
					gridPane.setVisible(false);
					//go to the profile GUI
					grid1.getChildren().add(profile);
				}
				else {
					createAlert(Alert.AlertType.ERROR, "Try Again!");
				}
			}
		});
		
		
		newAccountButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				grid1.getChildren().add(newAcc);
				
			}
		});
		
		//return
		this.getChildren().add(gridPane);
				
	}
	
	private Alert createAlert(Alert.AlertType type, String string) {
		Alert alert = new Alert(type);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();
		return alert;
	}
	
}
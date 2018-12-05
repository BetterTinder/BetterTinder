import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
/**
 * 
 * @author Danielle and Chris did SQL
 *
 */
public class LoginScreen extends Pane {

	private Button signInButton, newAccountButton;
	private TextField usernameField;
	private PasswordField passwordField;
	private HBox siBox, naBox;
	private Label welcomeLabel1,welcomeLabel2, usernameLabel, passwordLabel;

	public static void main(String[] args) {
		System.out.println("Login runnin");
	}

	LoginScreen(GridPane grid1, NewAccount newAcc) {
		GridPane gridPane = new GridPane();
		setGrid(gridPane);
		createLabels();
		createFields();		
		signInButton = new Button("Sign In");
		signInButton.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 15));
		signInButton.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		
		newAccountButton = new Button("New Account");
		newAccountButton.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 15));
		newAccountButton.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		
		setBox();
		controlGrid(gridPane);
		getSignBtn(grid1);
		getNewAccBtn(grid1, newAcc);
		//return
		this.getChildren().add(gridPane);
	}
/**
 * creates the fields for username and password
 */
	private void createFields() {
		usernameField = new TextField();
		usernameField.setPromptText("Username");

		passwordField = new PasswordField();
		passwordField.setPromptText("Password");
	}
/**
 * creates the labels
 */
	private void createLabels() {
		welcomeLabel1 = new Label("Welcome to");
		welcomeLabel1.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 30));
		welcomeLabel1.setMaxHeight(30);
		welcomeLabel1.setStyle("-fx-text-fill: white");
		
		welcomeLabel2 = new Label("Riddle Vision");
		welcomeLabel2.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 30));
		welcomeLabel2.setMaxHeight(30);
		welcomeLabel2.setStyle("-fx-text-fill: white");

		usernameLabel = new Label("Username:");
		usernameLabel.setFont(Font.font("Lucida Bright", FontWeight.EXTRA_LIGHT, 15));
		usernameLabel.setStyle("-fx-text-fill: white");

		passwordLabel = new Label("Password:");
		passwordLabel.setFont(Font.font("Lucida Bright", FontWeight.EXTRA_LIGHT, 15));
		passwordLabel.setStyle("-fx-text-fill: white");
	}
/**
 * 
 * @param gridPane
 */
	private void controlGrid(GridPane gridPane) {
		// gridPane.setGridLinesVisible(true);
		gridPane.add(welcomeLabel1, 0, 0);
		GridPane.setHalignment(welcomeLabel1, HPos.CENTER);
		gridPane.add(welcomeLabel2, 0, 1);
		gridPane.add(usernameLabel, 0, 5);
		gridPane.add(usernameField, 0, 6);
		gridPane.add(passwordLabel, 0, 7);
		gridPane.add(passwordField, 0, 8);
		gridPane.add(siBox, 0 ,9);
		gridPane.add(naBox, 0, 10);
	}
/**
 * 
 * @param gridPane
 */
	private void setGrid(GridPane gridPane) {
		String style = "-fx-background-color: #52858F";
		gridPane.setStyle(style);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		gridPane.setHgap(0);
		gridPane.setPrefSize(400, 520);
	}
/**
 * creates the hboxs for alignment for the sign in and new account buttons
 */
	private void setBox() {
		siBox = new HBox(10);
		siBox.setAlignment(Pos.CENTER);
		siBox.getChildren().add(signInButton);

		naBox = new HBox(10);
		naBox.setAlignment(Pos.CENTER);
		naBox.getChildren().add(newAccountButton);
	}
/**
 * 
 * @param grid1
 * @param newAcc
 */
	private void getNewAccBtn(GridPane grid1, NewAccount newAcc) {
		
		DropShadow shadow = new DropShadow();
		//Adding the shadow when the mouse cursor is on
		newAccountButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	newAccountButton.setEffect(shadow);
		        }
		}); 
		
		//Removing the shadow when the mouse cursor is off
		newAccountButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	newAccountButton.setEffect(null);
		        }
		});
		
		newAccountButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				grid1.getChildren().clear();
				grid1.getChildren().add(newAcc);
			}
		});
	}
/**
 * @param grid1
 */
	private void getSignBtn(GridPane grid1) {
		
		DropShadow shadow = new DropShadow();
		//Adding the shadow when the mouse cursor is on
		signInButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	signInButton.setEffect(shadow);
		        }
		}); 
		
		//Removing the shadow when the mouse cursor is off
		signInButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	signInButton.setEffect(null);
		        }
		});
		
		signInButton.setOnAction(event -> {
			String userID = new String();
			String password = new String();

			userID = usernameField.getText();
			password = passwordField.getText();			

			if (userID.isEmpty()) {
				createAlert(Alert.AlertType.ERROR, "No username was entered!");
			} else if (password.isEmpty()) {
				createAlert(Alert.AlertType.ERROR, "No password was entered!");		
			} else {
				boolean valid = checkLoginInformation(userID,password);
				if (valid == true) {
					UserID makeID = new UserID();
					makeID.makeUserID(userID);
					createAlert(Alert.AlertType.CONFIRMATION, "Signed In!");
					usernameField.clear();
					passwordField.clear();
					System.out.println("Signed In");
					grid1.getChildren().clear();
					Manager manager = new Manager();
					grid1.getChildren().add(manager.InitalizeProfile(grid1));
				}
				else {
					createAlert(Alert.AlertType.ERROR, "Try Again!");
				}
			}
		});
	}
/**
 * @param type
 * @param string
 * @return
 */
	
	private Alert createAlert(Alert.AlertType type, String string) {
		Alert alert = new Alert(type);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();
		return alert;
	}
	
/**
 * 
 * @param fileName
 * @param username
 * @param password
 * @return
 */
	private boolean checkLoginInformation(String username, String password) {
		Boolean valid = false;
		SQLData sqlData = SQLData.getInstance();
		sqlData.makeCon(sqlData);
		if(sqlData.userExists(username)==true) {
			String[] desiredcol = {"Password"};
			List<String> passList = new ArrayList<String>();
			passList.add(password);
			if(passList.equals(sqlData.readData(username, desiredcol))) {
				valid = true;
			}
			sqlData.closeCon();
		}
		return valid;
	}
}
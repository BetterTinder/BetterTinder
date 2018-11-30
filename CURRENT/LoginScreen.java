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
/**
 * 
 * @author Danielle and Michael
 *
 */
public class LoginScreen extends Pane {

	private Button signInButton, newAccountButton;
	private TextField usernameField;
	private PasswordField passwordField;
	private HBox siBox, naBox;
	private Label welcomeLabel, usernameLabel, passwordLabel;

	public static void main(String[] args) {
		System.out.println("Login runnin");
	}

	LoginScreen(GridPane grid1, NewAccount newAcc, Profile profile) {
		GridPane gridPane = new GridPane();
		setGrid(gridPane);
		createLabels();
		createFields();
		signInButton = new Button("Sign In");
		newAccountButton = new Button("New Account");
		setBox();
		controlGrid(gridPane);
		getSignBtn(grid1, profile);
		getNewAccBtn(grid1, newAcc);

		//return
		this.getChildren().add(gridPane);
	}
/**
 * creates the fields for username and passwrd
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
		welcomeLabel = new Label("Welcome to Riddle Vision");
		welcomeLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		welcomeLabel.setMinSize(200, 100);
		welcomeLabel.setWrapText(true);

		usernameLabel = new Label("Username:");

		passwordLabel = new Label("Password:");
	}
/**
 * 
 * @param gridPane
 */
	private void controlGrid(GridPane gridPane) {
		gridPane.add(welcomeLabel, 0, 0);
		gridPane.add(usernameLabel, 0, 1);
		gridPane.add(usernameField, 0, 2);
		gridPane.add(passwordLabel, 0, 3);
		gridPane.add(passwordField, 0, 4);
		gridPane.add(siBox, 0 ,5);
		gridPane.add(naBox, 0, 6);
	}
/**
 * 
 * @param gridPane
 */
	private void setGrid(GridPane gridPane) {
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		gridPane.setStyle(style);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		gridPane.setHgap(0);
		//gridPane.setGridLinesVisible(true);
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
		newAccountButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				grid1.getChildren().clear();
				grid1.getChildren().add(newAcc);
			}
		});
	}
/**
 * 
 * @param grid1
 * @param profile
 */
	private void getSignBtn(GridPane grid1, Profile profile) {
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
					grid1.getChildren().add(profile);
				}
				else {
					createAlert(Alert.AlertType.ERROR, "Try Again!");
				}
			}
		});
	}
/**
 * 
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
		if(sqlData.userExists(username)==true) {
			System.out.println("fuck my gay father with a garden hose");
			System.out.println(sqlData.readData(username, "Password"));
			if(sqlData.readData(username, "Password") == password) {
				System.out.println("OH BABY A TRIPLE");
				valid = true;
			}
		}
		return valid;
/*
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
*/
	}
}
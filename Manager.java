import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Manager extends Application {
	private Pane mainPane;
	private Pane homeScreen;
	private Pane newAccount;
	private Pane matchScreen;
	private Pane viewPeople;
	private Pane instantMessage;
	private Pane settingsAndProfile;
	private Pane helpScreen;
	
	public Manager() {
		mainPane = new Pane();
		homeScreen = new Pane();
		newAccount = new Pane();
		matchScreen = new Pane();
		viewPeople = new Pane();
		instantMessage = new Pane();
		settingsAndProfile = new Pane();
		helpScreen = new Pane();
	}
	
	@Override
	public void start(Stage primaryStage) {
		Scene primaryScene = new Scene(mainPane);
		primaryStage.setTitle("RiddleVision");
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void setPane(Pane pane) {
		mainPane = pane;
	}
}

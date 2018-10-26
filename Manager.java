import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * The application used to run Riddlevision and utilize
 * all of the GUIs created for the project.
 * @author Alec Clawson, ERAU, 2018
 *
 */

public class Manager extends Application {
	private BorderPane mainPane;
	private Pane homeScreen;
	private Pane newAccount;
	private Pane matchScreen;
	private Pane viewPeople;
	private Pane instantMessage;
	private Pane settingsAndProfile;
	private Pane helpScreen;
	private HBox taskBar;
	private Button taskBt1, taskBt2, taskBt3;
	
	public Manager() {
		// Initialize all possible GUI panes
		mainPane = new BorderPane();
		homeScreen = new Pane();
		newAccount = new Pane();
		matchScreen = new Pane();
		viewPeople = new Pane();
		instantMessage = new Pane();
		settingsAndProfile = new Pane();
		helpScreen = new Pane();
		taskBar = new HBox();
		taskBar.setAlignment(Pos.CENTER);
		
		taskBar.setMaxWidth(Double.MAX_VALUE);
		taskBar.setPrefHeight(30);
		
		// Initialize taskbar buttons
		taskBt1 = new Button("Profile");
		taskBt2 = new Button("Find");
		taskBt3 = new Button("Matched");
		
		taskBt1.setMaxWidth(Double.MAX_VALUE);
		taskBt1.setMaxHeight(Double.MAX_VALUE);
		taskBt2.setMaxWidth(Double.MAX_VALUE);
		taskBt2.setMaxHeight(Double.MAX_VALUE);
		taskBt3.setMaxWidth(Double.MAX_VALUE);
		taskBt3.setMaxHeight(Double.MAX_VALUE);
		
		// Add buttons to taskbar
		taskBar.setHgrow(taskBt1, Priority.ALWAYS);
		taskBar.setHgrow(taskBt2, Priority.ALWAYS);
		taskBar.setHgrow(taskBt3, Priority.ALWAYS);
		taskBar.getChildren().addAll(taskBt1, taskBt2, taskBt3);
		
		mainPane.setBottom(taskBar);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Scene primaryScene = new Scene(mainPane);
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("RiddleVision");
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void addPane(Pane pane) {
		mainPane.setCenter(pane);
	}
	public void removePane(Pane pane) {
		mainPane.setCenter(new Pane());
	}
}

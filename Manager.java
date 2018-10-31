import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * 
 * @author Michael Fornito,Alec Clawson
 *
 */
public class Manager extends Application{

	// Stage mainStage = new Stage();
	public static void main(String[] args) {
		launch(args);
	}
/**
 * 
 * @param stage
 * @return
 */
	//The Main Pane that holds the main buttons
	public  GridPane MainPane(Stage stage) {
		ManagerButtons Lebuttons = new ManagerButtons(stage);
		GridPane rootpane = new GridPane();
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(0,10,0,10));
		hbox.setAlignment(Pos.CENTER);
		
		hbox.setTranslateX(0);
		hbox.setTranslateY(490);
		hbox.getChildren().addAll(Lebuttons.getHelp(),Lebuttons.getProfile(),
				Lebuttons.getFind(),Lebuttons.getMatch());
		rootpane.getChildren().add(hbox);
		return rootpane;
	}
/**
 * Starts the stage when program runs
 */
	//The first thing that is called, the Login
	public void start(Stage stage) {
		stage.setResizable(false);
		LoginScreen login = new LoginScreen();
		Scene scene = new Scene(login,400,520);
		stage.setScene(scene);
		stage.show();
	}
/**
 * 
 * @param NewAccountStage
 */
	//Switching to NewAccount
	public void startNewAcc(Stage NewAccountStage) {
		NewAccount newacc= new NewAccount(MainPane(NewAccountStage));
		NewAccStart(NewAccountStage,newacc);
	}
/**
 * 
 * @param newAccountStage
 * @param newacc
 */
	//Displays the New Account
	public void NewAccStart(Stage newAccountStage, NewAccount newacc) {
		Boolean change = false;
		newAccountStage.setResizable(false);
		Scene scene = new Scene(newacc,400,520);
		newAccountStage.setScene(scene);
		newAccountStage.show();
		newAccountStage.requestFocus();
		/*
		Timeline time = new Timeline(
				new KeyFrame(Duration.seconds(1), e-> {
					if (newacc.getValue()==true) {
						newAccountStage.close();
					}
				}));
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
	}
		 */
	}
/**
 * 
 * @param ProfileStage
 */
	//Switching to Profile
	public void startProfile(Stage ProfileStage) {
		Profile profile = new Profile();
		//profile.getChildren().add(MainPane(ProfileStage));
		ProfileStart(ProfileStage,profile);
	}
/**
 * 
 * @param ProfileStage
 * @param profile
 */
	//Displays Profile
	public void ProfileStart(Stage ProfileStage, Profile profile) {	
		ProfileStage.setResizable(false);
		Scene scene = new Scene(profile,400,520);
		ProfileStage.setScene(scene);
		ProfileStage.show();
		profile.requestFocus();
	}
	/**
	 * 
	 * @param HelpStage
	 */
	//Switching to Help
	public void startHelp(Stage HelpStage) {
		Help Help = new Help();
		//profile.getChildren().add(MainPane(ProfileStage));
		HelpStart(HelpStage,Help);
	}
	/**
	 * 
	 * @param HelpStage
	 * @param help
	 */
	//Displaying Help
	public void HelpStart(Stage HelpStage, Help help) {	
		HelpStage.setResizable(false);
		Scene scene = new Scene(help,400,520);
		HelpStage.setScene(scene);
		HelpStage.show();
		help.requestFocus();
	}
	/**
	 * 
	 * @param SetStage
	 */
	public void startSet(Stage SetStage) {
		Setting set = new Setting();
		//profile.getChildren().add(MainPane(ProfileStage));
		SetStart(SetStage,set);
	}
	/**
	 * 
	 * @param setStage
	 * @param set
	 */
	private void SetStart(Stage setStage, Setting set) {
		setStage.setResizable(false);
		Scene scene = new Scene(set,400,520);
		setStage.setScene(scene);
		setStage.show();
		set.requestFocus();		
	}
	
	
}






import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Chris
 
 */
public class SettingScreen extends Pane {

	private HBox siBox;
	Button settingTester = new Button("Test Setting");
	Button newAccTester = new Button("Test New Account");
	
	public static void main(String[] args) {
		System.out.println("Login runnin");
	}

	SettingScreen(GridPane grid1, NewAccount newAcc, Profile profile) {
		GridPane gridPane = new GridPane();
		setGrid(gridPane);
		controlGrid(gridPane);
		this.getChildren().add(gridPane);
		getNewAccBtn(grid1, newAcc);
	}


	private void controlGrid(GridPane gridPane) {
		gridPane.add(settingTester, 0, 0);
		gridPane.add(newAccTester, 1, 0);
		settingTester.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Setting setting = new Setting(siBox, gridPane);
				setting.testSetting();
			}
		});
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
	private void getNewAccBtn(GridPane grid1, NewAccount newAcc) {
		newAccTester.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				newAcc.testNewAccount();
			}
		});
	}
}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTest extends Application {

	public static void main(String[] args) {
		launch(args);	
	}
	public void start(Stage stage) {
		ProfileTest profTest = new ProfileTest();
		profTest.start();
		FindUserTest findU = new FindUserTest();
		findU.start();
		stage.close();
	}
}


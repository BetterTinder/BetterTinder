import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class manager2 extends Application{

	public void start(Stage stage) {
		Pane rootpane = new Pane();
		Profile profle = new Profile();
		rootpane.getChildren().add(profle);
		Scene scene = new Scene(rootpane);
		stage.setScene(scene);
		stage.show();
	}

}

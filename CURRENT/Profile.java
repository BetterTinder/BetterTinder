
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * 
 * @author forni
 *
 */

public class Profile extends UserGUIMethods{
	Profile(HBox hBox, GridPane rootpane) {
		super(hBox, rootpane);
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		grabImageFromSQL();

		this.setStyle(style);
		this.getChildren().addAll(getHbox2(hBox, rootpane),getHbox1(),hBox,getname(),getBio(),getReviewRating(),view);
	}
}

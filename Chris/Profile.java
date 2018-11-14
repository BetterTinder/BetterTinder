import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

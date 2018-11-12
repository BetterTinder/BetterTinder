import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FindUsers extends UserGUIMethods{

	FindUsers(HBox hBox, GridPane rootpane) {
		super(hBox, rootpane);
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		grabImageFromSQL();

		this.setStyle(style);
		this.getChildren().addAll(getHbox1(),hBox,getname(),getBio(),getReviewRating(),view);
	}
}

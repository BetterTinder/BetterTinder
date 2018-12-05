import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 * 
 * @author Chris G and Michael Fornito
 *
 */
public class Help extends GridPane  {

	Help(){
		VBox vbox = new VBox(490);
		GridPane gridPane = new GridPane();
		setGrid(gridPane);
		
		Text profile = new Text(profileHelp());
		profile.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 15));
		
		Text matched = new Text(MatchedHelp());
		matched.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 15));

		Text finduser = new Text(findUserHelp());
		finduser.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 15));

		profile.setWrappingWidth(360);
		matched.setWrappingWidth(360);
		finduser.setWrappingWidth(360);

		gridPane.add(profile, 0, 0);
		gridPane.add(matched, 0, 1);
		gridPane.add(finduser, 0, 2);
		
		vbox.getChildren().addAll(gridPane);
		this.getChildren().addAll(vbox);
	}

	private void setGrid(GridPane  gridPane) {

		String style = "-fx-background-color: #52858F";
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setStyle("-fx-background-color: #52858F");
		gridPane.setVgap(18);
		gridPane.setHgap(0);
//		gridPane.setPrefSize(400, 500);
		
	}
	
	private String findUserHelp() {
		String finduser = new String("The Find Users button allows you to find your potential matches"
				+"to those you have common with. And those you have common with are displayed in Matched Users.");
		return finduser;
	}
	private String MatchedHelp() {
		String match = new String("The Matched Users button displays a list of those who you have matched with"
				+"from Find Users. From the list you can view their profile.");
		return match;
	}
	private String profileHelp() {
		String profile = new String("The Profile button displays your profile such as"
				+ "your pictures, name, bio, your review rating, and settings.");
		return profile;
	}
}
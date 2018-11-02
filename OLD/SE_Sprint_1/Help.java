import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * @author Chris G and Michael Fornito
 *
 */
public class Help extends GridPane  {

	Help(){
		VBox vbox = new VBox(20);
		Stage stage = new Stage();
		Text profile = new Text(profileHelp());
		Text matched = new Text(MatchedHelp());
		Text finduser = new Text(findUserHelp());
		
		profile.setWrappingWidth(380);
		matched.setWrappingWidth(380);
		finduser.setWrappingWidth(380);
	
		
		vbox.getChildren().addAll(profile,matched,finduser,getButton());
		
		this.getChildren().addAll(vbox);
	}
	/**
	 * 
	 * @return button to call profile
	 */
	private Button getButton() {
		Button button = new Button("Back");
		button.setOnAction(new EventHandler<ActionEvent>(){ 
			public void handle(ActionEvent event) {
				Manager manager = new Manager();
				Stage stage = new Stage();
				manager.startProfile(stage);
			}
		});
		
		return button;
	}
	/**
	 * 
	 * @return string
	 */
	private String findUserHelp() {
		String finduser = new String("The Find Users button allows you to find your potential matches"
				+"to those you have common with. And those you have common with are displayed in Matched Users.");
		return finduser;
	}
	/**
	 * 
	 * @return string
	 * 
	 */
	private String MatchedHelp() {
		String match = new String("The Matched Users button displays a list of those who you have matched with"
				+"from Find Users. From the list you can view their profile.");
	return match;
	}
	/**
	 * 
	 * @return string
	 */
	private String profileHelp() {
		String profile = new String("The Profile button displays your profile such as"
				+ "your pictures, name, bio, your review rating, and settings.");
		return profile;
	}
}
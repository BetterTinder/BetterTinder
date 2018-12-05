import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
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
		this.getChildren().addAll(getHbox2(hBox, rootpane),getHbox1(),hBox,getname(),getReviewRating(),getBio(),view);
	}
	/**
	 * 
	 * @param hbox
	 * @param rootpane
	 * @return
	 */
	public HBox getHbox2(HBox hbox, GridPane rootpane) { //All buttons for only profile are here
		HBox Hbox2 = new HBox(5);
		Hbox2.setTranslateX(1);
		Hbox2.setTranslateY(1);
		Hbox2.getChildren().addAll(getAddBtn(),getRemoveBtn(),getSettingBtn(hbox, rootpane));
		Hbox2.getChildren().addAll(sendBio());
		return Hbox2;
	}
	/**
	 * 
	 * @param hbox
	 * @param root
	 * @return
	 */
	public Button getSettingBtn(HBox hbox, GridPane root) {
		Setting set = new Setting(hbox,root);
		Button setting = new Button("Settings");
		setting.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				root.getChildren().clear();
				root.getChildren().add(set);
				set.runOnButton();
			}
		});
		return setting;
	}
	/**
	 * 
	 * @return reads and displays the user's name
	 */
	public Text getname() {
		SQLData Database = SQLData.getInstance();
		Database.makeCon(Database);
		String[] col = {"FirstName","LastName"};
		String FName = Database.readData(currentUser, col).get(0);
		String LName = Database.readData(currentUser, col).get(1);
		Database.closeCon();
		Text username = new Text(FName+" "+LName);
		username.setTranslateX(110.0f);
		username.setTranslateY(-70.0f);
		return username;
	}


	/**
	 * 
	 * @return finds and displays the user's bio information as a text on the pane
	 */
	public TextField getBio() {
		bio.setMaxWidth(400);
		bio.setTranslateX(10.0f);
		bio.setTranslateY(230.0f);
		return bio;
	}
	/**
	 * 
	 * @param bio
	 * @return
	 */
	public Button sendBio() {
		Button sendbio = new Button("Send Bio");
		sendbio.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SQLData sqlData = SQLData.getInstance();
				sqlData.makeCon(sqlData);
				String[] column = {"Bio"};
				String[] values = {bio.getText()};
				sqlData.updateData(currentUser, column, values);
				sqlData.closeCon();
			}
		});		
		bio.clear();
		return sendbio;
	}

}

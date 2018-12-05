import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
/**
 * 
 * @author forni
 *
 */
public class Profile extends UserGUIMethods{
	Profile(HBox hBox, GridPane rootpane) {
		super(hBox, rootpane);
		String style = "-fx-background-color: #52858F";;
		grabImageFromSQL();
		this.setStyle(style);
		this.getChildren().addAll(getHbox2(hBox, rootpane),getHbox1(),hBox,
				getname(),getReviewRating(),getBio(),DisplayCurrentBio(),view);
	}
	/**
	 * 
	 * @param hbox
	 * @param rootpane
	 * @return
	 */
	public HBox getHbox2(HBox hbox, GridPane rootpane) { //All buttons for only profile are here
		HBox Hbox2 = new HBox(10);
		Hbox2.setAlignment(Pos.TOP_CENTER);
		Hbox2.setTranslateY(5);
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
		setting.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		setting.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		setting.setMinSize(85, 20);
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
		username.setFont(Font.font("Lucida Bright"));
		username.setTranslateX(110.0f);
		username.setTranslateY(-70.0f);
		return username;
	}

	public Text DisplayCurrentBio() {
		SQLData Database = SQLData.getInstance();
		Database.makeCon(Database);
		Text userBio = new Text("");
		String[] col = {"Bio"};
		String Bio = Database.readBio(currentUser, col).get(0);
		Database.closeCon();
		userBio = new Text(Bio);
		userBio.setFont(Font.font("Lucida Bright"));
		userBio.setWrappingWidth(400);
		userBio.setTextAlignment(TextAlignment.CENTER);
		userBio.setTranslateX(0.0f);
		userBio.setTranslateY(260.0f);
		return userBio;
	}

	/**
	 * 
	 * @return finds and displays the user's bio information as a text on the pane
	 */
	public TextField getBio() {
		bio.setPromptText("Enter a new bio");
		bio.setMaxWidth(350);
		bio.setAlignment(Pos.CENTER);
		bio.setTranslateX(25.0f);
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
		sendbio.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		sendbio.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		sendbio.setMinSize(85, 20);
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

import java.lang.reflect.Array;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

class ProfileTest extends MainTest{
	GridPane rootpane = new GridPane();
	//Initialized variables names that I want to check
	String userid = "Test2";
	String rev = "5.0"; //Must a double value
	Text  username = new Text("Test 2");
	Text bio = new Text("Hello Im Test 2!");
	Text revText = new Text("Rating: "+rev+"/5.00");
	
	ProfileTest(){
		System.out.println("Current checking the current user information:");
		start();
	}

	public void start() {
		GridPane rootpane = new GridPane();
		HBox hbox = new HBox();
		changeUser();
		Profile profile = new Profile(hbox, rootpane);
		checkName(profile);
		checkBio(profile);
		checkReview(profile);
	}

	public void changeUser() {
		UserID userID = new UserID();
		userID.makeUserID(userid);
	}

	public void checkName(Profile profile) {;	
	String userStr = username.getText();
	Text SQLUserNameText = profile.getname();
	String  sqlUserNameStr = SQLUserNameText.getText();
	if(userStr.equals(sqlUserNameStr)){
		System.out.println("Passed the name test");
	}else {
		System.out.println("Failed the name test, current checked name: "+sqlUserNameStr);
	}
	}

	public void checkBio(Profile profile) {
		SQLData Database = SQLData.getInstance();
		Database.makeCon(Database);
		String[] col = {"Bio"};
		String Bio = Database.readBio(userid, col).get(0);
		Database.closeCon();
		Text sqlBioText = new Text(Bio);
		String SQLBio = sqlBioText.getText();
		String bioStr = bio.getText();
		if(bioStr.equals(SQLBio)) {
			System.out.println("Passed the bio test");
		}else {
			System.out.println("Failed the bio test, currently checked bio: "+ SQLBio);
		}
	}

	public void checkReview(Profile profile) {
		String revStr = revText.getText();
		Text SQLRevText = profile.getReviewRating();
		String SQLRevString = SQLRevText.getText();
		if(revStr.equals(SQLRevString)) {
			System.out.println("Passed the review test");
			System.out.println("");
		}else {
			System.out.println("Failed the review test, current check review:" + SQLRevString);
			System.out.println("");
		}
	}

}





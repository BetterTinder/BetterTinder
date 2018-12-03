import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

class ProfileTest extends MainTest{
	GridPane rootpane = new GridPane();
	//Initialized variables names that I want to check
	String userid = "Test2";
	Text  username = new Text("Test 2");
	Text bio = new Text("Hello I am Test 2");
	Text revText = new Text("5.0");
	
	ProfileTest(){
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

	public void checkName(UserGUIMethods profile) {;	
	String userStr = username.getText();
	Text SQLUserNameText = profile.getname();
	String  sqlUserNameStr = SQLUserNameText.getText();

	//Compare Test
	if(userStr.equals(sqlUserNameStr)){
		System.out.println("Passed the name test");
	}else {
		System.out.println("Failed the name test");
	}
	}

	public void checkBio(UserGUIMethods profile) {
		String bioStr = bio.getText();
		Text sqlBioText= profile.getBio();
		String SQLBio = sqlBioText.getText();

		if(bioStr.equals(SQLBio)) {
			System.out.println("Passed the bio test");
		}else {
			System.out.println("Failed the bio test");
		}
	}

	public void checkReview(UserGUIMethods profile) {
		String revStr = revText.getText();
		Text SQLRevText = profile.getReviewRating();
		String SQLRevString = SQLRevText.getText();
		
		if(revStr.equals(SQLRevString)) {
			System.out.println("Passed the review test");
			System.out.println("");
		}else {
			System.out.println("Failed the review test");
			System.out.println("");
		}
	}

}





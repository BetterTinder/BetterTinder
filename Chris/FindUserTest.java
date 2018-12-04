import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FindUserTest extends MainTest{
	GridPane rootpane = new GridPane();
	HBox hbox = new HBox();
	FindUsers findprofile = new FindUsers(hbox, rootpane);
	UserID userID = new UserID();
	String userid = ("Test 2"); //Current User
	Text username;
	Text bio;
	Text revText;

	public void start() {
		FoundNoMatches();
		changeUser();
		checkName(findprofile);
		checkBio(findprofile);
		checkReview(findprofile);
		
		FoundMatches();
		changeUser();
		checkName(findprofile);
		checkBio(findprofile);
		checkReview(findprofile);
	}
	
	public void FoundNoMatches() {//Test if they have no potential matchers
		System.out.println("Below are displaying no potential matched users:");
		username = new Text("There are currently no matches."); 
		bio = new Text("");
		revText = new Text("");
	}
	
	public void FoundMatches() {//Test if they have potential matchers
		System.out.println("Found Potential matched users:");
		username = new Text("Test3"); 
		bio = new Text("Hello this is my bio");
		revText = new Text("3");
	}

	public void changeUser() {
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



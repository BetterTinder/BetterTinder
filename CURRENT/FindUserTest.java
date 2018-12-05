import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FindUserTest extends MainTest{
	GridPane rootpane = new GridPane();
	HBox hbox = new HBox();
	FindUsers findprofile = new FindUsers(hbox, rootpane);
	UserID userID = new UserID();
	String userid = ("Test 2"); //The current user that will view the other user
	Text username;
	Text bio;
	Text revText;
/**
 * IMPORTANT NOTE: The results for found no matches and found matches should always be opposite results
 * because they share the same methods; for instance, if you find potential matches then you should pass for
 * all the potential matches and fail for finding no potential matches. The reason you fail for finding no potential matches
 * is because the strings for finding a user should never match the strings for not finding a user (vise versa).
 */
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
		String rev = ("3");
		username = new Text("Test3"); 
		bio = new Text("Hello Im Test3!");
		revText = new Text("Rating: "+rev+"/5.00");
	}

	public void changeUser() {
		userID.makeUserID(userid);
	}

	public void checkName(FindUsers profile) {;	
	String userStr = username.getText();
	Text SQLUserNameText = profile.getname();
	String  sqlUserNameStr = SQLUserNameText.getText();
	
	if(userStr.equals(sqlUserNameStr)){
		System.out.println("Passed the name test");
	}else {
		System.out.println("Failed the name test");
	}
	}

	public void checkBio(FindUsers profile) {
		String bioStr = bio.getText();
		Text sqlBioText= profile.getFindUserBio();
		String SQLBio = sqlBioText.getText();

		if(bioStr.equals(SQLBio)) {
			System.out.println("Passed the bio test");
		}else {
			System.out.println("Failed the bio test");
		}
	}

	public void checkReview(FindUsers profile) {
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



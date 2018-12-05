import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FindUserTest extends MainTest{
	List<String> potentialMatch = new ArrayList<String>();
	GridPane rootpane = new GridPane();
	HBox hbox = new HBox();
	FindUsers findprofile = new FindUsers(hbox, rootpane);
	UserID userID = new UserID();
	String userid; 
	String potentialNameCheck; 
	String bio;
	String rev;
	/**
	 * IMPORTANT NOTE: The results for found no matches and found matches should always be opposite results
	 * because they share the same methods; for instance, if you find potential matches then you should pass for
	 * all the potential matches and fail for finding no potential matches. The reason you fail for finding no potential matches
	 * is because the strings for finding a user should never match the strings for not finding a user (vise versa).
	 * @throws IOException 
	 */
	public void start() throws IOException {
		System.out.println("Current checking the potential user information:");
		FoundMatches();
		changeUser();
		FindPotentialMatches();
		checkName(findprofile);
		checkFindUserBio(findprofile);
		checkReview(findprofile);
	}
	/**
	 * Initalizes Values
	 */
	public void FoundMatches() {//Test if they have potential matchers
		userid= ("Test2"); //The current user that will view the other user
		potentialNameCheck = ("Test3");//The user you are supposed to match with
		rev = ("3.0");//include double value 
		bio = "Hello Im Test 3!"; //The bio of the user you are supposed to match with
		rev = "Rating: "+rev+"/5.00"; //The rating of the user you are supposed to match with
	}
	/**
	 * Update to the current user
	 */
	public void changeUser() {
		userID.makeUserID(userid);
	}
	private void FindPotentialMatches() throws IOException {
		Matching match = new Matching();
		UserID userID = new UserID();  
		match.DownloadData();
		match.getUserData(userID.getUserID());
		match.getPotentialMatches();
		match.filterPotentialMatches();
		String[][] MatchData = match.MatchUsers();
		for(int i = 0; i<MatchData.length; i++) {
			potentialMatch.add(MatchData[i][0]);
		}
		System.out.println("Results from the Matched Algorithm: " +potentialMatch);
	}
		/**
		 * 
		 * @param profile
		 * 
		 */
		public void checkName(FindUsers profile) {;	
		//Had to extract the code for getname() method because potentialMatch isnt take as a paramerer but instead a global variable
		Text sqlUserNameText = new Text("");
		if(potentialMatch.isEmpty()==true) {	
		}else if(potentialMatch.get(0)==null){
		}else {
		SQLData Database = SQLData.getInstance();
		Database.makeCon(Database);
		String[] col = {"FirstName","LastName"};
		String FName = Database.readData(potentialMatch.get(0), col).get(0);
		String LName = Database.readData(potentialMatch.get(0), col).get(1);
		Database.closeCon();
		sqlUserNameText = new Text(FName+LName);
		}
		String sqlUserNameStr = sqlUserNameText.getText();
		if(potentialNameCheck.equals(sqlUserNameStr)){
			System.out.println("Passed the name test");
		}else {
			System.out.println("Failed the name test, current name checked: "+sqlUserNameStr);
		}
		}
		/**
		 * 
		 * @param profile
		 * Check User Bio
		 */
		public void checkFindUserBio(FindUsers profile) {
			//Had to extract the code for getFindUserBio() method because potentialMatch isnt take as a paramerer but instead a global variable
			Text sqlBioText = new Text("");
			if(potentialMatch.isEmpty()==true) {	
			}else if(potentialMatch.get(0)==null){
			}else {
			SQLData Database = SQLData.getInstance();
			Database.makeCon(Database);
			String[] col = {"Bio"};
			String Bio = Database.readBio(potentialMatch.get(0), col).get(0);
			Database.closeCon();
			sqlBioText = new Text(Bio);
			}
			String SQLBio = sqlBioText.getText();
			if(bio.equals(SQLBio)) {
				System.out.println("Passed the bio test");
			}else {
				System.out.println("Failed the bio test, current bio checked: "+SQLBio);
			}
			
		}

		public void checkReview(FindUsers profile) {
			Text review = new Text("");
			if(potentialMatch.isEmpty()==true) {	
			}else if(potentialMatch.get(0)==null){
			}else {
				SQLData Database = SQLData.getInstance();
				Database.makeCon(Database);
				String[] col = {"Review"};
				String rev = Database.readData(potentialMatch.get(0), col).get(0);
				Database.closeCon();
				review = new Text("Rating: "+rev+"/5.00");
			}
			String SQLRevString = review.getText();
			if(rev.equals(SQLRevString)) {
				System.out.println("Passed the review test");
				System.out.println("");
			}else {
				System.out.println("Failed the review test, current review checked: "+SQLRevString);
				System.out.println("");
			}
		}

	}



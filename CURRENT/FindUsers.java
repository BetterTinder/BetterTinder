import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FindUsers extends UserGUIMethods{

	List<String> potentialMatch = new ArrayList<String>();
	FindUsers(HBox hBox, GridPane rootpane) {
		super(hBox, rootpane);
		grabImageFromSQL();

		try {
			FindPotentialMatches();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SetUpFindUser(hBox);

	}
	private HBox getBox(HBox hBox) {
		HBox Hbox1 = new HBox(255);
		Hbox1.setTranslateX(5);
		Hbox1.setTranslateY(100);
		Hbox1.getChildren().addAll(DislikeBtn(hBox),LikeBtn(hBox));
		return Hbox1;
	}
	public void SetUpFindUser(HBox hBox) {
		this.getChildren().clear(); //refresh to the next user
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		this.setStyle(style);
		this.getChildren().addAll(hBox,getBox(hBox),getHbox1(),getname(),getFindUserBio(),getReviewRating(),view);
	}

	/**
	 * 
	 * @return Text of the first potential name
	 */
	public Text getname() {
		Text username = new Text("There are currently no matches.");
		if(potentialMatch.isEmpty() || potentialMatch.get(0)==null) {
		}else {
			SQLData Database = SQLData.getInstance();
			Database.makeCon(Database);
			String[] col = {"FirstName","LastName"};
			String FName = Database.readData(potentialMatch.get(0), col).get(0);
			String LName = Database.readData(potentialMatch.get(0), col).get(1);
			Database.closeCon();
			username = new Text(FName+LName);
		}
		username.setTranslateX(110.0f);
		username.setTranslateY(-70.0f);
		return username;
	}
	
	public Text getFindUserBio() {
		Text userBio = new Text("");
		if(potentialMatch.isEmpty() || potentialMatch.get(0)==null) {
		}else {
			SQLData Database = SQLData.getInstance();
			Database.makeCon(Database);
			userBio = new Text("");
			String[] col = {"Bio"};
			String Bio = Database.readBio(potentialMatch.get(0), col).get(0);
			Database.closeCon();
			userBio = new Text(Bio);
		}
		userBio.setWrappingWidth(400);
		userBio.setTranslateX(10.0f);
		userBio.setTranslateY(230.0f);
		return userBio;
	}

	public Text getReviewRating() {
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
		review.setWrappingWidth(400);
		review.setTranslateX(230.0f);
		review.setTranslateY(-70.0f);
		return review;
	}

	private Button LikeBtn(HBox hBox) {
		Button like = new Button("Like");
		like.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(potentialMatch.isEmpty() || potentialMatch.get(0)==null) {
				}else {
					SQLData Database = SQLData.getInstance();
					Database.makeCon(Database);
					Database.likeUser(currentUser, potentialMatch.get(0), 1);
					Database.closeCon();
					potentialMatch.remove(0);
					SetUpFindUser(hBox);
				}
			}});
		return like;
	}

	private Button DislikeBtn(HBox hBox) {
		Button dislike = new Button("DisLike");
		dislike.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(potentialMatch.isEmpty()|| potentialMatch.get(0)==null) {
				}else {
					SQLData Database = SQLData.getInstance();
					Database.makeCon(Database);
					Database.likeUser(currentUser, potentialMatch.get(0), 0);
					Database.closeCon();
					potentialMatch.remove(0);
					SetUpFindUser(hBox);
					System.out.println("You did not like them");
				}
			}});
		return dislike;
	}

	private void FindPotentialMatches() throws IOException {
		Matching match = new Matching();
		UserID userID = new UserID();  
		match.DownloadData();
		match.getUserData(userID.getUserID());
		match.getPotentialMatches();
		match.filterPotentialMatches();
		String[][] MatchData = match.MatchUsers(75.0);
		for(int i = 0; i<MatchData.length; i++) {
			potentialMatch.add(MatchData[i][0]);
		}
		System.out.println("Matched"+":"+potentialMatch);
	}
}
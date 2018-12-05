public class Matching_tester {

public static void main(String[] args) {
	Matching match = new Matching();
	String UserID = "Test2";  
	match.DownloadData();
	  match.getUserData(UserID);
	  match.getPotentialMatches();
	  match.filterPotentialMatches();
	  String[][] MatchData = match.MatchUsers();

  }
}
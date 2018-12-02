public class Matching_tester {

public static void main(String[] args) {	
	Matching match = new Matching();
	  String userID = "Test3";
	  double PercentReq = 0.0;
	  match.DownloadData();
	  match.getUserData(userID);
	  match.getPotentialMatches();
	  match.filterPotentialMatches();
	  String[][] MatchData = match.MatchUsers(PercentReq);
	  System.out.println(MatchData[0][0]);

  }
}


public class Matching {
	int userid = 2943;
	int userRow;
	private String[][] ProfileData;
	private String[][] UserData;
	private String[][] PotentialMatchData;
	private String[][] FilteredMatchData;
	double totalMatchPoints;
	double MatchPoints;
	double Percent;
	double PercentMatch;
	
  public static void main(String[] args) {

	  Matching match = new Matching();
	  
	  match.DownloadData();
	  match.getUserData();
	  match.getPotentialMatches();
	  match.filterPotentialMatches();
	  match.MatchUsers();
  }
  
  //for now the download data method will only have hard-coded values for 6 profiles
  public void DownloadData(){
	ProfileData = new String[6][18];
	//User 1: Joseph Stalin
	ProfileData[0][0] = Integer.toString(5806);
	ProfileData[0][1] = "Joseph";
	ProfileData[0][2] = "Stalin";
	ProfileData[0][3] = "M";
    ProfileData[0][4] = "F";
	ProfileData[0][5] = "Daytona Beach";
	ProfileData[0][6] = "Long-Term";
	ProfileData[0][7] = "1";
	ProfileData[0][8] = "0";
	ProfileData[0][9] = "1";
	ProfileData[0][10] = "0";
	ProfileData[0][11] = "1";
	ProfileData[0][12] = "0";
	ProfileData[0][13] = "1";
	ProfileData[0][14] = "0";
	ProfileData[0][15] = "1";
	ProfileData[0][16] = "0";
	ProfileData[0][17] = "1";
	//User 2: Ryan Reynolds
	ProfileData[1][0] = Integer.toString(2943);
	ProfileData[1][1] = "Ryan";
	ProfileData[1][2] = "Reynolds";
	ProfileData[1][3] = "M";
    ProfileData[1][4] = "F";
	ProfileData[1][5] = "Daytona Beach";
	ProfileData[1][6] = "Long-Term";
	ProfileData[1][7] = "1";
	ProfileData[1][8] = "0";
	ProfileData[1][9] = "1";
	ProfileData[1][10] = "0";
	ProfileData[1][11] = "1";
	ProfileData[1][12] = "0";
	ProfileData[1][13] = "1";
	ProfileData[1][14] = "1";
	ProfileData[1][15] = "1";
	ProfileData[1][16] = "0";
	ProfileData[1][17] = "1";
	//User 3: Genghis Khan
	ProfileData[2][0] = Integer.toString(9908);
	ProfileData[2][1] = "Genghis";
	ProfileData[2][2] = "Khan";
	ProfileData[2][3] = "M";
    ProfileData[2][4] = "F";
	ProfileData[2][5] = "Somewhere in Asia";
	ProfileData[2][6] = "Long-Term";
	ProfileData[2][7] = "1";
	ProfileData[2][8] = "0";
	ProfileData[2][9] = "1";
	ProfileData[2][10] = "0";
	ProfileData[2][11] = "1";
	ProfileData[2][12] = "0";
	ProfileData[2][13] = "1";
	ProfileData[2][14] = "1";
	ProfileData[2][15] = "1";
	ProfileData[2][16] = "0";
	ProfileData[2][17] = "1";
	//User 4: Ariana Grande
	ProfileData[3][0] = Integer.toString(4269);
	ProfileData[3][1] = "Ariana";
	ProfileData[3][2] = "Grande";
	ProfileData[3][3] = "F";
    ProfileData[3][4] = "M";
	ProfileData[3][5] = "Daytona Beach";
	ProfileData[3][6] = "Long-Term";
	ProfileData[3][7] = "0";
	ProfileData[3][8] = "1";
	ProfileData[3][9] = "0";
	ProfileData[3][10] = "0";
	ProfileData[3][11] = "0";
	ProfileData[3][12] = "1";
	ProfileData[3][13] = "0";
	ProfileData[3][14] = "0";
	ProfileData[3][15] = "0";
	ProfileData[3][16] = "1";
	ProfileData[3][17] = "0";
	//User 5: Rihanna
	ProfileData[4][0] = Integer.toString(4581);
	ProfileData[4][1] = "Rihanna";
	ProfileData[4][2] = "";
	ProfileData[4][3] = "F";
    ProfileData[4][4] = "M";
	ProfileData[4][5] = "Daytona Beach";
	ProfileData[4][6] = "Hook-up";
	ProfileData[4][7] = "1";
	ProfileData[4][8] = "0";
	ProfileData[4][9] = "1";
	ProfileData[4][10] = "1";
	ProfileData[4][11] = "1";
	ProfileData[4][12] = "0";
	ProfileData[4][13] = "1";
	ProfileData[4][14] = "0";
	ProfileData[4][15] = "1";
	ProfileData[4][16] = "0";
	ProfileData[4][17] = "1";
	//User 6: Beyonce Knowles
	ProfileData[5][0] = Integer.toString(6451);
	ProfileData[5][1] = "Beyonce";
	ProfileData[5][2] = "Knowles";
	ProfileData[5][3] = "F";
    ProfileData[5][4] = "M";
	ProfileData[5][5] = "Daytona Beach";
	ProfileData[5][6] = "Long-Term";
	ProfileData[5][7] = "1";
	ProfileData[5][8] = "0";
	ProfileData[5][9] = "1";
	ProfileData[5][10] = "1";
	ProfileData[5][11] = "1";
	ProfileData[5][12] = "0";
	ProfileData[5][13] = "1";
	ProfileData[5][14] = "1";
	ProfileData[5][15] = "1";
	ProfileData[5][16] = "0";
	ProfileData[5][17] = "1";
	               
  }
  
  public void getUserData(){
	  UserData = new String[1][18];
	  for (int i = 0; i < ProfileData.length; i++) {
		  if (userid == Integer.valueOf(ProfileData[i][0])){
		  		userRow = i;
		  	  for (int j = 0; j < ProfileData[0].length; j++) {
				  UserData[0][j]=ProfileData[userRow][j];
			  }
		  }else{
		  }
	  }
	  System.out.println("User: " + UserData[0][1] + " " + UserData[0][2]);
  }
  
 public void getPotentialMatches(){
	 int MatchesLength = ProfileData.length - 1;
	 PotentialMatchData = new String[MatchesLength][18];
	 for (int i = 0; i < ProfileData.length; i++) {
	  	 for (int j = 0; j < ProfileData[0].length; j++) { 
	  		 if (userRow < i){
	  			 int k = i - 1;
		  		PotentialMatchData[k][j]=ProfileData[i][j];
	  		 }else if(userRow == i){
	  		 }else{
	  			PotentialMatchData[i][j]=ProfileData[i][j];
	  		 }
		  }
	  }
  }
 
 public void filterPotentialMatches(){
	 int x = 0;
	 int y = -1;
	 int FilteredLength;
	 for (int i = 0; i < PotentialMatchData.length; i++) {
		if  (UserData[0][3]!=PotentialMatchData[i][4]) {
			x = x + 1;
		}else if(UserData[0][4]!=PotentialMatchData[i][3]) {
			x = x + 1;
		}else if(UserData[0][5]!=PotentialMatchData[i][5]) {
			x = x + 1;
		}else if(UserData[0][6]!=PotentialMatchData[i][6]) {
			x = x + 1;
		}else {
		}
	 }
	 System.out.println("Filtered Matches: " + x);
	 FilteredLength = PotentialMatchData.length - x;
	 FilteredMatchData = new String[FilteredLength][18];
	 for (int j = 0; j < PotentialMatchData.length; j++) {
		if  (UserData[0][3]!=PotentialMatchData[j][4]) {
		}else if(UserData[0][4]!=PotentialMatchData[j][3]) {
		}else if(UserData[0][5]!=PotentialMatchData[j][5]) {
		}else if(UserData[0][6]!=PotentialMatchData[j][6]) {
		}else {
			y = y+1;
		  	 for (int k = 0; k < PotentialMatchData[0].length; k++) { 
		  		FilteredMatchData[y][k]=PotentialMatchData[j][k];
			  }
		}
	 }
		 
 }
 public void MatchUsers(){
	System.out.println("Matches");
	 for (int i = 0; i < FilteredMatchData.length; i++) {
		totalMatchPoints = 0;
		MatchPoints = 0;
		for (int j = 7; j < FilteredMatchData[0].length; j++) {
			if (UserData[0][j] == FilteredMatchData[i][j]) {
				MatchPoints = MatchPoints + 1;
				totalMatchPoints = 	totalMatchPoints + 1;
			}else if(UserData[0][j] == "2") {
			}else if(FilteredMatchData[i][j] == "2") {
			}else {
				totalMatchPoints = 	totalMatchPoints + 1;
			}

		}
		Percent = 100 * MatchPoints / totalMatchPoints;
		PercentMatch = Math.round(Percent*100)/100.0;
		System.out.println("" + FilteredMatchData[i][1] + " " + FilteredMatchData[i][2] + " -- Percent Match: " + PercentMatch + "%");
	 }
}
}
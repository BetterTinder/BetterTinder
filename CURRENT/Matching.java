import java.sql.*;
import java.util.List;

public class Matching {
	int userRow;
	private String[][] ProfileData;
	private String[][] UserData;
	private String[][] PotentialMatchData;
	private String[][] FilteredMatchData;
	private String[][] MatchData;
	double totalMatchPoints;
	double MatchPoints;
	double Percent;
	double PercentMatch;
	int row;
	int cellRows;
	int cellsPerLine;
  
  //for now the download data method will only have hard-coded values for 6 profiles
  public void DownloadData(){
	
	SQLData sqlData = SQLData.getInstance();
	sqlData.makeCon(sqlData);
	List<String> sqlDataList = sqlData.getAllData(1000);
	
	sqlData.closeCon();
	
	cellsPerLine = 14;
	int x,k;
	row = -1;
	int cellNumbers = sqlDataList.size();
	cellRows = cellNumbers/cellsPerLine;
	ProfileData = new String[cellRows][cellsPerLine];
	
	for (int i = 0; i < cellNumbers; i++) {
		if (i % cellsPerLine == 0) {
			row++;
		}
		k=row*cellsPerLine;
		x = i-k; 
		ProfileData[row][x] = sqlDataList.get(i);
	}
}
	
  public void getUserData(String userID){
	  for (int i = 0; i < cellRows; i++) {
		  if (userID.equals(ProfileData[i][0])) {
			  userRow=i;
		  }
	  }
		  UserData = new String[1][cellsPerLine];
		  for (int j = 0; j < cellsPerLine; j++) {
			  UserData[0][j] = ProfileData[userRow][j];
			  //"UserName","Location","Age","Dog","One_Night","Vegetarian","Movie","Exercise","Music","Relationship","Gender","Gender_Preference","Min_Age","Max_Age"
		  }
  }
 public void getPotentialMatches(){
	 int MatchesLength = ProfileData.length - 1;
	 PotentialMatchData = new String[MatchesLength][cellsPerLine];
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
		if  (!UserData[0][1].equals(PotentialMatchData[i][1])) {
			x = x + 1;
		}else if(!UserData[0][10].equals(PotentialMatchData[i][11])) {
			x = x + 1;
		}else if(!UserData[0][11].equals(PotentialMatchData[i][10])) {
			x = x + 1;
		}else if(!UserData[0][9].equals(PotentialMatchData[i][9])) {
			x = x + 1;
		}else if(Integer.valueOf(UserData[0][12])>Integer.valueOf(PotentialMatchData[i][2])) {
			x = x + 1;
		}else if(Integer.valueOf(UserData[0][13])<Integer.valueOf(PotentialMatchData[i][2])) {
			x = x + 1;
		}else if(Integer.valueOf(PotentialMatchData[i][12])>Integer.valueOf(UserData[0][2])) {
			x = x + 1;
		}else if(Integer.valueOf(PotentialMatchData[i][13])<Integer.valueOf(UserData[0][2])) {
			x = x + 1;
		}else {
	 }
	 }
	 FilteredLength = PotentialMatchData.length - x;
	 FilteredMatchData = new String[FilteredLength][cellsPerLine];
	
	 for (int j = 0; j < PotentialMatchData.length; j++) {
		if  (!UserData[0][1].equals(PotentialMatchData[j][1])) {
		}else if(!UserData[0][10].equals(PotentialMatchData[j][11]))  {
		}else if(!UserData[0][11].equals(PotentialMatchData[j][10])){
		}else if(!UserData[0][9].equals(PotentialMatchData[j][9])) {
		}else if(Integer.valueOf(UserData[0][12])>Integer.valueOf(PotentialMatchData[j][2])) {
		}else if(Integer.valueOf(UserData[0][13])<Integer.valueOf(PotentialMatchData[j][2])) {
		}else if(Integer.valueOf(PotentialMatchData[j][12])>Integer.valueOf(UserData[0][2])) {
		}else if(Integer.valueOf(PotentialMatchData[j][13])<Integer.valueOf(UserData[0][2])) {
		}else {
			y = y+1;
		  	 for (int k = 0; k < cellsPerLine; k++) { 
		  		FilteredMatchData[y][k]=PotentialMatchData[j][k];
			  }
		}
	 }
 }
 
 public String[][] MatchUsers(double PercentRequired) {
	 int k = 0;
	 MatchData = new String[1][2];
	 for (int i = 0; i < FilteredMatchData.length; i++) {
		totalMatchPoints = 0;
		MatchPoints = 0;
		for (int j = 3; j < 9; j++) {
			if (UserData[0][j].equals(FilteredMatchData[i][j])) {
				MatchPoints = MatchPoints + 1;
				totalMatchPoints = 	totalMatchPoints + 1;
			}else if(UserData[0][j].equals("Prefer not to answer")) {
			}else if(FilteredMatchData[i][j].equals("Prefer not to answer")) {
			}else {
				totalMatchPoints = 	totalMatchPoints + 1;
			}

		}
		Percent = 100 * MatchPoints / totalMatchPoints;
		PercentMatch = Math.round(Percent*100)/100.0;
		if (PercentMatch >= PercentRequired) {
			if (MatchData.length>k) {
			MatchData[k][0] = FilteredMatchData[i][0];
			MatchData[k][1] = Double.toString(PercentMatch);
			k++;
			} else {
				MatchData[k][0] = FilteredMatchData[i][0];
				MatchData[k][1] = Double.toString(PercentMatch);
				k++;
			}
			
		}
	 }
	 return MatchData;
}
}
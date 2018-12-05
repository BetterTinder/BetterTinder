import java.sql.SQLException;

class SQLManager{

    public static void main(String[] args) throws SQLException {
        /*
    	SQLData Database = SQLData.getInstance();
		String[] values = {"234"};
        Database.writeData("UserID",values);
        */
    	SQLData Database = SQLData.getInstance();
    	String[] values = {"Paulboy","Paul","Pull","sdlkfj","75","25","30","Port Orange","20","Prefer not to answer"};
    	String allFields = "UserName, FirstName, LastName, Password, Match, Min_Age, Max_Age, Location, Age, One_Night";
    	
    	String[] readCol = {"UserName", "FirstName", "LastName", "Password", "Match", "Min_Age", "Max_Age", "Location", "Age", "One_Night"};
    	Database.newUser(allFields, values);
    	//Database.newUser("UserName, userID", values);
    	System.out.println(Database.readData("Paulboy", readCol));
    	System.out.println(Database.userExists("Paul"));
    	Database.closeCon();
    	
    }
}


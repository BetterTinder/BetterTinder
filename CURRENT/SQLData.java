import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class that creates a connection to a SQL Database and interacts with it.
 * @author Jacob
 *
 */
public class SQLData
{
	private String url = null;
	private String user = null;
	private String pass = null;
	private Connection con = null;
	private static SQLData single_instance = null;

	/**
	 * Registers the driver and attempts to form a connection with the SQL server.
	 */
	private SQLData() 
	{
		url = "jdbc:sqlserver://172.3.161.26;database=RiddleVision;";
		user = "SA";
		pass = "rzZb<eW8JB^(QGA*";
		try 
		{
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		}
		catch (Exception ex) 
		{
			System.err.println(ex);
		}
	}

	public void makeCon(SQLData SQLData)
	{
		try 
		{
			if (SQLData.con == null)
				SQLData.con = DriverManager.getConnection(SQLData.url, SQLData.user, SQLData.pass);
			else if (SQLData.con.isClosed())
				SQLData.con = DriverManager.getConnection(SQLData.url, SQLData.user, SQLData.pass);
		}catch (Exception ex) 
		{
			System.err.println(ex);
		}
	}

	/**
	 * Singleton for ensuring only one connection is open at a time.
	 * @return SQLData
	 */
	public static SQLData getInstance() 
	{ 
		if (single_instance == null) 
			single_instance = new SQLData(); 
		return single_instance; 
	} 

	/**
	 * Writes values into the table, under the specified columns.
	 * @param columns Specified columns to insert data
	 * @param values Values that are inserted into the table
	 */
	public void newUser(String columns, String[] values)
	{
		String value = "'";
		for (int i=0; i<values.length; i++) 
		{
			value = value + values[i] + "'";
			if (i!=values.length-1) {
				value = value + ", '";
			}
		}
		String query = "INSERT INTO UserInformation ("+columns+") values("+value+")";
		try 
		{
			Statement statement = con.createStatement();
			int m = statement.executeUpdate(query);
			if (m == 1)
				System.out.println("inserted successfully : "+query);
			else
				System.out.println("insertion failed");

		} catch (SQLException e) {
			System.err.println(e);	
		}
	}

	/**
	 * Reads data from the UserInformation table on a SQL Server
	 * @param user String of the username of user that the desired information is stored with
	 * @param wantedData String of the column name of the desired data
	 * @return
	 */
	public List<String> readData(String user, String[] wantedData)
	{
		ResultSet m = null;
		List<String> Data = new ArrayList<String>();
		String query = "SELECT * FROM UserInformation WHERE UserName = '"+user+"';";
		try 
		{
			Statement statement = con.createStatement();
			m = statement.executeQuery(query);
			if (m != null)
			{
				m.next();
				for (int k=0;k<wantedData.length;k++) 
				{
					Data.add(m.getString(wantedData[k]).trim());
				}	
			}
			else {
				System.out.println("read failed");               
			} 
		} catch (SQLException e) 
		{
			System.err.println(e);	
		}
		return Data;	
	}
	
	public List<String> readBio(String user, String[] col)
	{
		return readData(user, col);
	}

	public List<String> getAllData(int rows)
	{
		ResultSet m = null;
		List<String> Data = new ArrayList<String>();
		String[] wantedData = { "UserName","Location","Age","Dog","One_Night","Vegetarian","Movie","Exercise","Music","Relationship","Gender","Gender_Preference","Min_Age","Max_Age","Match"};
		String query = "SELECT TOP ("+rows+") [";
		for (int i = 0; i<wantedData.length; i++)
		{
			query = query + wantedData[i] + "]";
			if (i<wantedData.length-1)
			{
				query = query + ",[";
			}
		}
		query = query +" FROM [RiddleVision].[dbo].[UserInformation]";
		try 
		{
			Statement statement = con.createStatement();
			m = statement.executeQuery(query);
			boolean notLast = true;
			while (notLast)
			{
				m.next();
				for (int k=0;k<wantedData.length;k++) 
				{
					try 
					{
						Data.add(m.getString(wantedData[k]).replaceAll("\\s+",""));
					}catch (SQLException p)
					{
						notLast = false;
						break;
					}
				}
			}

		} catch (SQLException e) 
		{
			System.err.println(e);

		}

		return Data;

	}

	public void updateData(String user, String[] column, String[] newVal) 
	{
		String query = "UPDATE UserInformation SET ";
		for (int j =0; j < column.length ; j++)
		{
			query = query + column[j] + " = '" + newVal[j] + "'";
			if (j<column.length-1)
			{
				query = query + ", ";
			}
		}
		query = query + "WHERE UserName = '" + user + "'";
		System.out.println(query);
		try 
		{
			Statement statement = con.createStatement();
			int m = statement.executeUpdate(query);
			if (m == 1)
				System.out.println("updated successfully : "+query);
			else
				System.out.println("update failed");
		} catch (SQLException e) 
		{
			System.err.println(e);
		}
	}
	
	public void likeUser(String currentUser, String viewingUser, int liked)
	{
		//liked = 1 for like and 0 for dislike
		String query = "UPDATE LikedUsers SET " + viewingUser + " = " + liked + " WHERE currentUser = '" + currentUser + "'";
		System.out.println(query);
		try 
		{
			Statement statement = con.createStatement();
			int m = statement.executeUpdate(query);
			if (m == 1)
				System.out.println("updated successfully : "+query);
			else
				System.out.println("update failed");
		} catch (SQLException e) 
		{
			System.err.println(e);
		}
	}
	
	public List<String> findMatched (String currentUser)
	{
		//Get List of All Users
		ResultSet n = null;
		List<String> userArray = new ArrayList<String>();
		String query2 = "SELECT currentUser FROM LikedUsers";
		boolean notLast = true;
		try {
			Statement statement1 = con.createStatement();
			n=statement1.executeQuery(query2);
			if (n != null)
			{
				while (notLast)
				{
					n.next();
					try 
					{
						userArray.add(n.getString("currentUser").replaceAll("\\s+",""));
					}catch (SQLException p)
					{
						notLast = false;
					}
				}
			}
		}catch(SQLException t) {}
		
		//Retrieve Users with a like value of 1
		ResultSet m = null;
		List<String> matched = new ArrayList<String>();
		String query1 = "SELECT * FROM LikedUsers WHERE currentUser = '"+currentUser+"';";
		try 
		{
			Statement statement = con.createStatement();
			m = statement.executeQuery(query1);
			if (m != null)
			{
				m.next();
				for (int k=0;k<userArray.size();k++) 
				{
					if(m.getInt(userArray.get(k))==1)
						matched.add(userArray.get(k));
				}	
			}
			else {
				System.out.println("read failed");               
			} 
		} catch (SQLException e) 
		{
			System.err.println(e);	
		}
		return matched;	
	}
	
	public void reviewUser(String user, double review)
	{
		String[] reviewCol = {"Review"};
		String[] countCol = {"Counter"};
		
		double OldReview = Double.parseDouble(readData(user, reviewCol).get(0));
		int count = Integer.parseInt(readData(user, countCol).get(0));
		int newCount = count+1;
		double newReview = (OldReview*count + review)/newCount;
		String[] Columns = {"Counter","Review"};
		String[] NewVals = {Integer.toString(newCount), Double.toString(newReview)};
		updateData(user, Columns, NewVals);
	}

	/**
	 * Used within the readData() method. Ensures that there are no other current users with a given username.
	 * @param set ResultSet object retrieved from the readData() method
	 * @return exists true if there is a user with the given username and false if there is no instance of the given username
	 */
	public boolean userExists(String user) 
	{
		boolean exists = false;
		getInstance();
		ResultSet set = null;	
		String query = "SELECT * FROM UserInformation WHERE UserName = '"+user+"';";
		try {
			Statement statement = con.createStatement();
			set = statement.executeQuery(query);
			if (set != null)
			{
				set.next();
				exists = true;
			}  
		} catch (SQLException e) {
			System.err.println(e);
		}
		return exists;
	}

	public void closeCon() {
		try {
			getInstance().con.close();
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
}






import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * 
 * @author Michael
 *
 */
public class UserID {
	/**
	 * 
	 * @return the userID
	 * @throws IOException 
	 */
	public String getUserID() throws IOException{
		String directory = System.getProperty("user.dir"); String dir = directory + ("\\\\");
		String userID ="defeault";
		String path = dir+"UserID.txt";
				userID = new String(Files.readAllBytes(Paths.get(path)));
		return userID;
	}
	/**
	 * 
	 * @param userID makes the UserID.txt file
	 */
	public void makeUserID(String userID) {
		BufferedWriter buff = null;
		try {
			File file = new File("UserID.txt");
			buff = new BufferedWriter(new FileWriter(file));
			buff.write(userID);
		}catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (buff !=null) {
				try {
					buff.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void alertUser() {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Could not locate your profile");
        alert.setContentText("Your username cannot be found. Please restart the application and login");
        alert.showAndWait();
	}	
}



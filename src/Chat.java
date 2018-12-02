import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * @author Alec Clawson, 2018
 *
 *This program is used to simulate a simple chat client, with a csv file representing
 *the different conversations stored on an online database.
 */

public class Chat {
	private static File chatLog;
	private static String chatId;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input the ID of the chat you wish to view: ");
		chatId = input.next();
		createChatFile();
		displayChat();
	}
	
	private static void createChatFile() {
		chatLog = new File("chat_log.txt");
	}
	
	public static void displayChat() {
		try {
			FileReader fileReader = new FileReader(chatLog);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			line = bufferedReader.readLine();
			while((line = bufferedReader.readLine()) != null) {
				String[] splitLine = line.split(";");
				
				String conversationId = splitLine[0];
				String userId = splitLine[1];
				String message = splitLine[2];
				
				if(conversationId.equalsIgnoreCase(chatId)) {
					System.out.println(userId + ": " + message);
				}
			}
			bufferedReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Alec Clawson, 2018
 *
 */

public class ChatGui extends Application {
	private File chatLog;	// Used as a placeholder for the sql table that will hold the messages
	private ArrayList<Label> messages = new ArrayList<>();	// The visual representation of the messages sent
	private String currentUser, otherUser;	// Used to tell the program which messages to show (only messages to/from these IDs
	
	private Button sendButton;
	private GridPane rootPane;	// The pane that will be inserted into the stage
	private ScrollPane chatWindow;	// Pane that scrolls down automatically when filled
	private TextField inputField;	// Text field to enter message
	private VBox chatBox;	// The vBox that contains the list of messages
	
	public ChatGui() {
		sendButton = new Button("Send");
		rootPane = new GridPane();
		chatWindow = new ScrollPane();
		inputField = new TextField();
		chatBox = new VBox();
		
		chatWindow.setContent(chatBox);
		chatWindow.setPrefSize(216, 400);
		rootPane.add(chatWindow, 0, 0);
		rootPane.add(inputField, 0, 1);
		rootPane.add(sendButton, 1, 1);
	}
	
	@Override
	public void start(Stage stage) {
		// If inputField is not empty, then write the message to the chatLog (SQL DB in real use)
		// then update the chat window
		sendButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
			public void handle(ActionEvent e) {
				if(inputField.getText() != null && !inputField.getText().isEmpty()) {
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(chatLog));
						writer.append("\n" + currentUser +";" + otherUser + ";" + inputField.getText());
						writer.close();
					} catch(IOException ex) {
						ex.printStackTrace();
					}
				}
				readChat();
				//TODO: Add SQL upload command
			}
		});
		
		// Just used as placeholder; will automatically use currentUser, and otherUser will be determined by
		// the profile being viewed when "chat" is pressed
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your User ID: ");
		currentUser = input.next();
		System.out.print("Enter the user you wish to chat with: ");
		otherUser = input.next();
		createChatFile();
		readChat();
		input.close();
		
		Scene scene = new Scene(rootPane);
		stage.setScene(scene);
		stage.show();
//		while(true)
//			readChat();
	}
	
	private void createChatFile() {
		chatLog = new File("chat_log.txt");
	}
	
	public void readChat() {
		//Empty out the chatWindow and refill it with the updated conversation
		chatBox = new VBox();
		messages.clear();
		try {
			FileReader fileReader = new FileReader(chatLog);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] splitLine = line.split(";");
				
				String sender = splitLine[0];
				String recipient = splitLine[1];
				String message = splitLine[2];
				
				if((otherUser.equals(recipient) && currentUser.equals(sender)) || 
						(otherUser.equals(sender) && currentUser.equals(recipient))) {
					messages.add(new Label(message));
				}
			}
			bufferedReader.close();
			for(Label x:messages) {
				chatBox.getChildren().add(x);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayChat() {
		for(int i=0; i<messages.size(); i++) {
			if(messages.get(i).getText().startsWith(currentUser)) {
				messages.get(i).setAlignment(Pos.CENTER_RIGHT);
			} else {
				messages.get(i).setAlignment(Pos.CENTER_LEFT);
			}
			messages.get(i).setPrefSize(50, 10);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

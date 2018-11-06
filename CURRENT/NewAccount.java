import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * 
 * @author Chris
 *
 */
public class NewAccount extends Setting  {

	/**
	 * the new account pane constructor. It adds things to the pane
	 * @param hbox
	 * @param prof
	 */
    NewAccount(HBox hbox, Profile prof) {
    	super(hbox, prof);
    	String style = "-fx-background-color: rgba(255, 255, 255, 1);";
        TextField name = new TextField();
        TextField FirstName = new TextField();
        TextField LastName = new TextField();
        TextField Password = new TextField();
        Label username = new Label("Username:");
        Label userFirst = new Label("First Name:");
        Label userLast = new Label("Last Name:");
        Label pass = new Label("Password:");
        GridPane gridPane = new GridPane();
        gridPane.setStyle(style);
        gridPane.add(username,0,0);
        gridPane.add(name,1,0);
        gridPane.add(pass,0,1);
        gridPane.add(Password,1,1);
        gridPane.add(userFirst,0,2);
        gridPane.add(FirstName,1,2);
        gridPane.add(userLast,0,3);
        gridPane.add(LastName,1,3);
        gridPane.add(comboBox,1,7);
        gridPane.add(genPrefLabel, 0, 4);
        gridPane.add(genIdenLabel, 0, 5);
        gridPane.add(genderPref, 1, 4);
        gridPane.add(genderIden, 1, 5);
        gridPane.add(age, 0, 6);
        gridPane.add(ageBox, 1, 6);
        gridPane.add(location, 0, 7);
        gridPane.add(agePref, 0, 8);
        gridPane.add(ageMin, 0, 9);
        gridPane.add(ageMinBox, 1, 9);
        gridPane.add(ageMax, 0, 10);
        gridPane.add(ageMaxBox, 1, 10);
        gridPane.add(intrest, 0, 11);
        gridPane.add(dog, 0, 12);
        gridPane.add(dogBox, 1, 12);
        gridPane.add(dogHave, 0, 13);
        gridPane.add(dogHaveBox, 1, 13);
        gridPane.add(vegetarian, 0, 14);
        gridPane.add(vegetarianBox, 1, 14);
        gridPane.add(movie, 0, 15);
        gridPane.add(movieBox, 1, 15);
        gridPane.add(walking, 0, 16);
        gridPane.add(walkingBox, 1, 16);
        gridPane.add(music, 0, 17);
        gridPane.add(musicBox, 1, 17);
        gridPane.add(democracy, 0, 18);
        gridPane.add(democracyBox, 1, 18);
        gridPane.add(save, 400, 500);

        //event handlers for the combo boxes
        genderPref.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like sleep with the gender of:");
            	System.out.println(genderPref.getValue());
            }
        });
        genderIden.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to identify as:");
            	System.out.println(genderIden.getValue());
            	}
        });
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their location");
            	System.out.println(comboBox.getValue());
            	}
        });
        ageBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their age");
            	System.out.println(ageBox.getValue());
            	}
        });
        dogBox.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(dogBox.getValue());
            	}
        });
        dogHaveBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(dogHaveBox.getValue());
            	}
        });
        dogHaveBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(dogHaveBox.getValue());
            	}
        });
        vegetarianBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(vegetarianBox.getValue());
            	}
        });
        movieBox.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(movieBox.getValue());
            	}
        });
        walkingBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(walkingBox.getValue());
            	}
        });
        musicBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(musicBox.getValue());
            	}
        });
        democracyBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(democracyBox.getValue());
            	}
        });
        ageMinBox.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(ageMinBox.getValue());
            	}
        });
        ageMaxBox.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(ageMaxBox.getValue());
            	}
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(ageMinBox.getValue()!=null && ageMaxBox.getValue()!=null && comboBox.getValue()!=null && ageBox.getValue()!=null && dogHaveBox.getValue()!=null && vegetarianBox.getValue()!=null && movieBox.getValue()!=null && walkingBox.getValue()!=null && musicBox.getValue()!=null && democracyBox.getValue()!=null && genderPref.getValue()!=null&&genderIden.getValue()!=null) {
            		if (Integer.parseInt(ageMinBox.getValue())<Integer.parseInt(ageMaxBox.getValue())) {
            		sendToProfile();
            		System.out.println("Changes saved");
            		//sendToDatabase isn't here, because I left it in Settings
                    sendToDataBase(ageMinBox, ageMaxBox, comboBox, ageBox, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderPref, genderIden);
                    userToDatabase(name, FirstName, LastName, Password);
            		}
            		else {
            			System.out.println("correct yo age");
            		}
            	}
            	else
            		System.out.println("Please fill in all values");

            	}
            
            /**
             * sends the newAccount specific vars to the SQL database
             * @param name
             * @param firstName
             * @param lastName
             * @param password
             */            public void userToDatabase(TextField name, TextField firstName, TextField lastName, TextField password) {
				//sendToDatabase.name.getText();
            	//sendToDatabase.firstName.getText();
            	//sendToDatabase.LastName.getText();
            	//sendToDatabase.password.getText();
			}

            /**
 			* this sends the user to the profile screen after creating their account
 			*/
            private void sendToProfile() {
        		gridPane.getChildren().clear();
        		gridPane.getChildren().add(prof);
        	}
        });
        
        this.getChildren().add(gridPane);
    }           
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("Bad Luck");
    }
}
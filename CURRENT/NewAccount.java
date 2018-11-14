import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
    	
		ageSlider.setMin(18);
		ageSlider.setMax(60);
		ageSlider.setValue(18);
        ageSlider.setBlockIncrement(5);
        ageSlider.setMajorTickUnit(5);
        ageSlider.setShowTickLabels(true);
        ageSlider.setShowTickMarks(true);
        ageSlider.setSnapToTicks(true);
        
        ageMinSlider.setMin(18);
		ageMinSlider.setMax(60);
		ageMinSlider.setValue(18);
        ageMinSlider.setBlockIncrement(5);
        ageMinSlider.setMajorTickUnit(5);
        ageMinSlider.setShowTickLabels(true);
        ageMinSlider.setShowTickMarks(true);
        ageMinSlider.setSnapToTicks(true);
        
        ageMaxSlider.setMin(18);
		ageMaxSlider.setMax(60);
		ageMaxSlider.setValue(18);
        ageMaxSlider.setBlockIncrement(5);
        ageMaxSlider.setMajorTickUnit(5);
        ageMaxSlider.setShowTickLabels(true);
        ageMaxSlider.setShowTickMarks(true);
        ageMaxSlider.setSnapToTicks(true);
        
        matchPercentage.setMin(0);
        matchPercentage.setMax(100);
		matchPercentage.setValue(75);
		matchPercentage.setBlockIncrement(5);
        matchPercentage.setMajorTickUnit(10);
        matchPercentage.setShowTickLabels(true);
        matchPercentage.setShowTickMarks(true);
        matchPercentage.setSnapToTicks(true);
        
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
        gridPane.setPadding(new Insets(25));
        gridPane.setStyle(style);
        gridPane.add(username,0,0);
        gridPane.add(name,1,0);
        gridPane.add(pass,0,1);
        gridPane.add(Password,1,1);
        gridPane.add(userFirst,0,2);
        gridPane.add(FirstName,1,2);
        gridPane.add(userLast,0,3);
        gridPane.add(LastName,1,3);
        gridPane.add(comboBox,1,6);
        gridPane.add(genPrefLabel, 0, 5);
        gridPane.add(genIdenLabel, 0, 4);
        gridPane.add(genderPref, 1, 5);
        gridPane.add(genderIden, 1, 4);
        gridPane.add(match, 0, 7);
        gridPane.add(matchPercentage, 1, 7);
        gridPane.add(age, 0, 8);
        gridPane.add(ageSlider, 1, 8);
        gridPane.add(location, 0, 6);
        gridPane.add(agePref, 0, 9);
        gridPane.add(ageMin, 0, 10);
        gridPane.add(ageMinSlider, 1, 10);
        gridPane.add(ageMax, 0, 11);
        gridPane.add(ageMaxSlider, 1, 11);
        gridPane.add(intrest, 0, 12);
        gridPane.add(dog, 0, 13);
        gridPane.add(dogBox, 1, 13);
        gridPane.add(dogHave, 0, 14);
        gridPane.add(dogHaveBox, 1, 14);
        gridPane.add(vegetarian, 0, 15);
        gridPane.add(vegetarianBox, 1, 15);
        gridPane.add(movie, 0, 16);
        gridPane.add(movieBox, 1, 16);
        gridPane.add(walking, 0, 17);
        gridPane.add(walkingBox, 1, 17);
        gridPane.add(music, 0, 18);
        gridPane.add(musicBox, 1, 18);
        gridPane.add(democracy, 0, 19);
        gridPane.add(democracyBox, 1, 19);
        gridPane.add(save, 1, 500);

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
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(comboBox.getValue()!=null && dogHaveBox.getValue()!=null && vegetarianBox.getValue()!=null && movieBox.getValue()!=null && walkingBox.getValue()!=null && musicBox.getValue()!=null && democracyBox.getValue()!=null && genderPref.getValue()!=null&&genderIden.getValue()!=null) {
            		if (ageMinSlider.getValue()<=ageMaxSlider.getValue()) {
            			sendToProfile();
            			System.out.println("Changes saved");
            			//sendToDatabase isn't here, because I left it in Settings
            			sendToDataBase(matchPercentage, ageMinSlider, ageMaxSlider, comboBox, ageSlider, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderPref, genderIden);
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
             * sends the newAccount specific variables to the SQL database
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
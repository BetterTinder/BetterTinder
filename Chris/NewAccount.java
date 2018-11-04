import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * 
 * @author Chris
 *
 */
public class NewAccount extends Setting  {

    NewAccount(GridPane grid1, Profile prof) {
    	String style = "-fx-background-color: rgba(255, 255, 255, 1);";
        TextField name = new TextField();
        TextField FirstName = new TextField();
        TextField LastName = new TextField();
        TextField Password = new TextField();
        Button save = new Button("Save Account");
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
        gridPane.add(intrest, 0, 8);
        gridPane.add(dog, 0, 9);
        gridPane.add(dogBox, 1, 9);
        gridPane.add(dogHave, 0, 10);
        gridPane.add(dogHaveBox, 1, 10);
        gridPane.add(vegetarian, 0, 11);
        gridPane.add(vegetarianBox, 1, 11);
        gridPane.add(movie, 0, 12);
        gridPane.add(movieBox, 1, 12);
        gridPane.add(walking, 0, 13);
        gridPane.add(walkingBox, 1, 13);
        gridPane.add(music, 0, 14);
        gridPane.add(musicBox, 1, 14);
        gridPane.add(democracy, 0, 15);
        gridPane.add(democracyBox, 1, 15);
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
        
        save.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	if(comboBox.getValue()!=null && ageBox.getValue()!=null && dogHaveBox.getValue()!=null && vegetarianBox.getValue()!=null && movieBox.getValue()!=null && walkingBox.getValue()!=null && musicBox.getValue()!=null && democracyBox.getValue()!=null && genderPref.getValue()!=null&&genderIden.getValue()!=null) {
            		grid1.getChildren().add(prof);
            		System.out.println("Changes saved");
                    sendToDataBase(comboBox, ageBox, dogBox, dogHaveBox, vegetarianBox, movieBox, walkingBox, musicBox, democracyBox, genderPref, genderIden);
            	}
            	else
            		System.out.println("Please fill in all values");

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
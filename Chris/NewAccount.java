import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author Chris
 *
 */
public class NewAccount extends Setting  {

    NewAccount() {

        TextField ID = new TextField();
        TextField FirstName = new TextField();
        TextField LastName = new TextField();
        TextField Password = new TextField();
        Button save = new Button("Save Account");
        Label userID = new Label("User ID:");
        Label userFirst = new Label("First Name:");
        Label userLast = new Label("Last Name:");
        Label pass = new Label("Password:");
        Label agg = new Label("Age:");
        Label gen = new Label("Gender preference:");
        Label geb = new Label("Gender:");
        Label loc = new Label("Location:");
        
        GridPane gridPane = new GridPane();
        gridPane.add(userID,0,0);
        gridPane.add(ID,1,0);
        gridPane.add(pass,0,1);
        gridPane.add(Password,1,1);
        gridPane.add(userFirst,0,2);
        gridPane.add(FirstName,1,2);
        gridPane.add(userLast,0,3);
        gridPane.add(LastName,1,3);
        gridPane.add(comboBox,0,7);
        gridPane.add(gen, 0, 4);
        gridPane.add(geb, 0, 5);
        gridPane.add(genderBox, 1, 4);
        gridPane.add(genderBox1, 1, 5);
        gridPane.add(agg, 0, 6);
        gridPane.add(comboBox1, 1, 6);
        gridPane.add(loc, 0, 7);
        gridPane.add(inr, 0, 8);
        gridPane.add(dog, 0, 9);
        gridPane.add(comboBox2, 1, 9);
        gridPane.add(doge, 0, 10);
        gridPane.add(comboBox3, 1, 10);
        gridPane.add(veg, 0, 11);
        gridPane.add(comboBox4, 1, 11);
        gridPane.add(mov, 0, 12);
        gridPane.add(comboBox5, 1, 12);
        gridPane.add(wal, 0, 13);
        gridPane.add(comboBox6, 1, 13);
        gridPane.add(mus, 0, 14);
        gridPane.add(comboBox7, 1, 14);
        gridPane.add(dem, 0, 15);
        gridPane.add(comboBox8, 1, 15);
        gridPane.add(save, 400, 500);

        //event handlers for the combo boxes
        genderBox.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like sleep with the gender of:");
            	System.out.println(genderBox.getValue());
            }
        });
        genderBox1.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to identify as:");
            	System.out.println(genderBox1.getValue());
            	}
        });
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their location");
            	System.out.println(comboBox.getValue());
            	}
        });
        comboBox1.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user would like to change their age");
            	System.out.println(comboBox1.getValue());
            	}
        });
        comboBox2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox2.getValue());
            	}
        });
        comboBox3.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox3.getValue());
            	}
        });
        comboBox3.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox3.getValue());
            	}
        });
        comboBox4.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox4.getValue());
            	}
        });
        comboBox5.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox5.getValue());
            	}
        });
        comboBox6.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox6.getValue());
            	}
        });
        comboBox7.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox7.getValue());
            	}
        });
        comboBox8.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("The user has answered:");
            	System.out.println(comboBox8.getValue());
            	}
        });
        
        save.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("Changes saved");
            	//sendtoDatabase(comboBox.getValue());
            	//sendtoDatabase(comboBox1.getValue());
            	//sendtoDatabase(comboBox2.getValue());
            	//sendtoDatabase(comboBox3.getValue());
            	//sendtoDatabase(comboBox4.getValue());
            	//sendtoDatabase(comboBox5.getValue());
            	//sendtoDatabase(comboBox6.getValue());
            	//sendtoDatabase(comboBox7.getValue());
            	//sendtoDatabase(comboBox8.getValue());
            	//sendtoDatabase(genderBox.getValue());
            	//sendtoDatabase(genderBox1.getValue());
            	}
        });
        this.getChildren().add(gridPane);
    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("IM FUCKING RUNNNNNIWNDBXW***2sx72 AHHHHHHH YMCA YMCA YMCA YMCA YMCA YMCA YMCA");
    }
}
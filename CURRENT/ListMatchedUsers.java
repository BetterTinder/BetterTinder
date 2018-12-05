import java.io.IOException;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListMatchedUsers extends GridPane
{
	UserID userID = new UserID();
	String currentUser;
	VBox List = new VBox(20);
	VBox Sliders = new VBox(20);
	List<String> Users;
	private static ListMatchedUsers instance = null;


	private ListMatchedUsers(HBox hbox, GridPane rootpane)
	{
		List.setTranslateY(3);
		List.setTranslateX(0);
		Sliders.setTranslateY(3);
		Sliders.setTranslateX(250);
		System.out.println(Sliders.getPrefWidth());
		//Sliders.setMaxWidth(60);
		//Sliders.autosize();
		refresh(hbox, rootpane);
	}
	
	public static ListMatchedUsers getInstance(HBox hbox, GridPane rootpane)
	{
		if (instance == null) 
		{
			instance = new ListMatchedUsers(hbox, rootpane);
		}else
		{
			instance.refresh(hbox, rootpane);
		}
			return instance;
	}
	
	public void refresh(HBox hbox, GridPane rootpane)
	{
		SQLData Database = SQLData.getInstance();
		Database.makeCon(Database);
		try 
		{
			currentUser = userID.getUserID();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		Users = Database.findMatched(currentUser);
		Database.closeCon();
		List.getChildren().clear();
		Sliders.getChildren().clear();
		rootpane.getChildren().clear();
		this.getChildren().clear();
		makeButtons(Users);
		setRoot(rootpane, hbox);
		this.getChildren().add(rootpane);
	}

	public void makeButtons(List<String> matchedUsers)
	{
		for (int i = 0; i<matchedUsers.size();i++)
		{
				Button button = new Button(matchedUsers.get(i));
				List.getChildren().add(button);	
				Slider reviewSlider = new Slider();
				setSlider(reviewSlider);
				Sliders.getChildren().add(reviewSlider);	
				System.out.println(Sliders.isResizable());
		}
	}
	
	private void setRoot(GridPane rootpane, HBox hbox)
	{
		rootpane.getChildren().add(List);
		rootpane.getChildren().add(hbox);
		rootpane.getChildren().add(Sliders);
	}
	
	private void setSlider(Slider slider)
	{
		slider.setMin(0);
		slider.setMax(5);
		slider.setValue(3);
		slider.setBlockIncrement(1);
		slider.setMajorTickUnit(1);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setSnapToTicks(true);
		slider.setMaxWidth(150);
	}































}
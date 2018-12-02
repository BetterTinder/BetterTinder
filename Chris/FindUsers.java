import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FindUsers<Strings> extends UserGUIMethods{

	FindUsers(HBox hBox, GridPane rootpane) {
		super(hBox, rootpane);
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		grabImageFromSQL();

		this.setStyle(style);
		this.getChildren().addAll(hBox,getBox(),getHbox1(),getname(),getBio(),getReviewRating(),view);
	}
	
	private HBox getBox() {
		HBox Hbox1 = new HBox(255);
		Hbox1.setTranslateX(5);
		Hbox1.setTranslateY(100);
		Hbox1.getChildren().addAll(DislikeBtn(),LikeBtn());
		return Hbox1;
	}


	private List<Strings> getPotentialName() {
		List<Strings> matches = new ArrayList<Strings>();
		return matches;
	}
	
	private Button LikeBtn() {
		Button like = new Button("Like");
		like.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
			
				System.out.println("You liked them");
			}
		});
		return like;
	}
	
	private Button DislikeBtn() {
		Button dislike = new Button("DisLike");
		dislike.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
			
				System.out.println("You did not like them");
			}
		});
		return dislike;
	}
	
}
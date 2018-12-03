import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

private void sendToDatabase(sentUser) {
	SQLData sqlData = SQLData.getInstance();
	sqlData.makeCon(sqlData);
	int reviewInt = (int)reviewSlider.getValue();
	String reviewVal = new String(Integer.toString(reviewInt));
	String[] column = {"Counter"};
	String[] values = {reviewVal};
	sqlData.updateData(sentUser, column, values);
	sqlData.closeCon();
	}

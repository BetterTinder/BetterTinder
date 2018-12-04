import java.text.DecimalFormat;
import java.util.List;

public class Review {

	private void updateReview(String reviewedUser, double review) {
		SQLData database = SQLData.getInstance();
		database.makeCon(database);

		String[] column = {"Counter", "Review"};
		List<String> oldData = database.readData(reviewedUser, column);

		int oldCounter = Integer.parseInt(oldData.get(0));
		double oldReview = Double.parseDouble(oldData.get(1));

		int newCounter = oldCounter + 1;
		double newReview = ((oldCounter*oldReview) + review) / newCounter;

		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String newReviewString = decimalFormat.format(newReview);
		String newCounterString = Integer.toString(newCounter);

		String [] newData = {newCounterString, newReviewString};
		database.updateData(reviewedUser, column, newData);
		database.closeCon();
	}
}
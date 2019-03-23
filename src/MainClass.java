import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.DatabaseManager;
import Controller.OutcomeManager;
import Model.Outcome;

public class MainClass {

	public static void main(String[] args) {
		try {
			ArrayList<Outcome> list = OutcomeManager.instance.getAllOutcomes();
			for (Outcome outcome : list) {
				System.out.println("the outcome description is "
						+ outcome.getDescription());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

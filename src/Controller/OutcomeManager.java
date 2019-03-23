package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale.Category;

import Model.Outcome;

public class OutcomeManager {

	public static final OutcomeManager instance = new OutcomeManager();

	private OutcomeManager() {

	}

	public void insertOutcome(Outcome o) {

	}

	public ArrayList<Outcome> getAllOutcomes() throws SQLException {
		ArrayList<Outcome> list = new ArrayList<Outcome>();

		String sql = "select * from outcome";
		ResultSet rs = DatabaseManager.instance.select(sql);
		while (rs.next()) {
			int id = rs.getInt("O_ID");
			double amount = rs.getDouble("Amount");
			String description = rs.getString("Description");	
			Date date = rs.getDate("Date");
			int C_id=rs.getInt("C_ID");
			int A_id=rs.getInt("A_ID");
			
			
			Outcome outcome = new Outcome(id,amount,description,date,C_id,A_id);
			
			list.add(outcome);
		}

		return list;
	}

	public ArrayList<Outcome> getOutcomes(Category category, Date startDate,
			Date endDate) {
		ArrayList<Outcome> list = new ArrayList<Outcome>();

		// ////

		return list;
	}

}

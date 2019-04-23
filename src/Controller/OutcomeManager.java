package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Model.Account;
import Model.Category;
import Model.Outcome;

public class OutcomeManager {

	public static final OutcomeManager instance = new OutcomeManager();

	private OutcomeManager() {

	}

	public void insertOutcome(Outcome o) throws SQLException {
		String sql = String.format(
				"EXEC [InsertOutcome] %f, '%s', '%s', %d, %d",
				o.getAmount(), o.getDescription(), o.getFormatedDate(), o.getC_id(), o.getA_id());

		DatabaseManager.instance.query(sql);
	}

	public ArrayList<Outcome> getAllOutcomes() throws SQLException {
		ArrayList<Outcome> list = new ArrayList<Outcome>();

		String sql = String.format(
				"SELECT * FROM Outcome AS O INNER JOIN FinancialAccount AS F ON O.A_ID=F.A_ID AND F.U_ID =%d",
				UserManager.instance.getCurrentUser().getU_ID());
		ResultSet rs = DatabaseManager.instance.select(sql);

		while (rs.next()) {
			Outcome outcome = getOutcomeFromResultSet(rs);
			list.add(outcome);
		}

		return list;
	}

	public ArrayList<Outcome> getOutcomes(Category category, Date startDate, Date endDate, Account account)
			throws SQLException {

		ArrayList<Outcome> list = new ArrayList<Outcome>();
		String sql = String.format(
				"SELECT * FROM Outcome WHERE (C_ID= '%d' AND [Date] BETWEEN '%s' AND '%s')AND A_ID='%d'",
				category.getId(), Utils.dateToString(startDate), Utils.dateToString(endDate), account.getId());

		ResultSet rs = DatabaseManager.instance.select(sql);

		while (rs.next()) {
			Outcome outcome = getOutcomeFromResultSet(rs);
			list.add(outcome);
		}

		return list;
	}

	private Outcome getOutcomeFromResultSet(ResultSet rs) throws SQLException {

		int id = rs.getInt("O_ID");
		double amount = rs.getDouble("Amount");
		String description = rs.getString("Description");
		Date date = rs.getDate("Date");
		int C_id = rs.getInt("C_ID");
		int A_id = rs.getInt("A_ID");

		Outcome outcome = new Outcome(id, amount, description, date, C_id, A_id);

		return outcome;
	}

}

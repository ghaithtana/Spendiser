package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Model.Account;
import Model.Income;

public class IncomeManager {

	public static final IncomeManager instance = new IncomeManager();

	private IncomeManager() {

	}

	public void insertIncome(Income i) throws SQLException {

		String sql = String
				.format("INSERT INTO Income (Amount,Description,Date,A_ID) VALUES('%f','%s','%s','%d')",
						i.getAmount(), i.getDescription(), i.getFormatedDate(),
						i.getA_ID());

		DatabaseManager.instance.query(sql);

	}

	public ArrayList<Income> getAllIncomes() throws SQLException {
		ArrayList<Income> list = new ArrayList<Income>();

		String sql = "select * from Income";
		ResultSet rs = DatabaseManager.instance.select(sql);

		while (rs.next()) {
			Income income = getIncomeFromResultSet(rs);
			list.add(income);

		}

		return list;
	}

	public ArrayList<Income> getIncomes(Date startDate, Date endDate,
			Account account) throws SQLException {

		ArrayList<Income> list = new ArrayList<Income>();
		String sql = String
				.format("SELECT * FROM Income WHERE ([Date] BETWEEN '%s' AND '%s')AND A_ID='%d'",
						Utils.dateToString(startDate), Utils.dateToString(endDate), account.getId());

		ResultSet rs = DatabaseManager.instance.select(sql);

		while (rs.next()) {
			Income income = getIncomeFromResultSet(rs);
			list.add(income);
		}

		return list;
	}

	private Income getIncomeFromResultSet(ResultSet rs) throws SQLException {

		int id = rs.getInt("I_ID");
		double amount = rs.getDouble("Amount");
		String description = rs.getString("Description");
		Date date = rs.getDate("Date");
		int A_id = rs.getInt("A_ID");

		Income income = new Income(id, amount, description, date, A_id);
		return income;

	}

}

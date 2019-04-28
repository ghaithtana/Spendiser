package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinancialManager {
	public static final FinancialManager instance = new FinancialManager();

	private FinancialManager() {
	}

	public double getBalance() throws SQLException {
		String sql = String.format("SELECT dbo.GETBALANCE(%d) As Balance ", UserManager.instance.getCurrentUser().getU_ID());
		ResultSet rs = DatabaseManager.instance.select(sql);

		if (rs.next()) {
			return rs.getDouble("Balance");
		}

		return 0;
	}

	public double TotalOutcomes(int month) throws SQLException {

		String sql = String.format("SELECT TotalOutcome FROM [Month] WHERE U_ID=%d AND [Month]=%d",
				UserManager.instance.getCurrentUser().getU_ID(), month);
		ResultSet rs = DatabaseManager.instance.select(sql);

		if (rs.next()) {
			return rs.getDouble("TotalOutcome");
		}

		return 0;
	}

}

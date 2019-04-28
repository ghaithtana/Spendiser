package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Account;

public class AccountManager {

	public static final AccountManager instance = new AccountManager();

	private AccountManager() {

	}

	public ArrayList<Account> getAllAccounts() throws SQLException {
		ArrayList<Account> list = new ArrayList<Account>();

		String sql = "SELECT * FROM FinancialAccount WHERE U_ID=" + UserManager.instance.getCurrentUser().getU_ID();
		ResultSet rs = DatabaseManager.instance.select(sql);

		while (rs.next()) {
			int aid = rs.getInt("A_ID");
			String name = rs.getString("Name");
			int uid = rs.getInt("U_ID");

			Account account = new Account(aid, name, uid);
			list.add(account);
		}

		return list;
	}

	public void insertAccount(Account account) throws SQLException {
		String sql = String.format("INSERT INTO FinancialAccount (Name,U_ID) VALUES('%s',%d)", account.getName(),
				account.getU_ID());
		DatabaseManager.instance.query(sql);
	}

	public void deleteAccount(int id) throws SQLException {
		String sql = String.format("DELETE FROM FinancialAccount WHERE A_ID=%d", id);
		DatabaseManager.instance.query(sql);
	}

}

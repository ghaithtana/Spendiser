package Controller;

import java.sql.SQLException;

import Model.Account;

public class AccountManager {

	public static final AccountManager instance = new AccountManager();

	private AccountManager() {

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

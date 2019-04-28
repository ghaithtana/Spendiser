package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Model.PremiumUser;
import Model.User;

public class UserManager {

	public static final UserManager instance = new UserManager();
	private User currentUser;

	private UserManager() {

	}

	public void signUp(User u) throws Exception {

		User user = getUser(u.getName());
		if (user != null) {
			throw new Exception("Taken username");
		} else {
			String sql = String.format(
					"INSERT INTO [User] (Username,Password,Name,Gender,Birthdate, IsPremium) VALUES ('%s','%s','%s',%d,'%s', 0)",
					u.getUsername(), u.getPassword(), u.getName(), u.getGender(), u.getFormatedDate());

			DatabaseManager.instance.query(sql);
		}
	}

	public User signIn(String username, String password) throws SQLException {

		String sql = String.format("EXEC [SignIn] '%s', '%s'", username, password);

		ResultSet rs = DatabaseManager.instance.select(sql);

		if (rs.next()) {
			currentUser = getUserFromResultSet(rs);
		}

		return currentUser;
	}

	public User getUser(String username) throws SQLException {

		String sql = String.format("SELECT * FROM [User] WHERE Username='%s'", username);

		ResultSet rs = DatabaseManager.instance.select(sql);

		if (rs.next()) {
			return getUserFromResultSet(rs);
		}

		return null;
	}

	public void upgradeUser() throws SQLException {
		String sql = String.format("EXEC [UpgardeUserToPermium] '%d''", currentUser.getU_ID());
		DatabaseManager.instance.query(sql);
		currentUser = new PremiumUser(currentUser);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	private User getUserFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("U_ID");
		String u = rs.getString("Username");
		String pass = rs.getString("Password");
		String name = rs.getString("Name");
		Date birthdate = rs.getDate("Birthdate");
		int gender = rs.getInt("Gender");
		boolean isPremium = rs.getBoolean("IsPremium");

		if (isPremium)
			return new PremiumUser(id, u, pass, name, gender, birthdate);
		return new User(id, u, pass, name, gender, birthdate);
	}

}

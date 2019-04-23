package Model;

import java.text.ParseException;
import java.util.Date;

public class PremiumUser extends User {

	boolean isPremium;

	public PremiumUser(int ID, String username, String password, String name, int gender, Date birthdate) {
		super(ID, username, password, name, gender, birthdate);

		this.isPremium = true;
	}

	public PremiumUser(String username, String password, String name, int gender, String birthdate)
			throws ParseException {
		super(username, password, name, gender, birthdate);

		this.isPremium = true;
	}

	public PremiumUser(User user) {
		super(user.u_id, user.username, user.password, user.name, user.gender, user.birthdate);
		this.isPremium = true;
	}

}

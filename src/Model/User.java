package Model;

import java.text.ParseException;
import java.util.Date;

import Controller.Utils;

public class User {

	protected int u_id;
	protected String username;
	protected String password;
	protected String name;
	protected int gender;
	protected Date birthdate;

	public User(int ID, String username, String password, String name,
			int gender, Date birthdate) {
		this.u_id = ID;
		this.username = username.toLowerCase();
		this.password = password;
		this.gender = gender;
		this.birthdate = birthdate;
		this.name = name;

	}

	public User(String username, String password, String name, int gender,
			String birthdate) throws ParseException {
		this.username = username.toLowerCase();
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.setBirthdate(birthdate);
	}

	public int getU_ID() {
		return u_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getFormatedDate() {
		return Utils.dateToString(birthdate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(String date) {
		this.birthdate = Utils.stringToDate(date);
	}
}

package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Outcome {

	private int id;
	private double amount;
	private String description;
	private Date date;
	private int c_id;
	private int a_id;

	public Outcome(double amount, String description, Date date, int c_id,
			int a_id) {
		setAmount(amount);
		setDescription(description);
		setDate(date);
		setC_id(c_id);
		setA_id(a_id);
	}

	public Outcome(int id, double amount, String description, Date date,
			int c_id, int a_id) {
		setId(id);
		setAmount(amount);
		setDescription(description);
		setDate(date);
		setC_id(c_id);
		setA_id(a_id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public String getFormatedDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		return dateFormat.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

}

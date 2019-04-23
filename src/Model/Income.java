package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Income {

	private int id;
	private double amount;
	private String description;
	private Date date;
	private int A_ID;

	public Income(int id, double amount, String description, Date date, int A_ID) {

		setId(id);
		setAmount(amount);
		setDescription(description);
		setDate(date);
		setA_ID(A_ID);

	}

	public Income(double amount, String description, Date date, int A_ID) {

		setAmount(amount);
		setDescription(description);
		setDate(date);
		setA_ID(A_ID);

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
	
	public String getFormatedDate(){
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.format(date);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getA_ID() {
		return A_ID;
	}

	public void setA_ID(int a_ID) {
		A_ID = a_ID;
	}
	

}

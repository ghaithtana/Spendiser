package Model;

public class Account {

	private int id;
	private String name;
	private int U_ID;

	public Account(int id, String name, int U_ID) {
		setId(id);
		setName(name);
		setU_ID(U_ID);

	}

	public Account(String name, int U_ID) {
		setName(name);
		setU_ID(U_ID);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getU_ID() {
		return U_ID;
	}

	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}

}

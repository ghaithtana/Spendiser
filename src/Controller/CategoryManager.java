package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Category;

public class CategoryManager {
	public static final CategoryManager instance = new CategoryManager();

	private CategoryManager() {

	}

	public ArrayList<Category> getAllCategories() throws SQLException {
		ArrayList<Category> list = new ArrayList<Category>();

		String sql = "SELECT * FROM Category";
		ResultSet rs = DatabaseManager.instance.select(sql);

		while (rs.next()) {
			int id = rs.getInt("C_ID");
			String name = rs.getString("Name");

			Category category = new Category(id, name);
			list.add(category);
		}

		return list;
	}
}

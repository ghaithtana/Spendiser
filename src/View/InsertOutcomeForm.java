package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AccountManager;
import Controller.CategoryManager;
import Controller.OutcomeManager;
import Controller.Utils;
import Controller.WrongInputexception;
import Model.Account;
import Model.Category;
import Model.Outcome;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class InsertOutcomeForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTable table;
	private JButton button;
	private JLabel label;
	private JTextField textField_3;
	private JLabel lblEnterAmount;
	private JButton button_1;
	private JLabel lblInsertIncome;
	private static JTable table_1;
	private JLabel lblAccounts;
	private JLabel lblCategories;
	private JLabel lblEnterCategoryId;
	private JTextField textField_4;
	private static double amount;
	private static int accountid;
	private static int categoryid;
	private static String description;
	private static String sdate;
	private static String listener1;
	private static String listener2;
	private static String listener3;
	private JTable table_2;
	private JTable table_3;
	private JButton button_2;
	private JLabel lblShow;

	/**
	 * Launch the application.
	 */
	public static void addCategory() {

		try {
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			ArrayList<Category> categories = new ArrayList<Category>();
			categories = CategoryManager.instance.getAllCategories();
			Object rowdata[] = new Object[20];
			for (int i = 0; i < categories.size(); i++) {
				rowdata[0] = categories.get(i).getId();
				rowdata[1] = categories.get(i).getName();
				model.addRow(rowdata);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addAccounts() {

		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts = AccountManager.instance.getAllAccounts();
			Object rowdata[] = new Object[20];
			for (int i = 0; i < accounts.size(); i++) {
				rowdata[0] = accounts.get(i).getId();
				rowdata[1] = accounts.get(i).getName();
				rowdata[2] = accounts.get(i).getU_ID();
				model.addRow(rowdata);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertOutcomeForm frame = new InsertOutcomeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertOutcomeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter description :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 146, 127, 20);
		contentPane.add(lblNewLabel);

		JLabel lblEnterEndDate = new JLabel("Enter Date :");
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterEndDate.setBounds(12, 208, 115, 20);
		contentPane.add(lblEnterEndDate);

		JLabel lblEnterAccountId = new JLabel("Enter Account ID :");
		lblEnterAccountId.setForeground(new Color(255, 255, 255));
		lblEnterAccountId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountId.setBounds(12, 260, 127, 20);
		contentPane.add(lblEnterAccountId);

		textField = new JTextField();
		textField.setBounds(151, 141, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				description = textField.getText();
			}
		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 203, 146, 26);
		contentPane.add(textField_1);
		textField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdate = textField_1.getText();
			}
		});

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 255, 146, 26);
		contentPane.add(textField_2);
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener2 = textField_2.getText();
				accountid = Integer.parseInt(textField_2.getText().trim());

			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setFont(new Font("Pristina", Font.BOLD, 14));
		table.setBounds(343, 89, 306, 212);
		contentPane.add(table);

		button = new JButton("");
		button.setIcon(new ImageIcon(InsertOutcomeForm.class.getResource("/View/images/left-arrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View.OutcomeManager outcome= new View.OutcomeManager();
				outcome.setVisible(true);
			}
		});
		button.setBounds(0, 0, 54, 38);
		contentPane.add(button);

		label = new JLabel("Back");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Pristina", Font.BOLD, 14));
		label.setBounds(10, 45, 32, 32);
		contentPane.add(label);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 83, 146, 26);
		contentPane.add(textField_3);
		textField_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener1 = textField_3.getText();
				amount = Double.parseDouble(textField_3.getText().trim());

			}
		});

		lblEnterAmount = new JLabel("Enter Amount :");
		lblEnterAmount.setForeground(Color.WHITE);
		lblEnterAmount.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAmount.setBounds(12, 88, 127, 20);
		contentPane.add(lblEnterAmount);

		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sdate != null && description != null && listener1 != null && listener2 != null
						&& listener3 != null) {

					try {
						Date date1 = Utils.stringToDate(sdate);
						Outcome o = new Outcome(amount, description, date1, categoryid, accountid);
						OutcomeManager.instance.insertOutcome(o);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (WrongInputexception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_1.setIcon(new ImageIcon(InsertOutcomeForm.class.getResource("/View/images/plus.png")));
		button_1.setBounds(50, 375, 49, 38);
		contentPane.add(button_1);

		lblInsertIncome = new JLabel("Insert Outcome");
		lblInsertIncome.setForeground(Color.WHITE);
		lblInsertIncome.setFont(new Font("Pristina", Font.PLAIN, 15));
		lblInsertIncome.setBounds(39, 424, 73, 38);
		contentPane.add(lblInsertIncome);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table_1.setBounds(343, 386, 250, 197);
		contentPane.add(table_1);

		lblAccounts = new JLabel("Accounts");
		lblAccounts.setForeground(Color.WHITE);
		lblAccounts.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts.setBounds(437, 11, 127, 20);
		contentPane.add(lblAccounts);

		lblCategories = new JLabel("Categories");
		lblCategories.setForeground(Color.WHITE);
		lblCategories.setFont(new Font("Pristina", Font.BOLD, 14));
		lblCategories.setBounds(421, 320, 127, 20);
		contentPane.add(lblCategories);

		lblEnterCategoryId = new JLabel("Enter Category ID :");
		lblEnterCategoryId.setForeground(Color.WHITE);
		lblEnterCategoryId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterCategoryId.setBounds(12, 320, 127, 20);
		contentPane.add(lblEnterCategoryId);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 315, 146, 26);
		contentPane.add(textField_4);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] { { " Account ID", " Account Name", " User ID" }, },
				new String[] { "New column", "New column", "New column" }));
		table_2.setForeground(Color.WHITE);
		table_2.setFont(new Font("Pristina", Font.BOLD, 14));
		table_2.setBackground(new Color(0, 250, 154));
		table_2.setBounds(343, 62, 306, 16);
		contentPane.add(table_2);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] { { " Category ID", " Category Name" }, },
				new String[] { "New column", "New column" }));
		table_3.setForeground(Color.WHITE);
		table_3.setFont(new Font("Pristina", Font.BOLD, 14));
		table_3.setBackground(new Color(0, 250, 154));
		table_3.setBounds(344, 359, 249, 16);
		contentPane.add(table_3);

		button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCategory();
				addAccounts();
			}
		});
		button_2.setIcon(new ImageIcon(InsertOutcomeForm.class.getResource("/View/images/show.png")));
		button_2.setBounds(230, 464, 73, 23);
		contentPane.add(button_2);

		lblShow = new JLabel("Show Categories & accounts");
		lblShow.setForeground(Color.WHITE);
		lblShow.setFont(new Font("Pristina", Font.BOLD, 14));
		lblShow.setBounds(184, 501, 149, 20);
		contentPane.add(lblShow);
		textField_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener3 = textField_4.getText();
				categoryid = Integer.parseInt(textField_4.getText().trim());

			}
		});

	}

}

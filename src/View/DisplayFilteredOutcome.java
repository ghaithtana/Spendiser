package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.AccountManager;
import Controller.CategoryManager;
import Controller.FinancialManager;
import Controller.IncomeManager;
import Controller.OutcomeManager;
import Controller.Utils;
import Model.Account;
import Model.Category;
import Model.Income;
import Model.Outcome;

public class DisplayFilteredOutcome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static JTable table;
	private JButton btnNewButton;
	private JButton button;
	private JLabel label;
	private static JTable table_1;
	private static JTable table_2;
	private JPanel panel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JLabel lblShowAccounts;
	private JButton button_1;
	private JLabel lblShowFilteredOutcomes;
	private static int id;
	private static String sdate;
	private static String edate;
	private static int aid;
	private static String listener1;
	private static String listener2;
	private static double balance;

	/**
	 * Launch the application.
	 */
	public static void addCategory() {

		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
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
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
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

	public static void addOutcomes() {

		try {
			Date ssdate = Utils.stringToDate(sdate);
			Date eedate = Utils.stringToDate(edate);
			DefaultTableModel model = (DefaultTableModel) table_2.getModel();
			ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
			outcomes = OutcomeManager.instance.getOutcomes(id, aid, ssdate, eedate);
			Object rowdata[] = new Object[20];
			for (int i = 0; i < outcomes.size(); i++) {
				rowdata[0] = outcomes.get(i).getAmount();
				rowdata[1] = outcomes.get(i).getDescription();
				rowdata[2] = outcomes.get(i).getDate();
				rowdata[3] = outcomes.get(i).getC_id();
				rowdata[4] = outcomes.get(i).getA_id();

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
					DisplayFilteredOutcome frame = new DisplayFilteredOutcome();
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
	public DisplayFilteredOutcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 811);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Choose category by ID :\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(246, 110, 131, 20);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(387, 105, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener1 = textField.getText();
				id = Integer.parseInt(textField.getText().trim());

			}
		});

		JLabel lblEnterStartDate = new JLabel("Start Date :");
		lblEnterStartDate.setForeground(new Color(255, 255, 255));
		lblEnterStartDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterStartDate.setBounds(274, 168, 69, 20);
		contentPane.add(lblEnterStartDate);

		JLabel lblEndDate = new JLabel("End Date :");
		lblEndDate.setForeground(new Color(255, 255, 255));
		lblEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEndDate.setBounds(274, 222, 69, 20);
		contentPane.add(lblEndDate);

		JLabel lblChoseAccountBy = new JLabel("Choose account by ID :");
		lblChoseAccountBy.setFont(new Font("Pristina", Font.BOLD, 14));
		lblChoseAccountBy.setForeground(new Color(255, 255, 255));
		lblChoseAccountBy.setBounds(229, 280, 131, 20);
		contentPane.add(lblChoseAccountBy);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(387, 163, 146, 26);
		contentPane.add(textField_1);
		textField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdate = textField_1.getText();

			}
		});

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(387, 217, 146, 26);
		contentPane.add(textField_2);
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				edate = textField_2.getText();
			}
		});

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(387, 275, 146, 26);
		contentPane.add(textField_3);
		textField_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener2 = textField_3.getText();
				aid = Integer.parseInt(textField_3.getText().trim());
			}
		});

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "New column", "New column" }));
		table.setBounds(897, 140, 268, 195);
		contentPane.add(table);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccounts();
				addCategory();
			}
		});
		btnNewButton.setIcon(new ImageIcon(DisplayFilteredOutcome.class.getResource("/View/images/show.png")));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(1010, 669, 81, 29);
		contentPane.add(btnNewButton);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View.OutcomeManager om = new View.OutcomeManager();
				om.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(DisplayFilteredOutcome.class.getResource("/View/images/left-arrow.png")));
		button.setBounds(210, 0, 54, 38);
		contentPane.add(button);

		label = new JLabel("Back");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Pristina", Font.BOLD, 14));
		label.setBounds(219, 40, 32, 32);
		contentPane.add(label);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));
		table_1.setBounds(870, 456, 364, 195);
		contentPane.add(table_1);

		JLabel lblAccounts = new JLabel("Categories");
		lblAccounts.setForeground(new Color(255, 255, 255));
		lblAccounts.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts.setBounds(968, 46, 131, 20);
		contentPane.add(lblAccounts);

		JLabel lblAccounts_1 = new JLabel("Accounts");
		lblAccounts_1.setForeground(new Color(255, 255, 255));
		lblAccounts_1.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts_1.setBounds(988, 377, 131, 20);
		contentPane.add(lblAccounts_1);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table_2.setBounds(229, 456, 571, 195);
		contentPane.add(table_2);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 211, 749);
		contentPane.add(panel);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DisplayFilteredOutcome.class.getResource("/View/images/user.png")));
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(65, 11, 71, 70);
		panel.add(label_1);

		label_2 = new JLabel("Current balance :");
		label_2.setForeground(new Color(0, 250, 154));
		label_2.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(0, 148, 104, 50);
		panel.add(label_2);

		label_3 = new JLabel("");
		label_3.setForeground(new Color(0, 250, 154));
		label_3.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_3.setBounds(53, 92, 86, 26);
		panel.add(label_3);

		label_4 = new JLabel("0.0 $");
		label_4.setFont(new Font("Pristina", Font.BOLD, 14));
		label_4.setBounds(114, 165, 61, 14);
		panel.add(label_4);
		try {
			balance = FinancialManager.instance.getBalance();
			label_4.setText(balance + " $");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		label_5 = new JLabel("Filtered Outcomes");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Pristina", Font.BOLD, 14));
		label_5.setBounds(427, 377, 123, 20);
		contentPane.add(label_5);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
				new Object[][] { { " Amount", " Description", " Date", "CategoryID", "AccountID" }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table_3.setForeground(Color.WHITE);
		table_3.setFont(new Font("Pristina", Font.BOLD, 14));
		table_3.setBackground(new Color(0, 250, 154));
		table_3.setBounds(229, 429, 571, 16);
		contentPane.add(table_3);

		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(new Object[][] { { " AccountID", " AccountName", " UserID" }, },
				new String[] { "New column", "New column", "New column" }));
		table_4.setForeground(Color.WHITE);
		table_4.setFont(new Font("Pristina", Font.BOLD, 14));
		table_4.setBackground(new Color(0, 250, 154));
		table_4.setBounds(870, 429, 364, 16);
		contentPane.add(table_4);

		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(new Object[][] { { " CategoryID", " CategoryName" }, },
				new String[] { "New column", "New column" }));
		table_5.setForeground(Color.WHITE);
		table_5.setFont(new Font("Pristina", Font.BOLD, 14));
		table_5.setBackground(new Color(0, 250, 154));
		table_5.setBounds(900, 113, 249, 16);
		contentPane.add(table_5);

		lblShowAccounts = new JLabel("Show Accounts & categories");
		lblShowAccounts.setForeground(Color.WHITE);
		lblShowAccounts.setFont(new Font("Pristina", Font.BOLD, 14));
		lblShowAccounts.setBounds(968, 718, 153, 20);
		contentPane.add(lblShowAccounts);

		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sdate != null && edate != null && listener1 != null && listener2 != null) {
					addOutcomes();
					listener1 = null;
					listener2 = null;
				}
			}
		});
		button_1.setIcon(new ImageIcon(DisplayFilteredOutcome.class.getResource("/View/images/show.png")));
		button_1.setBackground(new Color(230, 230, 250));
		button_1.setBounds(448, 669, 81, 29);
		contentPane.add(button_1);

		lblShowFilteredOutcomes = new JLabel("Show Filtered Outcomes");
		lblShowFilteredOutcomes.setForeground(Color.WHITE);
		lblShowFilteredOutcomes.setFont(new Font("Pristina", Font.BOLD, 14));
		lblShowFilteredOutcomes.setBounds(411, 709, 153, 20);
		contentPane.add(lblShowFilteredOutcomes);
	}
}

package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import Controller.AccountManager;
import Controller.IncomeManager;
import Controller.Utils;
import Controller.WrongInputexception;
import Model.Account;
import Model.Income;

public class InsertIncomeForm extends JFrame {

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
	private JLabel lblAccounts;
	private JTable table_1;
	private JButton button_2;
	private JLabel lblShow;
	private static double amount;
	private static String description;
	private static String sdate;
	private static int aid;
	private static String listener1;
	private static String listener2;

	/**
	 * Launch the application.
	 */
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
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
					InsertIncomeForm frame = new InsertIncomeForm();
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
	public InsertIncomeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter description :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 167, 127, 20);
		contentPane.add(lblNewLabel);

		JLabel lblEnterEndDate = new JLabel("Enter Date :");
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterEndDate.setBounds(12, 228, 115, 20);
		contentPane.add(lblEnterEndDate);

		JLabel lblEnterAccountId = new JLabel("Enter Account ID :");
		lblEnterAccountId.setForeground(new Color(255, 255, 255));
		lblEnterAccountId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountId.setBounds(15, 288, 127, 20);
		contentPane.add(lblEnterAccountId);

		textField = new JTextField();
		textField.setBounds(151, 162, 146, 26);
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
		textField_1.setBounds(151, 223, 146, 26);
		contentPane.add(textField_1);
		textField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdate = textField_1.getText();

			}
		});

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 283, 146, 26);
		contentPane.add(textField_2);
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener2 = textField_2.getText();
				aid = Integer.parseInt(textField_2.getText().trim());
			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));
		table.setFont(new Font("Pristina", Font.BOLD, 14));
		table.setBounds(355, 113, 306, 214);
		contentPane.add(table);

		button = new JButton("");
		button.setIcon(new ImageIcon(InsertIncomeForm.class.getResource("/View/images/left-arrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IncomeManagerForm inf = new IncomeManagerForm();
				inf.setVisible(true);
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
		textField_3.setBounds(151, 107, 146, 26);
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
		lblEnterAmount.setBounds(12, 112, 127, 20);
		contentPane.add(lblEnterAmount);

		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sdate != null && description != null && listener1 != null && listener2 != null) {

					try {
						Date date1 = Utils.stringToDate(sdate);
						Income i = new Income(amount, description, date1, aid);
						IncomeManager.instance.insertIncome(i);
						infoBox("Income inserted successfuly!", "");
						
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
		button_1.setIcon(new ImageIcon(InsertIncomeForm.class.getResource("/View/images/plus.png")));
		button_1.setBounds(46, 361, 49, 38);
		contentPane.add(button_1);

		lblInsertIncome = new JLabel("Insert Income");
		lblInsertIncome.setForeground(Color.WHITE);
		lblInsertIncome.setFont(new Font("Pristina", Font.PLAIN, 15));
		lblInsertIncome.setBounds(43, 398, 73, 38);
		contentPane.add(lblInsertIncome);

		lblAccounts = new JLabel("Accounts");
		lblAccounts.setForeground(Color.WHITE);
		lblAccounts.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts.setBounds(456, 28, 127, 20);
		contentPane.add(lblAccounts);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { " Account ID", " Account Name", " User Id" }, },
				new String[] { "New column", "New column", "New column" }));
		table_1.setForeground(Color.WHITE);
		table_1.setFont(new Font("Pristina", Font.BOLD, 14));
		table_1.setBackground(new Color(0, 250, 154));
		table_1.setBounds(355, 82, 306, 16);
		contentPane.add(table_1);

		button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccounts();
			}
		});
		button_2.setIcon(new ImageIcon(InsertIncomeForm.class.getResource("/View/images/show.png")));
		button_2.setBounds(476, 338, 63, 23);
		contentPane.add(button_2);

		lblShow = new JLabel("Show");
		lblShow.setForeground(Color.WHITE);
		lblShow.setFont(new Font("Pristina", Font.BOLD, 14));
		lblShow.setBounds(486, 379, 63, 20);
		contentPane.add(lblShow);
	}

}
